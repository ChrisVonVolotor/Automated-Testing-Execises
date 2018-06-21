package com.qa.quickstart.com.practiceselenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TeaTestingSteps {
	public ChromeDriver driver;
	static ExtentReports extent;
	
	
	@Given("^the correct web address$")
	public void isCorrectAddress() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dale\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		assertEquals("http://www.practiceselenium.com/welcome.html", driver.getCurrentUrl());

	}
	@When("^I navigate to the 'Menu' page$")
	public void setNavMenu() {
		driver.navigate().to("http://www.practiceselenium.com/menu.html");
	}
	
	@Then("^I can browse a list of the available products$")
	public void checkTeaIsHere() {
		WebElement itemsForSale = driver.findElementByXPath("//*[@id=\"wsb-element-00000000-0000-0000-0000-000453230000\"]/div/p/span/span/strong");
		assertEquals(itemsForSale.getText(), "Green Tea");
		driver.close();
		driver.quit();
	}
	
	@Given("^the correct web address$")
	public void setUpWebDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dale\\Desktop\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		assertEquals("http://www.practiceselenium.com/menu.html", driver.getCurrentUrl());

	}
	@When("^I click the checkout button$")
	public void webDriverNavigate() {
		WebElement checkOut = driver.findElementByXPath("//*[@id=\"wsb-button-00000000-0000-0000-0000-000451955160\"]/span");
		checkOut.click();
	}
	
	@Then("^I am taken to the checkout page$")
	public void checkNavigationg() {
		assertEquals("http://www.practiceselenium.com/check-out.html", driver.getCurrentUrl());
		driver.close();
		driver.quit();
	}
	

}
