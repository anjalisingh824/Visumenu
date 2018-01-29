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

public class AddDepartment {

	final static Logger logger = Logger.getLogger(AddDepartment.class);
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
	public void addDepartment() throws Exception {
		logger.debug("addDepartment:start");

		// login first
		Function.loginVisumenu(driver, 1);
		Thread.sleep(5000);

		// click on the icon
		driver.findElement(By.xpath("//html/body/root/header/div[1]/div/div[1]/button/span/mat-icon")).click();
		Thread.sleep(5000);

		// click on the department tab now
		driver.findElement(By.xpath("//html/body/root/header/div[2]/div/ul/li[2]/a")).click();
		Thread.sleep(2000);

		// click on the add button to add the department
		driver.findElement(By.xpath("//html/body/root/department/button/span/i")).click();
		Thread.sleep(2000);

		// check for the mandatory fields
		driver.findElement(By.xpath("//input[@placeholder='Enter department name']")).sendKeys(Keys.TAB);

		driver.findElement(By.xpath("//input[@placeholder='Select organization']")).sendKeys(Keys.TAB);

		// check for the errors
		Assert.assertEquals(driver.getPageSource().contains(Constants.ORGANIZATION_ERROR), true);
		Assert.assertEquals(driver.getPageSource().contains(Constants.DEPARTMENT_ERROR), true);

		Thread.sleep(2000);

		// validation value 1
		logger.debug("---------------------VALIDATION 1 START--------------------");
		Function.departmentValidations(driver, 3, Constants.DEPARTMENT_SHEET);
		Thread.sleep(3000);

		logger.debug("---------------------VALIDATION 1 END--------------------");

		// clear the fields
		driver.findElement(By.xpath("//input[@placeholder='Enter department name']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Select organization']")).clear();

		// validation value 2
		logger.debug("---------------------VALIDATION 2 START--------------------");
		Function.departmentValidations(driver, 4, Constants.DEPARTMENT_SHEET);
		Thread.sleep(3000);

		logger.debug("---------------------VALIDATION 2 END--------------------");

		// clear the fields
		driver.findElement(By.xpath("//input[@placeholder='Enter department name']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Select organization']")).clear();

		// validation value 3
		logger.debug("---------------------VALIDATION 3 START--------------------");
		Function.departmentValidations(driver, 5, Constants.DEPARTMENT_SHEET);
		Thread.sleep(3000);

		logger.debug("---------------------VALIDATION 3 END--------------------");

		// clear the fields
		driver.findElement(By.xpath("//input[@placeholder='Enter department name']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Select organization']")).clear();

		// validation value 4
		logger.debug("---------------------VALIDATION 4 START--------------------");
		Function.departmentValidations(driver, 6, Constants.DEPARTMENT_SHEET);
		Thread.sleep(3000);

		logger.debug("---------------------VALIDATION 4 END--------------------");

		// clear the fields
		driver.findElement(By.xpath("//input[@placeholder='Enter department name']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Select organization']")).clear();

		// validation value 5
		logger.debug("---------------------VALIDATION 5 END--------------------");
		Function.departmentValidations(driver, 7, Constants.DEPARTMENT_SHEET);
		Thread.sleep(3000);

		logger.debug("---------------------VALIDATION 5 END--------------------");

		// clear the fields
		driver.findElement(By.xpath("//input[@placeholder='Enter department name']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Select organization']")).clear();

		// validation value 6
		logger.debug("---------------------VALIDATION 6 START--------------------");
		driver.findElement(By.xpath("//input[@placeholder='Enter department name']"))
				.sendKeys(ExcelUtils.getCellData(8, 1, Constants.DEPARTMENT_SHEET));

		// pass values to search through autocomplete
		WebElement organizationValue1 = driver.findElement(By.xpath("//input[@placeholder='Select organization']"));
		organizationValue1.sendKeys("S");

		WebElement organizationValue2 = driver.findElement(By.xpath("//input[@placeholder='Select organization']"));
		organizationValue2.sendKeys("t");

		WebElement organizationValue3 = driver.findElement(By.xpath("//input[@placeholder='Select organization']"));
		organizationValue3.sendKeys("a");
		Thread.sleep(3000);

		// selecting value from dropdown by calling Function class
		Function.autoCompleteDepartment(driver, 8, Constants.DEPARTMENT_SHEET);
		Thread.sleep(2000);

		// click on the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		// check for the error
		if (driver.getPageSource().contains(Constants.NAME_TAKEN_ERROR)) {
			logger.debug("name already taken error is present");
		} else {
			logger.error("name already taken error is not present");
		}
		Thread.sleep(2000);

		logger.debug("---------------------VALIDATION 6 END--------------------");

		// clear the fields
		driver.findElement(By.xpath("//input[@placeholder='Enter department name']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Select organization']")).clear();

		// click on the add button
		// driver.findElement(By.xpath("//html/body/root/department/button/span/i")).click();
		// Thread.sleep(2000);

		// validation value 7
		logger.debug("---------------------VALIDATION 7 START--------------------");
		driver.findElement(By.xpath("//input[@placeholder='Enter department name']"))
				.sendKeys(ExcelUtils.getCellData(9, 1, Constants.DEPARTMENT_SHEET));

		// pass values to search through autocomplete
		WebElement enterOrganizationValue1 = driver
				.findElement(By.xpath("//input[@placeholder='Select organization']"));
		enterOrganizationValue1.sendKeys("S");

		WebElement enterOrganizationValue2 = driver
				.findElement(By.xpath("//input[@placeholder='Select organization']"));
		enterOrganizationValue2.sendKeys("t");

		WebElement enterOrganizationValue3 = driver
				.findElement(By.xpath("//input[@placeholder='Select organization']"));
		enterOrganizationValue3.sendKeys("a");
		Thread.sleep(3000);

		// selecting value from dropdown by calling Function class
		Function.autoCompleteDepartment(driver, 9, Constants.DEPARTMENT_SHEET);
		Thread.sleep(2000);

		// click on the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		// check for the error
		if (driver.getPageSource().contains(Constants.NAME_TAKEN_ERROR)) {
			logger.debug("name already taken error is present");
		} else {
			logger.error("name already taken error is not present");
		}
		Thread.sleep(2000);

		logger.debug("---------------------VALIDATION 7 END--------------------");

		// clear the fields
		driver.findElement(By.xpath("//input[@placeholder='Enter department name']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Select organization']")).clear();

		// validation value 8
		logger.debug("---------------------VALIDATION 8 START--------------------");
		driver.findElement(By.xpath("//input[@placeholder='Enter department name']"))
				.sendKeys(ExcelUtils.getCellData(10, 1, Constants.DEPARTMENT_SHEET));

		// pass values to search through autocomplete
		WebElement enterOrganizationValue4 = driver
				.findElement(By.xpath("//input[@placeholder='Select organization']"));
		enterOrganizationValue4.sendKeys("s");

		WebElement enterOrganizationValue5 = driver
				.findElement(By.xpath("//input[@placeholder='Select organization']"));
		enterOrganizationValue5.sendKeys("t");

		WebElement enterOrganizationValue6 = driver
				.findElement(By.xpath("//input[@placeholder='Select organization']"));
		enterOrganizationValue6.sendKeys("a");
		Thread.sleep(3000);

		// selecting value from dropdown by calling Function class
		Function.autoCompleteDepartment(driver, 10, Constants.DEPARTMENT_SHEET);
		Thread.sleep(2000);

		// click on the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		// check for the error
		if (driver.getPageSource().contains(Constants.NAME_TAKEN_ERROR)) {
			logger.debug("name already taken error is present");
		} else {
			logger.error("name already taken error is not present");
		}
		Thread.sleep(2000);

		logger.debug("---------------------VALIDATION 8 END--------------------");

		// clear the fields
		driver.findElement(By.xpath("//input[@placeholder='Enter department name']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Select organization']")).clear();

		// validation value 9
		logger.debug("---------------------VALIDATION 9 START--------------------");
		driver.findElement(By.xpath("//input[@placeholder='Enter department name']"))
				.sendKeys(ExcelUtils.getCellData(11, 1, Constants.DEPARTMENT_SHEET));

		// pass values to search through autocomplete
		WebElement enterOrganizationValue7 = driver
				.findElement(By.xpath("//input[@placeholder='Select organization']"));
		enterOrganizationValue7.sendKeys("S");

		WebElement enterOrganizationValue8 = driver
				.findElement(By.xpath("//input[@placeholder='Select organization']"));
		enterOrganizationValue8.sendKeys("t");

		WebElement enterOrganizationValue9 = driver
				.findElement(By.xpath("//input[@placeholder='Select organization']"));
		enterOrganizationValue9.sendKeys("a");
		Thread.sleep(3000);

		// selecting value from dropdown by calling Function class
		Function.autoCompleteDepartment(driver, 11, Constants.DEPARTMENT_SHEET);
		Thread.sleep(2000);

		// click on the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		// added successfully
		if (driver.getPageSource().contains(Constants.DEPARTMENT_ADDED_SUCCESSFULLY)) {
			logger.debug("Department added successfully message is present");
		} else {
			logger.error("Department added successfully message is present");
		}
		Thread.sleep(5000);

		logger.debug("---------------------VALIDATION 9 END--------------------");

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/department/button/span/i")).click();
		Thread.sleep(2000);

		// validation value 10
		logger.debug("--------------------VALIDATION 10 START------------------------");
		driver.findElement(By.xpath("//input[@placeholder='Enter department name']"))
				.sendKeys(ExcelUtils.getCellData(12, 1, Constants.DEPARTMENT_SHEET));

		// pass values to search through autocomplete
		WebElement enterOrganizationValue01 = driver
				.findElement(By.xpath("//input[@placeholder='Select organization']"));
		enterOrganizationValue01.sendKeys("A");

		WebElement enterOrganizationValue02 = driver
				.findElement(By.xpath("//input[@placeholder='Select organization']"));
		enterOrganizationValue02.sendKeys("m");

		Thread.sleep(3000);

		// selecting value from dropdown by calling Function class
		Function.autoCompleteDepartment(driver, 12, Constants.DEPARTMENT_SHEET);
		Thread.sleep(2000);

		// click on the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);

		// added successfully
		if (driver.getPageSource().contains(Constants.DEPARTMENT_ADDED_SUCCESSFULLY)) {
			logger.debug("Department added successfully message is present");
		} else {
			logger.error("Department added successfully message is present");
		}
		Thread.sleep(5000);

		logger.debug("--------------------VALIDATION 10 END------------------------");

		logger.debug("addDepartment:end");

	}

