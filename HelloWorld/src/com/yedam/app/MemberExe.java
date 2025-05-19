package com.yedam.app;

import java.util.Scanner;

import com.yedam.ref.Student;

/*
 * 회원 추가, 수정, 삭제, 조회 기능
 * 1) 추가
 *  - 아이디, 이름, 전화번호, 포인트
 *  2) 수정
 *   - 아이디
 *   - 전화번호 (바뀔항목)
 *   3) 삭제
 *   - 아이디
 *   4) 조회
 *    - 이름 (조회)
 * */
public class MemberExe {

	static Member[] memAry = null;

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		memAry = new Member[100];

		while (run) {
			System.out.println("-----------------------------------------------------");
			System.out.println("1.회원 추가 | 2.회원 수정 | 3.회원 삭제 | 4.회원 조회 | 5.종료");
			System.out.println("-----------------------------------------------------");
			System.out.print("선택 >> ");

			int selectNo = Integer.parseInt(scn.nextLine());

			if (selectNo == 1) {
				for (int i = 0; i < memAry.length; i++) {
					if (memAry[i] == null) {
						System.out.print("아이디를 입력하세요. >> ");
						String id = scn.nextLine();
						System.out.print("이름을 입력하세요. >> ");
						String name = scn.nextLine();
						System.out.print("'-'을 포함한 전화번호을 입력하세요. >> ");
						String phone = scn.nextLine();
						System.out.print("포인트을 입력하세요. >> ");
						int point = Integer.parseInt(scn.nextLine());

						Member member = new Member();
						member.id = id;
						member.name = name;
						member.phone = phone;
						member.point = point;

						memAry[i] = member;
						break;
					}
				}
				System.out.println("추가되었습니다.");

			} else if (selectNo == 2) {
				System.out.print("아이디를 입력해 주세요. >> ");
				String changeId = scn.nextLine();
				for (int i = 0; i < memAry.length; i++) {
					if (memAry[i] != null && changeId.equals(memAry[i].id)) {
						System.out.print("변경하고자 하는 전화번호를 '-' 포함하여 입력해 주세요. >> ");
						String changePhone = scn.nextLine();
						memAry[i].phone = changePhone;
						System.out.println("전화번호 변경이 완료되었습니다.");
						break;
					} else if (!changeId.equals(memAry[i].id)) {
						System.out.println("일치하는 아이디가 없습니다. 다시 시도해 주세요.");
						break;
					}
				}

			} else if (selectNo == 3) {
				boolean result = false;
				
				System.out.print("삭제하고자 하는 아이디를 입력해 주세요. >> ");
				String changeId = scn.nextLine();
				for (int i = 0; i < memAry.length; i++) {
					if (memAry[i] != null && changeId.equals(memAry[i].id)) {
						memAry[i] = null;
						System.out.println("삭제되었습니다.");
						result = true;
						break;
					}
				}
				
				if (!result) {
					System.out.println("일치하는 아이디가 없습니다. 다시 시도해 주세요.");
				}
				
				for (int i = 0; i < memAry.length - 1; i++) {
					if (memAry[i] == null) {
						memAry[i] = memAry[i + 1];
						memAry[i + 1] = null;
					}
				}

			} else if (selectNo == 4) {
				boolean result = false;
				
				System.out.print("조회할 이름을 입력해 주세요. >> ");
				String name = scn.nextLine();
				for (int i = 0; i < memAry.length; i++) {
					if (memAry[i] != null && memAry[i].id.equals(name)) {
						System.out.printf("아이디: %s | 이름: %s | 전화번호: %s | 포인트: %d\n", memAry[i].id, memAry[i].name,
								memAry[i].phone, memAry[i].point);
						result = true;
					}
				}
				if (!result) {
					System.out.println("일치하는 이름이 없습니다. 다시 시도해 주세요.");
				}
				
			} else if (selectNo == 5) {
				run = false;
			}
		} // while
		System.out.println("프로그램을 종료합니다.");
	}
}
