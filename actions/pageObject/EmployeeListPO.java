package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BaseActions;
import pageUIs.EmployeeListUI;

public class EmployeeListPO extends BaseActions {

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'header-container')]//button")
	private WebElement addButton;
	
	@FindBy(how = How.XPATH, using = "//div[text()='First (& Middle) Name']/parent::div/parent::div/following-sibling::div/div/div/div[9]/div/button[2]")
	private WebElement editButton;
	
	@FindBy(how = How.XPATH, using = "//label[text()=\"Employee Id\"]/parent::div/following-sibling::div/input")
	private WebElement empIDInput;

	@FindBy(how = How.XPATH, using = "//div[@class='oxd-form-actions']//button[@type='submit']")
	private WebElement searchButton;
	
	@FindBy(how = How.XPATH, using = "//div[text()='First (& Middle) Name']/parent::div/parent::div/following-sibling::div//div[contains(@class,'oxd-table-cell')][3]/div")
	private WebElement firstnameInput;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Last Name']/parent::div/parent::div/following-sibling::div//div[contains(@class,'oxd-table-cell')][4]/div")
	private WebElement lastnameInput;
	
	WebDriver driver;
	public EmployeeListPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);

	}
	public void clickToAddButton() {
		waitForElementClickable(driver,addButton);
		clickToElement(driver,addButton);
	}
	public void clickToeditButton(String value) {
		waitForElementClickable(driver,editButton);
		clickToElement(driver,editButton);
	}
	public void sendkeyToEmpIDInput(String value) {
		waitForElementVisible(driver, empIDInput);
		sendkeyToElement(driver, empIDInput, value);
	}
	public void clickToSearchButton() {
		waitForElementClickable(driver,searchButton);
		clickToElement(driver,searchButton);		
	}

	public String getFirstname() {
		waitForElementVisible(driver, firstnameInput);
		return getElementAttribute(driver,firstnameInput,"value");
	}
	public String getLastname() {
		waitForElementVisible(driver, lastnameInput);
		return getElementAttribute(driver,lastnameInput,"value");
	}
	public void clickToEditIcon() {
		
	}	
}
