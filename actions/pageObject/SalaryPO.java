package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v119.fedcm.model.Account;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BaseActions;

public class SalaryPO extends BaseActions{

	@FindBy(how = How.XPATH, using = "//h6[text()='Assigned Salary Components']/parent::div/button")	
	private WebElement addButton;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Pay Grade']/parent::div/following-sibling::div/div/div/div[2]/i")	
	private WebElement payGradeDropdown;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Pay Grade']/parent::div/following-sibling::div/div/div[2]/div/span")	
	private List<WebElement> childPayGrade;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Pay Frequency']/parent::div/following-sibling::div/div/div/div[2]/i")	
	private WebElement payFrequencyDropdown;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Pay Frequency']/parent::div/following-sibling::div/div/div[2]/div/span")	
	private List<WebElement> childPayFrequency;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Amount']/parent::div/following-sibling::div/input")	
	private WebElement amount;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Salary Component']/parent::div/following-sibling::div/input")	
	private WebElement salaryComponent;
	
	@FindBy(how = How.XPATH, using = "//p[text()='Include Direct Deposit Details']/following-sibling::div/label/span")	
	private WebElement switchInput;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Account Number']/parent::div/following-sibling::div/input")	
	private WebElement accountNumber;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Routing Number']/parent::div/following-sibling::div/input")	
	private WebElement rountingNumber;
	
	WebDriver driver;
	public SalaryPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	public void clickToAddButton() {
		waitForElementClickable(driver, addButton);
		clickToElement(driver, addButton);		
	}
	public void sendkeyToSalaryComponentInput(String value) {
		waitForElementVisible(driver,salaryComponent);
		clearContentInElement(driver,salaryComponent);
		sendkeyToElement(driver, salaryComponent, value);			
	}
	public void selectPayGradeDropdown(String value) {
		selectInDropdownCustom(driver, payGradeDropdown, childPayGrade, value);
	}
	public void selectPayFrequencyDropdown(String value) {
		selectInDropdownCustom(driver, payFrequencyDropdown, childPayFrequency, value);
	}
	public void sendkeyToAmountInput(String value) {
		waitForElementVisible(driver,amount);
		clearContentInElement(driver,amount);
		sendkeyToElement(driver, amount, value);				
	}
	public void clickEnableIDDD() {
		waitForElementClickable(driver, switchInput);
		clickToElement(driver, switchInput);		
	}
	public void sendkeyToAccountNumberInput(String value) {
		waitForElementVisible(driver,accountNumber);
		clearContentInElement(driver,accountNumber);
		sendkeyToElement(driver, accountNumber, value);		
	}
	public void sendkeyToRountingNumberInput(String value) {
		waitForElementVisible(driver,rountingNumber);
		clearContentInElement(driver,rountingNumber);
		sendkeyToElement(driver, rountingNumber, value);		
	}

}
