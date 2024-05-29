package pageObject;

import org.openqa.selenium.WebDriver;

import pageUIs.BasePageUI;
import commons.BaseActions;

public class DashboardPO extends BaseActions {

	WebDriver driver;
	public DashboardPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public void clickToDynamicLink(String value) {
		waitForElementClickable(driver,BasePageUI.DYNAMIC_PAGE,value);
		clickToElement(driver, BasePageUI.DYNAMIC_PAGE, value);	
	}
}
