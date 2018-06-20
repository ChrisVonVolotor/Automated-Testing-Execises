package com.qa.quickstart.net.phptravels.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class resultPage {
	@FindBy(xpath="//*[@id=\"body-section\"]/div[5]/div/div[3]/div[1]/div/table/tbody/tr/td/div[3]/a/button\r\n")
	private WebElement detailsResult;
	
	public void submit() {
		detailsResult.click();
	}
}
