package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import commons.BaseActions;
import pageUIs.AddEmployeeUI;

public class AddEmployeePO extends BaseActions {
	
	@FindBy(how = How.XPATH, using = "//input[@name='firstName']")
	private WebElement firstnameInput;

	@FindBy(how = How.XPATH, using = "//input[@name='lastName']")
	private WebElement lastnameInput;
	
	@FindBy(how = How.XPATH, using = "//button[text()=' Save ']")
	private WebElement saveButton;
	
	WebDriver driver;
	public AddEmployeePO(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);

	}
		
	public void sendkeyToFirstNameInput(String value) {
		waitForElementVisible(driver, firstnameInput);
		sendkeyToElement(driver, firstnameInput, value);
	}
	
	
	public void sendkeyToMiddleNameInput(String value) {
	
	}
	public void sendkeyToLastNameInput(String value) {
		
	}		
	
	public PersonalDetailPO clickToSaveButton() {
		return null;
	
	}
	
	public boolean isSaveSuccessfullyDisplay(String message) {
		return false;
	}
	
//	public PersonalDetailPO clickToSaveButton() {
//		waitForElementClickable(driver,AddEmployeeUI.SAVE_BUTTON);
//		clickToElement(driver, AddEmployeeUI.SAVE_BUTTON);
//		return PageGeneratorManager.getPersonalDetailPage(driver);
//	}
//	public boolean isSaveSuccessfullyDisplay(String message) {
//		waitForElementVisible(driver, AddEmployeeUI.DYNAMIC_SUCCESS_MESSAGE,message);
//		return isElementDisplayed(driver, AddEmployeeUI.DYNAMIC_SUCCESS_MESSAGE,message);
//	}

	
//	public void sendkeyToFirstNameInput(String value) {
//		waitForElementVisible(driver, AddEmployeeUI.FIRSTNAME_INPUT);
//		sendkeyToElement(driver, AddEmployeeUI.FIRSTNAME_INPUT, value);
//	}
//	public void sendkeyToMiddleNameInput(String value) {
//		waitForElementVisible(driver, AddEmployeeUI.MIDNAME_INPUT);
//		sendkeyToElement(driver, AddEmployeeUI.MIDNAME_INPUT, value);		
//	}
//	public void sendkeyToLastNameInput(String value) {
//		waitForElementVisible(driver, AddEmployeeUI.LASTNAME_INPUT);
//		sendkeyToElement(driver, AddEmployeeUI.LASTNAME_INPUT, value);		
//	}		
//	
//	public PersonalDetailPO clickToSaveButton() {
//		waitForElementClickable(driver,AddEmployeeUI.SAVE_BUTTON);
//		clickToElement(driver, AddEmployeeUI.SAVE_BUTTON);
//		return PageGeneratorManager.getPersonalDetailPage(driver);
//	}
//	public boolean isSaveSuccessfullyDisplay(String message) {
//		waitForElementVisible(driver, AddEmployeeUI.DYNAMIC_SUCCESS_MESSAGE,message);
//		return isElementDisplayed(driver, AddEmployeeUI.DYNAMIC_SUCCESS_MESSAGE,message);
//	}

	public String getEmployeeID() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
