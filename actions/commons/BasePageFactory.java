package commons;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageUIs.BasePageUI;
import pageObject.PageGeneratorManager;


public class BasePageFactory {
	
	
	public static BasePage getBasePage() {
		return new BasePage();
	}
	
	protected Duration Timeout = Duration.ofSeconds(50);
	
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	protected String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	protected String getCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	
	protected String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}
	
	protected void backToWeb(WebDriver driver) {
		driver.navigate().back();
	}
	
	protected void forwardToWeb(WebDriver driver) {
		driver.navigate().forward();
	}
	
	public void refreshToWeb(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	
	protected Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	protected void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
		//driver.switchTo().alert().accept();
	}
	
	protected void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
		//driver.switchTo().alert().dismiss();
	}	
	
	protected String getTextAlert(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	
	protected void sendkeyToAlert(WebDriver driver, String keyToSend) {
		waitForAlertPresence(driver).sendKeys(keyToSend);
	}
	
	protected void switchWindowByID(WebDriver driver, String windowID) {
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String id : allWindowsID) {
			if(!id.equals(windowID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}
	
	protected void switchWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String id : allWindowsID) {
			driver.switchTo().window(id);
			String currentTitle = driver.getTitle();
			if(currentTitle.equals(title)) {
				break;
			}
		}
	}
	
	protected void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindowsID = driver.getWindowHandles();
		for (String id : allWindowsID) {
			if(!id.equals(parentID)) {
				driver.switchTo().window(id);
				driver.close();
			}
			driver.switchTo().window(parentID);
		}
	}
	/////////////////////////////////////////////////////////////
	protected By getByXpath(String locatorType) {
		return By.xpath(locatorType);
	}
	
	protected By getByLocatorType(String locatorType) {
		By by = null;
		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
			by = By.id(locatorType.substring(3));
		}else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		}else if (locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		}else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		}else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
			by = By.xpath(locatorType.substring(6));
		}else {
			throw new RuntimeException("Locator is not support");
		}
		return by;
	}
	

	protected List<WebElement> getListWebElements(WebDriver driver, List<WebElement> element){
		return element;
	}
	
	protected WebElement getElement(WebDriver driver, WebElement element) {
		return element;
	}
	
	protected WebElement getWebElement(WebDriver driver, String locatorType,String...values) {
		return driver.findElement(getByLocatorType(locatorType));
	}
	
	
	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	public void clickToElement(WebDriver driver, WebElement element,String... values) {
		getElement(driver, element).click();
	}

	public void clickToElementByJS(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getElement(driver, element));
	}
	
	public void sendkeyToElement(WebDriver driver, WebElement element, String keyToSend) {
		element.clear();
		element.sendKeys(keyToSend);
	}
	
	
	public String getSelectedItem(WebDriver driver, WebElement element ) {
		Select dropdown = new Select(getElement(driver, element));
		return dropdown.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver, WebElement element) {
		Select dropdown = new Select(getElement(driver, element));
		return dropdown.isMultiple();
	}
	
	public void selectInDropdownDefault(WebDriver driver, WebElement element, String value, String...values) {
		Select dropdown = new Select(getElement(driver, element));
		dropdown.selectByVisibleText(value);
	}
	
	
	public void selectInDropdownCustom(WebDriver driver, String parentXpath, String childXpath, String expectedText) {
		getWebElement(driver, parentXpath).click();
		sleepInSecond(1);
		
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		List<WebElement> allItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocatorType(childXpath))); 
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedText)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true)", item);
				sleepInSecond(1);
				item.click();
				break;
			}
		}
	}
	
	public void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String getElementAttribute(WebDriver driver, WebElement element, String attributeName) {
		return element.getAttribute(attributeName);
	}
	
	public String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}
	
	public int getElementSize(WebDriver driver,List<WebElement> element){
		return getListWebElements(driver, element).size();
	}

	public void checkToCheckboxRadioDefault(WebDriver driver,String locatorType) {
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}
	
	public void checkToCheckboxRadioDefault(WebDriver driver,String locatorType,String...values) {
		WebElement element = getWebElement(driver, locatorType,values);
		if (!element.isSelected()) {
			element.click();
		}
	}
	
	public void uncheckToCheckboxRadioDefault(WebDriver driver,WebElement element) {
		getElement(driver, element);
		if (element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver,WebElement element) {
		return getElement(driver, element).isDisplayed();
	}
	
	
	public boolean isElementSelected(WebDriver driver,WebElement element) {
		return getElement(driver, element).isSelected();
	}
	
	
	public boolean isElementEnabled(WebDriver driver,WebElement element) {
		return getElement(driver, element).isEnabled();
	}

	
	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key) {
		Actions actions = new Actions(driver);
		actions.sendKeys(getWebElement(driver, locatorType), key).perform();
	}
	

	public void clickToElementByJS(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	
	
	protected void waitForElementVisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}

	protected void waitForElementInvisible(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	protected void waitForElementClickable(WebDriver driver, WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, Timeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable((element)));
	}

	public static BasePage getPageGeneratorObject() {
		return new BasePage();
	}
	
	public String getErrorMessage(WebDriver driver, String xpathLocator) {
		WebDriverWait exWait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement errMessage =  exWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
		String acctualResult = errMessage.getText();
		return  acctualResult;
	}
	
}
