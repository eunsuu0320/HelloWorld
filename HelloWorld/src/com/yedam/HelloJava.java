package com.yedam;

public class HelloJava {
	public static void main(String[] args) {
		// int(정수), double(실수), boolean(참과 거짓)
		int num1 = 10;
		double num2 = 20; // 자동형변환 (promotion)
		
		num1 = (int) num2;  // 강제형변환(casting)
		
		int num3 = 100;
		double num4 = 200;
		double result = (double) num3 + num4;
		System.out.println("결과는 " + result);
		
		// 20 + 30 = 50
		System.out.println("결과는 " + 20 + 30); // 문자열이 보다 뒤에 오는 숫자도 문자 타입으로 인식한다.
		System.out.println(20 + 30);
	}
}
