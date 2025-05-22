package com.yedam.board;

import com.yedam.Calendar;
import java.util.Scanner;

/*
 	추가(addBoard()) 
 	수정 (modifyBoard()) - 글번호로 조회하여 제목과 내용 수정
 	삭제 (removeBoard()) - 글번호
 	목록(boardList()) - 상세화면 조회
 	조회가능(글번호 -> 글반환) getBoard
 	순번부여 (nextSquence()) - 현재 글 번호 + 1
 */
public class BoardExe {
	// 필드
	private Board[] boards; // 데이터저장
	private Scanner scn = new Scanner(System.in);
	private int bno = 0;

	// 생성자
	public BoardExe() {
		boards = new Board[100];
		boards[0] = new Board(10, "안녕하세요", "ㅇ갑습니다", "최은수");
		boards[1] = new Board(11, "안녕하세ㅇ", "ㅇㅇ습니다", "최은수");
		boards[2] = new Board(12, "안녕하ㅇㅇ", "ㅇㅇㅇ니다", "최은수");
		boards[3] = new Board(13, "안녕ㅇㅇㅇ", "ㅇㅇㅇㅇ다", "최은수");
		boards[4] = new Board(14, "안ㅇㅇㅇㅇ", "ㅇㅇㅇㅇ러", "최은수");
		boards[5] = new Board(15, "ㅇㅇㅇㅇㅇ", "가나다라마", "최은수");
		boards[6] = new Board(16, "ㅇ녕하세요", "반갑습니ㅇ", "최은수");
		boards[7] = new Board(17, "ㅇㅇ하세요", "반갑습ㅇㅇ", "최은수");
		boards[8] = new Board(18, "ㅇㅇㅇ세요", "반갑ㅇㅇㅇ", "최은수");
	}

	boolean loginCheck() {
		// 3번의 기회를 날리면 프로그램 종료.
		int count = 0;
		while (true) {
			// 아이디 입력
			String userId = userMessage("아이디를 입력해주세요.");
			// 비밀번호 입력
			String password = userMessage("비밀번호를 입력해주세요.");
			UserExe.login(userId, password);
			if (!UserExe.login(userId, password)) {
				count++;
				if (count == 3) {
					System.out.println("프로그램을 종료합니다.");
					return false;
				}
				System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
				System.out.printf("%d번 틀렸습니다. 3번 틀리면 프로그램이 종료됩니다.\n\n", count);
			} else {
				System.out.printf("\n%s님, 환영합니다!\n\n", UserExe.userName(userId));
				break;
			}
		} // while
		return true;
	} // loginCheck

