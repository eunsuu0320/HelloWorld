package com.yedam.ref;

import java.util.Iterator;

public class ArrayExe1 {
	public static void main(String[] args) {
		// Math.random() 활용해서 10 ~ 100 사이의 점수을 생성.
		// 학생 10명의 점수를 생성해서 학생 점수의 평균을 구하고 최고점수 구하기.
		// scoreAry 변수명
		int[] scoreAry = new int[10];
		int max = 0;
		int sum = 0;
		double avg = 0;
		
		for (int i = 0; i < scoreAry.length; i++) {
			int score = (int) (Math.random() * 91) + 10;
			scoreAry[i] = score;
			sum += scoreAry[i];
			
			if (scoreAry[i] > max) {
				max = scoreAry[i];
			}
		}
		avg = (double) sum / scoreAry.length;
		System.out.printf("학생들의 평균 점수는 %.1f점 이고, 최고 점수는 %d 입니다.", avg, max);
	} // main

	public static void good () {
		// int배열 => intAry : 10, 17, 22, 31, 55, 24
				int[] intAry = {10, 17, 22, 31, 55, 24};
				int temp = 0;
				
				// 정렬
				for (int i = 0; i < intAry.length - 1; i++) {	
					for (int j = 0; j < intAry.length - 1; j++) {
						// 큰 값 기준으로 위치 변경
						if (intAry[j] < intAry[j + 1]) {
							temp = intAry[j];
							intAry[j] = intAry[j + 1];
							intAry[j + 1] = temp;
						} // if
					} // for
				} // for
				
				// 출력
				for (int i = 0; i < intAry.length; i++) {
					System.out.printf("i: %d, 값: %d\n", i, intAry[i]);
				}
				System.out.println("---------------------------");
				
				// 합
				int sum = 0;
				for (int i = 0; i < intAry.length; i++) {
					sum += intAry[i];			
					System.out.printf("sum: %d, i: %d\n", sum, i);
				}
				System.out.println("---------------------------");
				
				// 최대값
				int max = 0;
				for (int i = 0; i < intAry.length; i++) {
					if (intAry[i] > max) {
						max = intAry[i];
					}
				}
				System.out.println("최대값: " + max);
	} // good

	public static void test() {
		while (true) {
			int num1 = (int) (Math.random() * 6) + 1;
			int num2 = (int) (Math.random() * 6) + 1;

			System.out.printf("1번째 주사위 : %d, 2번째 주사위 : %d\n", num1, num2);

			if (num1 + num2 == 5) {
				break;
			}
		}
	}

	public static void test1() {
		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if ((4 * x) + (5 * y) == 60) {
					System.out.printf("(%d, %d)\n", x, y);
				}
			}
		}
	}

	public static void test2() {
		String n = "";

		for (int i = 0; i < 4; i++) {
			n += "*";
			System.out.println(n);
		}
	}

	public static void test3() {
		String n = "";

		for (int i = 0; i < 4; i++) {
			n += "*";
			System.out.printf("%4s\n", n);
		}
	}

	public static void test4() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (j <= i) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}
}
