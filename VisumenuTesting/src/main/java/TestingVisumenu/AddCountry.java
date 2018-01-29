package TestingVisumenu;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utils.Constants;
import Utils.ExcelUtils;
import Utils.Function;

public class AddCountry {

	final static Logger logger = Logger.getLogger(AddCountry.class);
	private WebDriver driver;

	@BeforeClass
	public void setUp() throws Exception {
		logger.debug("====================init start======================");
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_LOCATION);
		driver = new ChromeDriver();
		driver.get(Constants.ADMIN_URL);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// ExcelUtils.getTableArray(Constants.FILE_FULL_PATH,Constants.VISUMENU_SHEET);
		logger.debug("====================init end======================");
	}

	@Test(priority = 0)
	public void testAddCountry() throws Exception {
		logger.debug("testAddCountry:start");

		// login first
		Function.loginVisumenu(driver, 1);
		Thread.sleep(5000);

		// click on the icon
		driver.findElement(By.xpath("//html/body/root/header/div[1]/div/div[1]/button/span/mat-icon")).click();
		Thread.sleep(5000);

		// click on the Country tab
		driver.findElement(By.linkText("COUNTRY")).click();
		Thread.sleep(3000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/country/button/span/i")).click();
		Thread.sleep(2000);

		// click the tabs to check the mandatory fields

		// country
		driver.findElement(By.xpath("//input[@placeholder='Enter country name']")).sendKeys(Keys.TAB);

		// dialing code
		driver.findElement(By.xpath("//input[@placeholder='Enter dialing code']")).sendKeys(Keys.TAB);

		// code
		driver.findElement(By.xpath("//input[@placeholder='Enter code']")).sendKeys(Keys.TAB);

		// get the errors

		// country
		Assert.assertEquals(driver.getPageSource().contains(Constants.COUNTRY_ERROR), true);

		// dialing code
		Assert.assertEquals(driver.getPageSource().contains(Constants.DIALING_ERROR), true);

		// code
		Assert.assertEquals(driver.getPageSource().contains(Constants.CODE_ERROR), true);

		// validation value 1 from excel sheet calling function
		logger.debug("----------------VALIDATION 1 START----------------------------");
		Function.addCountryValidations(driver, 3, Constants.COUNTRY_SHEET);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.COUNTRY_LENGTH_ERROR), true);
		Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_DIALING_ERROR), true);

		Thread.sleep(3000);
		
		logger.debug("----------------VALIDATION 1 END----------------------------");

		// clear the fields
		Function.cleanFieldsForAddCountry(driver);

		// validation value 2
		logger.debug("----------------VALIDATION 2 START----------------------------");
		Function.addCountryValidations(driver, 4, Constants.COUNTRY_SHEET);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.COUNTRY_LENGTH_ERROR), true);

		Thread.sleep(2000);

		logger.debug("----------------VALIDATION 2 END----------------------------");

		// clearing the fields
		Function.cleanFieldsForAddCountry(driver);

		// validation value 3

		logger.debug("----------------VALIDATION 3 START----------------------------");
		Function.addCountryValidations(driver, 5, Constants.COUNTRY_SHEET);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_DIALING_ERROR), true);

		Thread.sleep(2000);
		
		logger.debug("----------------VALIDATION 3 END----------------------------");

		// clear the fields
		Function.cleanFieldsForAddCountry(driver);

		// validation value 4
		logger.debug("----------------VALIDATION 4 START----------------------------");
		Function.addCountryValidations(driver, 6, Constants.COUNTRY_SHEET);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_COUNTRY_NAME), true);
		Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_CODE_ERROR), true);

		Thread.sleep(3000);
		
		logger.debug("----------------VALIDATION 4 END----------------------------");

		// clear the fields
		Function.cleanFieldsForAddCountry(driver);

		// validation value 5
		logger.debug("----------------VALIDATION 5 START----------------------------");
		Function.addCountryValidations(driver, 7, Constants.COUNTRY_SHEET);

		// click on the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(2000);

		// check for the error
		if (driver.getPageSource().contains(Constants.COUNTRY_ALREADY_TAKEN)) {

			logger.debug("The country has already been taken.");
		} else {
			logger.error("The country has already been taken.");
		}

		Thread.sleep(5000);
		

		logger.debug("----------------VALIDATION 5 END----------------------------");

		// clear the fields
		Function.cleanFieldsForAddCountry(driver);

		Thread.sleep(2000);

		// validation value 6
		logger.debug("----------------VALIDATION 6 START----------------------------");
		Function.addCountryValidations(driver, 8, Constants.COUNTRY_SHEET);

		// click on the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(2000);

		// check for the error
		if (driver.getPageSource().contains(Constants.COUNTRY_ALREADY_TAKEN)) {

			logger.debug("The country has already been taken.");
		} else {
			logger.error("The country has already been taken.");
		}

		Thread.sleep(5000);

		logger.debug("----------------VALIDATION 6 END----------------------------");

		// clear the fields
		Function.cleanFieldsForAddCountry(driver);

		Thread.sleep(2000);
		
		// validation value 7
		logger.debug("----------------VALIDATION 7 START----------------------------");
		Function.addCountryValidations(driver, 9, Constants.COUNTRY_SHEET);

		// click on the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(2000);

		// check for the error
		if (driver.getPageSource().contains(Constants.COUNTRY_ALREADY_TAKEN)) {

			logger.debug("The country has already been taken.");
		} else {
			logger.error("The country has already been taken.");
		}

		Thread.sleep(5000);
		

		logger.debug("----------------VALIDATION 7 END----------------------------");

		// clear the fields
		Function.cleanFieldsForAddCountry(driver);

		Thread.sleep(2000);

		// validation value 8
		logger.debug("----------------VALIDATION 8 START----------------------------");
		Function.addCountryValidations(driver, 10, Constants.COUNTRY_SHEET);

		// click on the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(2000);

		// check for the error
		if (driver.getPageSource().contains(Constants.DIALING_CODE_ALREADY_TAKEN)) {

			logger.debug("The dialing code has already been taken.");
		} else {
			logger.error("The dialing code has already been taken.");
		}

		Thread.sleep(5000);

		logger.debug("----------------VALIDATION 8 END----------------------------");

		// clear the fields
		Function.cleanFieldsForAddCountry(driver);

		// validation value 9
		logger.debug("----------------VALIDATION 9 START----------------------------");
		Function.addCountryValidations(driver, 11, Constants.COUNTRY_SHEET);

		// click on the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(2000);

		// check for the error
		if (driver.getPageSource().contains(Constants.CODE_ALREADY_TAKEN)) {

			logger.debug("The code has already been taken.");
		} else {
			logger.error("The code has already been taken.");
		}

		Thread.sleep(5000);
		

		logger.debug("----------------VALIDATION 9 END----------------------------");

		// clear the fields
		Function.cleanFieldsForAddCountry(driver);

		Thread.sleep(2000);

		// remove comments if wanted to add country (i did so i commented and
		// change the all values in the excel sheet other errors will be thrown)

		// passing correct values
		logger.debug("----------------VALIDATION LAST----------------------------");
		Function.addCountryValidations(driver, 12, Constants.COUNTRY_SHEET);

		// click on the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);

		logger.debug("----------------VALIDATION LAST END----------------------------");
		
		logger.debug("testAddCountry:end");

	}

	@Test(priority = 1)
	public void searchCountry() throws Exception {

		logger.debug("searchCountry:start");

		// refresh the page
		driver.navigate().refresh();

		// search country
		driver.findElement(By.xpath("//input[@placeholder='Search country name...']"))
				.sendKeys(ExcelUtils.getCellData(12, 1, Constants.COUNTRY_SHEET));
		Thread.sleep(2000);

		// Check for the entered values
		// country
		String enteredCountryPresent = driver
				.findElement(By.xpath("//*[@id='scrollOnTop']/form/table/tbody/tr/td[1]/input")).getText();
		if (driver.getPageSource().contains(enteredCountryPresent)) {
			logger.debug("Entered country is present");
		}

		else {
			logger.error("Entered country is not present");
		}

		Thread.sleep(2000);

		// dialing code
		String enteredDialingCPresent = driver
				.findElement(By.xpath("//*[@id='scrollOnTop']/form/table/tbody/tr/td[2]/input")).getText();
		if (driver.getPageSource().contains(enteredDialingCPresent)) {
			logger.debug("Entered dialing code is present");
		}

		else {
			logger.error("Entered dialing code is not present");
		}

		Thread.sleep(2000);

		// code
		String enteredCodePresent = driver
				.findElement(By.xpath("//*[@id='scrollOnTop']/form/table/tbody/tr/td[3]/input")).getText();
		if (driver.getPageSource().contains(enteredCodePresent)) {
			logger.debug("Entered code is present");
		}

		else {
			logger.error("Entered code is not present");
		}

		Thread.sleep(2000);
		
		logger.debug("searchCountry:end");

	}

	@Test(priority = 2)
	public void deleteCountry() throws Exception {
		
		logger.debug("deleteCountry:start");

		// click on the delete icon
		WebElement clickOnDeleteIcon = driver
				.findElement(By.xpath("//*[@id='scrollOnTop']/form/table/tbody/tr/td[4]/button"));
		clickOnDeleteIcon.click();

		Thread.sleep(3000);

		// move to the popup and click on yes to delete
		WebElement clickYes = driver
				.findElement(By.xpath("//html/body/root/country/app-delete-item/div[1]/form/div/button[1]"));
		clickYes.click();

		Thread.sleep(3000);
		
		logger.debug("deleteCountry:end");

	}

	@Test(priority = 3)
	public void searchCountryAfterDeleting() throws Exception {
		
		logger.debug("searchCountryAfterDeleting:start");
		
		driver.navigate().refresh();
		Thread.sleep(5000);

		// search country
		driver.findElement(By.xpath("//input[@placeholder='Search country name...']"))
				.sendKeys(ExcelUtils.getCellData(12, 1, Constants.COUNTRY_SHEET));
		Thread.sleep(2000);

		// assert to check ,the country deleted should not be present
		Assert.assertEquals(driver.getPageSource().contains(Constants.COUNTRY_NOT_FOUND), true);
		Thread.sleep(2000);
		
		logger.debug("searchCountryAfterDeleting:end");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
