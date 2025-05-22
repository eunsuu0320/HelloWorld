package com.yedam.api;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*
 * Calendar : 날짜, 시간 관련.
 * Date : 날짜, 시간, 요일 
 */
public class CalendarExe {
	public static void main(String[] args) {
		makeCalendar(2025, 5);
	} // main

	// 달력 만드는 메소드
	public static void makeCalendar(int year, int month) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, 1);

		int space = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		int lastDate = calendar.getActualMaximum(Calendar.DATE);

		System.out.printf("          %d년 %d월     \n", year, month);
		System.out.println(" ===========================");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		System.out.println(" ===========================");

		for (int i = 1; i <= space; i++) {
			System.out.printf("%4s", "");
		}

		for (int i = 1; i <= lastDate; i++) {
			System.out.printf("%4d", i);
			if ((i + space) % 7 == 0) {
				System.out.println("");
			}
		}
	} // makeCalendar

	public static void date() {
		Date today = new Date();
		System.out.println(today.toString());

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 생성자의 매개값으로 포맷을 정하는 거 ㅋ

		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초");
		String timeStr = sdf1.format(today);
		System.out.println(timeStr);

		try {
			today = sdf.parse("2025-08-01 09:00:00"); // String -> Date
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(today);
	} // date

	public static void cal() {
		// Calendar 클래스
		Calendar now = Calendar.getInstance();

		// 시간 변경
		now.set(2025, 0, 1);
		now.set(Calendar.YEAR, 2024);

		// 요일
		int dayOfWeek = now.get(Calendar.DAY_OF_WEEK);
		switch (dayOfWeek) {
		case 1:
			System.out.println("일요일");
			break;
		case 2:
			System.out.println("월요일");
			break;
		case 3:
			System.out.println("화요일");
			break;
		case 4:
			System.out.println("수요일");
			break;
		case 5:
			System.out.println("목요일");
			break;
		case 6:
			System.out.println("금요일");
			break;
		case 7:
			System.out.println("토요일");
			break;
		default:
			break;
		}

		System.out.printf("%d년", now.get(Calendar.YEAR));
		System.out.printf(" %d월", now.get(Calendar.MONTH));
		System.out.printf(" %d일", now.get(Calendar.DATE));
		System.out.printf(" %d요일", now.get(Calendar.DAY_OF_WEEK)); // 오늘 기준으로 목요일이라 5 일요일부터 1 ~ 7
		System.out.printf(" 마지막: %d", now.getActualMaximum(Calendar.DATE)); // 이번 달의 마지막 날짜
	} // cal
}
