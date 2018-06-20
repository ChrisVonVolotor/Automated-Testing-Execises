package com.qa.quickstart.com.demoqa;

import static org.junit.Assert.*;

import java.awt.Desktop.Action;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class basic {
	
	public ChromeDriver driver;
	static ExtentReports extent;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\Development\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		extent= new ExtentReports("C:\\Users\\Admin\\Documents\\WebAutomaticTesting\\toolsqa\\com.demoqa\\Reports\\extent.html", false);
	}
	
	@Test
	public void tabs() {
		ExtentTest test1 = extent.startTest("Tabs Utility");
		String url = "http://demoqa.com/tabs/";
		driver.navigate().to(url);
		//tabs
		WebElement tab1 = driver.findElementById("ui-id-1");
		WebElement tab2 = driver.findElementById("ui-id-2");
		WebElement tab3 = driver.findElementById("ui-id-3");
		WebElement text1 = driver.findElementById("tabs-1");
		WebElement text2 = driver.findElementById("tabs-2");
		WebElement text3 = driver.findElementById("tabs-3");
		
		tab1.click();
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
	public void accordian() {
		ExtentTest test1 = extent.startTest("Accordian Tabs");
		
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
		
		tab1.click();
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
		test1.log(LogStatus.PASS, "Tab 1 Hidden When Tab 2 Selected.");
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
		test1.log(LogStatus.PASS, "Tab 2 Hidden When Tab 3 Selected.");
		}catch(AssertionError e) {
			test1.log(LogStatus.FAIL, "oof, ouch, owie my code");
			fail();
		}finally {
			test1.log(LogStatus.INFO, "Current URL: " + driver.getCurrentUrl());
			extent.endTest(test1);
		}
		tab4.click();
		try {
		assertEquals("true",text3.getAttribute("aria-hidden"));
		assertEquals("false",text4.getAttribute("aria-hidden"));
		test1.log(LogStatus.PASS, "Tab 3 Hidden When Tab 4 Selected.");
		}catch(AssertionError e) {
			test1.log(LogStatus.FAIL, "oof, ouch, owie my code");
			fail();
		}finally {
			test1.log(LogStatus.INFO, "Current URL: " + driver.getCurrentUrl());
			extent.endTest(test1);
		}
	}
	
	@Test
	public void autocomplete() {
		ExtentTest test1 = extent.startTest("Autocomplete");
		Actions action = new Actions(driver);

		String url = "http://demoqa.com/autocomplete/";
		driver.navigate().to(url);

		WebElement tags = driver.findElementById("tagss");
		WebElement list = driver.findElementById("ui-id-1");
		tags.click();
		test1.log(LogStatus.INFO, "Make a valid Searh");
		tags.sendKeys("BAS");
		action.pause(1000).perform();

		
		try {
		assertEquals("block", list.getCssValue("display") );
		test1.log(LogStatus.PASS, "Drop Down Displayed");
		}catch(AssertionError e) {
			test1.log(LogStatus.FAIL, "oof, ouch, owie my code");
			fail();
		}finally {
			test1.log(LogStatus.INFO, "Current URL: " + driver.getCurrentUrl());
			extent.endTest(test1);
		}
		
		WebElement item = driver.findElementByXPath("//*[@id=\"ui-id-1\"]");
		
		item.click();
		action.pause(1000).perform();

		try {
		assertEquals("BASIC", tags.getAttribute("value"));
		test1.log(LogStatus.PASS, "Selection Confirmed");
		}catch(AssertionError e) {
			test1.log(LogStatus.FAIL, "oof, ouch, owie my code");
			fail();
		}finally {
			test1.log(LogStatus.INFO, "Current URL: " + driver.getCurrentUrl());
			extent.endTest(test1);
		}
		test1.log(LogStatus.INFO, "Make an Incorrect Search");
		tags.sendKeys("BORISMANANANANANA");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
		assertEquals("none", list.getCssValue("display") );
		test1.log(LogStatus.PASS, "No results Confimed");
		}catch(AssertionError e) {
			test1.log(LogStatus.FAIL, "oof, ouch, owie my code");
			fail();
		}finally {
			test1.log(LogStatus.INFO, "Current URL: " + driver.getCurrentUrl());
			extent.endTest(test1);
		}
	}
	
	@Test
	public void datepicker() {
		ExtentTest test1 = extent.startTest("Date picker");
		 Actions action = new Actions(driver);

		String url = "http://demoqa.com/datepicker/";
		driver.navigate().to(url);
		WebElement pickerBox = driver.findElementById("datepicker1");
		test1.log(LogStatus.INFO, "Bring up calander");

		pickerBox.click();
		action.pause(1000).perform();
		test1.log(LogStatus.INFO, "Select date");
		WebElement date = driver.findElementByXPath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[5]/a");
		date.click();
		action.pause(1000).perform();

		try {
		assertEquals("June 15, 2018", pickerBox.getAttribute("value"));
		test1.log(LogStatus.PASS, "Date selected was input into textbox");
		}catch(AssertionError e) {
			test1.log(LogStatus.FAIL, "oof, ouch, owie my code");
			fail();
		}finally {
			test1.log(LogStatus.INFO, "Current URL: " + driver.getCurrentUrl());
			extent.endTest(test1);
		}
	}
	
	@Test
	public void menu() {
		 Actions action = new Actions(driver);

		ExtentTest test1 = extent.startTest("Menu Hover");
		String url = "http://demoqa.com/menu/";
		driver.navigate().to(url);
		
		WebElement selMenu = driver.findElementById("ui-id-2");
		selMenu.click();
		action.pause(500).perform();
		WebElement menu = driver.findElementByXPath("//*[@id=\"tabs-2\"]/div//*[@id=\"navigate\"]/ul/li[1]");
		WebElement subMenu = driver.findElementByXPath("//*[@id=\"tabs-2\"]/div//*[@id=\"navigate\"]/ul/li[1]/ul/li[1]");

		action.moveToElement(menu).pause(1000).moveByOffset(100, 0).pause(2000).build().perform();
		
		try {
			assertEquals("rgba(255, 153, 0, 1)", subMenu.getCssValue("background-color"));
			test1.log(LogStatus.PASS, "Hover Menu is GOLD. Always beleive in GOLD.");
			}catch(AssertionError e) {
				test1.log(LogStatus.FAIL, "oof, ouch, owie my code");
				fail();
			}finally {
				test1.log(LogStatus.INFO, "Current URL: " + driver.getCurrentUrl());
				extent.endTest(test1);
			}
	}

	@Test
	public void slider() {
		Actions action = new Actions(driver);
		ExtentTest test1 = extent.startTest("Slider");
		String url = "http://demoqa.com/slider/";
		driver.navigate().to(url);
		//WebElement slider = (new WebDriverWait(driver, 10)) .until(ExpectedConditions.presenceOfElementLocated(By.className("ui-slider-handle ui-state-default ui-corner-all"))); 
		WebElement display = driver.findElementByXPath("//*[@id=\"amount1\"]");
		System.out.print(display.getText());
		//Integer num1 = Integer.parseInt(display.getText());
		
		action.moveToElement(display,50,40).clickAndHold().moveByOffset(300, 0).release().perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Integer num2 = Integer.parseInt(display.getText());
		try {
		assertEquals("6", display.getAttribute("value"));
		test1.log(LogStatus.PASS, "Slider slide slylylylylyly");
		}catch(AssertionError e) {
			test1.log(LogStatus.FAIL, "oof, ouch, owie my code");
			fail();
		}finally {
			test1.log(LogStatus.INFO, "Current URL: " + driver.getCurrentUrl());
			extent.endTest(test1);
		}
	}
	
	@Test
	public void toolTip() {
		Actions action = new Actions(driver);
		ExtentTest test1 = extent.startTest("Slider");
		String url = "http://demoqa.com/tooltip/";
		driver.navigate().to(url);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement age = driver.findElementById("age");
		action.moveToElement(age).pause(2500).build().perform();
		try {
			assertNotNull(driver.findElementByClassName("ui-tooltip-content").getText());
			test1.log(LogStatus.PASS, "Tool Tip'd m'browser");
		}catch(AssertionError e) {
			test1.log(LogStatus.FAIL, "oof, ouch, owie my code");
			fail();
		}finally {
			test1.log(LogStatus.INFO, "Current URL: " + driver.getCurrentUrl());
			extent.endTest(test1);
		}
	}
	
	@Test
	public void draggable() {
		Actions action = new Actions(driver);
		ExtentTest test1 = extent.startTest("Slider");
		String url = "http://demoqa.com/droppable/";
		driver.navigate().to(url);

		WebElement draggable = driver.findElementById("draggableview");
		WebElement target = driver.findElementById("droppableview");
		
		action.moveToElement(draggable).clickAndHold().moveByOffset(160, 20).release().pause(2000).build().perform();
		System.out.println(target.getText());
		try {
		assertEquals("Dropped!",target.getText());
		test1.log(LogStatus.PASS, "Dropped");
		}catch(AssertionError e) {
			test1.log(LogStatus.FAIL, "oof, ouch, owie my code");
			fail();
		}finally {
			test1.log(LogStatus.INFO, "Current URL: " + driver.getCurrentUrl());
			extent.endTest(test1);
		}

	}
	
	@Test
	public void selectable() {
		Actions action = new Actions(driver);
		ExtentTest test1 = extent.startTest("Selectable");
		String url = "http://demoqa.com/selectable/";
		driver.navigate().to(url);
		
		WebElement item1 = driver.findElementByXPath("//*[@id=\"selectable\"]/li[1]");
		WebElement item2 = driver.findElementByXPath("//*[@id=\"selectable\"]/li[2]");
		WebElement item3 = driver.findElementByXPath("//*[@id=\"selectable\"]/li[3]");
		WebElement item4 = driver.findElementByXPath("//*[@id=\"selectable\"]/li[4]");
		WebElement item5 = driver.findElementByXPath("//*[@id=\"selectable\"]/li[5]");
		WebElement item6 = driver.findElementByXPath("//*[@id=\"selectable\"]/li[6]");
		WebElement item7 = driver.findElementByXPath("//*[@id=\"selectable\"]/li[7]");
		
		action.moveToElement(item1).clickAndHold().moveByOffset(20, 150).release().pause(2000).build().perform();
		System.out.println(item1.getAttribute("class"));
		try {
		assertEquals("ui-widget-content ui-corner-left ui-selectee ui-selected", item1.getAttribute("class"));
		assertEquals("ui-widget-content ui-corner-left ui-selectee ui-selected", item2.getAttribute("class"));
		assertEquals("ui-widget-content ui-corner-left ui-selectee ui-selected", item3.getAttribute("class"));
		assertEquals("ui-widget-content ui-corner-left ui-selectee ui-selected", item4.getAttribute("class"));
		assertEquals("ui-widget-content ui-corner-left ui-selectee ui-selected", item5.getAttribute("class"));
		assertEquals("ui-widget-content ui-corner-left ui-selectee", item6.getAttribute("class"));
		assertEquals("ui-widget-content ui-corner-left ui-selectee", item7.getAttribute("class"));
		test1.log(LogStatus.PASS, "Selectable 1-5 selected, Selectable 6-7 Unselected");
		}catch(AssertionError e) {
			test1.log(LogStatus.FAIL, "oof, ouch, owie my code");
			fail();
		}finally {
			test1.log(LogStatus.INFO, "Current URL: " + driver.getCurrentUrl());
			extent.endTest(test1);
		}
	}

	@After
	public void tearDown() {
		driver.close();
		extent.flush();
	}
}
