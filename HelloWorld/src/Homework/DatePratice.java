package Homework;

import java.util.Calendar;
import java.util.Scanner;

public class DatePratice {
	/*
	 * 사용자로부터 생년월일을 "YYYY-MM-DD" 형식으로 입력받고,
오늘 날짜 기준으로 만 나이를 계산해 출력하라.
	 * */
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		Calendar today = Calendar.getInstance();
		
		System.out.print("태어난 년도를 입력하세요. >> ");
		int year = Integer.parseInt(scn.nextLine());
		System.out.print("태어난 월을 입력하세요. >> ");
		int month = Integer.parseInt(scn.nextLine());
		System.out.print("태어난 일을 입력하세요. >> ");
		int day = Integer.parseInt(scn.nextLine());
	}
}
