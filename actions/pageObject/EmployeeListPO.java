package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BaseActions;
import pageUIs.EmployeeListUI;

public class EmployeeListPO extends BaseActions {

	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'header-container')]//button")
	private WebElement addButton;
	
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

}
