package com.qa.quickstart.com.demoqa;

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
	@Ignore
	public void tabs() {
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
		assertEquals("false",text1.getAttribute("aria-hidden"));
		tab2.click();
		assertEquals("true",text1.getAttribute("aria-hidden"));
		assertEquals("false",text2.getAttribute("aria-hidden"));
		tab3.click();
		assertEquals("true",text2.getAttribute("aria-hidden"));
		assertEquals("false",text3.getAttribute("aria-hidden"));


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
	public void autocomplete() {
		String url = "http://demoqa.com/autocomplete/";
		driver.navigate().to(url);

		WebElement tags = driver.findElementById("tagss");
		WebElement list = driver.findElementById("ui-id-1");
		tags.click();
		tags.sendKeys("B");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		assertEquals("block", list.getCssValue("display") );
		tags.sendKeys("BORISMANANANANANA");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("none", list.getCssValue("display") );

	}
	
	@After
	public void tearDown() {
		driver.close();
	}
	

}
