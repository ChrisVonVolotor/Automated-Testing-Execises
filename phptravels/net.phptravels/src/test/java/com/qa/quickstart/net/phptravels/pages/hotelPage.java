package com.qa.quickstart.net.phptravels.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class hotelPage {
	@FindBy(xpath="//*[@id=\"ROOMS\"]/div/table/tbody/tr[1]/td/div[2]/div[2]/div/div[3]/div/button")
	private WebElement bookButton;
	
	public void submit() {
		bookButton.click();
	}
}
