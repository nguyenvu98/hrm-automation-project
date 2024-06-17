package pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commons.BaseActions;
import pageUIs.PersonalDetailUI;

public class PersonalDetailPO extends BaseActions{
	@FindBy(how = How.XPATH, using = "//input[@name='firstName']")
	private WebElement firstnameInput;
	
	@FindBy(how = How.XPATH, using = "//input[@name='lastName']")
	private WebElement lastnameInput;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'oxd-grid-2')]/div/div/child::div[2]//input")
	private WebElement employeeIDInput;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Nationality']/parent::div/following-sibling::div//i")
	private WebElement nationalityDropdown;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Nationality']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span")
	private List<WebElement> childNationalItem;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Marital Status']/parent::div/following-sibling::div//i")
	private WebElement maritalDropdown;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Marital Status']/parent::div/following-sibling::div//div[@class='oxd-select-option']/span")
	private List<WebElement> childMaritalItem;
	
	@FindBy(how = How.XPATH, using = "//label[text()='License Expiry Date']/parent::div/following-sibling::div//input")
	private WebElement licenseExpireDatePicker;

	@FindBy(how = How.XPATH, using = "//label[text()='Date of Birth']/parent::div/following-sibling::div//input")
	private WebElement birthDatePicker;
	
	@FindBy(how = How.XPATH, using = "//p[text()=' * Required']/following-sibling::button")
	private WebElement saveButton;

	WebDriver driver;	
	public PersonalDetailPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public String getFirstName() {
		waitForElementVisible(driver, firstnameInput);
		String temp = getElementText(driver,firstnameInput);
		return temp;
	}
	public String getLastName() {
		waitForElementVisible(driver, lastnameInput);
		String temp = getElementText(driver,lastnameInput);
		return temp;		
	}
	public String getEmployeeID() {
		waitForElementVisible(driver, employeeIDInput);
		return getElementAttribute(driver,employeeIDInput,"value");
	}

	public void selectNationality(String value) {
		waitForElementClickable(driver, nationalityDropdown);
		nationalityDropdown.click();
		sleepInSecond(2);
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.visibilityOfAllElements(childNationalItem)); 
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(value)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}


	public void selectLienceExDate(String dateSelected) {
		// TODO Auto-generated method stub
		
	}
	
	public void selectMaritalStatus(String value) {
//		waitForElementClickable(driver, maritalDropdown);
//		selectInDropdownDefault(driver, maritalDropdown, value);		
	}


	public void selectLienceExDatePicker(String randomLienceExDay) {
		waitForElementVisible(driver, licenseExpireDatePicker);
		sendkeyToElement(driver, licenseExpireDatePicker, randomLienceExDay);
	}

	public void selectDateOfBirthPicker(String randombirthDay) {
		waitForElementVisible(driver, birthDatePicker);
		sendkeyToElement(driver, birthDatePicker, randombirthDay);		
	}

	public void clickToMaleRadioButton() {
		// TODO Auto-generated method stub
		
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver,saveButton);
		clickToElement(driver,saveButton);		
	}


}
