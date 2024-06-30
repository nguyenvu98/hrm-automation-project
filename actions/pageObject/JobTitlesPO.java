package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BaseActions;

public class JobTitlesPO extends BaseActions{
	
	
	@FindBy(how = How.XPATH, using = "//div[@class='orangehrm-header-container']/div/button")
	private WebElement addBUtton;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Job Title']/parent::div/following-sibling::div/input")	
	private WebElement jobTitleInput;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Job Description']/parent::div/following-sibling::div/textarea")	
	private WebElement jobDesInput;

	WebDriver driver;
	public JobTitlesPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	public void clickToAddButton() {
		waitForElementClickable(driver, addBUtton);
		clickToElement(driver, addBUtton);
	}

	
}
