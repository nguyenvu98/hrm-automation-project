package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pageUIs.BasePageUI;
import pageUIs.DashboardUI;
import commons.BaseActions;

public class DashboardPO extends BaseActions {

	@FindBy(how = How.XPATH, using = "//ul[@class='oxd-main-menu']//span[text()='PIM']")
	private WebElement pimModul;
	

	@FindBy(how = How.XPATH, using = "//ul[@class='oxd-main-menu']//span[text()='Admin']")
	private WebElement adminModul;
	
	WebDriver driver;
	public DashboardPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void clickToPIMModule() {
		waitForElementVisible(driver, pimModul);
		clickToElement(driver, pimModul);
	}

	public void clickToAdminModule() {
		waitForElementVisible(driver, adminModul);
		clickToElement(driver, adminModul);		
	}

}
