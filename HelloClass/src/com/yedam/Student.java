package com.yedam;

/*
 * 라이브러리 클래스.
 * */
public class Student {
	// 필드(클래스를 통해서 속성을 담아놓겠습미다)
	private int studentNo; // private : 외부에서 접근하지 못하도록 막음. 이 클래스 파일 안에서만 사용이 가능하다 ~
	private String studentName;
	private double height;
	private int engScore;
	private int mathScore;

	// 생성자(객체:instance의 초기화)
	public Student() { 
		// 매개값이 없는 생성자 => 기본 생성자 / 이 생성자가 없으면 인스턴스를 생성할 때 자바 컴파일러가 자동으로 만들어준다.
		// 컴파일러가 생성.
	}

	// 생성자를 통해 전달 받은 매개값 > sutdentNo, studentName
	// 매개값이 들어간 생성자를 만들면, 매개값이 들어간 생성자만 쓰겠다라는 말로 기본 생성자는 자동으로 만들어지지 않는다. 필요하면 내가
	// 만들어야 함.
	public Student(int studentNo, String studentName) {
		// this가 필드를 가리킴
		this.studentNo = studentNo; // 첫번째 매개값은 학생번호 할당.
		this.studentName = studentName; // 두번째 매개값은 학생이름 할당.
	}

	public Student(int studentNo, int engScore, int mathScore) {
		this.studentNo = studentNo;
		this.engScore = engScore;
		this.mathScore = mathScore;
	}

	// 메소드(기능)
	void study() {
		System.out.println("공부를 합니다.");
	}

	void introduce() {
		System.out.printf("학번은 %d이고, 이름은 %s 입니다.\n", studentNo, studentName);
	}

	// setter
	void setEngScore(int engScore) {
		if (engScore < 0 || engScore > 100) {
			return;
		}
		this.engScore = engScore;
	}

	void setMathScore(int mathScore) {
		if (mathScore < 0 || mathScore > 100) {
			return;
		}
		this.mathScore = mathScore;
	}

	// 학생의 번호
	void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	// 값을 가져올 수 있는 메소드 getter
	int getStudentNo() {
		return studentNo;
	}

	String getStudentName() {
		return studentName;
	}
	
	int getEngScore() {
		return engScore;
	}
	
	int getMathScore() {
		return mathScore;
	}
}
