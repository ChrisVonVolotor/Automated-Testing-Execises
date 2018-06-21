package com.qa.quickstart.net.phptravels.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class hotelPage {
	@FindBy(xpath="//*[@id=\"ROOMS\"]/div/table/tbody/tr[2]/td/div[2]/div[2]/div/div[3]")
	private WebElement bookButton;
	
	public void submit(ChromeDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(bookButton).click().build().perform();
		action.click().pause(3000).build().perform();
		action.pause(2500).perform();
	}
}
