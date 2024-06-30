package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import commons.BaseActions;

public class PageGradesPO extends BaseActions {

	@FindBy(how = How.XPATH, using = "//label[text()='Name']/parent::div/following-sibling::div/input")	
	private WebElement nameInput;
	
	WebDriver driver;
	public PageGradesPO(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public String getName() {
		String empID = getElementAttribute(driver, nameInput, "value");
		System.out.println(empID);
		return empID;	
	}

}
