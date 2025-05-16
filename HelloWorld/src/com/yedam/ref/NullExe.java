package com.yedam.ref;

public class NullExe {
	public static void main(String[] args) {
		String str1 = "홍길동";
		String str2 = null;
		
//		System.out.println(str2.toString());
		
		int num1 = 10;
		int[] ary = {10, 20, 30}; // 변수 선언과 초기화.
		System.out.printf("ary배열의 크기 -> %d\n", ary.length);
		
		int[] intAry;  // 변수 선언
		intAry = new int[] {40, 50, 60}; // 값 할당.
		// 첫번째 위치의 40 => 400 변경.
		intAry[0] = 400;
		
		// 인덱스 3 => 4번째 위치.
//		intAry[3] = 10; -> 4번째 위치가 없는데 값 할당 하려고 해서 오류가 남. ArrayIndexOutOfBoundsException ......
		
		// for 반복문
		for (int i = 0; i < 3; i++) {
			System.out.printf("[%d]번째의 값 : %d\n", i, intAry[i]);
		}
		System.out.println("-----------------------------------------------------");
		
		// 배열 선언 후 크기 늘리기 -> 크기 변경 하려면 새로 선언 해야함.
		intAry = new int[5];
		intAry[0] = 40;
		intAry[1] = 50;
		intAry[2] = 60;
		intAry[3] = 10;
		for (int i = 0; i < intAry.length; i++) {
			System.out.printf("intAry[%d]번째의 값 : %d\n", i, intAry[i]);
		}
		System.out.println("-----------------------------------------------------");
		
		// 배열선언: double 값을 담는 배열 dblAry
		// 10.2, 23.2, 34.5
		double[] dblAry = {10.2, 23.2, 34.5};
		for (int i = 0; i < dblAry.length; i++) {
			System.out.printf("dblAry[%d]번째의 값 : %.1f\n", i, dblAry[i]);
		}
		System.out.println("-----------------------------------------------------");
		
		// 문자열을 담는 배열
		String[] strAry = new String[10]; // {"Hello", "World"};
		for (int i = 0; i < strAry.length; i++) {
			System.out.printf("StringAry[%d]번째의 값 : %s\n", i, strAry[i]);
		}
		
	} // main
}
