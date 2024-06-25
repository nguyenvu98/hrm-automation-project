package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BaseActions;

public class JobPO extends BaseActions{
	
	@FindBy(how = How.XPATH, using = "//p[contains(@class,'user-form-header-text')]/following-sibling::div/label/span")	
	private WebElement switchInput;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Job Category']/parent::div/following-sibling::div//i")	
	private WebElement jobCategoryDropdown;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Job Category']/parent::div/following-sibling::div/div/div[2]/div/span")	
	private List<WebElement> childJobCategory;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Contract Details']/parent::div/following-sibling::div/input")	
	private WebElement browseButton;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Contract Start Date']/parent::div/following-sibling::div//input")
	private WebElement contractStartDatePicker;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Contract End Date']/parent::div/following-sibling::div//input")
	private WebElement contractEndDatePicker;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Salary')]")	
	private WebElement salaryLink;
	
	WebDriver driver;
	public JobPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public void selectJobDropdown(String value) {
		selectInDropdownCustom(driver, jobCategoryDropdown, childJobCategory, value);
	}
	public void clickEnableIECD() {
		waitForElementClickable(driver, switchInput);
		clickToElement(driver, switchInput);
	}

	public void clickToBrowseButton(String fileName) {
		uploadMultipleFiles(driver, browseButton, fileName);		
	}

	public void selectContractStartDatePicker(String randomContractStartDate) {
		waitForElementVisible(driver, contractStartDatePicker);
		clearContentInElement(driver, contractStartDatePicker);
		sendkeyToElement(driver, contractStartDatePicker, randomContractStartDate);
	}

	public void selectContractEndDatePicker(String randomContractEndDate) {
		waitForElementVisible(driver, contractEndDatePicker);
		clearContentInElement(driver, contractEndDatePicker);
		sendkeyToElement(driver, contractEndDatePicker, randomContractEndDate);
	}

	public void clickToSalaryLink() {
		waitForElementClickable(driver, salaryLink);
		clickToElement(driver,salaryLink);	
	}

}
