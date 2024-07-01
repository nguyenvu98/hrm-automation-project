package com.hrm.admin;

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
import pageObject.AddEmploymentStatusPO;
import pageObject.AddJobTitlePO;
import pageObject.AddPayGradePO;
import pageObject.ContactDetailPO;
import pageObject.DashboardPO;
import pageObject.EmergencyContactPO;
import pageObject.EmployeeListPO;
import pageObject.EmploymentStatusPO;
import pageObject.JobPO;
import pageObject.JobTitlesPO;
import pageObject.LoginPO;
import pageObject.PageGeneratorManager;
import pageObject.PageGradesPO;
import pageObject.PersonalDetailPO;
import pageObject.SalaryPO;
import pageObject.UserManagementPO;
import pageUIs.AddEmployeeUI;
import pageUIs.BasePageUI;
import reportConfig.ExtentManager;

public class Admin_03_Employment_Status extends BaseTest{
	
	private WebDriver driver;
	LoginPO loginPage;
	DashboardPO dashboardPage;
	UserManagementPO userManagementPage;
	EmploymentStatusPO employmentStatusPage;
	AddEmploymentStatusPO addEmploymentStatusPage;
	
	String tempName;
	
	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browser) throws Exception {
		driver = getBrowserDriver(browser);
		
		loginPage = new LoginPO(driver);
		loginPage.sendkeyToUsernameInput(DataContants.USERNAME);
		loginPage.sendkeyToPasswordInput(DataContants.PASSWORD);
		loginPage.clickToLoginButton();
		
		dashboardPage = PageGeneratorManager.getDashboardPage(driver);
		dashboardPage.clickToAdminModule();
		
		userManagementPage = PageGeneratorManager.getUserManagementPO(driver);
		userManagementPage.clickToEmploymentStatus();
	}
	
	@Test
	public void Employee_01_Add_New(Method method) {
		employmentStatusPage = PageGeneratorManager.getEmploymentStatusPO(driver);
		employmentStatusPage.clickToAddButton();
		
		addEmploymentStatusPage = PageGeneratorManager.getAddEmploymentStatusPO(driver);
		addEmploymentStatusPage.sendkeyToNameInput();
		
		tempName = addEmploymentStatusPage.getName();

		addEmploymentStatusPage.clickToSaveButton();
		
		Assert.assertEquals(addEmploymentStatusPage.isSuccessMessageVisibled(), "Successfully Saved");
		sleepInSecond(3);
		
		employmentStatusPage = PageGeneratorManager.getEmploymentStatusPO(driver);
		Assert.assertEquals(employmentStatusPage.getEmploymentStatus(), tempName);
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
	   if (driver != null) {
            driver.quit();
        }
	}
}
