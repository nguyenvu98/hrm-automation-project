package pageUIs;

public class AddEmployeeUI {

	public static final String FIRSTNAME_INPUT = "xpath=//input[@name='firstName']";
	public static final String MIDNAME_INPUT = "xpath=//input[@name='middleName']";
	public static final String LASTNAME_INPUT = "xpath=//input[@name='lastName']";
	public static final String EMP_ID_INPUT = "xpath=//label[text()='Employee Id']//parent::div//following-sibling::div//input";
	public static final String SAVE_BUTTON = "xpath=//button[text()=' Save ']";
	public static final String DYNAMIC_SUCCESS_MESSAGE = "xpath=//p[contains(@class,'oxd-toast-content-text') and text()='%s']";

}
