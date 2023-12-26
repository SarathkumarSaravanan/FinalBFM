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
	public static WebDriver driver;
	@Test()
public static void login()
	{
	driver = new ChromeDriver();
	driver.get("https://dev.yourchildsday.com/");
	driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
WebElement usname= driver.findElement(By.xpath("//input[@type='text']"));
usname.sendKeys("inntechadmin@yourchildsday.com");
WebElement psw=driver.findElement(By.xpath("//input[@type='password']"));
psw.sendKeys("02xU^lA4e4gz");
WebElement btn=driver.findElement(By.xpath("//button[@type='submit']"));
btn.click();
WebElement saSite=driver.findElement(By.xpath("//div[text()='SA']"));
saSite.click();
String actual="My Profile";
WebElement text=driver.findElement(By.xpath("//h2[@class='page-title']"));
String expected=text.getText();
Assert.assertEquals(actual, expected);
System.out.println("Login suceesfully move to Home Page");
	
}

}
