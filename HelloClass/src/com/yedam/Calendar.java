package com.yedam;

public class Calendar {

	static boolean isLeapYear(int year) {
		// 윤년이면 true, 평년이면 false
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					return true;
				}
			} else {
				return true;
			}
		}
		return false;
	}

	public static void showMonth() {
		// Sun Mon Tue Wed Thu Fri Sat
		// ===========================
		// 1 2 3
		// 4 5 6 7 8 9 10 ......
		System.out.println("          2025년 5월         ");
		System.out.println(" ===========================");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		System.out.println(" ===========================");

		for (int i = 0; i < 4; i++) {
			System.out.printf("%4s", "");
		}

		for (int i = 1; i <= 31; i++) {
			System.out.printf("%4d", i);
			if (i % 7 == 3) {
				System.out.println("");
			}
		}
	}
}
