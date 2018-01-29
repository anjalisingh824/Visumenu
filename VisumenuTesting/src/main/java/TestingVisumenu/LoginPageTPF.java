package TestingVisumenu;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utils.Constants;
import Utils.ExcelUtils;



public class LoginPageTPF {

	private WebDriver driver;
	private LoginPagePageFactory login;
	final static Logger logger = Logger.getLogger(LoginPageTPF.class);

	@BeforeClass
	public void setUp() throws Exception {

		logger.debug("==========================init start================================");
		System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_LOCATION);
		driver = new ChromeDriver();
		driver.get(Constants.ADMIN_URL);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		login = new LoginPagePageFactory(driver);
		logger.debug("==========================init end===================================");

	}

	@Test
	public void testingLogin() throws Exception
	{
		logger.debug("testingLogin:start");
		
		login.enterUsername.sendKeys(ExcelUtils.getCellData(1, 1, Constants.LOGIN_PAGE_SHEET));
		login.enterPassword.sendKeys(ExcelUtils.getCellData(1, 2, Constants.LOGIN_PAGE_SHEET));
		Thread.sleep(2000);
		login.loginBtn.click();
		
		
		logger.debug("testingEnd:end");
		
	}
	
	
}