	@Test(priority = 1)
	public void searchDepartment() throws Exception {
		logger.debug("searchDepartent:start");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// searching the added department
		driver.findElement(By.xpath("//input[@placeholder='Search department name...']"))
				.sendKeys(ExcelUtils.getCellData(13, 1, Constants.DEPARTMENT_SHEET));

		// Assert to check whether the values present or not
		String departmentValue = driver.findElement(By.xpath("//*[@id='scrollOnTop']/form/table/tbody/tr/td[1]/input"))
				.getText();
		if (driver.getPageSource().contains(departmentValue)) {
			logger.debug("Added Department value is present");
		} else {
			logger.error("Added Department value is not present");
		}

		String organizationValue = driver.findElement(By.xpath("//*[@id='scrollOnTop']/form/table/tbody/tr/td[2]"))
				.getText();
		if (driver.getPageSource().contains(organizationValue)) {
			logger.debug("Added Organization value is present");
		} else {
			logger.error("Added Organization value is not present");
		}

		Thread.sleep(3000);

		logger.debug("searchDepartent:end");

	}

	@Test(priority = 2)
	public void deleteDepartment() throws Exception {

		logger.debug("deleteDepartment:start");

		// click on the delete icon
		WebElement clickOnDeleteIcon = driver
				.findElement(By.xpath("//*[@id='scrollOnTop']/form/table/tbody/tr[1]/td[3]/button/span/mat-icon"));
		clickOnDeleteIcon.click();
		Thread.sleep(2000);

		// click on the yes button
		WebElement clickOnYes = driver
				.findElement(By.xpath("//html/body/root/department/app-delete-item/div[1]/form/div/button[1]"));
		clickOnYes.click();

		Thread.sleep(3000);

		logger.debug("deleteDepartment:end");

	}

