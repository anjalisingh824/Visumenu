package TestingVisumenu;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPagePageFactory {

	private WebDriver driver;
	
	public LoginPagePageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Username']")
	public WebElement enterUsername;

	@FindBy(xpath = "//input[@placeholder='Password']")
	public WebElement enterPassword;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement loginBtn;

	public void clickLogin() {
		loginBtn.click();
	}

}
