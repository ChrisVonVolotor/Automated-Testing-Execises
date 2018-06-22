package com.qa.quickstart.DemoSite;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class demoSiteBasic {
	public ChromeDriver driver;
	public ExtentReports extent;
    ArrayList<String> userNames = new ArrayList<String>();
    ArrayList<String> password = new ArrayList<String>();
	
	private void usersIn() {

		XSSFWorkbook wb = null;
    FileInputStream file;


	try {
		file = new FileInputStream(new File("C:\\Users\\Admin\\Documents\\WebAutomaticTesting\\demosite\\DemoSite\\excel\\users.xlsx"));
		wb = new XSSFWorkbook(file);
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	
	XSSFSheet sheet = wb.getSheetAt(0);
	DataFormatter formatter = new DataFormatter();
	for (Iterator<Row> iterator = sheet.rowIterator(); iterator.hasNext();) {
	    XSSFRow row = (XSSFRow) iterator.next();
	    for (int i = 0; i < row.getPhysicalNumberOfCells(); i=i+2) {
	        XSSFCell cellUser = row.getCell(i, MissingCellPolicy.CREATE_NULL_AS_BLANK);
	        XSSFCell cellPass = row.getCell(i+1, MissingCellPolicy.CREATE_NULL_AS_BLANK);

	        //System.out.println(formatter .formatCellValue(cell));
	        userNames.add(formatter .formatCellValue(cellUser));
	        password.add(formatter .formatCellValue(cellPass));
	    }

	}

		
}
	
	private void logger(WebElement username, WebElement password, WebElement submit, String thisUsername, String thisPassword) {
		username.click();
		username.sendKeys(Keys.chord(thisUsername));
		password.click();
		password.sendKeys(Keys.chord(thisPassword));
		submit.click();
	}
	
	
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\Development\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		extent = new ExtentReports("C:\\Users\\Admin\\Documents\\WebAutomaticTesting\\demosite\\DemoSite\\Reports\\extent.html", true);
		usersIn();
	}
	
	@Test
	public void test() {
		Iterator<String> it1 = userNames.iterator();
		Iterator<String> it2 = password.iterator();
		
		WebElement username;
		WebElement password;
		WebElement submit;
		WebElement win;
		String lUsername;
		String lPassword;
		ExtentTest test = extent.startTest("Change UserName and Password and test Login");
		driver.manage().window().maximize();

		while (it1.hasNext() || it2.hasNext()) {
			String url = "http://thedemosite.co.uk/addauser.php";
			driver.navigate().to(url);
			lUsername = it1.next();
			lPassword = it2.next();
			
			username = driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input");
			password = driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input");
			submit = driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input");
			test.log(LogStatus.INFO, "Set new Username and Password");
			System.out.println("usr: " + lUsername + " pass: " + lPassword);
			logger(username,password,submit,lUsername,lPassword);
			
			test.log(LogStatus.INFO, "Navigate to login page and input login details");
			url = "http://thedemosite.co.uk/login.php";
			driver.navigate().to(url);
			username = driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input");
			password = driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input");
			submit = driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input");
			
			win = driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font");
			//System.out.println(win.getText());

			logger(username,password,submit,lUsername,lPassword);
			System.out.println("usr: " + lUsername + " pass: " + lPassword);
			win = driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font");

			System.out.println(win.getCssValue("color"));
			System.out.println("");
			
			try {
			assertEquals("rgba(255, 0, 0, 1)", win.getCssValue("color"));
			test.log(LogStatus.PASS, lUsername + " Login Successfull.");
			}catch(AssertionError e) {
				test.log(LogStatus.FAIL, "oof, ouch, owie my code");
			}
		}
		test.log(LogStatus.INFO, "All Elelements Looped through successfully");
		extent.endTest(test);
	}
	
	@After
	public void tearDown() {
		driver.close();
		extent.flush();
	}
	

}
