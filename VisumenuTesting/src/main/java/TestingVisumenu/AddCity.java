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

public class AddCity {
	final static Logger logger = Logger.getLogger(AddCity.class);
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
	public void addCity() throws Exception {

		logger.debug("addCity:Start");

		// login first
		Function.loginVisumenu(driver, 1);
		Thread.sleep(2000);

		// click on the icon
		driver.findElement(By.xpath("//html/body/root/header/div[1]/div/div[1]/button/span/mat-icon")).click();
		Thread.sleep(2000);

		// click on the state tab
		driver.findElement(By.linkText("CITY")).click();
		Thread.sleep(5000);

		// click on the add icon
		driver.findElement(By.xpath("//html/body/root/city/button/span/i")).click();
		Thread.sleep(2000);

		// check for the mandatory fields
		// city
		driver.findElement(By.xpath("//input[@placeholder='Enter city name']")).sendKeys(Keys.TAB);

		// state
		driver.findElement(By.xpath("//input[@placeholder='Select state']")).sendKeys(Keys.TAB);

		// code
		driver.findElement(By.xpath("//input[@placeholder='Enter Code']")).sendKeys(Keys.TAB);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.ENTER_CITY_NAME), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.STATE_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.CODE_ERROR), true);

		Thread.sleep(3000);

		// validation value 1
		logger.debug("----------------------VALIDATION 1 START------------------------");
		Function.cityValidations(driver, 3, Constants.CITY_SHEET);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.CITY_LIMIT_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.STATE_ERROR), true);

		Thread.sleep(3000);

		logger.debug("----------------------VALIDATION 1 END------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/city/button/span/i")).click();
		Thread.sleep(2000);

		// validation 2
		logger.debug("----------------------VALIDATION 2 START------------------------");
		Function.cityValidations(driver, 4, Constants.CITY_SHEET);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.CITY_LIMIT_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.STATE_ERROR), true);

		Thread.sleep(3000);

		logger.debug("----------------------VALIDATION 2 END------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/city/button/span/i")).click();
		Thread.sleep(2000);

		// validation 3
		logger.debug("----------------------VALIDATION 3 START------------------------");
		Function.cityValidations(driver, 5, Constants.CITY_SHEET);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_CITY_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.STATE_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_CODE_ERROR), true);

		Thread.sleep(3000);
		logger.debug("----------------------VALIDATION 3 END------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/city/button/span/i")).click();
		Thread.sleep(2000);

		// validation 4
		logger.debug("-----------------------VALIDATION 4 START----------------------");
		Function.cityValidations(driver, 6, Constants.CITY_SHEET);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_CITY_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.STATE_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_CODE_ERROR), true);

		Thread.sleep(3000);

		logger.debug("-----------------------VALIDATION 4 END----------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/city/button/span/i")).click();
		Thread.sleep(2000);

		// validation 5
		logger.debug("-----------------------VALIDATION 5 START---------------------");
		Function.cityValidations(driver, 7, Constants.CITY_SHEET);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_CITY_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.STATE_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_CODE_ERROR), true);

		Thread.sleep(3000);

		logger.debug("-----------------------VALIDATION 5 END------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/city/button/span/i")).click();
		Thread.sleep(2000);

		// validation 6
		logger.debug("-----------------------VALIDATION 6 START-----------------------");
		// city
		driver.findElement(By.xpath("//input[@placeholder='Enter city name']"))
				.sendKeys(ExcelUtils.getCellData(8, 1, Constants.CITY_SHEET));

		// state
		WebElement stateSelect = driver.findElement(By.xpath("//input[@placeholder='Select state']"));
		stateSelect.sendKeys("C");
		Thread.sleep(2000);

		WebElement stateSelect1 = driver.findElement(By.xpath("//input[@placeholder='Select state']"));
		stateSelect1.sendKeys("a");
		Thread.sleep(2000);

		// calling autocomplete function
		Function.autoCompleteForCity(driver, 8, Constants.CITY_SHEET);
		Thread.sleep(2000);

		// code
		driver.findElement(By.xpath("//input[@placeholder='Enter Code']"))
				.sendKeys(ExcelUtils.getCellData(8, 3, Constants.CITY_SHEET));

		// click on the save button
		driver.findElement(By.xpath("//html/body/root/city/div[2]/form/div[5]/button/span")).click();
		Thread.sleep(2000);

		// check for the error
		if (driver.getPageSource().contains(Constants.NAME_TAKEN_ERROR)) {
			logger.debug("Name already taken error is present");
		} else {
			logger.debug("Name already taken error is not present");
		}
		Thread.sleep(2000);

		logger.debug("-----------------------VALIDATION 6 END-----------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/city/button/span/i")).click();
		Thread.sleep(2000);

		// validation 7
		logger.debug("------------------------VALIDATION 7 START---------------------");

		// city
		driver.findElement(By.xpath("//input[@placeholder='Enter city name']"))
				.sendKeys(ExcelUtils.getCellData(9, 1, Constants.CITY_SHEET));

		// state
		WebElement stateSelect2 = driver.findElement(By.xpath("//input[@placeholder='Select state']"));
		stateSelect2.sendKeys("C");
		Thread.sleep(2000);

		WebElement stateSelect3 = driver.findElement(By.xpath("//input[@placeholder='Select state']"));
		stateSelect3.sendKeys("a");
		Thread.sleep(2000);

		// calling autocomplete function
		Function.autoCompleteForCity(driver, 9, Constants.CITY_SHEET);
		Thread.sleep(2000);

		// code
		driver.findElement(By.xpath("//input[@placeholder='Enter Code']"))
				.sendKeys(ExcelUtils.getCellData(9, 3, Constants.CITY_SHEET));

		// click on the save button
		driver.findElement(By.xpath("//html/body/root/city/div[2]/form/div[5]/button/span")).click();
		Thread.sleep(2000);

		// check for the error
		if (driver.getPageSource().contains(Constants.CODE_ALREADY_TAKEN)) {
			logger.debug("Code already taken error is present");
		} else {
			logger.debug("Code already taken error is not present");
		}
		Thread.sleep(2000);

		logger.debug("-----------------------VALIDATION 7 END-----------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/city/button/span/i")).click();
		Thread.sleep(2000);

		// validation 8
		logger.debug("-----------------------VALIDATION 8 START-----------------------");
		// city
		driver.findElement(By.xpath("//input[@placeholder='Enter city name']"))
				.sendKeys(ExcelUtils.getCellData(10, 1, Constants.CITY_SHEET));

		// state
		WebElement stateSelect4 = driver.findElement(By.xpath("//input[@placeholder='Select state']"));
		stateSelect4.sendKeys("a");
		Thread.sleep(2000);

		WebElement stateSelect5 = driver.findElement(By.xpath("//input[@placeholder='Select state']"));
		stateSelect5.sendKeys("r");
		Thread.sleep(2000);

		// calling autocomplete function
		Function.autoCompleteForCity(driver, 10, Constants.CITY_SHEET);
		Thread.sleep(2000);

		// code
		driver.findElement(By.xpath("//input[@placeholder='Enter Code']"))
				.sendKeys(ExcelUtils.getCellData(10, 3, Constants.CITY_SHEET));

		// click on the save button
		driver.findElement(By.xpath("//html/body/root/city/div[2]/form/div[5]/button/span")).click();
		Thread.sleep(2000);

		// check for the error
		if (driver.getPageSource().contains(Constants.NAME_TAKEN_ERROR)) {
			logger.debug("Name already taken error is present");
		} else {
			logger.debug("Name already taken error is not present");
		}
		Thread.sleep(2000);

		logger.debug("-----------------------VALIDATION 8 END-----------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/city/button/span/i")).click();
		Thread.sleep(2000);

		// validation 9
		logger.debug("-----------------------VALIDATION 9 START-----------------------");

		// city
		driver.findElement(By.xpath("//input[@placeholder='Enter city name']"))
				.sendKeys(ExcelUtils.getCellData(11, 1, Constants.CITY_SHEET));

		// state
		WebElement stateSelect6 = driver.findElement(By.xpath("//input[@placeholder='Select state']"));
		stateSelect6.sendKeys("a");
		Thread.sleep(2000);

		WebElement stateSelect7 = driver.findElement(By.xpath("//input[@placeholder='Select state']"));
		stateSelect7.sendKeys("r");
		Thread.sleep(2000);

		// calling autocomplete function
		Function.autoCompleteForCity(driver, 11, Constants.CITY_SHEET);
		Thread.sleep(2000);

		// code
		driver.findElement(By.xpath("//input[@placeholder='Enter Code']"))
				.sendKeys(ExcelUtils.getCellData(11, 3, Constants.CITY_SHEET));

		// click on the save button
		driver.findElement(By.xpath("//html/body/root/city/div[2]/form/div[5]/button/span")).click();
		Thread.sleep(2000);

		// check for the error
		if (driver.getPageSource().contains(Constants.NAME_TAKEN_ERROR)) {
			logger.debug("Name already taken error is present");
		} else {
			logger.debug("Name already taken error is not present");
		}
		Thread.sleep(2000);

		logger.debug("-----------------------VALIDATION 9 END-----------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/city/button/span/i")).click();
		Thread.sleep(2000);

		// validation 10
		logger.debug("------------------------VALIDATION 10 START---------------------");

		// city
		driver.findElement(By.xpath("//input[@placeholder='Enter city name']"))
				.sendKeys(ExcelUtils.getCellData(12, 1, Constants.CITY_SHEET));

		// state
		WebElement stateSelect8 = driver.findElement(By.xpath("//input[@placeholder='Select state']"));
		stateSelect8.sendKeys("C");
		Thread.sleep(2000);

		WebElement stateSelect9 = driver.findElement(By.xpath("//input[@placeholder='Select state']"));
		stateSelect9.sendKeys("A");
		Thread.sleep(2000);

		// calling autocomplete function
		Function.autoCompleteForCity(driver, 12, Constants.CITY_SHEET);
		Thread.sleep(2000);

		// code
		driver.findElement(By.xpath("//input[@placeholder='Enter Code']"))
				.sendKeys(ExcelUtils.getCellData(12, 3, Constants.CITY_SHEET));

		// click on the save button
		driver.findElement(By.xpath("//html/body/root/city/div[2]/form/div[5]/button/span")).click();
		Thread.sleep(2000);

		// check for the error
		if (driver.getPageSource().contains(Constants.NAME_TAKEN_ERROR)) {
			logger.debug("Name already taken error is present");
		} else {
			logger.debug("Name already taken error is not present");
		}
		Thread.sleep(2000);

		logger.debug("------------------------VALIDATION 10 END---------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/city/button/span/i")).click();
		Thread.sleep(2000);

		// validation 11
		logger.debug("------------------------VALIDATION 11 START--------------------");

		// city
		driver.findElement(By.xpath("//input[@placeholder='Enter city name']"))
				.sendKeys(ExcelUtils.getCellData(13, 1, Constants.CITY_SHEET));

		// state
		WebElement stateSelect10 = driver.findElement(By.xpath("//input[@placeholder='Select state']"));
		stateSelect10.sendKeys("A");
		Thread.sleep(2000);

		WebElement stateSelect11 = driver.findElement(By.xpath("//input[@placeholder='Select state']"));
		stateSelect11.sendKeys("r");
		Thread.sleep(2000);

		// calling autocomplete function
		Function.autoCompleteForCity(driver, 13, Constants.CITY_SHEET);
		Thread.sleep(2000);

		// code
		driver.findElement(By.xpath("//input[@placeholder='Enter Code']"))
				.sendKeys(ExcelUtils.getCellData(13, 3, Constants.CITY_SHEET));

		// click on the save button
		driver.findElement(By.xpath("//html/body/root/city/div[2]/form/div[5]/button/span")).click();
		Thread.sleep(5000);

		Assert.assertEquals(driver.getPageSource().contains(Constants.CITY_LIMIT_ERROR), true);
		Thread.sleep(2000);

		logger.debug("------------------------VALIDATION 11 END--------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/city/button/span/i")).click();
		Thread.sleep(2000);

		// validation 12
		logger.debug("------------------------VALIDATION 12 START--------------------");

		// city
		driver.findElement(By.xpath("//input[@placeholder='Enter city name']"))
				.sendKeys(ExcelUtils.getCellData(14, 1, Constants.CITY_SHEET));

		// state
		WebElement stateSelect12 = driver.findElement(By.xpath("//input[@placeholder='Select state']"));
		stateSelect12.sendKeys("A");
		Thread.sleep(2000);

		WebElement stateSelect13 = driver.findElement(By.xpath("//input[@placeholder='Select state']"));
		stateSelect13.sendKeys("r");
		Thread.sleep(2000);

		// calling autocomplete function
		Function.autoCompleteForCity(driver, 14, Constants.CITY_SHEET);
		Thread.sleep(2000);

		// code
		driver.findElement(By.xpath("//input[@placeholder='Enter Code']"))
				.sendKeys(ExcelUtils.getCellData(14, 3, Constants.CITY_SHEET));

		// click on the save button
		driver.findElement(By.xpath("//html/body/root/city/div[2]/form/div[5]/button/span")).click();
		Thread.sleep(5000);

		logger.debug("------------------------VALIDATION 12 END----------------------");

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/city/button/span/i")).click();
		Thread.sleep(2000);

		// validation 13
		logger.debug("------------------------VALIDATION 13 START----------------------");

		// city
		driver.findElement(By.xpath("//input[@placeholder='Enter city name']"))
				.sendKeys(ExcelUtils.getCellData(15, 1, Constants.CITY_SHEET));

		// state
		WebElement stateSelect14 = driver.findElement(By.xpath("//input[@placeholder='Select state']"));
		stateSelect14.sendKeys("C");
		Thread.sleep(2000);

		WebElement stateSelect15 = driver.findElement(By.xpath("//input[@placeholder='Select state']"));
		stateSelect15.sendKeys("a");
		Thread.sleep(2000);

		// calling autocomplete function
		Function.autoCompleteForCity(driver, 15, Constants.CITY_SHEET);
		Thread.sleep(2000);

		// code
		driver.findElement(By.xpath("//input[@placeholder='Enter Code']"))
				.sendKeys(ExcelUtils.getCellData(15, 3, Constants.CITY_SHEET));

		// click on the save button
		driver.findElement(By.xpath("//html/body/root/city/div[2]/form/div[5]/button/span")).click();
		Thread.sleep(5000);

		logger.debug("------------------------VALIDATION 13 END----------------------");

		logger.debug("addCity:End");

	}

	@Test(priority = 1)
	public void searchCity() throws Exception {
		logger.debug("searchCity:start");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// search the entered city
		driver.findElement(By.xpath("//input[@placeholder='Search city name...']"))
				.sendKeys(ExcelUtils.getCellData(15, 1, Constants.CITY_SHEET));
		Thread.sleep(2000);

		// check for the values present
		String cityValue = driver.findElement(By.xpath("//*[@id='scrollOnTop']/form/table/tbody/tr/td[1]/input"))
				.getText();
		if (driver.getPageSource().contains(cityValue)) {

			logger.debug("The entered city is present");
		} else {
			logger.debug("The entered city is not present");
		}
		Thread.sleep(2000);

		String stateValue = driver.findElement(By.xpath("//*[@id='scrollOnTop']/form/table/tbody/tr/td[2]")).getText();
		if (driver.getPageSource().contains(stateValue)) {

			logger.debug("The entered state is present");
		} else {
			logger.debug("The entered state is not present");
		}
		Thread.sleep(2000);

		String codeValue = driver.findElement(By.xpath("//*[@id='scrollOnTop']/form/table/tbody/tr/td[3]/input"))
				.getText();
		if (driver.getPageSource().contains(codeValue)) {

			logger.debug("The entered code is present");
		} else {
			logger.debug("The entered code is not present");
		}
		Thread.sleep(2000);

		logger.debug("searchCity:end");
	}

	@Test(priority = 2)
	public void deleteCity() throws Exception {
		logger.debug("deleteCity:start");

		WebElement clickOnIcon = driver
				.findElement(By.xpath("//*[@id='scrollOnTop']/form/table/tbody/tr/td[4]/button/span/mat-icon"));
		clickOnIcon.click();
		Thread.sleep(2000);

		WebElement clickOnYes = driver
				.findElement(By.xpath("//html/body/root/city/app-delete-item/div[1]/form/div/button[1]"));
		clickOnYes.click();
		Thread.sleep(5000);

		logger.debug("deleteCity:end");

	}

	// @Test(priority = 3)
	// public void deleteCode() throws Exception {
	//
	// logger.debug("deleteCode:start");
	//
	// // refresh the page
	// driver.navigate().refresh();
	// Thread.sleep(5000);
	//
	// // delete 14 row value also
	// // search the entered code
	// driver.findElement(By.xpath("//input[@placeholder='Search code...']"))
	// .sendKeys(ExcelUtils.getCellData(14, 3, Constants.CITY_SHEET));
	//
	// Thread.sleep(2000);
	//
	// WebElement clickOnIcon = driver
	// .findElement(By.xpath("//*[@id='scrollOnTop']/form/table/tbody/tr/td[4]/button/span/mat-icon"));
	// clickOnIcon.click();
	// Thread.sleep(2000);
	//
	// WebElement clickOnYes = driver
	// .findElement(By.xpath("//html/body/root/city/app-delete-item/div[1]/form/div/button[1]/span"));
	// clickOnYes.click();
	// Thread.sleep(5000);
	//
	// logger.debug("deleteCode:end");
	//
	// }

	@Test(priority = 3)
	public void searchAfterDelete() throws Exception {
		logger.debug("searchAfterDelete:start");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// search the entered city
		driver.findElement(By.xpath("//input[@placeholder='Search city name...']"))
				.sendKeys(ExcelUtils.getCellData(15, 1, Constants.CITY_SHEET));
		Thread.sleep(2000);

		// check city not found
		Assert.assertEquals(driver.getPageSource().contains(Constants.CITY_NOT_FOUND), true);
		Thread.sleep(2000);

		logger.debug("searchAfterDelete:end");
	}

	@Test(priority = 4)
	public void searchCode() throws Exception {
		logger.debug("searchCode:start");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// search the code
		driver.findElement(By.xpath("//input[@placeholder='Search code...']"))
				.sendKeys("O");
		Thread.sleep(3000);

		// assert to check whether it is same or not
		String codeValue = driver.findElement(By.xpath("//*[@id='scrollOnTop']/form/table/tbody/tr/td[3]/input"))
				.getText();
		if (driver.getPageSource().contains(codeValue)) {
			logger.debug("Entered code is present");
		} else {
			logger.debug("Entered code is not present");
		}

		Thread.sleep(2000);
		logger.debug("searchCode:end");

	}

	@Test(priority = 5)
	public void deleteCode() throws Exception {
		logger.debug("deleteCode:start");

		WebElement clickOnIcon = driver
				.findElement(By.xpath("//*[@id='scrollOnTop']/form/table/tbody/tr/td[4]/button/span/mat-icon"));
		clickOnIcon.click();
		Thread.sleep(2000);

		WebElement clickOnYes = driver
				.findElement(By.xpath("//html/body/root/city/app-delete-item/div[1]/form/div/button[1]"));
		clickOnYes.click();
		Thread.sleep(5000);

		logger.debug("deleteCode:end");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
