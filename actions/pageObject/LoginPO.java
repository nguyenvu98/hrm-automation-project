package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BaseActions;
import pageUIs.LoginUI;

public class LoginPO extends BaseActions {

	
	@FindBy(how = How.XPATH, using = "//input[@name='username']")
	private WebElement usernameInput;
	
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	private WebElement passwordInput;
	
	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	private WebElement loginButton;
	
	WebDriver driver;
	public LoginPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	public void sendkeyToUsernameInput(String value) {
		waitForElementVisible(driver,usernameInput);
		sendkeyToElement(driver, usernameInput, value);
	}
	public void sendkeyToPasswordInput(String value) {
		waitForElementVisible(driver,passwordInput);
		sendkeyToElement(driver, passwordInput, value);		
	}
	public void clickToLoginButton() {
		waitForElementClickable(driver, loginButton);
		clickToElement(driver,loginButton);
	}

}
