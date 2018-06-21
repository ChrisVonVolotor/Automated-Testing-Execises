package com.qa.quickstart.net.phptravels.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class homePage {
	@FindBy(id="select2-drop-mask")
	private WebElement mask;
	
	@FindBy(id="select2-drop")
	private WebElement cityBarContainer;
	
	@FindBy(css="#select2-drop > div > input")
	private WebElement cityBar;
	
	@FindBy(xpath="//*[@id=\"select2-drop\"]/ul/li/ul/li[1]")
	private WebElement citybarResult1;
	
	@FindBy(xpath="//*[@id=\"dpd1\"]/div/input")
	private WebElement date1;
	
	@FindBy(xpath="/html/body/div[8]/div[1]/table/tbody/tr[4]/td[5]")
	private WebElement date1Pick;
	
	@FindBy(xpath="//*[@id=\"dpd2\"]/div/input")
	private WebElement date2;

	@FindBy(xpath="/html/body/div[9]/div[1]/table/tbody/tr[5]/td[4]")
	private WebElement date2Pick;
	
	@FindBy(xpath="//*[@id=\"travellersInput\"]")
	private WebElement adultPick;
	
	@FindBy(xpath="//*[@id=\"adultPlusBtn\"]")
	private WebElement adultPickInc;
	
	@FindBy(xpath="//*[@id=\"HOTELS\"]/form/div[5]/button")
	private WebElement searchBut;
	
	
	public void setCity(ChromeDriver driver) {
		Actions action = new Actions(driver);
		
	//	action.pause(2000).build().perform();
	//	mask.click();
	//	cityBarContainer.click();
		//action.pause(2000).build().perform();
		action.moveByOffset(500, 300).perform();
		action.click().perform();
		action.sendKeys("Lond").perform();
		action.pause(2500).perform();
		action.sendKeys(Keys.RETURN).perform();
		//action.moveByOffset(350, 260).contextClick().sendKeys("Lond").pause(2000).moveToElement(citybarResult1).click().build().perform();
		//cityBar.sendKeys("Lond");
		//action.pause(2000).build().perform();
		//citybarResult1.click();
		
		return;
	}
	
	public void setDates(ChromeDriver driver) {
		Actions action = new Actions(driver);

		date1.click();
		//action.pause(2500);

		date1Pick.click();
		//action.pause(2000).build().perform();
		//date2.click();
		//action.pause(2000).build().perform();
		date2Pick.click();
		//action.pause(2000).build().perform();
		return;
	}
	
	public void setAdults3(ChromeDriver driver) {
		Actions action = new Actions(driver);

		adultPick.click();
		//action.pause(2000).build().perform();;

		adultPickInc.click();
		return;
	}
	
	public void submit() {
		searchBut.click();
		return;
	}

}
