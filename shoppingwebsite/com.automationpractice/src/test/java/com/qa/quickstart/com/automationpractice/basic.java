package com.qa.quickstart.com.automationpractice;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class basic {
	public ChromeDriver driver;
	static ExtentReports extent;

	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\Development\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		extent= new ExtentReports("C:\\Users\\Admin\\Documents\\WebAutomaticTesting\\shoppingwebsite\\com.automationpractice\\Reports\\extent.html", true);
	}
	
	@Test
	public void test() {
		ExtentTest test = extent.startTest("Shopping Search Results");
		driver.manage().window().maximize();
		String url = "http://automationpractice.com/index.php";
		driver.navigate().to(url);
		WebElement searchbar = driver.findElementByXPath("//*[@id=\"search_query_top\"]");
		WebElement searchButton = driver.findElementByXPath("//*[@id=\"searchbox\"]/button");
		searchbar.click();
		test.log(LogStatus.INFO, "Searching for Dress");
		searchbar.sendKeys("Dress");
		searchButton.click();
		WebElement result = driver.findElementByXPath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img");
		try {
		test.log(LogStatus.INFO, "Checking for results...");
		assertNotNull(result);
		test.log(LogStatus.PASS, "Search result found");
		}catch(AssertionError e) {
			test.log(LogStatus.FAIL, "oof, ouch, owie my code");
			fail();
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
