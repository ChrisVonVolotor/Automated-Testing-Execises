package com.qa.quickstart.com.practiceselenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class NavigationSteps {
	WebDriver myDriver;
	
	
	@Given("^a functioning webDriver$")
	public void setUpWebDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Dale\\Desktop\\chromedriver.exe");
		myDriver = new ChromeDriver();
		myDriver.manage().window().maximize();
		assertNotNull(myDriver);
	}
	@When("^I call the Navigate method to https://www.google.co.uk/$")
	public void webDriverNavigate() {
		myDriver.navigate().to("https://www.google.co.uk/");
	}
	
	@Then("^the driver's URL should be https://www.google.co.uk/$")
	public void checkNavigationg() {
		assertEquals("https://www.google.co.uk/", myDriver.getCurrentUrl());
}
}
