package pageObject;

import org.openqa.selenium.WebDriver;

import commons.BaseActions;
import pageUIs.LoginUI;

public class LoginPO extends BaseActions {

	WebDriver driver;
	public LoginPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public void sendkeyToUsernameInput(String value) {
		waitForElementVisible(driver,LoginUI.USERNAME_INPUT);
		sendkeyToElement(driver, LoginUI.USERNAME_INPUT, value);
	}
	public void sendkeyToPasswordInput(String value) {
		waitForElementVisible(driver,LoginUI.USERNAME_INPUT);
		sendkeyToElement(driver, LoginUI.USERNAME_INPUT, value);		
	}
	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginUI.SUBMIT_BUTTON);
		clickToElement(driver,LoginUI.SUBMIT_BUTTON);
	}

}
