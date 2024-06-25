package pageObject;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	
	public static LoginPO getLoginPage(WebDriver driver) {
		return new LoginPO(driver);
	}
	
	public static DashboardPO getDashboardPage(WebDriver driver) {
		return new DashboardPO(driver);
	}
	
	public static EmployeeListPO getEmployeeListPage(WebDriver driver) {
		return new EmployeeListPO(driver);
	}
	
	public static AddEmployeePO getAddEmployeePage(WebDriver driver) {
		return new AddEmployeePO(driver);
	}
	
	public static PersonalDetailPO getPersonalDetailPage(WebDriver driver) {
		return new PersonalDetailPO(driver);
	}
	
	public static ContactDetailPO getContactDetailPage(WebDriver driver) {
		return new ContactDetailPO(driver);
	}
	
	public static EmergencyContactPO getEmergencyContactPO(WebDriver driver) {
		return new EmergencyContactPO(driver);
	}
	
	public static JobPO getJobPO(WebDriver driver) {
		return new JobPO(driver);
	}
	
	public static SalaryPO getSalaryPO(WebDriver driver) {
		return new SalaryPO(driver);
	}
}
