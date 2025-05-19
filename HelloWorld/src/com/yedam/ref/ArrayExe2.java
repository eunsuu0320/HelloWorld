package com.yedam.ref;

/*
 * 2차원 배열
 * intAry[2][3]
 * */
public class ArrayExe2 {
	public static void main(String[] args) {
		int[][] intAry = { { 17, 22, 31, 55 }, { 28, 38, 12 } };
		intAry[0][2] = 44;

		for (int i = 0; i < intAry.length; i++) {
			for (int j = 0; j < intAry[i].length; j++) {
				System.out.printf("intAry[%d][%d] => %d\n", i, j, intAry[i][j]);
			}
		}
		System.out.println("----------------------------------------------");

		int[][] ary2 = new int[3][4];
		int sum1 = 0;

		for (int i = 0; i < ary2.length; i++) {
			for (int j = 0; j < ary2[i].length; j++) {
				ary2[i][j] = (int) (Math.random() * 100) + 1;
				System.out.printf("ary2[%d][%d] => %d\n", i, j, ary2[i][j]);
				// ary2[1] 인 경우에만 합
				if (i == 1) {
					sum1 += ary2[i][j];
				}
			}
		}
		System.out.printf("ary2[1]의 합: %d", sum1);
	} // main
}
