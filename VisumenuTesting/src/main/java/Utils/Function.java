package Utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import TestingVisumenu.LoginPagePageFactory;

public class Function {
	private LoginPagePageFactory login;

	public static void loginVisumenu(WebDriver driver, int row) throws Exception {
		
		driver.findElement(By.xpath("//input[@placeholder='Username']"))
				.sendKeys(ExcelUtils.getCellData(row, 1, Constants.LOGIN_PAGE_SHEET));
		driver.findElement(By.xpath("//input[@placeholder='Password']"))
				.sendKeys(ExcelUtils.getCellData(row, 2, Constants.LOGIN_PAGE_SHEET));

		// click on the login button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

	}

	public static void loginPageValidations(WebDriver driver, int row, String sheet) throws Exception {

		driver.findElement(By.xpath("//input[@placeholder='Username']"))
				.sendKeys(ExcelUtils.getCellData(row, 1, Constants.LOGIN_PAGE_SHEET));
		driver.findElement(By.xpath("//input[@placeholder='Password']"))
				.sendKeys(ExcelUtils.getCellData(row, 2, Constants.LOGIN_PAGE_SHEET));

		Thread.sleep(2000);

	}

	public static void clearLoginFields(WebDriver driver) {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Password']")).clear();
	}

	public static void addCountryValidations(WebDriver driver, int row, String sheet) throws Exception {

		// country
		driver.findElement(By.xpath("//input[@placeholder='Enter country name']"))
				.sendKeys(ExcelUtils.getCellData(row, 1, Constants.COUNTRY_SHEET));

		// dialing code
		driver.findElement(By.xpath("//input[@placeholder='Enter dialing code']"))
				.sendKeys(ExcelUtils.getCellData(row, 2, Constants.COUNTRY_SHEET));

		// code
		driver.findElement(By.xpath("//input[@placeholder='Enter code']"))
				.sendKeys(ExcelUtils.getCellData(row, 3, Constants.COUNTRY_SHEET));

		Thread.sleep(2000);

	}

	public static void cleanFieldsForAddCountry(WebDriver driver) throws Exception {

		// country
		driver.findElement(By.xpath("//input[@placeholder='Enter country name']")).clear();

		// dialing code
		driver.findElement(By.xpath("//input[@placeholder='Enter dialing code']")).clear();

		// code
		driver.findElement(By.xpath("//input[@placeholder='Enter code']")).clear();

		Thread.sleep(2000);

	}

	public static void organizationValidations(WebDriver driver, int row, String sheet) throws Exception {
		driver.findElement(By.xpath("//input[@placeholder='Enter organization name']"))
				.sendKeys(ExcelUtils.getCellData(row, 1, Constants.ORGANIZATION_SHEET));

		// passing value from sheet to check minimum length error(Enter url)
		driver.findElement(By.xpath("//input[@placeholder='Enter app URL']"))
				.sendKeys(ExcelUtils.getCellData(row, 2, Constants.ORGANIZATION_SHEET));

		Thread.sleep(2000);
	}

	public static void departmentValidations(WebDriver driver, int row, String sheet) throws Exception {
		driver.findElement(By.xpath("//input[@placeholder='Enter department name']"))
				.sendKeys(ExcelUtils.getCellData(row, 1, Constants.DEPARTMENT_SHEET));

		driver.findElement(By.xpath("//input[@placeholder='Select organization']"))
				.sendKeys(ExcelUtils.getCellData(row, 2, Constants.DEPARTMENT_SHEET));
	}

	public static void autoCompleteDepartment(WebDriver driver, int row, String sheet ) throws Exception {
		WebElement name = driver.findElement(By.tagName("auto-complete"));
		List<WebElement> storeTag = name.findElements(By.className("ng-star-inserted"));
		String str = ExcelUtils.getCellData(row, 2, Constants.DEPARTMENT_SHEET);
		for (int i = 0; i < storeTag.size(); i++) {
			if (storeTag.get(i).getText().contains(str)) {
				Thread.sleep(2000);
				storeTag.get(i).click();
				break;
			}
		}
	}

	public static void addStateValidations(WebDriver driver, int row, String sheet) throws Exception {
		// state
		driver.findElement(By.xpath("//input[@placeholder='Enter State name']"))
				.sendKeys(ExcelUtils.getCellData(row, 1, Constants.STATE_SHEET));

		// code
		driver.findElement(By.xpath("//input[@placeholder='Enter Code']"))
				.sendKeys(ExcelUtils.getCellData(row, 2, Constants.STATE_SHEET));

		driver.findElement(By.xpath("//input[@placeholder='Enter Code']")).sendKeys(Keys.TAB);

		// country
		Actions action = new Actions(driver);
		WebElement country = driver.findElement(By.xpath("//input[@placeholder='Select Country']"));
		action.moveToElement(country).sendKeys(ExcelUtils.getCellData(row, 3, Constants.STATE_SHEET)).build().perform();

		Thread.sleep(2000);

	}

	public static void autocompleteForState(WebDriver driver, int row, String sheet) throws Exception {
		WebElement name = driver.findElement(By.tagName("auto-complete"));
		List<WebElement> storeTag = name.findElements(By.className("ng-star-inserted"));
		String str = ExcelUtils.getCellData(row, 3, Constants.STATE_SHEET);
		for (int i = 0; i < storeTag.size(); i++) {
			if (storeTag.get(i).getText().contains(str)) {
				Thread.sleep(2000);
				storeTag.get(i).click();
				break;
			}
		}

	}

