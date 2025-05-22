package com.yedam;

import java.util.Scanner;

public class ObjectExe {
	// 호출
	public static void main(String[] args) {
//		Calendar.showMonth();
		Scanner scn = new Scanner(System.in);

		int year = 0;

		while (true) {
			try {
				System.out.print("숫자를 입력하세요. >> ");
				year = Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				System.out.printf("올바른 숫자를 입력하세요.\n\n");
				continue;
			}
			if (Calendar.isLeapYear(year)) {
				System.out.printf("%d년은 윤년입니다.", year);
				break;
			} else {
				System.out.printf("%d년은 윤년이 아닙니다.", year);
				break;
			}
		}
		

	} // main
}
