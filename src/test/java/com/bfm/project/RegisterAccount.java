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
	
	
	@Test(priority=0)
public void register()
	{
	driver = new FirefoxDriver();
	driver.get("https://dev.yourchildsday.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement newact= driver.findElement(By.xpath("//a[contains(text(),'Create a new account')]"));
	newact.click();
	String actual="Create a New Account";
	WebElement newac =driver.findElement(By.xpath("//h2[text()='Create a New Account']"));
	String expected = newac.getText();
	Assert.assertEquals(actual, expected);
	System.out.println("Enter into create a new account page");

}
	
	@Test(dependsOnMethods="register",priority=1)
public static void createacc() throws InterruptedException
{
	WebElement fname=driver.findElement(By.xpath("//input[@id='FirstName']"));
	
	fname.sendKeys("SampleTest1"+dt1+"");
	WebElement lname=driver.findElement(By.xpath("//input[@id='LastName']"));
	lname.sendKeys("SampleTest2"+dt1+"");
	WebElement email=driver.findElement(By.xpath("//input[@id='Email']"));
	email.sendKeys("Testingsar6"+dt1+"@yopmail.com");
	WebElement phone=driver.findElement(By.xpath("//input[@id='MobileNumber']"));
	phone.sendKeys("9632154215");
	WebElement usname=driver.findElement(By.xpath("//input[@id='UserName']"));
	usname.sendKeys("AutoTesting6"+dt1+"");
	WebElement psw=driver.findElement(By.xpath("//input[@id='Password']"));
	psw.sendKeys("Vss@1234");
	WebElement cpsw=driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
	cpsw.sendKeys("Vss@1234");
	WebElement regbtn=driver.findElement(By.xpath("//input[@value='REGISTER']"));
	regbtn.click();
	String paren=driver.getWindowHandle();
	Set<String> child=driver.getWindowHandles();
	for(String ch:child)
	{
		if(!ch.equals(paren))
			driver.switchTo().window(ch);
		}
//	Set<String> child=driver.getWindowHandles();
//	List<String>li= new LinkedList<>();
//	li.addAll(child);
//	driver.switchTo().window(li.get(1));
	String actual= "Sign In";
	WebElement sgn=driver.findElement(By.xpath("//p[text()='Sign In']"));
	String expected=sgn.getText();
	Assert.assertEquals(actual, expected);
	System.out.println("New User Created Sucessfully");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://yopmail.com/");
	WebElement maillgn=driver.findElement(By.xpath("//input[@id='login']"));
	maillgn.sendKeys("Testingsar6"+dt1+"@yopmail.com");
	WebElement gmail=driver.findElement(By.xpath("//i[contains(@class,'material-icons-outlined f36')]"));
	gmail.click();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	WebElement frame=driver.findElement(By.xpath("//iframe[@id='ifmail']"));
	driver.switchTo().frame(frame);
	WebElement cfm=driver.findElement(By.xpath("//a[text()='link']"));
	cfm.click();
	String paren1=driver.getWindowHandle();
	Set<String> child1=driver.getWindowHandles();
	for(String ch:child1)
	{
		if(!ch.equals(paren1))
			driver.switchTo().window(ch);
		}
	String actual1= "Sign In";
	WebElement sgn1=driver.findElement(By.xpath("//p[text()='Sign In']"));
	String expected1=sgn.getText();
	Assert.assertEquals(actual1, expected1);
	System.out.println("Mail verified successfully");
	}
	@Test(priority=2, enabled=false)
	public static void mailValid()
	{
	driver = new ChromeDriver();
		driver.get("https://yopmail.com/");
		WebElement maillgn=driver.findElement(By.xpath("//input[@id='login']"));
		maillgn.sendKeys("Testingsar6"+dt1+"@yopmail.com");
		WebElement gmail=driver.findElement(By.xpath("//i[contains(@class,'material-icons-outlined f36')]"));
		gmail.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement frame=driver.findElement(By.xpath("//iframe[@id='ifmail']"));
		driver.switchTo().frame(frame);
		WebElement cfm=driver.findElement(By.xpath("//a[text()='link']"));
		cfm.click();
		String paren=driver.getWindowHandle();
		Set<String> child=driver.getWindowHandles();
		for(String ch:child)
		{
			if(!ch.equals(paren))
				driver.switchTo().window(ch);
			}
		String actual= "Sign In";
		WebElement sgn=driver.findElement(By.xpath("//p[text()='Sign In']"));
		String expected=sgn.getText();
		Assert.assertEquals(actual, expected);
		System.out.println("Mail verified successfully");
		WebElement inntecadmin=driver.findElement(By.xpath("//input[@id='Email']"));
		inntecadmin.sendKeys("InntechAdmin");
		driver.findElement(By.xpath("//input[@id='Password']"));
		
	}
	
}
