package com.yedam.operator;

import java.util.Scanner;

public class ScannerExe {
	public static void main(String[] args) {
		// 10만원이 넘어가면 입금이 안됨. 마이너스 금액이면 출금 못 함.
		Scanner scn = new Scanner(System.in);
		int balance = 0; // 계좌 잔액
		
		while(true) {
			System.out.println("1.입금 2.출금 3.잔액 확인 4.종료");
			int menu = Integer.parseInt(scn.nextLine());
			int money = 0;
			
			if (menu == 1) {
				System.out.print("입금할 금액을 입력하세요. >> ");
				money = Integer.parseInt(scn.nextLine());
				if (balance + money > 100000) {
					System.out.println("10만원을 초과하므로 입금할 수 없습니다.");
				} else {
					balance += money;
					System.out.println("입금 되었습니다.");
				}
				
			} else if (menu == 2) {
				System.out.print("출금할 금액을 입력하세요. >> ");
				money = Integer.parseInt(scn.nextLine());
				if (money <= 0) {
					System.out.println("출금할 수 있는 금액이 없습니다.");
				} else if (balance < money) {
					System.out.println("출금하려는 금액이 더 큽니다.");
				} else {
					balance -= money;
					System.out.println("출금이 완료되었습니다.");
				}
				
			} else if (menu == 3) {
				System.out.println("3. 잔액 확인");
				System.out.printf("현재 잔액은 %d원 입니다.\n", balance);

				
			} else if (menu == 4) {
				break;
			} else {
				System.out.println("1 ~ 4번 중에 선택하세요.");
			}
		} // while
		System.out.println("프로그램을 종료합니다.");
	} // main
}
