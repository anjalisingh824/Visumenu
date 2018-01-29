package TestingVisumenu;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utils.Constants;
import Utils.Function;

public class AddNumber {

	final static Logger logger = Logger.getLogger(AddNumber.class);
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

	@Test
	public void addNumberTesting() throws Exception {
		logger.debug("addNumberTesting:start");

		// login first
		Function.loginVisumenu(driver, 1);
		Thread.sleep(2000);

		// click on the add icon button
		driver.findElement(By.xpath("//html/body/root/header/div[1]/div/div[2]/div/a/label")).click();
		Thread.sleep(3000);

		// check for the mandatory fields
		// phone number
		driver.findElement(By.xpath("//input[@placeholder='Ex. XXXXXXXXXX, XXX-XXX-XXXX, (XXX) XXX-XXXX']"))
				.sendKeys(Keys.TAB);

		// select type
		driver.findElement(By.xpath("//mat-select[@placeholder='Select type']")).sendKeys(Keys.TAB);

		// select organization
		driver.findElement(By.xpath("//input[@placeholder='Select Organization']")).sendKeys(Keys.TAB);

		// country
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys(Keys.TAB);

		// state
		driver.findElement(By.xpath("//input[@placeholder='Select State']")).sendKeys(Keys.TAB);

		// city
		driver.findElement(By.xpath("//input[@placeholder='Select City']")).sendKeys(Keys.TAB);

		// street
		driver.findElement(By.xpath("//input[@placeholder='Select Street']")).sendKeys(Keys.TAB);

		// postal Code
		driver.findElement(By.xpath("//input[@placeholder='Select Postal Code']")).sendKeys(Keys.TAB);

		// department
		driver.findElement(By.xpath("//input[@placeholder='Select Department']")).sendKeys(Keys.TAB);

		// extension
		driver.findElement(By.xpath("//input[@placeholder='Ex. X,XX']")).sendKeys(Keys.TAB);

		// check for the erorrs
		// phone number
		Assert.assertEquals(driver.getPageSource().contains(Constants.PHONE_NUMBER_ERROR), true);

		// type
		Assert.assertEquals(driver.getPageSource().contains(Constants.TYPE_ERROR), true);

		// organization
		Assert.assertEquals(driver.getPageSource().contains(Constants.ORGANIZATION_MAN_ERROR), true);

		// state
		Assert.assertEquals(driver.getPageSource().contains(Constants.STATE_MAN_ERROR), true);

		// city
		Assert.assertEquals(driver.getPageSource().contains(Constants.CITY_MAN_ERROR), true);

		// department
		Assert.assertEquals(driver.getPageSource().contains(Constants.DEPARTMENT_MAN_ERROR), true);

		Thread.sleep(2000);

		// validation 1
		logger.debug("----------------------------VALIDATION 1 START-------------------------------");
		Function.addNumberValidations(driver, 3, Constants.ADD_NUMBER_SHEET);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.PHONE_NUMBER_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.TYPE_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.ORGANIZATION_MAN_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.COUNTRY_MAN_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.CITY_MAN_ERROR), true);

		// Assert.assertEquals(driver.getPageSource().contains(Constants.STREET_LIMIT_ERROR),
		// true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.DEPARTMENT_MAN_ERROR), true);

		logger.debug("----------------------------VALIDATION 1 END-------------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// click on the add icon button
		driver.findElement(By.xpath("//html/body/root/header/div[1]/div/div[2]/div/a/label")).click();
		Thread.sleep(3000);

		// validation 2
		logger.debug("--------------------------VALIDATION 2 START--------------------------------");
		Function.addNumberValidations(driver, 4, Constants.ADD_NUMBER_SHEET);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.PHONE_NUMBER_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.TYPE_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.ORGANIZATION_MAN_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.COUNTRY_MAN_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.STATE_MAN_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.CITY_MAN_ERROR), true);

		logger.debug("--------------------------VALIDATION 2 END--------------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// click on the add icon button
		driver.findElement(By.xpath("//html/body/root/header/div[1]/div/div[2]/div/a/label")).click();
		Thread.sleep(3000);

		// validation 3
		logger.debug("--------------------------VALIDATION 3 START------------------------------");
		Function.addNumberValidations(driver, 5, Constants.ADD_NUMBER_SHEET);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.PHONE_NUMBER_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.TYPE_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.ORGANIZATION_MAN_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.COUNTRY_MAN_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.STATE_MAN_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.CITY_MAN_ERROR), true);

		logger.debug("--------------------------VALIDATION 3 END---------------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// click on the add icon button
		driver.findElement(By.xpath("//html/body/root/header/div[1]/div/div[2]/div/a/label")).click();
		Thread.sleep(3000);

		// validation 4
		logger.debug("---------------------------VALIDATION 4 START--------------------------------");
		Function.addNumberValidations(driver, 6, Constants.ADD_NUMBER_SHEET);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.TYPE_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.ORGANIZATION_MAN_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.COUNTRY_MAN_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.STATE_MAN_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.CITY_MAN_ERROR), true);

		logger.debug("---------------------------VALIDATION 4 END----------------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// click on the add icon button
		driver.findElement(By.xpath("//html/body/root/header/div[1]/div/div[2]/div/a/label")).click();
		Thread.sleep(3000);

		// validation 5
		logger.debug("---------------------------VALIDATION 5 START--------------------------------");
		Function.addNumberValidations(driver, 7, Constants.ADD_NUMBER_SHEET);

		// Check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.TYPE_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.ORGANIZATION_MAN_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.COUNTRY_MAN_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.STATE_MAN_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.CITY_MAN_ERROR), true);

		logger.debug("---------------------------VALIDATION 5 END--------------------------------");

		logger.debug("addNumberTesting:end");
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
