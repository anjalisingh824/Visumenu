package TestingVisumenu;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utils.Constants;
import Utils.ExcelUtils;
import Utils.Function;

public class AddState {
	final static Logger logger = Logger.getLogger(AddState.class);
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
	public void addState() throws Exception {
		logger.debug("addState:start");

		// login first
		Function.loginVisumenu(driver, 1);
		Thread.sleep(2000);

		// click on the icon
		driver.findElement(By.xpath("//html/body/root/header/div[1]/div/div[1]/button/span/mat-icon")).click();
		Thread.sleep(2000);

		// click on the state tab
		driver.findElement(By.linkText("STATE")).click();
		Thread.sleep(5000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/state/button/span/i")).click();
		Thread.sleep(2000);

		// check for the mandatory fields
		// state
		 driver.findElement(By.xpath("//input[@placeholder='Enter State name']")).sendKeys(Keys.TAB);
		
		 // code
		 driver.findElement(By.xpath("//input[@placeholder='Enter Code']")).sendKeys(Keys.TAB);
		
		 // country
		 Actions action = new Actions(driver);
		 WebElement country =
		 driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		 action.moveToElement(country).sendKeys(Keys.TAB).build().perform();
		
		 Thread.sleep(2000);
		
		 // check for the errors
		 Assert.assertEquals(driver.getPageSource().contains(Constants.STATE_ERROR),
		 true);
		
		 Assert.assertEquals(driver.getPageSource().contains(Constants.COUNTRY_ERROR),
		 true);
		
		 // Validation value 1
		 logger.debug("-------------------VALIDATION 1 START-----------------------");
		 Function.addStateValidations(driver, 3, Constants.STATE_SHEET);
		
		 // check for the errors
		 Assert.assertEquals(driver.getPageSource().contains(Constants.STATE_LIMIT_ERROR),
		 true);
		
		 logger.debug("-------------------VALIDATION 1 END-----------------------");
		
		 // refresh the page and click on the add button
		 driver.navigate().refresh();
		 Thread.sleep(5000);
		
		 // click on the add button
		 driver.findElement(By.xpath("//html/body/root/state/button/span/i")).click();
		 Thread.sleep(2000);
		
		 // Validation value 2
		 logger.debug("--------------------VALIDATION 2 START-----------------------");
		 Function.addStateValidations(driver, 4, Constants.STATE_SHEET);
		
		 // check for the errors
		 Assert.assertEquals(driver.getPageSource().contains(Constants.STATE_LIMIT_ERROR),
		 true);
		
		 logger.debug("--------------------VALIDATION 2 END-----------------------");
		
		 // refresh the page and click on the add button
		 driver.navigate().refresh();
		 Thread.sleep(5000);
		
		 // click on the add button
		 driver.findElement(By.xpath("//html/body/root/state/button/span/i")).click();
		 Thread.sleep(2000);
		
		 // Validation value 3
		 logger.debug("--------------------VALIDATION 3 START----------------------");
		 Function.addStateValidations(driver, 5, Constants.STATE_SHEET);
		
		 // check for the errors
		 Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_STATE_ERROR),
		 true);
		
		 Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_CODE_ERROR),
		 true);
		
		 logger.debug("--------------------VALIDATION 3 END----------------------");
		
		 // refresh the page and click on the add button
		 driver.navigate().refresh();
		 Thread.sleep(5000);
		
		 // click on the add button
		 driver.findElement(By.xpath("//html/body/root/state/button/span/i")).click();
		 Thread.sleep(2000);
		
		 // validation value 4
		 logger.debug("--------------------VALIDATION 4 START----------------------");
		 Function.addStateValidations(driver, 6, Constants.STATE_SHEET);
		
		 // check for the errors
		 Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_STATE_ERROR),
		 true);
		
		 Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_CODE_ERROR),
		 true);
		
		 logger.debug("--------------------VALIDATION 4 END----------------------");
		
		 // refresh the page and click on the add button
		 driver.navigate().refresh();
		 Thread.sleep(5000);
		
		 // click on the add button
		 driver.findElement(By.xpath("//html/body/root/state/button/span/i")).click();
		 Thread.sleep(2000);
		
		 // validation value 5
		 logger.debug("--------------------VALIDATION 5 START----------------------");
		 Function.addStateValidations(driver, 7, Constants.STATE_SHEET);
		
		 Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_STATE_ERROR),
		 true);
		
		 Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_CODE_ERROR),
		 true);
		
		 logger.debug("--------------------VALIDATION 5 END---------------------");
		
		 // refresh the page and click on the add button
		 driver.navigate().refresh();
		 Thread.sleep(5000);
		
		 // click on the add button
		 driver.findElement(By.xpath("//html/body/root/state/button/span/i")).click();
		 Thread.sleep(2000);

		// validation value 6
		logger.debug("---------------------VALIDATION 6 START--------------------");

		// state
		driver.findElement(By.xpath("//input[@placeholder='Enter State name']"))
				.sendKeys(ExcelUtils.getCellData(8, 1, Constants.STATE_SHEET));

		// code
		driver.findElement(By.xpath("//input[@placeholder='Enter Code']"))
				.sendKeys(ExcelUtils.getCellData(8, 2, Constants.STATE_SHEET));

		driver.findElement(By.xpath("//input[@placeholder='Enter Code']")).sendKeys(Keys.TAB);

		// country
		WebElement countrySelect = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		action.moveToElement(countrySelect).sendKeys("C").build().perform();
		Thread.sleep(2000);

		WebElement countrySelect1 = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		action.moveToElement(countrySelect1).sendKeys("h").build().perform();

		Function.autocompleteForState(driver, 8, Constants.STATE_SHEET);
		Thread.sleep(5000);

		// click on the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		// get the error
		if (driver.getPageSource().contains(Constants.STATE_ALREADY_TAKEN)) {
			logger.debug("State has already been taken error is present");
		} else {
			logger.debug("State has already been taken error is not present");
		}
		logger.debug("---------------------VALIDATION 6 END--------------------");
		Thread.sleep(2000);

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/state/button/span/i")).click();
		Thread.sleep(2000);

		// validation value 7
		logger.debug("---------------------VALIDATION 7 START-------------------");
		// state
		driver.findElement(By.xpath("//input[@placeholder='Enter State name']"))
				.sendKeys(ExcelUtils.getCellData(9, 1, Constants.STATE_SHEET));

		// code
		driver.findElement(By.xpath("//input[@placeholder='Enter Code']"))
				.sendKeys(ExcelUtils.getCellData(9, 2, Constants.STATE_SHEET));

		driver.findElement(By.xpath("//input[@placeholder='Enter Code']")).sendKeys(Keys.TAB);

		// country
		WebElement countrySelect2 = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		action.moveToElement(countrySelect2).sendKeys("C").build().perform();
		Thread.sleep(2000);

		WebElement countrySelect3 = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		action.moveToElement(countrySelect3).sendKeys("a").build().perform();

		Function.autocompleteForState(driver, 9, Constants.STATE_SHEET);
		Thread.sleep(5000);

		// click on the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		// get the error
		if (driver.getPageSource().contains(Constants.CODE_ALREADY_TAKEN)) {
			logger.debug("Code has already been taken error is present");
		} else {
			logger.debug("Code has already been taken error is not present");
		}

		logger.debug("---------------------VALIDATION 7 END-------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/state/button/span/i")).click();
		Thread.sleep(2000);

		// validation value 8
		logger.debug("---------------------VALIDATION 8 START------------------");

		// state
		driver.findElement(By.xpath("//input[@placeholder='Enter State name']"))
				.sendKeys(ExcelUtils.getCellData(10, 1, Constants.STATE_SHEET));

		// code
		driver.findElement(By.xpath("//input[@placeholder='Enter Code']"))
				.sendKeys(ExcelUtils.getCellData(10, 2, Constants.STATE_SHEET));

		driver.findElement(By.xpath("//input[@placeholder='Enter Code']")).sendKeys(Keys.TAB);

		// country
		WebElement countrySelect4 = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		action.moveToElement(countrySelect4).sendKeys("A").build().perform();
		Thread.sleep(2000);

		WebElement countrySelect5 = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		action.moveToElement(countrySelect5).sendKeys("n").build().perform();

		Function.autocompleteForState(driver, 10, Constants.STATE_SHEET);
		Thread.sleep(5000);

		// click on the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		// get the error
		if (driver.getPageSource().contains(Constants.STATE_ALREADY_TAKEN)) {
			logger.debug("State has already been taken error is present");
		} else {
			logger.debug("State has already been taken error is not present");
		}

		logger.debug("---------------------VALIDATION 8 END------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/state/button/span/i")).click();
		Thread.sleep(2000);

		// validation value 9
		logger.debug("---------------------VALIDATION 9 START-----------------");

		// state
		driver.findElement(By.xpath("//input[@placeholder='Enter State name']"))
				.sendKeys(ExcelUtils.getCellData(11, 1, Constants.STATE_SHEET));

		// code
		driver.findElement(By.xpath("//input[@placeholder='Enter Code']"))
				.sendKeys(ExcelUtils.getCellData(11, 2, Constants.STATE_SHEET));

		driver.findElement(By.xpath("//input[@placeholder='Enter Code']")).sendKeys(Keys.TAB);

		// country
		WebElement countrySelect6 = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		action.moveToElement(countrySelect6).sendKeys("A").build().perform();
		Thread.sleep(2000);

		WebElement countrySelect7 = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		action.moveToElement(countrySelect7).sendKeys("n").build().perform();

		Function.autocompleteForState(driver, 11, Constants.STATE_SHEET);
		Thread.sleep(5000);

		// click on the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		// get the error
		if (driver.getPageSource().contains(Constants.CODE_ALREADY_TAKEN)) {
			logger.debug("Code has already been taken error is present");
		} else {
			logger.debug("Code has already been taken error is not present");
		}

		logger.debug("---------------------VALIDATION 9 END-------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/state/button/span/i")).click();
		Thread.sleep(2000);

		// validation value
		logger.debug("----------------------VALIDATION 10 START-----------------");

		// state
		driver.findElement(By.xpath("//input[@placeholder='Enter State name']"))
				.sendKeys(ExcelUtils.getCellData(12, 1, Constants.STATE_SHEET));

		// code
		driver.findElement(By.xpath("//input[@placeholder='Enter Code']"))
				.sendKeys(ExcelUtils.getCellData(12, 2, Constants.STATE_SHEET));

		driver.findElement(By.xpath("//input[@placeholder='Enter Code']")).sendKeys(Keys.TAB);

		// country
		WebElement countrySelect8 = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		action.moveToElement(countrySelect8).sendKeys("C").build().perform();
		Thread.sleep(2000);

		WebElement countrySelect9 = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		action.moveToElement(countrySelect9).sendKeys("a").build().perform();

		Function.autocompleteForState(driver, 12, Constants.STATE_SHEET);
		Thread.sleep(5000);

		// click on the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		// get the error
		if (driver.getPageSource().contains(Constants.CODE_ALREADY_TAKEN)) {
			logger.debug("Code has already been taken error is present");
		} else {
			logger.debug("Code has already been taken error is not present");
		}

		logger.debug("---------------------VALIDATION 10 END-------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/state/button/span/i")).click();
		Thread.sleep(2000);

		// validation value 11
		logger.debug("----------------------VALIDATION 11 START------------------");

		// state
		driver.findElement(By.xpath("//input[@placeholder='Enter State name']"))
				.sendKeys(ExcelUtils.getCellData(13, 1, Constants.STATE_SHEET));

		// code
		driver.findElement(By.xpath("//input[@placeholder='Enter Code']"))
				.sendKeys(ExcelUtils.getCellData(13, 2, Constants.STATE_SHEET));

		driver.findElement(By.xpath("//input[@placeholder='Enter Code']")).sendKeys(Keys.TAB);

		// country
		WebElement countrySelect10 = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		action.moveToElement(countrySelect10).sendKeys("C").build().perform();
		Thread.sleep(2000);

		WebElement countrySelect11 = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		action.moveToElement(countrySelect11).sendKeys("h").build().perform();

		Function.autocompleteForState(driver, 13, Constants.STATE_SHEET);
		Thread.sleep(5000);

		// click on the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		logger.debug("----------------------VALIDATION 11 END------------------");
		logger.debug("addState:end");

	}

	@Test(priority = 1)
	public void searchState() throws Exception {
		logger.debug("searchState:start");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(2000);

		// search the state
		driver.findElement(By.xpath("//input[@placeholder='Search state name...']"))
				.sendKeys(ExcelUtils.getCellData(13, 1, Constants.STATE_SHEET));
		Thread.sleep(5000);

		// check for the values entered is same or not
		// state
		String state = driver.findElement(By.xpath("//*[@id='scrollOnTop']/form/table/tbody/tr/td[1]/input/"))
				.getText();
		if (driver.getPageSource().contains(state)) {
			logger.debug("Entered state is present");
		} else {
			logger.debug("Entered state is not present");
		}
		Thread.sleep(2000);

		// code
		String code = driver.findElement(By.xpath("//*[@id='scrollOnTop']/form/table/tbody/tr/td[2]/input")).getText();
		if (driver.getPageSource().contains(code)) {
			logger.debug("Entered code is present");
		} else {
			logger.debug("Entered code is not present");
		}
		Thread.sleep(2000);

		// country
		String country = driver.findElement(By.xpath("//*[@id='scrollOnTop']/form/table/tbody/tr/td[3]")).getText();
		if (driver.getPageSource().contains(country)) {
			logger.debug("Entered country is present");
		} else {
			logger.debug("Entered country is not present");
		}
		Thread.sleep(2000);

		logger.debug("searchState:end");

	}

	@Test(priority = 2)
	public void deleteEnteredStateRow() throws Exception {
		logger.debug("deleteEnteredStateRow:start");

		// click on the icon
		WebElement deleteIcon = driver
				.findElement(By.xpath("//*[@id='scrollOnTop']/form/table/tbody/tr/td[4]/button/span/mat-icon"));
		deleteIcon.click();
		Thread.sleep(2000);

		// click on the yes button
		WebElement clickOnYes = driver
				.findElement(By.xpath("//html/body/root/state/app-delete-item/div[1]/form/div/button[1]"));
		clickOnYes.click();
		Thread.sleep(2000);

		logger.debug("deleteEnteredStateRow:end");

	}

	@Test(priority = 3)
	public void searchAfterDeleting() throws Exception {
		logger.debug("searchAfterDeleting:start");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(2000);

		// search the state
		driver.findElement(By.xpath("//input[@placeholder='Search state name...']"))
				.sendKeys(ExcelUtils.getCellData(13, 1, Constants.STATE_SHEET));
		Thread.sleep(2000);

		// check for the state not present
		Assert.assertEquals(driver.getPageSource().contains(Constants.STATE_NOT_FOUND), true);
		Thread.sleep(2000);

		logger.debug("searchAfterDeleting:end");
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	
}
