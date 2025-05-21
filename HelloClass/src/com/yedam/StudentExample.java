package com.yedam;
/*
 * 실행 클래스.
 * */
public class StudentExample {
	public static void main(String[] args) {
		//클래스    변수         인스턴스 생성
		Student student = new Student();  // 생성자를 통해서 인스턴스를 만들겠습니다 ~ 
//		student.studentNo = 1001;
		student.setStudentNo(1001);
//		student.studentName = "홍길동";
		student.setStudentName("홍길동");
//		student.engScore = 80;  private를 설정한 필드라서 속성값에 바로 대입하면 오류가 난다.
		student.setEngScore(80); // 메소드의 매개값으로 점수를 대입. private를 설정한 필드라서. 
//		student.mathScore = 85;
		student.setMathScore(85);
		student.study();
		student.introduce();
		
		Student student2 = new Student(1002, "김민규");
//		student.engScore = -50;
		student.setEngScore(-50);
//		student.mathScore = -80;
		student.setMathScore(-80);
		student2.study();
		student2.introduce();
		
//		student2.studentName = "박민규";
		student.setStudentName("박민규");
		student2.introduce();
		
		System.out.println("이름: " + student.getStudentName() + ", 영어점수: " + student.getEngScore() + ", 수학점수: " + student.getMathScore());
	}
}
