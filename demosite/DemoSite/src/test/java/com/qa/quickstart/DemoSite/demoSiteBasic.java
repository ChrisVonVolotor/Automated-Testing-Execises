package com.qa.quickstart.DemoSite;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class demoSiteBasic {
	public ChromeDriver driver;
	

	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\Development\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
	}
	
	@Test
	public void test() {
		driver.manage().window().maximize();
		String url = "http://thedemosite.co.uk/addauser.php";
		driver.navigate().to(url);
		WebElement username = driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input");
		WebElement password = driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input");
		WebElement submit = driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input");

		username.click();
		username.sendKeys(Keys.chord("usrNameCD"));
		password.click();
		password.sendKeys(Keys.chord("usrNameCD"));
		submit.click();
		
		url = "http://thedemosite.co.uk/login.php";
		driver.navigate().to(url);
		username = driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input");
		password = driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input");
		submit = driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input");

		username.click();
		username.sendKeys(Keys.chord("usrNameCD"));
		password.click();
		password.sendKeys(Keys.chord("usrNameCD"));
		submit.click();
		
		WebElement succ = driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b");
		
		
		assertEquals("**Successful Login**",succ.getText());
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
