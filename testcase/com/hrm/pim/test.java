package com.hrm.pim;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class test {
	
	public static void main(String[] args) {
		randomDay1();
		randomDay2();
	}
	protected static String ascendingNumber() {
		String temp = null;
        int[] numbers = new int[999];
		for (int i = 1; i < numbers.length; i++) {
			temp = String.format("%04d", i);
			break;
		}
		System.out.println(temp);
		return temp ;
	}
	
	protected static int randomNumber() {
		int randomNumber = ThreadLocalRandom.current().nextInt(1000, 10000);
		System.out.println(randomNumber);
		return randomNumber;
	}
	
	protected static String randomDay1() {
		Random number = new Random();
		
		int ranDay = 1 + number.nextInt(28);
		int ranMonth = 1 + number.nextInt(12);
		int ranYear = 2000 + number.nextInt(99);
		
		LocalDate date = LocalDate.of(ranYear, ranMonth, ranDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(formatter);
		System.out.println("License Expired day:" + formattedDate);

        return formattedDate;		
	}
	
	protected static String randomDay2() {
		Random number = new Random();
		
		int ranDay = 1 + number.nextInt(28);
		int ranMonth = 1 + number.nextInt(12);
		int ranYear = 1900 + number.nextInt(99);
		
		LocalDate date = LocalDate.of(ranYear, ranMonth, ranDay);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = date.format(formatter);
		System.out.println("Birthday:" + formattedDate);
        return formattedDate;		
	}
}
