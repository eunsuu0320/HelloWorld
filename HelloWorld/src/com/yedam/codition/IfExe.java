package com.yedam.codition;

import java.util.Scanner;

public class IfExe {
	public static void main(String[] args) {
		//1에서 1000 사이의 임의의 값을 생성
		// 500 입력하면 입력값보다 큽니다. 틀리면 업다운 말해주기, 몇 번 만에 맞췄는지
		// 값이 같을 때 까지 계속 반복
		Scanner scn = new Scanner(System.in);
		
		int num = (int) (Math.random() * 1000) + 1;
		int count = 0;
		
		while (true) {
			System.out.print("1 ~ 1000 까지의 숫자를 입력해 주세요. >> ");
			int value = Integer.parseInt(scn.nextLine());
			if (num > value) {
				System.out.println("입력값보다 큽니다.");
				count++;
			} else if (num < value) {
				System.out.println("입력값보다 작습니다.");
				count++;
			} else if (num == value) {
				count++;
				System.out.printf("두 수가 같습니다. %d번 만에 맞췄습니다.", count);
				break;
			}
		}
	}
}
