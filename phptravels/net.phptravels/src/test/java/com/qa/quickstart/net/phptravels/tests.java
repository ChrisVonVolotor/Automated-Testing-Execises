package com.qa.quickstart.net.phptravels;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.quickstart.net.phptravels.pages.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class tests {
	public ChromeDriver driver;
	static ExtentReports extent;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\Development\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		extent= new ExtentReports("C:\\Users\\Admin\\Documents\\WebAutomaticTesting\\toolsqa\\com.demoqa\\Reports\\extent.html", false);
	}
	
	@Test
	public void pomTest() {
		ExtentTest test1 = extent.startTest("Book Seats");

		String url = "https://www.phptravels.net/";
		driver.navigate().to(url);
		/*9
		try {
			driver.manage().wait(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		homePage home = PageFactory.initElements(driver, homePage.class);
				
		home.setCity(driver);
		home.setDates(driver);
		home.setAdults3(driver);
		home.submit();
		
		try {
			driver.manage().wait(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resultPage result = PageFactory.initElements(driver, resultPage.class);
		result.submit();
		
		try {
			driver.manage().wait(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		hotelPage hotel = PageFactory.initElements(driver, hotelPage.class);
		hotel.submit();		
		
		
	}
	
	@After
	public void tearDown() {
		driver.close();
		extent.flush();
	}
}
