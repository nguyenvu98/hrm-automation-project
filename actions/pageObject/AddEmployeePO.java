package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
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
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'oxd-grid-2')]/div/div/div[2]/input")
	private WebElement employeeID;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'oxd-grid-2')]/div/div/div[2]/input")
	private WebElement successfullyMessage;
	
	@FindBys({
		@FindBy(how = How.XPATH, using = "//form[@class='oxd-form']/div/div"),
		@FindBy(how = How.XPATH, using = "//form[@class='oxd-form']/div/div/div")
	})
	private WebElement loadingSpinner;
	
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
	
	public void sendkeyToLastNameInput(String value) {
		waitForElementVisible(driver, lastnameInput);
		sendkeyToElement(driver, lastnameInput, value);
	}
	
	public void sendkeyToEmpIDInput(String value) {
		waitForElementVisible(driver, employeeID);
		sendkeyToElement(driver, employeeID, value);
	}	
	
	public void clickToSaveButton() {
		waitForElementClickable(driver, saveButton);
		clickToElement(driver, saveButton);	
	}
	
	public boolean isSaveSuccessfullyDisplay(String message) {
		waitForElementVisible(driver, successfullyMessage);
		return isElementDisplayed(driver, successfullyMessage);
	}

	public String getEmployeeID() {
		String empID = getElementAttribute(driver, employeeID, "value");
		System.out.println(empID);
		return empID;
	}
	public String getEmployeeFirstname() {
		String firstname = getElementAttribute(driver, firstnameInput, "value");
		return firstname;
	}
	
	public String getEmployeeLastname() {
		String lastname = getElementAttribute(driver, lastnameInput, "value");
		return lastname;
	}

	public boolean waitForLoadingSpinnerInvisible() {
		waitForElementInvisible(driver, loadingSpinner);
		return !isElementDisplayed(driver, loadingSpinner);
	}
	
	public void clearEmpField() {
		employeeID.clear();
	}
}
