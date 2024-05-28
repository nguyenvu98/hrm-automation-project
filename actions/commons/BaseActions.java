package commons;

import java.util.Random;

import org.openqa.selenium.WebDriver;

public class BaseActions extends BasePage {
	WebDriver driver;
	public BaseActions(WebDriver driver) {
		this.driver = driver;
	}
	
	public static String randomNumber() {
		Random randomNumber = new Random();
		int rand_int = randomNumber.nextInt(1000000);
		return String.valueOf(rand_int);
	}
}
