package TestingVisumenu;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utils.Constants;
import Utils.ExcelUtils;
import Utils.Function;

public class LoginPage {

	final static Logger logger = Logger.getLogger(LoginPage.class);
	private WebDriver driver;

	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser) throws Exception {
		logger.debug("====================init start======================");

		// If browser is googlechrome, then do this
		if (browser.equalsIgnoreCase("googlechrome")) {
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_LOCATION);
			driver = new ChromeDriver();
		}
		// If the browser is Firefox, then do this
		else if (browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.firefox.marionette", "/home/smart/Downloads/geckodriver");
			driver = new FirefoxDriver();

		}

		driver.get(Constants.ADMIN_URL);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// ExcelUtils.getTableArray(Constants.FILE_FULL_PATH,Constants.VISUMENU_SHEET);
		logger.debug("====================init end======================");
	}

	@Test
	public void testLogin() throws Exception {
		logger.debug("testLogin:start");

		// check for the url first whether we landed on the correct page
		String url = driver.getCurrentUrl();
		Assert.assertEquals(url, Constants.ADMIN_URL);

		// checking for the mandatory errors
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(Keys.TAB);
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(Keys.TAB);

		// check for the errors present (Enter username)
		Assert.assertEquals(driver.getPageSource().contains(Constants.ENTER_USERNAME), true);

		// Enter password
		Assert.assertEquals(driver.getPageSource().contains(Constants.ENTER_PASSWORD), true);

		Thread.sleep(5000);

		// passing validation values
		// validation value 1
		logger.debug("---------------------VALIDATION 1 START----------------------");
		Function.loginPageValidations(driver, 3, Constants.LOGIN_PAGE_SHEET);

		// checking for the error present
		Assert.assertEquals(driver.getPageSource().contains(Constants.PASSWORD_LENGTH_ERROR), true);

		// setting the result to the excel sheet
		if (driver.getPageSource().contains(Constants.PASSWORD_LENGTH_ERROR)) {
			ExcelUtils.setCellData("PASSED", 3, 3, Constants.LOGIN_PAGE_SHEET);
		} else {
			ExcelUtils.setCellData("FAILED", 3, 3, Constants.LOGIN_PAGE_SHEET);
		}

		Thread.sleep(2000);

		logger.debug("---------------------VALIDATION 1 END----------------------");

		// clearing fields
		Function.clearLoginFields(driver);

		Thread.sleep(5000);

		// validation value 2
		logger.debug("---------------------VALIDATION 2 START----------------------");
		Function.loginPageValidations(driver, 4, Constants.LOGIN_PAGE_SHEET);

		// checking for the error present
		Assert.assertEquals(driver.getPageSource().contains(Constants.USERNAME_LENGTH_ERROR), true);

		if (driver.getPageSource().contains(Constants.USERNAME_LENGTH_ERROR)) {
			ExcelUtils.setCellData("PASSED", 4, 3, Constants.LOGIN_PAGE_SHEET);
		} else {
			ExcelUtils.setCellData("FAILED", 4, 3, Constants.LOGIN_PAGE_SHEET);
		}

		Assert.assertEquals(driver.getPageSource().contains(Constants.PASSWORD_LENGTH_ERROR), true);

		if (driver.getPageSource().contains(Constants.PASSWORD_LENGTH_ERROR)) {
			ExcelUtils.setCellData("PASSED", 4, 3, Constants.LOGIN_PAGE_SHEET);
		} else {
			ExcelUtils.setCellData("FAILED", 4, 3, Constants.LOGIN_PAGE_SHEET);
		}

		Thread.sleep(2000);

		logger.debug("---------------------VALIDATION 2 END----------------------");

		// clearing fields
		Function.clearLoginFields(driver);

		Thread.sleep(5000);

		// validation value 3
		logger.debug("---------------------VALIDATION 3 START----------------------");
		Function.loginPageValidations(driver, 5, Constants.LOGIN_PAGE_SHEET);

		// click on the login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		// get the error whether it is present on the page
		Assert.assertEquals(driver.getPageSource().contains(Constants.INVALID_USERN_PASS_ERROR), true);

		if (driver.getPageSource().contains(Constants.INVALID_USERN_PASS_ERROR)) {
			ExcelUtils.setCellData("PASSED", 5, 3, Constants.LOGIN_PAGE_SHEET);
		} else {
			ExcelUtils.setCellData("FAILED", 5, 3, Constants.LOGIN_PAGE_SHEET);
		}

		logger.debug("---------------------VALIDATION 3 END----------------------");

		// clearing fields
		Function.clearLoginFields(driver);

		Thread.sleep(5000);

		// validation value 4
		logger.debug("---------------------VALIDATION 4 START----------------------");
		Function.loginPageValidations(driver, 6, Constants.LOGIN_PAGE_SHEET);

		// click on the login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		// get the error whether it is present on the page
		Assert.assertEquals(driver.getPageSource().contains(Constants.INVALID_USERN_PASS_ERROR), true);

		if (driver.getPageSource().contains(Constants.INVALID_USERN_PASS_ERROR)) {
			ExcelUtils.setCellData("PASSED", 6, 3, Constants.LOGIN_PAGE_SHEET);
		} else {
			ExcelUtils.setCellData("FAILED", 6, 3, Constants.LOGIN_PAGE_SHEET);
		}

		Thread.sleep(2000);

		logger.debug("---------------------VALIDATION 4 END----------------------");

		// clearing fields
		Function.clearLoginFields(driver);

		Thread.sleep(5000);

		// validation value 5
		logger.debug("---------------------VALIDATION 5 START----------------------");
		Function.loginPageValidations(driver, 7, Constants.LOGIN_PAGE_SHEET);

		// click on the login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		// get the error whether it is present on the page
		Assert.assertEquals(driver.getPageSource().contains(Constants.INVALID_USERN_PASS_ERROR), true);

		if (driver.getPageSource().contains(Constants.INVALID_USERN_PASS_ERROR)) {
			ExcelUtils.setCellData("PASSED", 7, 3, Constants.LOGIN_PAGE_SHEET);
		} else {
			ExcelUtils.setCellData("FAILED", 7, 3, Constants.LOGIN_PAGE_SHEET);
		}

		Thread.sleep(2000);
		logger.debug("---------------------VALIDATION 5 END----------------------");

		// clearing fields
		Function.clearLoginFields(driver);

		Thread.sleep(5000);

		// validation value 6
		logger.debug("---------------------VALIDATION 6 START----------------------");
		Function.loginPageValidations(driver, 8, Constants.LOGIN_PAGE_SHEET);

		// click on the login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		// get the error whether it is present on the page
		Assert.assertEquals(driver.getPageSource().contains(Constants.INVALID_USERN_PASS_ERROR), true);
		if (driver.getPageSource().contains(Constants.INVALID_USERN_PASS_ERROR)) {
			ExcelUtils.setCellData("PASSED", 8, 3, Constants.LOGIN_PAGE_SHEET);
		} else {
			ExcelUtils.setCellData("FAILED", 8, 3, Constants.LOGIN_PAGE_SHEET);
		}

		Thread.sleep(2000);

		logger.debug("---------------------VALIDATION 6 END----------------------");

		// clearing fields
		Function.clearLoginFields(driver);

		Thread.sleep(5000);

		// validation value 7
		logger.debug("---------------------VALIDATION 7 START----------------------");
		Function.loginPageValidations(driver, 9, Constants.LOGIN_PAGE_SHEET);

		// click on the login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		// get the error whether it is present on the page
		Assert.assertEquals(driver.getPageSource().contains(Constants.INVALID_USERN_PASS_ERROR), true);

		if (driver.getPageSource().contains(Constants.INVALID_USERN_PASS_ERROR)) {
			ExcelUtils.setCellData("PASSED", 9, 3, Constants.LOGIN_PAGE_SHEET);
		} else {
			ExcelUtils.setCellData("FAILED", 9, 3, Constants.LOGIN_PAGE_SHEET);
		}

		Thread.sleep(2000);
		logger.debug("---------------------VALIDATION 7 END----------------------");

		// clearing fields
		Function.clearLoginFields(driver);

		Thread.sleep(5000);

		// validation value 8
		logger.debug("---------------------VALIDATION 8 START----------------------");
		Function.loginPageValidations(driver, 10, Constants.LOGIN_PAGE_SHEET);

		// click on the login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		// get the error whether it is present on the page
		Assert.assertEquals(driver.getPageSource().contains(Constants.INVALID_USERN_PASS_ERROR), true);

		if (driver.getPageSource().contains(Constants.INVALID_USERN_PASS_ERROR)) {
			ExcelUtils.setCellData("PASSED", 10, 3, Constants.LOGIN_PAGE_SHEET);
		} else {
			ExcelUtils.setCellData("FAILED", 10, 3, Constants.LOGIN_PAGE_SHEET);
		}

		Thread.sleep(2000);
		logger.debug("---------------------VALIDATION 8 START----------------------");

		// validation value 9
		// click on the password eye to read the password
		logger.debug("---------------------VALIDATION 9 START----------------------");
		driver.findElement(
				By.xpath("//html/body/root/login/div/div/form/div[2]/mat-form-field/div/div[1]/div[2]/mat-icon"))
				.click();
		Thread.sleep(2000);

		logger.debug("---------------------VALIDATION 9 END----------------------");

		logger.debug("--------------------");

		// can get the password which is read by clicking on the password eye
		String getPassword = driver.findElement(By.xpath("//input[@placeholder='Password']")).getText();
		System.out.println(getPassword);
		logger.debug("---------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// validation value 10
		logger.debug("---------------------VALIDATION 10 START----------------------");
		Function.loginPageValidations(driver, 13, Constants.LOGIN_PAGE_SHEET);

		// click on the login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);

		logger.debug("---------------------VALIDATION 10 END----------------------");

		// clearing fields
		Function.clearLoginFields(driver);

		// validation value 11
		logger.debug("---------------------VALIDATION 11 START----------------------");
		Function.loginPageValidations(driver, 14, Constants.LOGIN_PAGE_SHEET);

		// click on the login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);
		logger.debug("---------------------VALIDATION 11 END----------------------");

		// clearing fields
		Function.clearLoginFields(driver);

		// validation value 12
		logger.debug("---------------------VALIDATION 12 START----------------------");
		Function.loginPageValidations(driver, 15, Constants.LOGIN_PAGE_SHEET);

		// click on the login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);

		// now click on the logout button
		driver.findElement(By.xpath("//html/body/root/header/div/div/div[2]/div/button")).click();
		Thread.sleep(5000);

		logger.debug("---------------------VALIDATION 12 END----------------------");

		// validation value 13
		logger.debug("---------------------VALIDATION 13 START----------------------");
		Function.loginPageValidations(driver, 16, Constants.LOGIN_PAGE_SHEET);

		// click on the login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);

		// now click on the logout button
		driver.findElement(By.xpath("//html/body/root/header/div/div/div[2]/div/button")).click();
		Thread.sleep(5000);

		logger.debug("---------------------VALIDATION 13 END----------------------");

		// validation value 14
		logger.debug("---------------------VALIDATION 14 START----------------------");
		Function.loginPageValidations(driver, 17, Constants.LOGIN_PAGE_SHEET);

		// click on the login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(5000);

		logger.debug("---------------------VALIDATION 14 END----------------------");

		// click on the back button to check that the user should not be logged
		// out
		driver.navigate().back();
		Thread.sleep(3000);

		logger.debug("testLogin:end");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
