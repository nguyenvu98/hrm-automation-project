package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BaseActions;

public class AddJobTitlePO extends BaseActions{

	
	@FindBy(how = How.XPATH, using = "//label[text()='Job Specification']/parent::div/following-sibling::div/input")	
	private WebElement browseButton;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Job Title']/parent::div/following-sibling::div/input")	
	private WebElement jobTitleInput;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Job Description']/parent::div/following-sibling::div/textarea")	
	private WebElement jobDesInput;
	
	WebDriver driver;
	
	public AddJobTitlePO(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);	}

	public void uploadImage(String fileName) {
		uploadMultipleFiles(driver, browseButton,fileName);
	}

	public void sendkeyToJobTitleInput() {
		waitForElementVisible(driver, jobTitleInput);
		sendkeyToElement(driver, jobTitleInput, "abc"+randomNumber());
	}
	public void sendkeyToJobDesInput() {
		waitForElementVisible(driver, jobDesInput);
		sendkeyToElement(driver, jobDesInput, "abc"+randomNumber());		
	}
}