	@Test(priority = 3)
	public void searchDeletedDepartment() throws Exception {

		logger.debug("searchDeletedDepartment:start");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(3000);

		// searching the added department
		driver.findElement(By.xpath("//input[@placeholder='Search department name...']"))
				.sendKeys(ExcelUtils.getCellData(13, 1, Constants.DEPARTMENT_SHEET));

		Thread.sleep(2000);
		Assert.assertEquals(driver.getPageSource().contains(Constants.DEPARTMENT_NOT_FOUND), true);
		Thread.sleep(5000);

		logger.debug("searchDeletedDepartment:end");

	}

	@Test(priority = 4)
	public void searchDepartmentAgain() throws Exception {
		logger.debug("searchDepartmentAgain:start");

		// refresh the page
		driver.navigate().refresh();
		Thread.sleep(5000);

		// searching the added department
		driver.findElement(By.xpath("//input[@placeholder='Search department name...']"))
				.sendKeys("I N");

		// Assert to check whether the values present or not
		String departmentValue = driver.findElement(By.xpath("//*[@id='scrollOnTop']/form/table/tbody/tr/td[1]/input"))
				.getText();
		if (driver.getPageSource().contains(departmentValue)) {
			logger.debug("Added Department value is present");
		} else {
			logger.error("Added Department value is not present");
		}

		Thread.sleep(5000);
		logger.debug("searchDepartmentAgain:end");

	}
	
	@Test(priority=5)
	public void deleteDepartmentAgain() throws Exception
	{
		logger.debug("deleteDepartmentAgain:start");
		Thread.sleep(5000);

		// click on the delete icon
		WebElement clickOnDeleteIcon = driver
				.findElement(By.xpath("//*[@id='scrollOnTop']/form/table/tbody/tr[1]/td[3]/button/span/mat-icon"));
		clickOnDeleteIcon.click();
		Thread.sleep(2000);

		// click on the yes button
		WebElement clickOnYes = driver
				.findElement(By.xpath("//html/body/root/department/app-delete-item/div[1]/form/div/button[1]"));
		clickOnYes.click();

		Thread.sleep(3000);

		logger.debug("deleteDepartmentAgain:end");
		
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
