package com.yedam;

import java.util.Arrays;
import java.util.Scanner;

public class JSExe {
	public static void main(String[] args) {
		test5();
		
//		int num1 = 30;
//		int num2 = 30;
//		
//		System.out.println(num1 == num2);
//		
//		String str1 = new String("Hello");
//		String str2 = new String("Hello");
//		
//		System.out.println(str1);
//		System.out.println(str2);
//		
//		System.out.println(str1.equals(str2));
	} // main

	
	public static void test() {
		int sum = 0;
		// 1부터 10까지의 값을 누적하는 반복문
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) {
				sum += i;
			} // if
		} // for
		System.out.println(sum);
	} // test

	
	public static void test2() {
		// 임의의 수를 생성 30 ~ 100사이의 임의의 값을 생성.
		// 평균: 173/5 => 34.6
		Math.random(); // 0 <= x < 1 | Math.random() * 10 : 0 <= x < 10

		int sum = 0;
		for (int i = 1; i <= 7; i++) {
			double result =(int) (Math.random() * 71) + 30; // 1 <= x < 101
			sum += result;
		} // for
		double avg = sum / 7.0;
		System.out.println("합 : " + sum);
		System.out.println("평균 : " + avg);
		System.out.println(Math.round(avg * 100) / 100.0); //Math.round 소숫점 반올림
		System.out.println(String.format("%.3f", avg));    //String.format %.nf n만큼 소숫점을 나타내겠다.
		
		int n = 30;
		String s = "30";
		System.out.println(Integer.parseInt(s) == n); // 문자열을 숫자로 변환해서 비교
	} // test2
	
	
	public static void test3() {
	// 사용자의 입력값을 읽어들이기.
		Scanner scn = new Scanner(System.in);
		
		int sum = 0;
		for (int i = 1; i <= 3; i++) {
			System.out.println("학생의 점수를 입력하세요.");
			String value = scn.nextLine(); // 입력값을 문자열형태로 변환.
			int score = Integer.parseInt(value);
			sum += score;
		} // for
		double avg = sum / 3.0;
		System.out.println("합 : " + sum + ", 평균 : " + avg);
		System.out.println("평균 : " + Math.round(avg * 100) / 100.0); //Math.round 소숫점 반올림
		System.out.println("평균 : " + String.format("%.3f", avg));   
	} // test3
	
	
	public static void test4 () {
		// 사용자에게서 받아온 이름들을 "친구 목록은 누구누구, 누구누구, 누구누구 입니다." 로 출력.
		Scanner scn = new Scanner(System.in);
		String name = "";
		
		while(true) {
			System.out.println("친구의 이름을 입력하세요. 종료 하려면 quit 를 입력하세요.");
			String msg = scn.nextLine();
			
			if (msg.equals("quit")) {
				System.out.println("프로그램이 종료되었습니다.");
				break;
			} // if
			
			if (name.equals("")) {
				name += "친구 목록은 " + msg;
			} else {
				name += ", " + msg;
			}
				
		} // while
		System.out.println(name + " 입니다.");
	} // test4
	
	public static void test5 () {
		//printf("형식문자열", 값1, 값2 ...)
		System.out.printf("%s", "문자"); // 뒤에 오는 문자열을 출력
		System.out.printf("%d\n", 30);    // 뒤에 오는 정수를 출력 \n는 줄바꿈
		
		// "홍길동", 100, 23.9
		System.out.printf("%s %d %.1f\n", "홍길동", 100, 23.9);
		
		// "안녕하세요 최은수입니다.
		// 나이는 20세 입니다.
		// 몸무게는 55.5 입니다.
		System.out.printf("안녕하세요 %s입니다\n 나이는 %d입니다\n 몸무게는 %.1f입니다\n", "최은수", 20, 55.5);
		
		System.out.print("문자");  // print 는 줄바꿈없이 옆에 계속 써주는거고 println은 줄바꿈을 해준다.
		System.out.print("answk");
	} // test5
}