	// 메소드
	// 실행
	public void execute() {
		boolean run = true;

		if (!loginCheck()) {
			return;
		}
		;

		while (run) {
			System.out.println("--------------------------------------------");
			System.out.println("1.추가 | 2.수정 | 3.삭제 | 4.목록 | 5.달력 | 6.종료");
			System.out.println("--------------------------------------------");
			System.out.print("선택 >> ");

			// 문자를 숫자 변경 예외 발생,
			int selectNo = 0;
			try {
				selectNo = Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("1 ~ 5번 중에서 선택하세요.");
				continue; // 다시 반복문의 처음으로 돌아가게 하기
			}

			switch (selectNo) {
			case 1: // 추가
				addBoard();
				break;

			case 2: // 수정
				modifyBoard();
				break;

			case 3: // 삭제
				removeBoard();
				sort();
				break;

			case 4: // 목록
				boardList();
				break;
			case 5: // 달력
				Calendar.showMonth();
				break;
			case 6: // 종료
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
		int no = nextSquence();
		String title = userMessage("제목을 입력하세요.");
		String content = userMessage("내용을 입력하세요.");
		String writer = userMessage("작성자를 입력하세요.");

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
		int page = 1; // 페이지 !

		// 사용자가 q를 누를 때 까지 보여줘야 하니까 while 반복문을 사용
		while (true) {
			int start = (page - 1) * 5; // 한 페이지당 5건을 보여줄 때. | 게시글 처음 보여줄 때, 페이지가 1이니까 (1 - 1) * 5 = 0이니까 0번째부터 end의 1 *
										// 5 = 5개, 5개까지,
			int end = page * 5; // 한 페이지당 5건을 보여줄 때. | 2페이지에서는 (2 - 1) * 5 = 5, 2 * 5 = 10, 5번째부터 10번째까지의 게시글을
								// 보여주게 된다. 바로 아래 for문 참조.

			System.out.printf("%3s %12s %6s\n", "글번호", "제목", "작성자");
			System.out.println("================================");
			for (int i = start; i < end; i++) {
				if (boards[i] != null) {
					boards[i].showInfo();
					result = true;
				}
			}

			if (!result) {
				System.out.println("등록된 글이 없습니다. 글을 등록해주세요.");
				return;
			}

			System.out.println("---------------------------------------------");
			System.out.println("상세보기: 글번호 입력 | 다음페이지(n) | 메뉴으로 이동(q)");
			System.out.println("---------------------------------------------");
			System.out.print("선택 >> ");
			String str = scn.nextLine();
			if (str.equals("q")) {
				break;
			} else if (str.equals("n")) {
				page++;
			} else if (str.equals("q")) {
				page--;
			} else {
				// 목록에 없는 번호를 입력했을 때 예외 처리
				int no = 0;
				try {
					no = Integer.parseInt(str);
				} catch (NumberFormatException e) {
					System.out.printf("\n목록에 있는 글 번호를 선택하세요.\n\n");
					continue; // 다시 목록부터 보여주기
				}
				
				Board sBoard = getBoard(no);
				if (sBoard == null) {
					System.out.println("조회한 결과가 없습니다.");
					return;
				}
				sBoard.showAllInfo();
			}
		} // while
		System.out.println();
	} // boardList

	// 수정 - 글번호를 조회하여 제목과 내용 수정
	void modifyBoard() {
		int bno = userMenu("수정할 글번호를 입력하세요.");
		Board result = getBoard(bno);
		if (result == null) {
			System.out.println("조회한 결과가 없습니다.");
			return;
		}
		String title = userMessage("수정할 제목을 입력하세요.");
		String content = userMessage("수정할 내용을 입력하세요.");

		result.setTitle(title);
		result.setContent(content);
		System.out.println("수정이 완료되었습니다.");

	} // modifyBoard

	// 삭제
	void removeBoard() {
		int bno = userMenu("삭제할 글번호를 입력하세요.");
		Board result = getBoard(bno);
		if (result == null) {
			System.out.println("조회한 결과가 없습니다.");
			return;
		}
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bno) {
				boards[i] = null;
				System.out.printf("\n삭제하였습니다.\n\n");
			}
		}
	} // removeBoard

	// 단건조회(getBoard)
	// 글 번호를 활용해서 배열에서 조회하고 board 반환.
	Board getBoard(int bno) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bno) {
				return boards[i];
			}
		}
		return null; // 조건에 맞는 글 번호 없으면 null 반환.
	} // getBoard

	// 사용자 입력값을 반환
	String userMessage(String msg) {
		System.out.print(msg + " >> ");
		return scn.nextLine();
	} // userMessage

	int userMenu(String msg) {
		System.out.print(msg + " >> ");
		return Integer.parseInt(scn.nextLine());
	} // userMenu

	int nextSquence() {
		int max = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && max < boards[i].getBoardNo()) {
				max = boards[i].getBoardNo();
			}
		}
		return max + 1;
	}

	// 삭제 후 인덱스 땡기기, 글 번호도 땡기기
	void sort() {
		for (int i = 0; i < boards.length - 1; i++) {
			if (boards[i] == null && boards[i + 1] != null) {
				boards[i] = boards[i + 1];
				boards[i].setBoardNo(boards[i + 1].getBoardNo() - 1);
				boards[i + 1] = null;
			}
		}
	} // sort
}
