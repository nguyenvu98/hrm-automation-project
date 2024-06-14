package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BaseActions;
import pageUIs.PersonalDetailUI;

public class PersonalDetailPO extends BaseActions{
	@FindBy(how = How.XPATH, using = "//input[@name='firstName']")
	private WebElement firstnameInput;
	@FindBy(how = How.XPATH, using = "//input[@name='lastName']")
	private WebElement lastnameInput;

	WebDriver driver;	
	public PersonalDetailPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public Object getFirstName() {
		waitForElementVisible(driver, firstnameInput);
		String temp = getElementText(driver,firstnameInput);
		return temp;
	}
	public Object getLastName() {
		waitForElementVisible(driver, lastnameInput);
		String temp = getElementText(driver,lastnameInput);
		return temp;		
	}
	public Object getEmployeeID() {
		// TODO Auto-generated method stub
		return null;
	}

}
