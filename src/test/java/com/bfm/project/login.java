package com.bfm.project;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class login {
	@Test(priority=1)
public static void login() throws IOException
	{
//		createReport();
		createTest("Login");
	driver = new ChromeDriver();
	driver.get("https://dev.yourchildsday.com/");
	driver.manage().window().maximize();
	teststatus("pass", "YCD site opened");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
WebElement usname= driver.findElement(By.xpath("//input[@type='text']"));
usname.sendKeys("inntechadmin@yourchildsday.com");
teststatus("pass", "Email passed");
WebElement psw=driver.findElement(By.xpath("//input[@type='password']"));
psw.sendKeys("IN02xU^lA4e4gz");
teststatus("pass", "password passed");
WebElement btn=driver.findElement(By.xpath("//button[@type='submit']"));
btn.click();
teststatus("pass", "login button clicked");
WebElement saSite=driver.findElement(By.xpath("//div[text()='SA']"));
saSite.click();
teststatus("pass", "SA site clicked");
String actual="My Profile";
WebElement text=driver.findElement(By.xpath("//h2[@class='page-title']"));
String expected=text.getText();
Assert.assertEquals(actual, expected);

//TakesScreenshot tks=(TakesScreenshot)driver;
//File src=tks.getScreenshotAs(OutputType.FILE);
//File dst=new File("C:\\Users\\TSI\\eclipse-workspace\\BFMProject\\user.dir\\login"+dt1+".png");
//FileHandler.copy(src, dst);
System.out.println("Login suceesfully move to Home Page");
teststatus("passScreenshot", "Enter into a Home Page");
//test.addScreenCaptureFromPath("C:\\Users\\TSI\\eclipse-workspace\\BFMProject\\user.dir\\login"+dt1+".png");

}
	@Test(priority=2)
	public static void createacc() throws InterruptedException, IOException
	{
			
			createTest("Create New Account");
			driver = new FirefoxDriver();
			driver.get("https://dev.yourchildsday.com/");
			teststatus("pass", "YCD Site Open");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			WebElement newact= driver.findElement(By.xpath("//a[text()='Create a new account >']"));
			newact.click();
			teststatus("pass", "Create a new account clicked");
			String actual="Create a New Account";
			WebElement newac =driver.findElement(By.xpath("//h2[text()='Create a New Account']"));
			String expected = newac.getText();
			Assert.assertEquals(actual, expected);
			System.out.println("Enter into create a new account page");
			teststatus("passScreenshot", "Entered new account clicked");
//			TakesScreenshot tks=(TakesScreenshot)driver;
//			File src=tks.getScreenshotAs(OutputType.FILE);
//			File dst=new File("C:\\Users\\TSI\\eclipse-workspace\\BFMProject\\user.dir\\Signup"+dt1+".png");
//			FileHandler.copy(src, dst);
//			test.addScreenCaptureFromPath("C:\\Users\\TSI\\eclipse-workspace\\BFMProject\\user.dir\\Signup"+dt1+".png");
		WebElement fname=driver.findElement(By.xpath("//input[@placeholder='First name']"));
		fname.sendKeys("SampleTest1"+dt1+"");
		teststatus("pass", "First Name Entered");
		WebElement lname=driver.findElement(By.xpath("//input[@placeholder='Last name']"));
		lname.sendKeys("SampleTest2"+dt1+"");
		teststatus("pass", "Last Name Entered");
		WebElement email=driver.findElement(By.xpath("//input[@placeholder='Email']"));
		email.sendKeys("Testingsar6"+dt1+"@yopmail.com");
		teststatus("pass", "Email Entered");
		WebElement phone=driver.findElement(By.xpath("//input[@placeholder='Mobile number']"));
		phone.sendKeys("9632154215");
		teststatus("pass", "Mobile Entered");
//		WebElement usname=driver.findElement(By.xpath("//input[@id='UserName']"));
//		usname.sendKeys("AutoTesting6"+dt1+"");
		WebElement slctCompany=driver.findElement(By.xpath("//span[text()='Select company']"));
		slctCompany.click();
		teststatus("pass", "Company clicked");
		teststatus("fail", "Unable to select company");
//		teststatus("fail", "Unable to select company");
//		TakesScreenshot tks1=(TakesScreenshot)driver;
//		File src1=tks.getScreenshotAs(OutputType.FILE);
//		File dst1=new File("C:\\Users\\TSI\\eclipse-workspace\\BFMProject\\user.dir\\cpnyError"+dt1+".png");
//		FileHandler.copy(src1, dst1);
//		test.addScreenCaptureFromPath("C:\\Users\\TSI\\eclipse-workspace\\BFMProject\\user.dir\\cpnyError"+dt1+".png");
		slctCompany.sendKeys(Keys.DOWN);
		slctCompany.sendKeys(Keys.ENTER);
		
		
		WebElement psw=driver.findElement(By.xpath("//input[@id='Password']"));
		psw.sendKeys("Vss@1234");
		WebElement cpsw=driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
		cpsw.sendKeys("Vss@1234");
		WebElement regbtn=driver.findElement(By.xpath("//input[@value='REGISTER']"));
		regbtn.click();
		stop();
	}

}
