package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BaseActions;

public class EmploymentStatusPO extends BaseActions{

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Employment Status')]//ancestor::div[@class='oxd-table-header']//following-sibling::div[@class='oxd-table-body']//div[contains(@class,'oxd-table-row--with-border')]/div[2]/div[text()='abc']")	
	private WebElement nameValue;
	
	WebDriver driver;
	public EmploymentStatusPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);	
		
	}
	public String getEmploymentStatus() {
		String empID = getElementAttribute(driver, nameValue, "value");
		System.out.println(empID);
		return empID;		}

}
