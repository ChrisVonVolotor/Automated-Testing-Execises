package com.qa.quickstart.DemoSite;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class demoSiteBasic {
	public ChromeDriver driver;
	public ExtentReports extent;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\Development\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		extent = new ExtentReports("C:\\Users\\Admin\\Documents\\WebAutomaticTesting\\demosite\\DemoSite\\Reports\\extent.html", true);

	}
	
	@Test
	public void test() {
		ExtentTest test = extent.startTest("Change UserName and Password and test Login");
		driver.manage().window().maximize();
		String url = "http://thedemosite.co.uk/addauser.php";
		driver.navigate().to(url);
		WebElement username = driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input");
		WebElement password = driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input");
		WebElement submit = driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input");
		test.log(LogStatus.INFO, "Set new Username and Password");
		username.click();
		username.sendKeys(Keys.chord("usrNameCD"));
		password.click();
		password.sendKeys(Keys.chord("usrNameCD"));
		submit.click();
		test.log(LogStatus.INFO, "Navigate to login page and input login details");
		url = "http://thedemosite.co.uk/login.php";
		driver.navigate().to(url);
		username = driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input");
		password = driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input");
		submit = driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input");
		
		username.click();
		username.sendKeys(Keys.chord("usrNameCD"));
		password.click();
		password.sendKeys(Keys.chord("usrNameCD"));
		submit.click();
		WebElement succ = driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b");

		
		try {
		assertEquals("**Successful Login**",succ.getText());
		test.log(LogStatus.PASS, "Login Successfull.");
		}catch(AssertionError e) {
			test.log(LogStatus.FAIL, "oof, ouch, owie my code");
		}finally {
			test.log(LogStatus.INFO, "Current URL: " + driver.getCurrentUrl());
			extent.endTest(test);
		}

	}
	
	@After
	public void tearDown() {
		driver.close();
		extent.flush();
	}
	

}
