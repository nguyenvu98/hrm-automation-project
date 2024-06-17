package commons;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DataContants {

	public static final String USERNAME = "automationfc";
	public static final String PASSWORD = "Nguyenvu@988";
	public static final String FIRSTNAME = getRandomFirstName();
	public static final String LASTNAME = getRandomLastName();
	public static final String EMP_ID = randomNumber();
	public static final String RANDOM_BIRTHDAY = randomBirthDay();
	public static final String RANDOM_LICENSE_EXPIRED_DAY = randomLicenseExpiredDay();


	
	protected static String getRandomFirstName() {
		String[] firstname = {"Eren","Mikasa","Armin","Cristiano","Leonel","Mike","Micheal","Kobe","Benjamin","Tony"};
		Random random = new Random();
		int index = random.nextInt(firstname.length);
		return firstname[index];
	}
	
	protected static String getRandomLastName() {
		String[] firstname = {"Yeager","Jordan","Neymar","Bryan","Ronaldo","Parker","Jackson","Bale","Tèo","Simon"};
		Random random = new Random();
		int index = random.nextInt(firstname.length);
		return firstname[index];
	}
	
	protected static String randomNumber() {
		String randomNumber = String.valueOf(ThreadLocalRandom.current().nextInt(1000, 10000));
		return randomNumber;
	}
	
	protected static String randomBirthDay() {
		Random number = new Random();
		
		int ranDay = 1 + number.nextInt(28);
		int ranMonth = 1 + number.nextInt(12);
		int ranYear = 1000 + number.nextInt(99);
		
		LocalDate date = LocalDate.of(ranYear, ranMonth, ranDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(formatter);
		
        return formattedDate;		
	}
	
	protected static String randomLicenseExpiredDay() {
		Random number = new Random();
		
		int ranDay = 1 + number.nextInt(28);
		int ranMonth = 1 + number.nextInt(12);
		int ranYear = 2000 + number.nextInt(60);
		
		LocalDate date = LocalDate.of(ranYear, ranMonth, ranDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(formatter);
		
        return formattedDate;		
	}
	
}
