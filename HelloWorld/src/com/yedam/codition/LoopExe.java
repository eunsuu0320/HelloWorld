package com.yedam.codition;

import java.util.Scanner;

public class LoopExe {
	public static void main(String[] args) {
		// 가위 바위 보 1,2,3,4 - 종료
		// "you lost, you win draw
		Scanner scn = new Scanner(System.in);
		
		while (true) {
			System.out.println("1.가위 2.바위 3.보 4.종료");
			int value = Integer.parseInt(scn.nextLine());
			int com = (int) (Math.random() * 4) + 1;
			
			if (value == com) {
				System.out.printf("com: %d, 나: %d = 비겼습니다.", com, value);
			} else if (value == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} 
			if (com == 1) { // com == 가위
				if (value == 2) {
					System.out.printf("com: %d, 나: %d = 내가 이겼습니다.", com, value);
				} else if (value == 3) {
					System.out.printf("com: %d, 나: %d = 내가 졌습니다.", com, value);
				}
			} else if (com == 2) {
				if (value == 1) {
					System.out.printf("com: %d, 나: %d = 내가 졌습니다.", com, value);
				} else if (value == 3) {
					System.out.printf("com: %d, 나: %d = 내가 이겼습니다.", com, value);
				}
			} else if (com == 3) {
				if (value == 1) {
					System.out.printf("com: %d, 나: %d = 내가 이겼습니다.", com, value);
				} else if (value == 2) {
					System.out.printf("com: %d, 나: %d = 내가 졌습니다.", com, value);
				}
			}
		}
	}
}
