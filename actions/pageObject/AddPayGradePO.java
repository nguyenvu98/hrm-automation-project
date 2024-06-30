package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BaseActions;

public class AddPayGradePO extends BaseActions{

	@FindBy(how = How.XPATH, using = "//label[text()='Name']/parent::div/following-sibling::div/input")	
	private WebElement nameInput;
	
	@FindBy(how = How.XPATH, using = "//div[@class='oxd-select-wrapper']/div/div/following-sibling::div/i")	
	private WebElement concurencyDropdown;
	
	@FindBy(how = How.XPATH, using = "//div[@class='oxd-select-wrapper']/div[@class='oxd-select-dropdown --positon-bottom']/div")	
	private List<WebElement> childConcurency;
	
	@FindBy(how = How.XPATH, using = "//h6[text()='Add Currency']/following-sibling::form/div[@class='oxd-form-actions']/button[@type='submit']")
	private WebElement saveButton;


	WebDriver driver;
	public AddPayGradePO(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);	
	}
	
	public void sendkeyToNameInput() {
		waitForElementVisible(driver, nameInput);
		sendkeyToElement(driver, nameInput, "abc"+randomNumber());
	}

	public void selectConcurencyDropdown() {
		selectInDropdownCustom(driver, concurencyDropdown, childConcurency, "ANG - NL Antillian Guilder");
	}

	public void sendkeyToMinimumInput() {
		waitForElementVisible(driver, nameInput);
		sendkeyToElement(driver, nameInput, "10000");		
	}
	
	public void sendkeyToMaximunInput() {
		waitForElementVisible(driver, nameInput);
		sendkeyToElement(driver, nameInput, "10000000");		
	}

	public String getName() {
		String empID = getElementAttribute(driver, nameInput, "value");
		System.out.println(empID);
		return empID;	
		
	}

	public void clickToAddConcurencySaveButton() {
		waitForElementClickable(driver, saveButton);
		clickToElement(driver, saveButton);
	}
}
