package com.qa.quickstart.com.demoqa;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
public class basic {
	
	public ChromeDriver driver;
	static ExtentReports extent;

	@BeforeClass
	public void init() {
		extent= new ExtentReports("C:\\Users\\Admin\\Documents\\WebAutomaticTesting\\toolsqa\\com.demoqa\\Reports\\extent.html", true);
	}
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\Development\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
	}
	
	@Test
	@Ignore
	public void tabs() {
		ExtentTest test1 = extent.startTest("Tabs Utility");
		driver.manage().window().maximize();
		String url = "http://demoqa.com/tabs/";
		driver.navigate().to(url);
		//tabs
		WebElement tab1 = driver.findElementById("ui-id-1");
		WebElement tab2 = driver.findElementById("ui-id-2");
		WebElement tab3 = driver.findElementById("ui-id-3");
		WebElement text1 = driver.findElementById("tabs-1");
		WebElement text2 = driver.findElementById("tabs-2");
		WebElement text3 = driver.findElementById("tabs-3");
		
		System.out.println(text1.getAttribute("aria-hidden"));
		try {
		assertEquals("false",text1.getAttribute("aria-hidden"));
		test1.log(LogStatus.PASS, "Tab 1 Selected.");
		}catch(AssertionError e) {
			test1.log(LogStatus.FAIL, "oof, ouch, owie my code");
			
			fail();
		}finally {
			test1.log(LogStatus.INFO, "Current URL: " + driver.getCurrentUrl());
			extent.endTest(test1);
		}
		
		tab2.click();
		try {
		assertEquals("true",text1.getAttribute("aria-hidden"));
		assertEquals("false",text2.getAttribute("aria-hidden"));
		test1.log(LogStatus.PASS, "Tab 1 Hidden on Tab2 Shown.");
		}catch(AssertionError e) {
			test1.log(LogStatus.FAIL, "oof, ouch, owie my code");
			fail();
		}finally {
			test1.log(LogStatus.INFO, "Current URL: " + driver.getCurrentUrl());
			extent.endTest(test1);
		}
		tab3.click();
		try {
		assertEquals("true",text2.getAttribute("aria-hidden"));
		assertEquals("false",text3.getAttribute("aria-hidden"));
		test1.log(LogStatus.PASS, "Tab 2 Hidden on Tab 3 Shown.");
		}catch(AssertionError e) {
			test1.log(LogStatus.FAIL, "oof, ouch, owie my code");
			fail();
		}finally {
			test1.log(LogStatus.INFO, "Current URL: " + driver.getCurrentUrl());
			extent.endTest(test1);
		}

	}
	
	@Test
	@Ignore
	public void accordian() {
		driver.manage().window().maximize();
		String url = "http://demoqa.com/accordion/";
		driver.navigate().to(url);
		//tabs
		WebElement tab1 = driver.findElementById("ui-id-4");
		WebElement tab2 = driver.findElementById("ui-id-6");
		WebElement tab3 = driver.findElementById("ui-id-8");
		WebElement tab4 = driver.findElementById("ui-id-10");

		WebElement text1 = driver.findElementById("ui-id-5");
		WebElement text2 = driver.findElementById("ui-id-7");
		WebElement text3 = driver.findElementById("ui-id-9");
		WebElement text4 = driver.findElementById("ui-id-11");

		
		System.out.println(text1.getAttribute("aria-hidden"));
		assertEquals("false",text1.getAttribute("aria-hidden"));
		tab2.click();
		assertEquals("true",text1.getAttribute("aria-hidden"));
		assertEquals("false",text2.getAttribute("aria-hidden"));
		tab3.click();
		assertEquals("true",text2.getAttribute("aria-hidden"));
		assertEquals("false",text3.getAttribute("aria-hidden"));
		tab4.click();
		assertEquals("true",text3.getAttribute("aria-hidden"));
		assertEquals("false",text4.getAttribute("aria-hidden"));


	}
	
	@Test
	@Ignore
	public void autocomplete() {
		String url = "http://demoqa.com/autocomplete/";
		driver.navigate().to(url);

		WebElement tags = driver.findElementById("tagss");
		WebElement list = driver.findElementById("ui-id-1");
		tags.click();
		tags.sendKeys("BAS");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("block", list.getCssValue("display") );
		WebElement item = driver.findElementByXPath("//*[@id=\"ui-id-1\"]");
		
		item.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("BASIC", tags.getAttribute("value"));
		tags.sendKeys("BORISMANANANANANA");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("none", list.getCssValue("display") );

	}
	
	@Test
	@Ignore
	public void datepicker() {
		String url = "http://demoqa.com/datepicker/";
		driver.navigate().to(url);
		WebElement pickerBox = driver.findElementById("datepicker1");
		
		pickerBox.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement date = driver.findElementByXPath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[5]/a");
		date.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("June 15, 2018", pickerBox.getAttribute("value"));
	}
	
	@Test
	public void menu() {
		String url = "http://demoqa.com/menu/";
		driver.navigate().to(url);
		
		driver.findElementsById("#ui-id-2");
	}
	
	@After
	public void tearDown() {
		driver.close();
		extent.fluch();
	}
 

}
