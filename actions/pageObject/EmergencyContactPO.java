package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BaseActions;

public class EmergencyContactPO extends BaseActions {
	@FindBy(how = How.XPATH, using = "//div[@class='orangehrm-attachment']//div[contains(@class,'orangehrm-vertical-padding')]/div/button")	
	private WebElement addButton;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Select File']/parent::div/following-sibling::div/input")	
	private WebElement browseButton;
	WebDriver driver;
	
	public EmergencyContactPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	public void clickToAddButton() {
		waitForElementClickable(driver, addButton);
		clickToElement(driver, addButton);
	}
	public void clickToBrowseButton(String filename) {
		uploadMultipleFiles(driver, browseButton,filename);
	}

}
