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
import pageObject.ContactDetailPO;
import pageObject.DashboardPO;
import pageObject.EmergencyContactPO;
import pageObject.EmployeeListPO;
import pageObject.JobPO;
import pageObject.JobTitlesPO;
import pageObject.LoginPO;
import pageObject.PageGeneratorManager;
import pageObject.PersonalDetailPO;
import pageObject.SalaryPO;
import pageObject.UserManagementPO;
import pageUIs.AddEmployeeUI;
import pageUIs.BasePageUI;
import reportConfig.ExtentManager;

public class Admin_01_Job_Titles extends BaseTest{
	
	private WebDriver driver;
	LoginPO loginPage;
	DashboardPO dashboardPage;
	UserManagementPO userManagementPage;
	JobTitlesPO jobTitlesPage;
	AddJobTitlePO addJobTitlePage;
	
	String fileName = "cat meme.jpg";
	String tempJobTItle, tempJobDes;
	
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
		userManagementPage.clickToJobTitles();
	}
	
	@Test
	public void Employee_01_Add_New(Method method) {
		jobTitlesPage = PageGeneratorManager.geJobTitlesPO(driver);
		jobTitlesPage.clickToAddButton();
		
		addJobTitlePage = PageGeneratorManager.geAddJobTitlePO(driver);
		addJobTitlePage.sendkeyToJobTitleInput();
		addJobTitlePage.sendkeyToJobDesInput();	
		
		tempJobTItle = addJobTitlePage.getJobTitles();
		tempJobDes = addJobTitlePage.getJobDes();

		addJobTitlePage.uploadImage(fileName);
		addJobTitlePage.clickToSaveButton();
		
		Assert.assertEquals(addJobTitlePage.isSuccessMessageVisibled(), "Successfully Saved");
		jobTitlesPage = PageGeneratorManager.geJobTitlesPO(driver);
		Assert.assertEquals(jobTitlesPage.getJobTitles(), tempJobTItle);
		Assert.assertEquals(jobTitlesPage.getJobDes(), tempJobDes);
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
	   if (driver != null) {
            driver.quit();
        }
	}
}
