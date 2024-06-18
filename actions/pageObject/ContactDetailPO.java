package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BaseActions;

public class ContactDetailPO extends BaseActions {
	WebDriver driver;

	@FindBy(how = How.XPATH, using = "//ul[@class='oxd-main-menu']//span[text()='PIM']")
	private WebElement pimModul;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Country']/parent::div/following-sibling::div//i")
	private WebElement countryDropdown;

	@FindBy(how = How.XPATH, using = "//label[text()='Country']/parent::div/following-sibling::div//i//ancestor::div[contains(@class,'oxd-select-text--focus')]/following-sibling::div/div")
	private List<WebElement> childCountry;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Street 1']/parent::div/following-sibling::div/input")
	private WebElement street1;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Street 2']/parent::div/following-sibling::div/input")
	private WebElement street2;
	
	@FindBy(how = How.XPATH, using = "//label[text()='City']/parent::div/following-sibling::div/input")
	private WebElement city;
	
	@FindBy(how = How.XPATH, using = "//label[text()='State/Province']/parent::div/following-sibling::div/input")
	private WebElement state;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Zip/Postal Code']/parent::div/following-sibling::div/input")
	private WebElement zip;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Home']/parent::div/following-sibling::div/input")
	private WebElement homeNumber;

	@FindBy(how = How.XPATH, using = "//label[text()='Mobile']/parent::div/following-sibling::div/input")
	private WebElement mobileNumber;

	@FindBy(how = How.XPATH, using = "//label[text()='Work']/parent::div/following-sibling::div/input")
	private WebElement workNumber;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Work Email']/parent::div/following-sibling::div/input")
	private WebElement workEmail;

	@FindBy(how = How.XPATH, using = "//label[text()='Other Email']/parent::div/following-sibling::div/input")
	private WebElement otherEmail;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Emergency Contacts')]")
	private WebElement emergencyContactLink;
	
	@FindBy(how = How.XPATH, using = "//div[@class='oxd-form-actions']/button[@type='submit']")
	private WebElement saveButton;
	
	public ContactDetailPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	public void sendkeyToStreet1Input(String value) {
		waitForElementVisible(driver,street1);
		sendkeyToElement(driver, street1, value);
	}
	public void sendkeyToStreet2Input(String value) {
		waitForElementVisible(driver,street2);
		sendkeyToElement(driver, street2, value);		
	}
	public void sendkeyToCityInput(String value) {
		waitForElementVisible(driver,city);
		sendkeyToElement(driver, city, value);		
	}
	public void sendkeyToStateInput(String value) {
		waitForElementVisible(driver,state);
		sendkeyToElement(driver, state, value);		
	}
	public void sendkeyToZIPInput(String value) {
		waitForElementVisible(driver,zip);
		sendkeyToElement(driver, zip, value);				
	}
	public void selectCountryDropdown(String value) {
		selectInDropdownCustom(driver, countryDropdown, childCountry, value);
	}
	public void sendkeyToHomeNumberInput(String value) {
		waitForElementVisible(driver,homeNumber);
		sendkeyToElement(driver, homeNumber, value);		
	}
	public void sendkeyToMobileNumberInput(String value) {
		waitForElementVisible(driver,mobileNumber);
		sendkeyToElement(driver, mobileNumber, value);		
	}
	public void sendkeyToWorkNumberInput(String value) {
		waitForElementVisible(driver,workNumber);
		sendkeyToElement(driver, workNumber, value);		
	}
	public void sendkeyToWorkEmailInput(String value) {
		waitForElementVisible(driver,workEmail);
		sendkeyToElement(driver, workEmail, value);		
	}
	public void sendkeyToOtherEmailInput(String value) {
		waitForElementVisible(driver,otherEmail);
		sendkeyToElement(driver, otherEmail, value);		
	}
	public void clickToEmergencyContactLink() {
		waitForElementClickable(driver, emergencyContactLink);
		clickToElement(driver,emergencyContactLink);		
	}

}
