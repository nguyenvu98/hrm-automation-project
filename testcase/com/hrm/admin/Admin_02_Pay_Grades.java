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
import pageObject.AddJobTitlePO;
import pageObject.AddPayGradePO;
import pageObject.ContactDetailPO;
import pageObject.DashboardPO;
import pageObject.EmergencyContactPO;
import pageObject.EmployeeListPO;
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

public class Admin_02_Pay_Grades extends BaseTest{
	
	private WebDriver driver;
	LoginPO loginPage;
	DashboardPO dashboardPage;
	UserManagementPO userManagementPage;
	PageGradesPO pageGradesPage;
	AddPayGradePO addPayGradePage;
	
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
		userManagementPage.clickToPayGrade();
	}
	
	@Test
	public void Employee_01_Add_New(Method method) {
		pageGradesPage = PageGeneratorManager.getPageGradesPO(driver);
		pageGradesPage.clickToAddButton();
		
		addPayGradePage = PageGeneratorManager.getAddPayGradePO(driver);
		addPayGradePage.sendkeyToNameInput();
		
		tempName = addPayGradePage.getName();

		addPayGradePage.clickToSaveButton();		
		sleepInSecond(3);

		addPayGradePage.clickToAddButton();
		sleepInSecond(1);
		
		addPayGradePage.selectConcurencyDropdown();
		addPayGradePage.sendkeyToMinimumInput();
		addPayGradePage.sendkeyToMaximunInput();
		addPayGradePage.clickToAddConcurencySaveButton();
		
		Assert.assertEquals(addPayGradePage.isSuccessMessageVisibled(), "Successfully Saved");
		pageGradesPage = PageGeneratorManager.getPageGradesPO(driver);

//		Assert.assertEquals(pageGradesPage.getName(), tempName);
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
	   if (driver != null) {
            driver.quit();
        }
	}
}
