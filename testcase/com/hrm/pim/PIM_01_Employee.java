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
import pageObject.ContactDetailPO;
import pageObject.DashboardPO;
import pageObject.EmergencyContactPO;
import pageObject.EmployeeListPO;
import pageObject.JobPO;
import pageObject.LoginPO;
import pageObject.PageGeneratorManager;
import pageObject.PersonalDetailPO;
import pageObject.SalaryPO;
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
	ContactDetailPO contactDetailPage;
	EmergencyContactPO emergencyContactPage;
	JobPO jobPage;
	SalaryPO salaryPage;
	
	String employeeID;
//	, employeeFirstname, employeeLastname;
	String fileName = "cat meme.jpg";
	
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
		String employeeFirstname = addEmployeePage.getEmployeeFirstname();
		String employeeLastname = addEmployeePage.getEmployeeLastname();
		
		addEmployeePage.clickToSaveButton();
		sleepInSecond(3);
		personalDetailPage = PageGeneratorManager.getPersonalDetailPage(driver);		
		Assert.assertEquals(personalDetailPage.getEmployeeID(), employeeID);
		
		personalDetailPage.clickToEmployeeListTopbar();
		
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);
		employeeListPage.sendkeyToEmpIDInput(employeeID);
		employeeListPage.clickToSearchButton();
		employeeListPage.clickToEditIcon();

		System.out.println(employeeFirstname+ " " + employeeLastname);
		Assert.assertEquals(employeeListPage.getFirstname(), employeeFirstname);
		Assert.assertEquals(employeeListPage.getLastname(), employeeLastname);
		
	}

	@Test
	public void Employee_02_Personal_Details(Method method) {
		personalDetailPage = PageGeneratorManager.getPersonalDetailPage(driver);
		sleepInSecond(3);
		personalDetailPage.selectLienceExDatePicker(DataContants.RANDOM_LICENSE_EXPIRED_DAY);
		personalDetailPage.selectNationality("American");
		personalDetailPage.selectMaritalStatus("Single");	
		personalDetailPage.selectDateOfBirthPicker(DataContants.RANDOM_BIRTHDAY);
		personalDetailPage.clickToSaveButton();
		sleepInSecond(3);
		
		Assert.assertEquals(personalDetailPage.isSuccessMessageVisibled(), "Successfully Updated");
		personalDetailPage.clickToContactDetailLink();
	}

	@Test
	public void Employee_03_Contact_Details() {		
		contactDetailPage = PageGeneratorManager.getContactDetailPage(driver);
		sleepInSecond(5);
		contactDetailPage.sendkeyToStreet1Input(DataContants.STREET_1);
		contactDetailPage.sendkeyToStreet2Input(DataContants.STREET_2);
		contactDetailPage.sendkeyToCityInput(DataContants.CITY);
		contactDetailPage.sendkeyToStateInput(DataContants.STATE);
		contactDetailPage.sendkeyToZIPInput(DataContants.ZIP);
		contactDetailPage.selectCountryDropdown("Angola");
		contactDetailPage.sendkeyToHomeNumberInput(DataContants.HOME_BUMBER);
		contactDetailPage.sendkeyToMobileNumberInput(DataContants.MOBILE_NUMBER);
		contactDetailPage.sendkeyToWorkNumberInput(DataContants.WORK_NUMBER);
		contactDetailPage.sendkeyToWorkEmailInput(DataContants.WORK_EMAIL);
		contactDetailPage.sendkeyToOtherEmailInput(DataContants.ORTHER_EMAIL);
		sleepInSecond(5);
		contactDetailPage.clickToSaveButton();
		Assert.assertEquals(contactDetailPage.isSuccessMessageVisibled(), "Successfully Updated");
		contactDetailPage.clickToEmergencyContactLink();
	}
	
	@Test
	public void Employee_04_Emergency_Contact() {
		emergencyContactPage = PageGeneratorManager.getEmergencyContactPO(driver);
		emergencyContactPage.clickToAddButton();
		emergencyContactPage.clickToBrowseButton(fileName);
		sleepInSecond(4);
		emergencyContactPage.clickToSaveButton();
		sleepInSecond(2);
		
		Assert.assertEquals(contactDetailPage.isSuccessMessageVisibled(), "Successfully Saved");		
	}

	@Test
	public void Employee_05_Job() {
		emergencyContactPage.clickToJobLink();
		
		jobPage = PageGeneratorManager.getJobPO(driver);
		sleepInSecond(3);
		jobPage.selectJobDropdown("Operatives");
		jobPage.clickEnableIECD();
		sleepInSecond(3);	
		
		jobPage.selectContractStartDatePicker(DataContants.RANDOM_BIRTHDAY);
		jobPage.selectContractEndDatePicker(DataContants.RANDOM_LICENSE_EXPIRED_DAY);
		jobPage.clickToBrowseButton(fileName);
		jobPage.clickToSaveButton();
		
		Assert.assertEquals(contactDetailPage.isSuccessMessageVisibled(), "Successfully Updated");		
		jobPage.clickToSalaryLink();

	}
	
	@Test
	public void Employee_06_Salary() {
		salaryPage = PageGeneratorManager.getSalaryPO(driver);
		salaryPage.clickToAddButton();
		sleepInSecond(2);
		
		salaryPage.sendkeyToSalaryComponentInput(DataContants.randomNumber());
		salaryPage.selectPayGradeDropdown("abc");
		sleepInSecond(1);
		salaryPage.selectPayFrequencyDropdown("Monthly");
		salaryPage.sendkeyToAmountInput(DataContants.randomNumber());
		salaryPage.clickEnableIDDD();
		salaryPage.sendkeyToAccountNumberInput(DataContants.randomNumber());
		salaryPage.selectPayGradeDropdown("Checking");
		salaryPage.sendkeyToRountingNumberInput(DataContants.randomNumber());
		salaryPage.sendkeyToAmountInput(DataContants.randomNumber());

		salaryPage.clickToSaveButton();		
		Assert.assertEquals(contactDetailPage.isSuccessMessageVisibled(), "Successfully Updated");		
	}

//	@Test
//	public void Employee_07_Report_To() {
//		
//	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
	   if (driver != null) {
            driver.quit();
        }
	}
}
