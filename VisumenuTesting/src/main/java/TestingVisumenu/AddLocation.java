package TestingVisumenu;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utils.Constants;
import Utils.ExcelUtils;
import Utils.Function;

public class AddLocation {

	final static Logger logger = Logger.getLogger(AddLocation.class);
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
	public void addLocation() throws Exception {
		logger.debug("addLocation:start");

		// login first
		Function.loginVisumenu(driver, 1);
		Thread.sleep(2000);

		// click on the icon
		driver.findElement(By.xpath("//html/body/root/header/div[1]/div/div[1]/button/span/mat-icon")).click();
		Thread.sleep(2000);

		// click on the location
		driver.findElement(By.linkText("LOCATION")).click();
		Thread.sleep(2000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/street/button/span/i")).click();

		// check for the mandatory field errors
		// organization
		WebElement organization = driver.findElement(By.xpath("//input[@placeholder='Select organization']"));
		organization.sendKeys(Keys.TAB);

		// country
		WebElement country = driver.findElement(By.xpath("//input[@placeholder='Select country']"));
		country.sendKeys(Keys.TAB);

		// state
		WebElement state = driver.findElement(By.xpath("//input[@placeholder='Select state']"));
		state.sendKeys(Keys.TAB);

		// city
		WebElement city = driver.findElement(By.xpath("//input[@placeholder='Select city']"));
		city.sendKeys(Keys.TAB);

		// street
		WebElement street = driver.findElement(By.xpath("//input[@placeholder='Enter street name']"));
		street.sendKeys(Keys.TAB);

		// postal code
		WebElement postalCode = driver.findElement(By.xpath("//input[@placeholder='Select postal code']"));
		postalCode.sendKeys(Keys.TAB);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.ORGANIZATION_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.COUNTRY_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.STATE_MAN_ERROR), true);

		Thread.sleep(3000);

		// validation value 1
		logger.debug("-------------------------VALIDATION 1 START------------------------");
		Function.locationValidations(driver, 3, Constants.LOCATION_SHEET);

		// check for the errors

		Assert.assertEquals(driver.getPageSource().contains(Constants.STATE_MAN_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.STREET_LIMIT_ERROR), true);

