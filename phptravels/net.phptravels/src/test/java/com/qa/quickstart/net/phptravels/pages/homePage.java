package com.qa.quickstart.net.phptravels.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;

public class homePage {
	@FindBy(xpath="//*[@id=\"select2-drop\"]/div/input")
	private WebElement cityBar;
	
	
	@FindBy(xpath="//*[@id=\"select2-drop\"]/ul/li/ul/li[1]")
	private WebElement citybarResult1;
	
	@FindBy(xpath="//*[@id=\"dpd1\"]/div/input")
	private WebElement date1;
	
	@FindBy(xpath="/html/body/div[8]/div[1]/table/tbody/tr[4]/td[5]")
	private WebElement date1Pick;
	
	@FindBy(xpath="//*[@id=\"dpd2\"]/div/input")
	private WebElement date2;
	
	@FindBy(xpath="/html/body/div[9]/div[1]/table/tbody/tr[5]/td[6]")
	private WebElement date2Pick;
	
	@FindBy(xpath="//*[@id=\"travellersInput\"]")
	private WebElement adultPick;
	
	@FindBy(xpath="//*[@id=\"adultPlusBtn\"]")
	private WebElement adultPickInc;
	
	@FindBy(xpath="//*[@id=\"HOTELS\"]/form/div[5]/button")
	private WebElement searchBut;
	
	
	
	public void setCity(WebDriver driver) {
		cityBar.click();
		cityBar.sendKeys("Lond");
		try {
			driver.manage().wait(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		citybarResult1.click();
		
		
	}
	
	public void setDates(WebDriver driver) {
		date1.click();
		try {
			driver.manage().wait(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		date1Pick.click();
		date2.click();
		try {
			driver.manage().wait(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		date2Pick.click();
	}
	
	public void setAdults3(WebDriver driver) {
		adultPick.click();
		try {
			driver.manage().wait(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		adultPickInc.click();
	}
	
	public void submit() {
		searchBut.click();
	}

}
