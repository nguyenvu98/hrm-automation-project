package commons;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class BaseActions extends BasePageFactory {
	

	@FindBy(how = How.XPATH, using = "//ul//li//a[contains(text(),'Employee List')]")
	private WebElement dynamicTopbarLink;
	
	WebDriver driver;
	public BaseActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	public static String randomNumber() {
		Random randomNumber = new Random();
		int rand_int = randomNumber.nextInt(1000000);
		return String.valueOf(rand_int);
	}
	
	public void clickToEmployeeListTopbar() {
		waitForElementClickable(driver, dynamicTopbarLink);
		clickToElement(driver, dynamicTopbarLink);
	}

}
