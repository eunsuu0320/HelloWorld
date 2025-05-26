package com.yedam.Collection;

public class Student {
	private int studentNo; // 1001, 1002, 1003 ... 1010;
	private int score;

	public Student(int studentNo, int score) {
		this.studentNo = studentNo;
		this.score = score;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public int getScore() {
		return score;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	
}