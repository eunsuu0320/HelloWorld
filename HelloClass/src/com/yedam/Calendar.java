package com.yedam;

public class Calendar {
	public static void showMonth() {
		// Sun Mon Tue Wed Thu Fri Sat
		// ===========================
		//                  1   2   3
		//  4   5   6   7   8   9  10 ......
		System.out.println("          2025년 5월         ");
		System.out.println(" ===========================");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		System.out.println(" ===========================");

		for (int i = 0; i < 4; i++) {
			System.out.printf("%4s","");
		}
		
		for (int i = 1; i <= 31; i++) {
			System.out.printf("%4d", i);
			if (i % 7 == 3) {
				System.out.println("");
			}
		}
	}
}
