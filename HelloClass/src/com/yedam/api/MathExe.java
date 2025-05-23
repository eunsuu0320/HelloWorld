package com.yedam.api;

public class MathExe {
	public static void main(String[] args) {
		// 절대값
		System.out.println(Math.abs(200));
		
		// 올림, 버림
		System.out.println(Math.ceil(12.3));
		System.out.println(Math.floor(12.3));
		System.out.println(Math.round(12.3));
		
		// 크기 비교.
		System.out.println(Math.max(Math.ceil(12.3), Math.floor(0)));
	}
}
