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
	
	String employeeID, employeeFirstname, employeeLastname;
	
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
	
	@Test
	public void Employee_01_Add_New(Method method) {
		employeeListPage.clickToAddButton();
		
		addEmployeePage = PageGeneratorManager.getAddEmployeePage(driver);
		addEmployeePage.sendkeyToFirstNameInput(DataContants.FIRSTNAME);
		addEmployeePage.sendkeyToLastNameInput(DataContants.LASTNAME);
		addEmployeePage.sendkeyToEmpIDInput(DataContants.EMP_ID);
		
		employeeID = addEmployeePage.getEmployeeID();
		employeeFirstname = addEmployeePage.getEmployeeFirstname();
		employeeLastname = addEmployeePage.getEmployeeLastname();
		
		addEmployeePage.clickToSaveButton();
		sleepInSecond(3);
		personalDetailPage = PageGeneratorManager.getPersonalDetailPage(driver);		
		Assert.assertEquals(personalDetailPage.getEmployeeID(), employeeID);
		
		personalDetailPage.clickToEmployeeListTopbar();
		
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);
		employeeListPage.sendkeyToEmpIDInput(employeeID);
		employeeListPage.clickToSearchButton();
		
		System.out.println(employeeFirstname + employeeLastname);
		Assert.assertEquals(employeeListPage.getFirstname(), employeeFirstname);
		Assert.assertEquals(employeeListPage.getLastname(), employeeLastname);
	}

	@Test
	public void Employee_02_Personal_Details(Method method) {
		employeeListPage.clickToEditIcon();
		
		personalDetailPage = PageGeneratorManager.getPersonalDetailPage(driver);
		personalDetailPage.selectLienceExDatePicker(DataContants.RANDOM_LICENSE_EXPIRED_DAY);
		personalDetailPage.selectNationality("American");
		personalDetailPage.selectMaritalStatus("Single");	
		personalDetailPage.selectDateOfBirthPicker(DataContants.RANDOM_BIRTHDAY);
//		personalDetailPage.clickToMaleRadioButton();
		personalDetailPage.clickToSaveButton();
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
	   if (driver != null) {
            driver.quit();
        }
	}
}