		logger.debug("-------------------------VALIDATION 1 END------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/street/button/span/i")).click();
		Thread.sleep(2000);

		// validation 2
		logger.debug("------------------------VALIDATION 2 START--------------------------");
		Function.locationValidations(driver, 4, Constants.LOCATION_SHEET);

		// check for the errors

		Assert.assertEquals(driver.getPageSource().contains(Constants.STATE_MAN_ERROR), true);

		Assert.assertEquals(driver.getPageSource().contains(Constants.STREET_LIMIT_ERROR), true);

		logger.debug("------------------------VALIDATION 2 END--------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/street/button/span/i")).click();
		Thread.sleep(2000);

		// validation 3
		logger.debug("------------------------VALIDATION 3 START-------------------------");
		Function.locationValidations(driver, 5, Constants.LOCATION_SHEET);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.STATE_MAN_ERROR), true);

		logger.debug("------------------------VALIDATION 3 END-------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/street/button/span/i")).click();
		Thread.sleep(2000);

		// validation 4
		logger.debug("------------------------VALIDATION 4 START-------------------------");
		Function.locationValidations(driver, 6, Constants.LOCATION_SHEET);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.STATE_MAN_ERROR), true);

		logger.debug("------------------------VALIDATION 4 END-------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/street/button/span/i")).click();
		Thread.sleep(2000);

		// validation 5
		logger.debug("------------------------VALIDATION 5 START-------------------------");
		Function.locationValidations(driver, 7, Constants.LOCATION_SHEET);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.STATE_MAN_ERROR), true);

		logger.debug("------------------------VALIDATION 5 END-------------------------");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/street/button/span/i")).click();
		Thread.sleep(2000);

		// validation 6
		logger.debug("------------------------VALIDATION 6 START-------------------------");

		// organization
		try {
			WebElement selectOrganization = driver.findElement(By.xpath("//input[@placeholder='Select organization']"));
			selectOrganization.sendKeys("A");
			Thread.sleep(2000);

			WebElement selectOrganization1 = driver
					.findElement(By.xpath("//input[@placeholder='Select organization']"));
			selectOrganization1.sendKeys("e");

			WebElement name = driver.findElement(By.tagName("auto-complete"));
			List<WebElement> storeTag = name.findElements(By.className("ng-star-inserted"));
			String str = ExcelUtils.getCellData(8, 1, Constants.LOCATION_SHEET);
			for (int i = 0; i < storeTag.size(); i++) {
				if (storeTag.get(i).getText().contains(str)) {
					Thread.sleep(2000);
					storeTag.get(i).click();
					break;
				}
			}
		} catch (Exception e) {
			e.getMessage();
		}
		Thread.sleep(5000);

		// country
		WebElement selectCountry = driver.findElement(By.xpath("//input[@placeholder='Select country']"));
		selectCountry.sendKeys("U");
		Thread.sleep(2000);

		WebElement selectCountry1 = driver.findElement(By.xpath("//input[@placeholder='Select country']"));
		selectCountry1.sendKeys("n");
		Thread.sleep(2000);

		WebElement selectCountry2 = driver.findElement(By.xpath("//input[@placeholder='Select country']"));
		selectCountry2.sendKeys("i");

		WebElement autoComplete = driver.findElement(By.tagName("auto-complete"));
		List<WebElement> list = autoComplete.findElements(By.className("ng-star-inserted"));
		String matchValue = ExcelUtils.getCellData(8, 2, Constants.LOCATION_SHEET);
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getText().contains(matchValue)) {
				Thread.sleep(2000);
				list.get(i).click();
				break;
			}
		}

		Thread.sleep(5000);

		// state
		WebElement selectState = driver.findElement(By.xpath("//input[@placeholder='Select state']"));
		selectState.sendKeys("C");
		Thread.sleep(2000);

		WebElement selectState1 = driver.findElement(By.xpath("//input[@placeholder='Select state']"));
		selectState1.sendKeys("a");

		WebElement autoComplete1 = driver.findElement(By.tagName("auto-complete"));
		List<WebElement> list1 = autoComplete1.findElements(By.className("ng-star-inserted"));
		String matchValue1 = ExcelUtils.getCellData(8, 3, Constants.LOCATION_SHEET);
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i).getText().contains(matchValue1)) {
				Thread.sleep(2000);
				list1.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);

		// city
		WebElement selectCity = driver.findElement(By.xpath("//input[@placeholder='Select city']"));
		selectCity.sendKeys("L");
		Thread.sleep(2000);

		WebElement selectCity1 = driver.findElement(By.xpath("//input[@placeholder='Select city']"));
		selectCity1.sendKeys("i");

		WebElement autoComplete2 = driver.findElement(By.tagName("auto-complete"));
		List<WebElement> list12 = autoComplete2.findElements(By.className("ng-star-inserted"));
		String matchValue2 = ExcelUtils.getCellData(8, 4, Constants.LOCATION_SHEET);
		for (int i = 0; i < list12.size(); i++) {
			if (list12.get(i).getText().contains(matchValue2)) {
				Thread.sleep(2000);
				list12.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);

		// street
		WebElement selectStreet = driver.findElement(By.xpath("//input[@placeholder='Enter street name']"));
		selectStreet.sendKeys(ExcelUtils.getCellData(8, 5, Constants.LOCATION_SHEET));

		// postal code
		WebElement selectPostalCode = driver.findElement(By.xpath("//input[@placeholder='Select postal code']"));
		selectPostalCode.sendKeys("9");
		Thread.sleep(2000);

		WebElement selectPostalCode1 = driver.findElement(By.xpath("//input[@placeholder='Select postal code']"));
		selectPostalCode1.sendKeys("4");

		WebElement autoComplete3 = driver.findElement(By.tagName("auto-complete"));
		List<WebElement> list3 = autoComplete3.findElements(By.className("ng-star-inserted"));
		String matchValue4 = ExcelUtils.getCellData(8, 6, Constants.LOCATION_SHEET);
		for (int i = 0; i < list3.size(); i++) {
			if (list3.get(i).getText().contains(matchValue4)) {
				Thread.sleep(2000);
				list3.get(i).click();
				break;
			}
		}
		Thread.sleep(2000);

		// click on the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);

		logger.debug("------------------------VALIDATION 6 END-------------------------");

		logger.debug("addLocation:end");

	}

	@Test(priority = 1)
	public void searchPostalCode() throws Exception {
		logger.debug("searchPostalCode:start");

		// refresh
		driver.navigate().refresh();
		Thread.sleep(5000);

		// search the postal code
		driver.findElement(By.xpath("input[@placeholder='Search code...']"))
				.sendKeys(ExcelUtils.getCellData(8, 6, Constants.LOCATION_SHEET));
		Thread.sleep(2000);

		logger.debug("searchPostalCode:end");
	}

	@Test(priority = 2)
	public void deleteLocationEntered() throws Exception {
		logger.debug("deleteLocationEntered:start");

		WebElement clickOnIcon = driver
				.findElement(By.xpath("//*[@id='scrollOnTop']/form/table/tbody/tr[1]/td[7]/button/span/mat-icon"));
		clickOnIcon.click();
		Thread.sleep(2000);

		WebElement clickOnYes = driver
				.findElement(By.xpath("//html/body/root/street/app-delete-item/div[1]/form/div/button[1]"));
		clickOnYes.click();
		Thread.sleep(2000);

		logger.debug("deleteLocationEntered:end");

	}

	@Test()
	public void searchAfterDeletingRow() throws Exception {
		logger.debug("searchAfterDeletingRow:start");

		// refresh
		driver.navigate().refresh();
		Thread.sleep(5000);

		// search the postal code
		driver.findElement(By.xpath("input[@placeholder='Search code...']"))
				.sendKeys(ExcelUtils.getCellData(8, 6, Constants.LOCATION_SHEET));
		Thread.sleep(2000);

		logger.debug("searchAfterDeletingRow:end");
	}

}
