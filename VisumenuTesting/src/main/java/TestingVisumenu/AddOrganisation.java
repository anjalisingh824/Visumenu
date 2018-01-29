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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utils.Constants;
import Utils.ExcelUtils;
import Utils.Function;

public class AddOrganisation {

	final static Logger logger = Logger.getLogger(AddOrganisation.class);
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
	public void testOrganization() throws Exception {
		logger.debug("testOrganization:start");

		// login first
		Function.loginVisumenu(driver, 1);
		Thread.sleep(2000);

		// click on the icon
		driver.findElement(By.xpath("//html/body/root/header/div[1]/div/div[1]/button/span/mat-icon")).click();
		Thread.sleep(2000);

		// click on the organization tab
		driver.findElement(By.linkText("ORGANIZATION")).click();
		Thread.sleep(5000);

		// click on the add button for adding organization
		driver.findElement(By.xpath("//html/body/root/organization/button/span/i")).click();
		Thread.sleep(2000);

		// moving to pop up
//		WebElement popUp = driver.findElement(By.xpath("//input[@placeholder='Enter organization name']"));
//		Actions action = new Actions(driver);
//		action.moveToElement(popUp).sendKeys(Keys.TAB).build().perform();
//
//		// click on the the pop up field to check the error
//		driver.findElement(By.xpath("//input[@placeholder='Enter app URL']")).sendKeys(Keys.TAB);
//		Thread.sleep(5000);
//
//		// get the mandatory errors
//		String organizationError = driver
//				.findElement(By.xpath("//html/body/root/organization/div[2]/form/div[1]/validation/small/span"))
//				.getText();
//		Assert.assertEquals(organizationError, "Enter organization.");
//
//		Thread.sleep(2000);
//
//		// validation value 1
//		Function.organizationValidations(driver, 3, Constants.ORGANIZATION_SHEET);
//
//		// get the error
//		Assert.assertEquals(driver.getPageSource().contains(Constants.ORGANIZATION_LENGTH_ERROR), true);
//
//		if (driver.getPageSource().contains(Constants.ORGANIZATION_LENGTH_ERROR)) {
//			ExcelUtils.setCellData("PASSED", 3, 3, Constants.ORGANIZATION_SHEET);
//		} else {
//			ExcelUtils.setCellData("FAILED", 3, 3, Constants.ORGANIZATION_SHEET);
//		}
//
//		Thread.sleep(2000);
//
//		// clean the fields
//		driver.findElement(By.xpath("//input[@placeholder='Enter organization name']")).clear();
//		driver.findElement(By.xpath("//input[@placeholder='Enter app URL']")).clear();
//
//		Thread.sleep(2000);
//
//		// validation value 2
//		Function.organizationValidations(driver, 4, Constants.ORGANIZATION_SHEET);
//
//		// get the error
//		Assert.assertEquals(driver.getPageSource().contains(Constants.ORGANIZATION_LENGTH_ERROR), true);
//		if (driver.getPageSource().contains(Constants.ORGANIZATION_LENGTH_ERROR)) {
//			ExcelUtils.setCellData("PASSED", 4, 3, Constants.ORGANIZATION_SHEET);
//		} else {
//			ExcelUtils.setCellData("FAILED", 4, 3, Constants.ORGANIZATION_SHEET);
//		}
//
//		Thread.sleep(2000);
//
//		Assert.assertEquals(driver.getPageSource().contains(Constants.URL_NOT_FOUND), true);
//		if (driver.getPageSource().contains(Constants.URL_NOT_FOUND)) {
//			ExcelUtils.setCellData("PASSED", 4, 3, Constants.ORGANIZATION_SHEET);
//		} else {
//			ExcelUtils.setCellData("FAILED", 4, 3, Constants.ORGANIZATION_SHEET);
//		}
//
//		Thread.sleep(2000);
//
//		// clean the fields
//		driver.findElement(By.xpath("//input[@placeholder='Enter organization name']")).clear();
//		driver.findElement(By.xpath("//input[@placeholder='Enter app URL']")).clear();
//
//		// Validation field 3
//		Function.organizationValidations(driver, 5, Constants.ORGANIZATION_SHEET);
//
//		Assert.assertEquals(driver.getPageSource().contains(Constants.URL_NOT_FOUND), true);
//		if (driver.getPageSource().contains(Constants.URL_NOT_FOUND)) {
//			ExcelUtils.setCellData("PASSED", 5, 3, Constants.ORGANIZATION_SHEET);
//		} else {
//			ExcelUtils.setCellData("FAILED", 5, 3, Constants.ORGANIZATION_SHEET);
//		}
//
//		Thread.sleep(2000);
//
//		// click on the save button
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		Thread.sleep(7000);
//
//		// delete the entry added as it is only for testing purpose
//		// click on the delete icon
//		driver.findElement(By
//				.xpath("//*[@id='scrollOnTop']/form/div/mat-accordion/mat-expansion-panel[1]/mat-expansion-panel-header/span/mat-panel-title/div/div[3]/button/span/mat-icon"))
//				.click();
//		Thread.sleep(3000);
//
//		// click on the yes button
//		driver.findElement(By.xpath("//html/body/root/organization/app-delete-item/div[1]/form/div/button[1]")).click();
//		Thread.sleep(2000);
//
//		// click on the add button
//		driver.findElement(By.xpath("//html/body/root/organization/button/span/i")).click();
//		Thread.sleep(2000);
//
//		// validation value 4
//
//		Function.organizationValidations(driver, 6, Constants.ORGANIZATION_SHEET);
//
//		Assert.assertEquals(driver.getPageSource().contains(Constants.URL_NOT_FOUND), true);
//		if (driver.getPageSource().contains(Constants.URL_NOT_FOUND)) {
//			ExcelUtils.setCellData("PASSED", 6, 3, Constants.ORGANIZATION_SHEET);
//		} else {
//			ExcelUtils.setCellData("FAILED", 6, 3, Constants.ORGANIZATION_SHEET);
//		}
//
//		Thread.sleep(2000);
//
//		// click on the save button
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		Thread.sleep(7000);
//
//		// delete the entry added as it is only for testing purpose
//		// click on the delete icon
//		driver.findElement(By
//				.xpath("//*[@id='scrollOnTop']/form/div/mat-accordion/mat-expansion-panel[1]/mat-expansion-panel-header/span/mat-panel-title/div/div[3]/button/span/mat-icon"))
//				.click();
//		Thread.sleep(3000);
//
//		// click on the yes button
//		driver.findElement(By.xpath("//html/body/root/organization/app-delete-item/div[1]/form/div/button[1]")).click();
//		Thread.sleep(2000);
//
//		// click on the add button
//		driver.findElement(By.xpath("//html/body/root/organization/button/span/i")).click();
//		Thread.sleep(2000);
//
//		// validation value 5
//		Function.organizationValidations(driver, 7, Constants.ORGANIZATION_SHEET);
//
//		Assert.assertEquals(driver.getPageSource().contains(Constants.URL_NOT_FOUND), true);
//		if (driver.getPageSource().contains(Constants.URL_NOT_FOUND)) {
//			ExcelUtils.setCellData("PASSED", 7, 3, Constants.ORGANIZATION_SHEET);
//		} else {
//			ExcelUtils.setCellData("FAILED", 7, 3, Constants.ORGANIZATION_SHEET);
//		}
//
//		Thread.sleep(2000);
//
//		// click on the save button
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		Thread.sleep(7000);
//
//		// delete the entry added as it is only for testing purpose
//		// click on the delete icon
//		driver.findElement(By
//				.xpath("//*[@id='scrollOnTop']/form/div/mat-accordion/mat-expansion-panel[1]/mat-expansion-panel-header/span/mat-panel-title/div/div[3]/button/span/mat-icon"))
//				.click();
//		Thread.sleep(3000);
//
//		// click on the yes button
//		driver.findElement(By.xpath("//html/body/root/organization/app-delete-item/div[1]/form/div/button[1]")).click();
//		Thread.sleep(2000);
//
//		// click on the add button
//		driver.findElement(By.xpath("//html/body/root/organization/button/span/i")).click();
//		Thread.sleep(2000);
//
//		// validation value 6
//		// passing to check whether we can take same organization again
//		Function.organizationValidations(driver, 8, Constants.ORGANIZATION_SHEET);
//
//		// click on the save button
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		Thread.sleep(2000);
//
//		// name already taken error
//		if (driver.getPageSource().contains(Constants.NAME_TAKEN_ERROR)) {
//			ExcelUtils.setCellData("PASSED", 8, 3, Constants.ORGANIZATION_SHEET);
//		} else {
//			ExcelUtils.setCellData("FAILED", 8, 3, Constants.ORGANIZATION_SHEET);
//		}
//
//		Thread.sleep(2000);
//
//		// clean the fields
//		driver.findElement(By.xpath("//input[@placeholder='Enter organization name']")).clear();
//		driver.findElement(By.xpath("//input[@placeholder='Enter app URL']")).clear();
//
//		Thread.sleep(5000);
//
//		// validation value 7
//		Function.organizationValidations(driver, 9, Constants.ORGANIZATION_SHEET);
//
//		// click on the save button
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		Thread.sleep(2000);
//
//		// name already taken error
//		if (driver.getPageSource().contains(Constants.NAME_TAKEN_ERROR)) {
//			ExcelUtils.setCellData("PASSED", 9, 3, Constants.ORGANIZATION_SHEET);
//		} else {
//			ExcelUtils.setCellData("FAILED", 9, 3, Constants.ORGANIZATION_SHEET);
//		}
//
//		Thread.sleep(2000);
//
//		// clean the fields
//		driver.findElement(By.xpath("//input[@placeholder='Enter organization name']")).clear();
//		driver.findElement(By.xpath("//input[@placeholder='Enter app URL']")).clear();
//
//		// validation value 8
//		Function.organizationValidations(driver, 10, Constants.ORGANIZATION_SHEET);
//
//		// click on the save button
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
//		Thread.sleep(7000);
//
//		if (driver.getPageSource().contains(Constants.ORGANIZATION_ADDED_SUCCESSFULLY)) {
//			ExcelUtils.setCellData("PASSED", 10, 3, Constants.ORGANIZATION_SHEET);
//		} else {
//			ExcelUtils.setCellData("FAILED", 10, 3, Constants.ORGANIZATION_SHEET);
//		}
//		Thread.sleep(5000);
//
//		// delete the entry added as it is only for testing purpose
//		// click on the delete icon
//		driver.findElement(By
//				.xpath("//*[@id='scrollOnTop']/form/div/mat-accordion/mat-expansion-panel[1]/mat-expansion-panel-header/span/mat-panel-title/div/div[3]/button/span/mat-icon"))
//				.click();
//		Thread.sleep(3000);
//
//		// click on the yes button
//		driver.findElement(By.xpath("//html/body/root/organization/app-delete-item/div[1]/form/div/button[1]")).click();
//		Thread.sleep(2000);
//
//		// click on the add button
//		driver.findElement(By.xpath("//html/body/root/organization/button/span/i")).click();
//		Thread.sleep(2000);

		// validation value 9
		Function.organizationValidations(driver, 11, Constants.ORGANIZATION_SHEET);
		Thread.sleep(4000);

		// click on the checkbox to select the url
	    WebElement checkbox=driver.findElement(By.tagName("li"));
	    WebElement clickOn=checkbox.findElement(By.className("ng-star-inserted"));
	    clickOn.click();
	    Thread.sleep(2000);
		

		// click on the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(7000);

		if (driver.getPageSource().contains(Constants.ORGANIZATION_ADDED_SUCCESSFULLY)) {
			ExcelUtils.setCellData("PASSED", 11, 3, Constants.ORGANIZATION_SHEET);
		} else {
			ExcelUtils.setCellData("FAILED", 11, 3, Constants.ORGANIZATION_SHEET);
		}

		String getAssignedValue = driver
				.findElement(By
						.xpath("//*[@id='scrollOnTop']/form/div/mat-accordion/mat-expansion-panel[1]/mat-expansion-panel-header/span/mat-panel-title/div/div[2]"))
				.getText();
		Assert.assertEquals(getAssignedValue, "1 assigned");

		Thread.sleep(5000);

		// delete the entry added as it is only for testing purpose
		// click on the delete icon
		driver.findElement(By
				.xpath("//*[@id='scrollOnTop']/form/div/mat-accordion/mat-expansion-panel[1]/mat-expansion-panel-header/span/mat-panel-title/div/div[3]/button/span/mat-icon"))
				.click();
		Thread.sleep(3000);

		// click on the yes button
		driver.findElement(By.xpath("//html/body/root/organization/app-delete-item/div[1]/form/div/button[1]")).click();
		Thread.sleep(2000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/organization/button/span/i")).click();
		Thread.sleep(2000);

		Thread.sleep(5000);

		// validation value 10
		Function.organizationValidations(driver, 12, Constants.ORGANIZATION_SHEET);
		Thread.sleep(4000);
		
		// click on the checkbox to select the url
		driver.findElement(By.xpath("//mat-checkbox[contains(text(),'SELECT ALL')]")).click();
		Thread.sleep(2000);

		// click on the save button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(7000);

		if (driver.getPageSource().contains(Constants.ORGANIZATION_ADDED_SUCCESSFULLY)) {
			ExcelUtils.setCellData("PASSED", 12, 3, Constants.ORGANIZATION_SHEET);
		} else {
			ExcelUtils.setCellData("FAILED", 12, 3, Constants.ORGANIZATION_SHEET);
		}

		String getAssignedValueNext = driver
				.findElement(By
						.xpath("//*[@id='scrollOnTop']/form/div/mat-accordion/mat-expansion-panel[1]/mat-expansion-panel-header/span/mat-panel-title/div/div[2]"))
				.getText();
		Assert.assertEquals(getAssignedValueNext, "1 assigned");

		Thread.sleep(5000);

		// delete the entry added as it is only for testing purpose
		// click on the delete icon
		driver.findElement(By
				.xpath("//*[@id='scrollOnTop']/form/div/mat-accordion/mat-expansion-panel[1]/mat-expansion-panel-header/span/mat-panel-title/div/div[3]/button/span/mat-icon"))
				.click();
		Thread.sleep(3000);

		// click on the yes button
		driver.findElement(By.xpath("//html/body/root/organization/app-delete-item/div[1]/form/div/button[1]")).click();
		Thread.sleep(2000);

		// click on the add button
		driver.findElement(By.xpath("//html/body/root/organization/button/span/i")).click();
		Thread.sleep(2000);

		Thread.sleep(5000);

		logger.debug("testOrganization:end");

	}

	// @Test(priority = 1)
	// public void searchOrganization() throws Exception {
	// logger.debug("searchOrganization:start");
	//
	// driver.navigate().refresh();
	// Thread.sleep(5000);
	//
	// // search the organization entered
	// driver.findElement(By.xpath("//input[@placeholder='Search organization
	// name...']"))
	// .sendKeys(ExcelUtils.getCellData(11, 1, Constants.ORGANIZATION_SHEET));
	// Thread.sleep(2000);
	//
	// // assert to check whether the value we have entered is present or not
	// String OrganizationValuePresent = driver
	// .findElement(By
	// .xpath("//*[@id='scrollOnTop']/form/div/mat-accordion/mat-expansion-panel/mat-expansion-panel-header/span/mat-panel-title/div/div[1]"))
	// .getText();
	// if (driver.getPageSource().contains(OrganizationValuePresent)) {
	// System.out.println("Passed");
	// } else {
	// System.out.println("Failed");
	// }
	// Thread.sleep(2000);
	//
	// // 0 assigned value also present check that too
	// String assignedValuePresent = driver
	// .findElement(By
	// .xpath("//*[@id='scrollOnTop']/form/div/mat-accordion/mat-expansion-panel/mat-expansion-panel-header/span/mat-panel-title/div/div[2]"))
	// .getText();
	// if (driver.getPageSource().contains(assignedValuePresent)) {
	// System.out.println("Passed");
	// } else {
	// System.out.println("Failed");
	// }
	// Thread.sleep(5000);
	//
	// }
	//
	// @Test(priority = 2)
	// public void deleteOrganization() throws Exception {
	// // click on the delete icon to delete the organization entered
	// WebElement deleteIcon = driver.findElement(By.xpath(
	// "//*[@id='scrollOnTop']/form/div/mat-accordion/mat-expansion-panel/mat-expansion-panel-header/span/mat-panel-title/div/div[3]/button/span/mat-icon"));
	// deleteIcon.click();
	// Thread.sleep(2000);
	//
	// // click on the yes option to delete the organization
	// WebElement clickYes = driver
	// .findElement(By.xpath("//html/body/root/organization/app-delete-item/div[1]/form/div/button[1]/span"));
	// clickYes.click();
	// Thread.sleep(2000);
	//
	// }
	//
	// @Test(priority = 3)
	// public void recheckAfterDeletingOrganization() throws Exception {
	// // refresh the page again
	// driver.navigate().refresh();
	// Thread.sleep(2000);
	//
	// // search the organization again which is deleted to make sure
	//
	// driver.findElement(By.xpath("//input[@placeholder='Search organization
	// name...']"))
	// .sendKeys(ExcelUtils.getCellData(11, 1, Constants.ORGANIZATION_SHEET));
	// Thread.sleep(2000);
	//
	// // check for the error present
	// String organizationNotFound = driver
	// .findElement(By.xpath("//html/body/root/organization/div/div/no-data/div/h2")).getText();
	// if (driver.getPageSource().contains(organizationNotFound)) {
	// System.out.println("Passed");
	// } else {
	// System.out.println("Failed");
	// }
	//
	// Thread.sleep(2000);
	// }

//	@AfterClass
//	public void tearDown() {
//		driver.quit();
//	}

}
