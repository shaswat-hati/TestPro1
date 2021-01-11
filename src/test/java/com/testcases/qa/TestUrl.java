package com.testcases.qa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestUrl {
	
	static WebDriver driver;

	@BeforeTest
	public void init(){
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public static void handleMultiWin() throws InterruptedException{
		List<String> titleList= new ArrayList<String>();		
		driver.get("http://demo.automationtesting.in/Windows.html");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);		
		
		String title = driver.getTitle();
		System.out.println("Title of parent window: "+title);
		System.out.println(driver.getWindowHandle());
		
		driver.findElement(By.xpath("//*[@id='Tabbed']/a/button")).click();
		Thread.sleep(5000);
		
		//System.out.println("Title of parent window: "+title);
		
		Set<String> s= driver.getWindowHandles();
		Iterator<String> it= s.iterator();
		while(it.hasNext()){
			String child= it.next();			
			driver.switchTo().window(child);
			System.out.println(driver.getTitle());
			titleList.add(driver.getTitle());
			
		}
		System.out.println("Windows title list: "+titleList);
	
	}
	
	//@AfterTest
	public void tearDown(){
		driver.close();
	}

}
