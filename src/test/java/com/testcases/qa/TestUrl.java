package com.testcases.qa;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestUrl {
	
	static WebDriver driver;

	@BeforeTest
	public void init(){
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver1.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public static void checkUrl(){
		
		
		driver.get("http://www.ndi.world/support.php");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
		String title = driver.getTitle();
		System.out.println(title);
	
	}
	
	//@AfterTest
	public void tearDown(){
		driver.close();
	}

}
