package pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BaseActions;

public class UserManagementPO extends BaseActions{

	
	@FindBy(how = How.XPATH, using = "//div[@class='oxd-topbar-body']/nav/ul/li/span[contains(text(),'Job')]")
	private WebElement jobDropdown;

	
	@FindBy(how = How.XPATH, using = "//div[@class='oxd-topbar-body']/nav/ul/li/ul/li/a")
	private List<WebElement> childJobDropdown;
	
	WebDriver driver;
	
	public UserManagementPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void clickToJobTitles() {
		waitForElementClickable(driver, jobDropdown);
		selectInDropdownCustom(driver, jobDropdown, childJobDropdown,"Job Titles");

	}
	
	public void clickToPayGrade() {
		waitForElementClickable(driver, jobDropdown);
		selectInDropdownCustom(driver, jobDropdown, childJobDropdown,"Pay Grades");

	}

	public void clickToEmploymentStatus() {
		waitForElementClickable(driver, jobDropdown);
		selectInDropdownCustom(driver, jobDropdown, childJobDropdown,"Employment Status");		
	}

}
