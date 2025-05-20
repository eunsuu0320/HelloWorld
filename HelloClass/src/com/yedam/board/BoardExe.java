package com.yedam.board;

import java.util.Scanner;

/*
 	추가 수정 삭제 목록
 */
public class BoardExe {
	// 필드
	private Board[] boards; // 데이터저장
	private Scanner scn = new Scanner(System.in);
	private int bno = 0;

	// 생성자
	public BoardExe() {
		boards = new Board[100];
		boards[0] = new Board(1, "안녕하세요", "반갑습니다", "최은수");
	}

	// 메소드
	// 실행
	public void execute() {
		boolean run = true;

		while (run) {
			System.out.println("--------------------------------------");
			System.out.println("1.추가 | 2.수정 | 3.삭제 | 4.목록 | 5.종료");
			System.out.println("--------------------------------------");
			System.out.print("선택 >> ");
			int selectNo = Integer.parseInt(scn.nextLine());

			switch (selectNo) {
			case 1: // 추가
				addBoard();
				break;

			case 2: // 수정

				break;

			case 3: // 삭제

				break;

			case 4: // 목록
				boardList();
				break;

			case 5: // 종료
				run = false;
				break;

			default:
				System.out.println("1 ~ 5번 까지의 숫자를 입력해주세요.");
			} // switch
		} // while
		System.out.println("프로그램을 종료합니다.");
	} // execute

	// 추가하는 메소드
	void addBoard() {
		System.out.print("글번호를 입력하세요. >> ");
		int no = Integer.parseInt(scn.nextLine());
		System.out.print("제목을 입력하세요. >> ");
		String title = scn.nextLine();
		System.out.print("내용을 입력하세요. >> ");
		String content = scn.nextLine();
		System.out.print("작성자를 입력하세요. >> ");
		String writer = scn.nextLine();

		Board board = new Board(no, title, content, writer);

		for (int i = 0; i < boards.length; i++) {
			if (boards[i] == null) {
				boards[i] = board;
				System.out.printf("\n추가되었습니다.\n\n");

				break;
			}
		}
	} // addBoard

	// 목록
	// 글번호, 제목, 작성자
	void boardList() {
		boolean result = false;

		System.out.printf("%3s %12s %6s\n", "글번호", "제목", "작성자");
		System.out.println("===========================");
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null) {
				boards[i].showInfo();
				result = true;
			}
		}
		
		if (!result) {
			System.out.println("등록된 글이 없습니다. 글을 등록해주세요.");
			return;
		}
		
		System.out.println("----------------------------------");
		System.out.println("상세보기: 글번호 입력 | 메뉴으로 이동(q)");
		System.out.println("----------------------------------");
		System.out.print("선택 >> ");
		String str = scn.nextLine();
		if (str.equals("q")) {
			return;
		} else {
			for (int i = 0; i < boards.length; i++) {
				if (boards[i] != null && Integer.parseInt(str) == boards[i].getBoardNo()) {
					boards[i].showAllInfo();
					break;
				}
			}
		}
	} // selectBoard
}
