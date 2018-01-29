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

public class App {

	final static Logger logger = Logger.getLogger(App.class);
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
	public void addApp() throws Exception {
		logger.debug("addApp:start");

		// login first
		Function.loginVisumenu(driver, 1);
		Thread.sleep(2000);

		// click on the icon
		driver.findElement(By.xpath("//html/body/root/header/div[1]/div/div[1]/button/span/mat-icon")).click();
		Thread.sleep(2000);

		// click on the location
		driver.findElement(By.linkText("APP")).click();
		Thread.sleep(2000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/app-apps/button/span/i")).click();
		Thread.sleep(2000);

		// check for the mandatory fields
		// url
		WebElement url = driver.findElement(By.xpath("//input[@placeholder='Enter Url']"));
		url.sendKeys(Keys.TAB);

		// description
		WebElement Description = driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"));
		Description.sendKeys(Keys.TAB);

		// organization
		WebElement organization = driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"));
		organization.sendKeys(Keys.TAB);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.URL_ERROR), true);

		Thread.sleep(2000);

		// validation value 1
		logger.debug("--------------------VALIDATION 1 START-------------------------");
		Function.appValidations(driver, 3, Constants.APP_SHEET);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_URL_ERROR), true);

		Thread.sleep(2000);

		logger.debug("--------------------VALIDATION 1 END---------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// click to add app
		driver.findElement(By.xpath("//html/body/root/app-apps/button/span/i")).click();
		Thread.sleep(2000);

		// validation value 2
		logger.debug("--------------------VALIDATION 2 START-------------------------");
		Function.appValidations(driver, 4, Constants.APP_SHEET);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_URL_ERROR), true);

		Thread.sleep(2000);

		logger.debug("--------------------VALIDATION 2 END---------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// click to add app
		driver.findElement(By.xpath("//html/body/root/app-apps/button/span/i")).click();
		Thread.sleep(2000);

		// validation value 3
		logger.debug("--------------------VALIDATION 3 START-------------------------");
		Function.appValidations(driver, 5, Constants.APP_SHEET);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_URL_ERROR), true);

		Thread.sleep(2000);

		logger.debug("--------------------VALIDATION 3 END---------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// click to add app
		driver.findElement(By.xpath("//html/body/root/app-apps/button/span/i")).click();
		Thread.sleep(2000);

		// validation value 4
		logger.debug("--------------------VALIDATION 4 START-------------------------");
		Function.appValidations(driver, 6, Constants.APP_SHEET);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_URL_ERROR), true);

		Thread.sleep(2000);

		logger.debug("--------------------VALIDATION 4 END---------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// click to add app
		driver.findElement(By.xpath("//html/body/root/app-apps/button/span/i")).click();
		Thread.sleep(2000);

		// validation value 5
		logger.debug("--------------------VALIDATION 5 START-------------------------");
		Function.appValidations(driver, 7, Constants.APP_SHEET);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_URL_ERROR), true);

		Thread.sleep(2000);

		logger.debug("--------------------VALIDATION 5 END---------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// click to add app
		driver.findElement(By.xpath("//html/body/root/app-apps/button/span/i")).click();
		Thread.sleep(2000);

		// validation value 6
		logger.debug("--------------------VALIDATION 6 START-------------------------");

		// url
		driver.findElement(By.xpath("//input[@placeholder='Enter Url']"))
				.sendKeys(ExcelUtils.getCellData(8, 1, Constants.APP_SHEET));

		// click on the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);

		logger.debug("--------------------VALIDATION 6 END-------------------------");

		// click to add app
		driver.findElement(By.xpath("//html/body/root/app-apps/button/span/i")).click();
		Thread.sleep(2000);

		// validation value 7
		logger.debug("--------------------VALIDATION 7 START-------------------------");

		// url
		driver.findElement(By.xpath("//input[@placeholder='Enter Url']"))
				.sendKeys(ExcelUtils.getCellData(9, 1, Constants.APP_SHEET));

		// click on the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);

		Thread.sleep(1000);

		// catch error
		if (driver.getPageSource().contains(Constants.URL_TAKEN)) {
			logger.debug("Url already taken is present");
		} else {
			logger.debug("Url already taken is not present");
		}
		Thread.sleep(2000);

		logger.debug("--------------------VALIDATION 7 END-------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// click to add app
		driver.findElement(By.xpath("//html/body/root/app-apps/button/span/i")).click();
		Thread.sleep(2000);

		// validation 8
		logger.debug("--------------------VALIDATION 8 START-------------------------");
		driver.findElement(By.xpath("//input[@placeholder='Enter Url']"))
				.sendKeys(ExcelUtils.getCellData(10, 1, Constants.APP_SHEET));

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_URL_ERROR), true);

		logger.debug("--------------------VALIDATION 8 END-------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// click to add app
		driver.findElement(By.xpath("//html/body/root/app-apps/button/span/i")).click();
		Thread.sleep(2000);

		// validation 9
		logger.debug("--------------------VALIDATION 9 START-------------------------");
		driver.findElement(By.xpath("//input[@placeholder='Enter Url']"))
				.sendKeys(ExcelUtils.getCellData(11, 1, Constants.APP_SHEET));

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.VALID_URL_ERROR), true);

		logger.debug("--------------------VALIDATION 9 END-------------------------");

		logger.debug("addApp:end");

	}

	@Test(priority = 1)
	public void searchUrl() throws Exception {
		logger.debug("searchUrl:start");

		// refresh
		driver.navigate().refresh();
		Thread.sleep(5000);

		// search url
		driver.findElement(By.xpath("//input[@placeholder='Search app...']"))
				.sendKeys(ExcelUtils.getCellData(8, 1, Constants.APP_SHEET));
		Thread.sleep(3000);

		logger.debug("searchUrl:end");
	}

	@Test(priority = 2)
	public void deleteRow() throws Exception {
		logger.debug("deleteRow:start");

		WebElement clickOnIcon = driver.findElement(By.xpath(
				"//*[@id='scrollOnTop']/form/div/mat-accordion/mat-expansion-panel/mat-expansion-panel-header/span/mat-panel-title/div/div[4]/button/span/mat-icon"));
		clickOnIcon.click();
		Thread.sleep(3000);

		WebElement clickOnYes = driver
				.findElement(By.xpath("//html/body/root/app-apps/app-delete-item/div[1]/form/div/button[1]"));
		clickOnYes.click();
		Thread.sleep(5000);

		logger.debug("deleteRow:end");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
