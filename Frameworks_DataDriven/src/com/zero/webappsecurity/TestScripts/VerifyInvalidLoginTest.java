package com.zero.webappsecurity.TestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.zero.webappsecurity.Pages.Login;
import com.zero.webappsecurity.Pages.LoginError;

import utils.GenericMethods;

public class VerifyInvalidLoginTest {
	
WebDriver driver;
	
	@BeforeTest
	public void openApplication() {
		System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Selenium\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://zero.webappsecurity.com/login.html");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void verifyInvalidLogin() throws IOException {
		Login lp = new Login(driver);
		LoginError le = new LoginError(driver);
		String[][] data = GenericMethods.getData("C:\\Ritu\\Selenium Training\\TestData.xlsx", "Sheet1");
		
		for (int i=1;i<data.length;i++) {
		
			lp.applicationLogin(data[i][0],data[i][1]);
			String ActualMsg = le.getErrorMsg();;
			String ExpectedMsg = "Login and/or password are wrong.";
			Assert.assertEquals(ActualMsg, ExpectedMsg);
			driver.navigate().back();
		}
		
	}
	
	
	@AfterTest
	public void DriverClose() {
		driver.close();
	}

}
