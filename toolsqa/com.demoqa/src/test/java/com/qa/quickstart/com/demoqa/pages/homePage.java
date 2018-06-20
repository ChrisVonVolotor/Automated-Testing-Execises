package com.qa.quickstart.com.demoqa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class homePage {
	@FindBy(xpath="//*[@id=\"menu-item-140\"]")
	private WebElement button;
	
	public void clickButton() {
		button.click();
	}
}
