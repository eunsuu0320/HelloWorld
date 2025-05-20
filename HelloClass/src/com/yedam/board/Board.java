package com.yedam.board;

//글번호, 제목, 내용, 작성자 : 필드
//getter, setter 작성 : 메소드.
//기본생성자, 전체 매개값을 다 가지는 생성자

public class Board {
	private int boardNo;
	private String title;
	private String content;
	private String writer;

	public Board() {

	}

	public Board(int boardNo, String title, String content, String writer) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	// 글번호, 제목, 작성자 => 간략하게 출력
	public void showInfo() {
		System.out.printf("%3d | %11s | %7s\n", boardNo, title, writer);
	}

	// 상세보기
	public void showAllInfo() {
		String strFormet = "글번호: %d   작성자: %s\n";
		strFormet += "제목: %s\n";
		strFormet += "내용: %s\n\n";
		System.out.printf(strFormet, boardNo, writer, title, content);
	}

}