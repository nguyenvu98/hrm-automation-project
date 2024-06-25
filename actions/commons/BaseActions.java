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
	
	@FindBy(how = How.XPATH, using = "//div[@id='oxd-toaster_1']/div/div[1]/div[2]//p[contains(@class,'oxd-text--toast-message')]")
	private WebElement successMessage;
	
	
	@FindBy(how = How.XPATH, using = "//div[@class='oxd-form-actions']/button[@type='submit']")
	private WebElement saveButton;

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
	
	
	public String isSuccessMessageVisibled() {
		waitForElementVisible(driver, successMessage);
		String message = getElementText(driver,successMessage);
		return message;
	}
	
	public void clickToSaveButton() {
		waitForElementClickable(driver, saveButton);
		clickToElement(driver, saveButton);

	}
	
	

}
