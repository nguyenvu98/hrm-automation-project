package commons;

public class DataContants {

	public static final String USERNAME = "automationfc";
	public static final String PASSWORD = "Nguyenvu@988";
	public static final String FIRSTNAME = "Eren";
	public static final String MIDNAME = "Mikasa";
	public static final String LASTNAME = "Armin";
	public static final String EMP_ID = ascendingNumber();

	
	protected static String ascendingNumber() {
		String temp = null;
        int[] numbers = new int[999];
		for (int i = 1; i < numbers.length; i++) {
			temp = String.format("%04d", i);
			break;
		}
		return temp ;
	}
}
