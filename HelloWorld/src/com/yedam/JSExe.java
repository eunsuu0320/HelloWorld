package com.yedam;

public class JSExe {
	public static void main(String[] args) {
		// 임의의 수를 생성 1 ~ 10사이의 임의의 값을 생성.
		Math.random(); // 0 <= x < 1 | Math.random() * 10 : 0 <= x < 10
		int sum = 0;
		for (int i = 1; i <= 5; i++) {
			int result = (int) (Math.random() * 10) + 1; // 1 <= x < 11			
			sum += result;
		} // for
		System.out.println(sum);
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
}
