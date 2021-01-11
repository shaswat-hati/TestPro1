package com.testcases.qa;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FileUploadDownload {
	
	static WebDriver driver;
	String skFilePath= "C:\\Users\\shaswat\\Desktop";
	static String fileUploadPath="C:\\Users\\shaswat\\Pictures\\";

	@BeforeTest
	public void init(){
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"/Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		
	}
	
	@Test
	public static void verifyFIleUpload() throws InterruptedException, FindFailed{
		
		driver.get("http://demo.automationtesting.in/Register.html");		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement browseBttn=driver.findElement(By.xpath("//*[@id='imagesrc']"));
		System.out.println(browseBttn.isDisplayed());
		//System.out.println(browseBttn.getAttribute("type"));
		Thread.sleep(5000);
		browseBttn.sendKeys(fileUploadPath+"xyz.png");
		
		/*
		
		Screen s = new Screen();
		Pattern inputFile= new Pattern(skFilePath+"sn1.PNG");
		Pattern openFile= new Pattern(skFilePath+"sn2.PNG");
		
		s.wait(inputFile,20);
		s.type(inputFile,fileUploadPath+"test1.jpg");
		s.click(openFile);*/
		
		
	}
	
	//@AfterTest
	public void tearDown(){
		driver.close();
	}

}
