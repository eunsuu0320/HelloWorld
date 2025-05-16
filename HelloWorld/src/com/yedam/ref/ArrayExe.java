package com.yedam.ref;

import java.util.Scanner;

public class ArrayExe {
	public static void main(String[] args) {
		frinedApp();
	} // main

	public static void frinedApp() {
		Scanner scn = new Scanner(System.in);
		String[] frinedAry = new String[10];
		boolean run = true;

		while (run) {
			System.out.println("--------------------------");
			System.out.println("1.추가 2.목록 3.삭제 4.종료");
			System.out.print("번호를 선택하세요. >> ");
			int menu = Integer.parseInt(scn.nextLine());
			System.out.printf("--------------------------\n");

			switch (menu) {
			case 1: // 친구 목록 추가
				System.out.print("이름을 입력하세요. >> ");
				String name = scn.nextLine();
				// 배열에 추가
				for (int i = 0; i < frinedAry.length; i++) {
					if (frinedAry[i] == null) {
						frinedAry[i] = name;
						System.out.println("추가되었습니다.");
						break;
					} else {
						if (frinedAry[i].equals(name)) {
							System.out.print("동일한 이름이 있습니다. 추가하시겠습니까? 1.추가 2.취소 >> ");
							int yOrn = Integer.parseInt(scn.nextLine());
							if (yOrn == 2) {
								System.out.println("취소되었습니다.");
								break;
							}
						}
					}
				} // for
				break;

			case 2: // 목록
				if (frinedAry[0] != null) {
					System.out.print("현재 친구 목록은 ");
					for (int i = 0; i < frinedAry.length; i++) {
						if (frinedAry[i] != null) {
							System.out.printf(" '%s' ", frinedAry[i]);
						}
					} // for
					System.out.print("입니다.\n");
				} else if (frinedAry[0] == null) {
					System.out.println("친구 목록에 아무도 없습니다.");
				}
				break;

			case 3: // 삭제
				System.out.print("삭제할 친구의 이름을 입력하세요. >> ");
				String delName = scn.nextLine();
				boolean result = false;
				
				for (int i = 0; i < frinedAry.length; i++) {
					if (frinedAry[i] != null && frinedAry[i].equals(delName)) {
						frinedAry[i] = null;
						result = true;
						System.out.println("성공적으로 삭제되었습니다.");
						break;
					} 
				} // for
				
				//삭제 후 인덱스 당기기
				for (int j = 0; j < frinedAry.length - 1; j++) {
					if (frinedAry[j + 1] != null) {
						frinedAry[j] = frinedAry[j + 1];
						frinedAry[j + 1] = null;
					} // if
				} // for
				
				if (!result) {
					System.out.println("찾는 이름이 없습니다.");
				}
				
				break; // case 의 break

			case 4: // 종료
				run = false;
				break;
			default:
				System.out.println("1 ~ 4의 값만 입력해 주세요.");
			} // switch
		} // while
		System.out.println("프로그램을 종료합니다.");
	} // frinedApp

	// 문자열배열 추가
	public static void strAry() {
		Scanner scn = new Scanner(System.in);

		String[] stringAry = new String[10]; // 입력값을 저장

		while (true) {
			System.out.print("이름을 입력하세요. >> ");
			String name = scn.nextLine();
			if (name.equals("quit")) {
				break; // while 문 종료.
			}

			for (int i = 0; i < stringAry.length; i++) {
				// 빈공간(null) 이 체크.
				if (stringAry[i] == null) {
					stringAry[i] = name;
					System.out.println("입력되었습니다.");
					break; // 이거 안해주면 null 값에 다 채워버림.
				} // if
			} // for
		} // while

		// 입력값 출력
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null) {
				System.out.printf("%d번째 이름은 '%s' 입니다.\n", i, stringAry[i]);
			}
		}
		System.out.println("프로그램이 종료되었습니다.");

	} // strAry

	public static void deleteAry() {
		Scanner scn = new Scanner(System.in);
		String[] stringAry = new String[10]; // 입력값을 저장
		stringAry[0] = "짱구";
		stringAry[1] = "맹구";
		stringAry[2] = "철수";
		stringAry[3] = "유리";

		System.out.print("삭제할 친구의 이름을 입력하세요. >> ");
		String name = scn.nextLine();

		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null && stringAry[i].equals(name)) {
				stringAry[i] = null; // 삭제
				System.out.println("성공적으로 삭제되었습니다.");
			}
		}

		// 입력값 출력
		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null) {
				System.out.printf("%d번째 이름은 '%s' 입니다.\n", i, stringAry[i]);
			}
		}
		System.out.println("프로그램을 종료합니다.");
	} // deleteAry
}
