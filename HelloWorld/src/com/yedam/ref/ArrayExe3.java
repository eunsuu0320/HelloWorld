package com.yedam.ref;

/*
 * 배열 + 기본타입: 정수, 실수
 * 배열 + 참조타입(클래스): 학생이름, 점수
 * */
public class ArrayExe3 {

	static Student[] stdAry; // 변수 선언.

	public static void main(String[] args) {
		init(); // 먼저 호출을 해줘야 아래 for문 코드에서 값을 넣어서 출력해준다.
		int sum = 0;
		double max = 0;
//		String maxName = "";
		Student maxStd = new Student(); // 값을 선언해서 여기다 담아가지고 쓰는 게 더 좋다.
		// 배열의 값 출력.
		for (int i = 0; i < stdAry.length; i++) {
			System.out.printf("이름: %s | 점수: %d\n", stdAry[i].studentName, stdAry[i].score);
			sum += stdAry[i].score;
			if (max < stdAry[i].height) {
				max = stdAry[i].height;
				
				maxStd.studentName = stdAry[i].studentName;
				maxStd.score = stdAry[i].score;
				maxStd.height = stdAry[i].height;
				maxStd.gender = stdAry[i].gender;
			}
		}
		double avg = 1.0 * sum / stdAry.length;
		String strFmt = "키 큰 학생: %s | 키: %.1f | 점수: %d | 평균: %.2f";
		System.out.printf(strFmt, maxStd.studentName, maxStd.height, maxStd.score, avg);
	} // main

	public static void init() {
		Student s1 = new Student(); // 인스턴스
		s1.studentName = "홍길동";
		s1.score = 80;
		s1.height = 170.8;
		s1.gender = Gender.MALE;

		Student s2 = new Student();
		s2.studentName = "김민규";
		s2.score = 85;
		s2.height = 182.5;
		s2.gender = Gender.MALE;

		Student s3 = new Student();
		s3.studentName = "박철민";
		s3.score = 90;
		s3.height = 176.8;
		s3.gender = Gender.MALE;

		stdAry = new Student[] { s1, s2, s3 }; // 배열에 값을 할당.
	} // init

	public static void test() {
		// 홍길동, 80
		Student s1 = new Student(); // 인스턴스 생성 | 값을 담을 수 있는 빈 공간을 만들어주는 과정. 클래스 끌어온 거라서.
		s1.studentName = "홍길동";
		s1.score = 80;

		// 김민규, 85
		Student s2 = new Student();
		s2.studentName = "김민규";
		s2.score = 85;

		// 홍길동의 점수를 90으로 변경
		s1.score = 90;

		// 학생정보를 배열에 저장.
		Student[] students = { s1, s2 };
		students[0].studentName = "홍길도";

		System.out.printf("이름: %s, 점수: %d\n", s1.studentName, s1.score);
	} // test
}
