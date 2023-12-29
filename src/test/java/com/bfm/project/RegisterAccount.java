package com.bfm.project;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterAccount {
	public static Date dt = new Date();
	public static  SimpleDateFormat sdf= new SimpleDateFormat("hh:mm:ss");
	public static  String date=sdf.format(dt);
	public static String dt1=date.replace(":","");
	public static WebDriver driver;
	
	
	@Test()
public static void createacc() throws InterruptedException
{
		driver = new FirefoxDriver();
		driver.get("https://dev.yourchildsday.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement newact= driver.findElement(By.xpath("//a[text()='Create a new account >']"));
		newact.click();
		String actual="Create a New Account";
		WebElement newac =driver.findElement(By.xpath("//h2[text()='Create a New Account']"));
		String expected = newac.getText();
		Assert.assertEquals(actual, expected);
		System.out.println("Enter into create a new account page");
	WebElement fname=driver.findElement(By.xpath("//input[@placeholder='First name']"));
	
	fname.sendKeys("SampleTest1"+dt1+"");
	WebElement lname=driver.findElement(By.xpath("//input[@placeholder='Last name']"));
	lname.sendKeys("SampleTest2"+dt1+"");
	WebElement email=driver.findElement(By.xpath("//input[@placeholder='Email']"));
	email.sendKeys("Testingsar6"+dt1+"@yopmail.com");
	WebElement phone=driver.findElement(By.xpath("//input[@placeholder='Mobile number']"));
	phone.sendKeys("9632154215");
//	WebElement usname=driver.findElement(By.xpath("//input[@id='UserName']"));
//	usname.sendKeys("AutoTesting6"+dt1+"");
	WebElement slctCompany=driver.findElement(By.xpath("//span[text()='Select company']"));
	slctCompany.click();
	Thread.sleep(2000);
	slctCompany.sendKeys(Keys.DOWN);
	slctCompany.sendKeys(Keys.ENTER);
	WebElement psw=driver.findElement(By.xpath("//input[@id='Password']"));
	psw.sendKeys("Vss@1234");
	WebElement cpsw=driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
	cpsw.sendKeys("Vss@1234");
	WebElement regbtn=driver.findElement(By.xpath("//input[@value='REGISTER']"));
	regbtn.click();
}
	
	
}
