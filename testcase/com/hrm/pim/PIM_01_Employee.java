package com.hrm.pim;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.DataContants;
import pageObject.AddEmployeePO;
import pageObject.DashboardPO;
import pageObject.EmployeeListPO;
import pageObject.LoginPO;
import pageObject.PageGeneratorManager;
import pageObject.PersonalDetailPO;
import pageUIs.AddEmployeeUI;
import pageUIs.BasePageUI;
import reportConfig.ExtentManager;

public class PIM_01_Employee extends BaseTest{
	
	private WebDriver driver;
	LoginPO loginPage;
	DashboardPO dashboardPage;
	EmployeeListPO employeeListPage;
	AddEmployeePO addEmployeePage;
	PersonalDetailPO personalDetailPage;
	
	String employeeID;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) throws Exception {
		driver = getBrowserDriver(browser);
		
		loginPage = new LoginPO(driver);
		loginPage.sendkeyToUsernameInput(DataContants.USERNAME);
		loginPage.sendkeyToPasswordInput(DataContants.PASSWORD);
		loginPage.clickToLoginButton();
		
		dashboardPage = PageGeneratorManager.getDashboardPage(driver);
		dashboardPage.clickToPIMModule();
		
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);

	}
	
//	@Test
	public void Employee_01_Add_New(Method method) {
		employeeListPage.clickToAddButton();
		addEmployeePage = PageGeneratorManager.getAddEmployeePage(driver);

		addEmployeePage.sendkeyToFirstNameInput(DataContants.FIRSTNAME);
		
		addEmployeePage.sendkeyToLastNameInput(DataContants.LASTNAME);

		employeeID = addEmployeePage.getEmployeeID();
		
		addEmployeePage.clickToSaveButton();
		
		Assert.assertTrue(addEmployeePage.isSaveSuccessfullyDisplay("Successfully Saved"));
				
//		verifyEquals(personalDetailPage.getFirstName(), DataContants.FIRSTNAME);		
//		verifyEquals(personalDetailPage.getLastName(), DataContants.LASTNAME);
//		verifyEquals(personalDetailPage.getEmployeeID(), employeeID);
	}

	@Test
	public void Employee_02_Personal_Details() {
		
	}

//	@Test
//	public void Employee_03_Contact_Details() {
//		
//	}
//	
//	@Test
//	public void Employee_04_Emergency_Contact() {
//		
//	}
//	
//	@Test
//	public void Employee_05_Dependents() {
//		
//	}
//	
//	@Test
//	public void Employee_06_Immagration() {
//		
//	}
//	
//	@Test
//	public void Employee_07_Job() {
//		
//	}
//	
//	@Test
//	public void Employee_08_Salary() {
//		
//	}
//	
//	@Test
//	public void Employee_09_Report_To() {
//		
//	}
//	
//	@Test
//	public void Employee_10_Qualification() {
//		
//	}
//	
//	@Test
//	public void Employee_11_Membership() {
//		
//	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		driver.quit();
	}
}
