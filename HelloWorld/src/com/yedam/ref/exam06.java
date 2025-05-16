package com.yedam.ref;

import java.util.Scanner;

public class exam06 {
	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scn = new Scanner(System.in);
		
		while (run) {
			System.out.println("----------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("----------------------------------------------");
			System.out.print("선택 >> ");
			
			int selectNo = Integer.parseInt(scn.nextLine());
			
			if (selectNo == 1) {
				System.out.print("학생수 >> ");
				studentNum = Integer.parseInt(scn.nextLine());
				scores = new int[studentNum];
			} else if (selectNo == 2) {
				for (int i = 0; i < studentNum; i++) {
				System.out.printf("scores[%d] > ", i);
					scores[i] = Integer.parseInt(scn.nextLine());			
				}
			} else if (selectNo == 3) {
				for (int i = 0; i < studentNum; i++) {			
					System.out.printf("scores[%d] > %d\n", i, scores[i]);
				}
			} else if (selectNo == 4) {
				int max = 0;
				double avg = 0;
				int sum = 0;
				for (int i = 0; i < scores.length; i++) {
					if (scores[i] > max) {
						max = scores[i];
					}
					sum += scores[i];
				}
				avg = (double) sum / scores.length;
				
				System.out.println("최고 점수: " + max + "점");
				System.out.println("최고 점수: " + avg + "점");
			} else if (selectNo == 5) {
				run = false;
			}
		} // while
		System.out.println("프로그램을 종료합니다.");
	} // main
}
