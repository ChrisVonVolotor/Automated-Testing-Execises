package com.qa.quickstart.com.automationpractice;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class basic {
	public ChromeDriver driver;
	

	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\Development\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
	}
	
	@Test
	public void test() {
		driver.manage().window().maximize();
		String url = "http://automationpractice.com/index.php";
		driver.navigate().to(url);
		WebElement searchbar = driver.findElementByXPath("//*[@id=\"search_query_top\"]");
		WebElement searchButton = driver.findElementByXPath("//*[@id=\"searchbox\"]/button");
		searchbar.click();
		searchbar.sendKeys("Dress");
		searchButton.click();
		
		WebElement result = driver.findElementByXPath("//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img");
		assertNotNull(result);
		//assertEquals("**Successful Login**",succ.getText());
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void tearDown() {
		driver.close();
	}
	

}
