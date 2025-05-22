package com.yedam.exception;

import java.util.Scanner;

public class ExceptionExe2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (run) {
			int menu = 0;

			while (true) { // 적절한 값을 선택할 때 까지 계속 반복 하겠다.
				try {
					System.out.println("1.메뉴 2.종료");
					System.out.print("선택 >> ");
					menu = Integer.parseInt(scn.nextLine());
				} catch (NumberFormatException e) {
					System.out.printf("메뉴를 다시 선택하세요.\n\n");
					continue; // 다시 try 구문으로 가서 다시 실행할 수 있도록 함.
				}
				break; // 예외가 발생하지 않고 정상적으로 작동함.
			}

			switch (menu) {
			case 1:
				백업();
				break;

			case 2:
				run = false;

			default:
				System.out.println("없는 번호를 선택하였습니다. 프로그램을 종료합니다.");
				run = false;
			}
		} // while
		System.out.println("프로그램이 종료되었습니다.");
		scn.close();
	} // main

	
	
	
	
	public static void 백업() {
		// NullPointerException
		// NumberFormetException
		// ClassCastException
		// ArrayIndexOutOffBoundsException

		String str = null;
//				try {			
//					System.out.println(str.toString());
//				} catch (NumberFormatException e) {     // try 구문에서 발생하는 오류를 catch 구문에 넣어줘야지만 제대로 작동한다. 여기 코드는 여전히 오류가 남.
//					System.out.println("포맷이 비정상.");
//				}
		try {
			System.out.println(str.toString());
		} catch (NullPointerException e) {
			System.out.println("null");
		}

		// try는 여러 개의 catch를 가질 수 있다. 하나의 catch 안에 여러가지의 예외를 병렬로 처리해줄 수 있다.
		try {
			System.out.println(str.toString());
			int num = Integer.parseInt("a");
		} catch (NullPointerException | NumberFormatException e) {
			System.out.println("null");
//				} catch (NumberFormatException e) {
//					System.out.println("포맷 비정상.");
		}

		Scanner scn = new Scanner(System.in); 
		// REsource leak : 'scanner' is never closed
		String strr = scn.nextLine();
		try {
			System.out.println(strr.toString());
		} catch (NullPointerException e) {
			System.out.println("null");
		} finally {
			// 정상 실행, 예외 발생 시 반드시 실행해야할 코드.
//			scn.close(); // 리소스를 환원.
		}

		System.out.println("프로그램을 종료합니다.");
	} // 백업

}