	public static void cityValidations(WebDriver driver, int row, String sheetName) throws Exception {

		// city
		driver.findElement(By.xpath("//input[@placeholder='Enter city name']"))
				.sendKeys(ExcelUtils.getCellData(row, 1, Constants.CITY_SHEET));

		// state
		driver.findElement(By.xpath("//input[@placeholder='Select state']"))
				.sendKeys(ExcelUtils.getCellData(row, 2, Constants.CITY_SHEET));

		// code
		driver.findElement(By.xpath("//input[@placeholder='Enter Code']"))
				.sendKeys(ExcelUtils.getCellData(row, 3, Constants.CITY_SHEET));

		Thread.sleep(2000);

	}

	public static void autoCompleteForCity(WebDriver driver, int row, String sheetName) throws Exception {
		WebElement name = driver.findElement(By.tagName("auto-complete"));
		List<WebElement> storeTag = name.findElements(By.className("ng-star-inserted"));
		String str = ExcelUtils.getCellData(row, 2, Constants.CITY_SHEET);
		for (int i = 0; i < storeTag.size(); i++) {
			if (storeTag.get(i).getText().equalsIgnoreCase(str)) {
				Thread.sleep(2000);
				storeTag.get(i).click();
				break;
			}
		}

	}

	public static void locationValidations(WebDriver driver, int row, String sheet) throws Exception {
		// organization
		driver.findElement(By.xpath("//input[@placeholder='Select organization']"))
				.sendKeys(ExcelUtils.getCellData(row, 1, Constants.LOCATION_SHEET));

		// country
		driver.findElement(By.xpath("//input[@placeholder='Select country']"))
				.sendKeys(ExcelUtils.getCellData(row, 2, Constants.LOCATION_SHEET));

		// state
		driver.findElement(By.xpath("//input[@placeholder='Select state']"))
				.sendKeys(ExcelUtils.getCellData(row, 3, Constants.LOCATION_SHEET));

		// city
		driver.findElement(By.xpath("//input[@placeholder='Select city']"))
				.sendKeys(ExcelUtils.getCellData(row, 4, Constants.LOCATION_SHEET));

		// street
		driver.findElement(By.xpath("//input[@placeholder='Enter street name']"))
				.sendKeys(ExcelUtils.getCellData(row, 5, Constants.LOCATION_SHEET));

		// postal code
		driver.findElement(By.xpath("//input[@placeholder='Select postal code']"))
				.sendKeys(ExcelUtils.getCellData(row, 6, Constants.LOCATION_SHEET));

		Thread.sleep(3000);

	}

	public static void appValidations(WebDriver driver, int row, String sheetName) throws Exception {

		// url
		driver.findElement(By.xpath("//input[@placeholder='Enter Url']"))
				.sendKeys(ExcelUtils.getCellData(row, 1, Constants.APP_SHEET));

		// description
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Description']"))
				.sendKeys(ExcelUtils.getCellData(row, 2, Constants.APP_SHEET));

		// organization
		driver.findElement(By.xpath("//input[@placeholder='Enter Organization name']"))
				.sendKeys(ExcelUtils.getCellData(row, 3, Constants.APP_SHEET));

		Thread.sleep(2000);

	}

	public static void addNumberValidations(WebDriver driver,int row,String sheetName) throws Exception {

		// phone number
		driver.findElement(By.xpath("//input[@placeholder='Ex. XXXXXXXXXX, XXX-XXX-XXXX, (XXX) XXX-XXXX']"))
				.sendKeys(ExcelUtils.getCellData(row, 1, Constants.ADD_NUMBER_SHEET));

		// select type
		driver.findElement(By.xpath("//mat-select[@placeholder='Select type']")).sendKeys(ExcelUtils.getCellData(row, 2, Constants.ADD_NUMBER_SHEET));

		// select organization
		driver.findElement(By.xpath("//input[@placeholder='Select Organization']")).sendKeys(ExcelUtils.getCellData(row, 3, Constants.ADD_NUMBER_SHEET));

		// country
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys(ExcelUtils.getCellData(row, 4, Constants.ADD_NUMBER_SHEET));

		// state
		driver.findElement(By.xpath("//input[@placeholder='Select State']")).sendKeys(ExcelUtils.getCellData(row, 5, Constants.ADD_NUMBER_SHEET));

		// city
		driver.findElement(By.xpath("//input[@placeholder='Select City']")).sendKeys(ExcelUtils.getCellData(row, 6, Constants.ADD_NUMBER_SHEET));

		// street
		driver.findElement(By.xpath("//input[@placeholder='Select Street']")).sendKeys(ExcelUtils.getCellData(row, 7, Constants.ADD_NUMBER_SHEET));

		// postal Code
		driver.findElement(By.xpath("//input[@placeholder='Select Postal Code']")).sendKeys(ExcelUtils.getCellData(row, 8, Constants.ADD_NUMBER_SHEET));

		// department
		driver.findElement(By.xpath("//input[@placeholder='Select Department']")).sendKeys(ExcelUtils.getCellData(row, 9, Constants.ADD_NUMBER_SHEET));

		// extension
		driver.findElement(By.xpath("//input[@placeholder='Ex. X,XX']")).sendKeys(ExcelUtils.getCellData(row, 10, Constants.ADD_NUMBER_SHEET));

		Thread.sleep(2000);
		
	}

}
