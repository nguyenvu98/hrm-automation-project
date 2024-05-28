package com.hrm.pim;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.DataContants;
import pageObject.LoginPO;
import pageObject.PageGeneratorManager;

public class PIM_01_Employee extends BaseTest{
	
	private WebDriver driver;
	LoginPO loginPage;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) throws Exception {
		driver = getBrowserDriver(browser);
		
		loginPage = new LoginPO(driver);
		loginPage.sendkeyToUsernameInput(DataContants.USERNAME);
		loginPage.sendkeyToPasswordInput(DataContants.PASSWORD);
		loginPage.clickToLoginButton();
	}
	
	@Test
	public void Employee_01_Add_New(Method method) {
		
	}

	@Test
	public void Employee_02_Personal_Details() {
		
	}

	@Test
	public void Employee_03_Contact_Details() {
		
	}
	
	@Test
	public void Employee_04_Emergency_Contact() {
		
	}
	
	@Test
	public void Employee_05_Dependents() {
		
	}
	
	@Test
	public void Employee_06_Immagration() {
		
	}
	
	@Test
	public void Employee_07_Job() {
		
	}
	
	@Test
	public void Employee_08_Salary() {
		
	}
	
	@Test
	public void Employee_09_Report_To() {
		
	}
	
	@Test
	public void Employee_10_Qualification() {
		
	}
	
	@Test
	public void Employee_11_Membership() {
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
