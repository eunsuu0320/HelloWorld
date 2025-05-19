package com.yedam.ref;

import java.util.Scanner;

public class exam06 {

	static Student[] scores = null;

	public static void main(String[] args) {
		init(); // 초기 데이터 생성
		boolean run = true;
		int studentNum = 0;
		Scanner scn = new Scanner(System.in);

		while (run) {
			System.out.println("-----------------------------------------------------");
			System.out.println("1.학생수 | 2.학생이름과 점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("-----------------------------------------------------");
			System.out.print("선택 >> ");

			int selectNo = Integer.parseInt(scn.nextLine());

			if (selectNo == 2 || selectNo == 3 || selectNo == 4) {
				if (scores == null) {
					System.out.println("입력된 학생 수가 없습니다. 1번부터 진행해 주세요.");
					continue;
				}
			}

			if (selectNo == 1) {
				System.out.print("학생수 >> ");
				studentNum = Integer.parseInt(scn.nextLine());
				scores = new Student[studentNum];

			} else if (selectNo == 2) {
				for (int i = 0; i < scores.length; i++) {
					System.out.printf("scores[%d] 이름: ", i);
					String name = scn.nextLine();

					System.out.printf("scores[%d] 점수: ", i);
					int score = Integer.parseInt(scn.nextLine());

					// Double.parseDouble : 문자를 실수 타입으로 변환
					System.out.printf("scores[%d] 키: ", i);
					double height = Double.parseDouble(scn.nextLine());

					System.out.printf("scores[%d] 성별: ", i);
					String gender = scn.nextLine();
					Gender gen = Gender.MALE;
					if (gender.equals("남") || gender.equals("남자")) {
						gen = Gender.MALE;
					} else if (gender.equals("여") || gender.equals("여자")) {
						gen = Gender.FEMALE;
					}

					Student student = new Student(); // 인스턴스 생성
					student.studentName = name;
					student.score = score;
					student.height = height;
					student.gender = gen;
					scores[i] = student; // 배열에 저장

				}

			} else if (selectNo == 3) {
				// 배열의 합이 0이면 점수 입력하세요.
				if (scores[0] == null) {
					System.out.println("점수 입력이 되지 않았습니다. 점수를 입력해주세요.");
					continue;
				}

				System.out.print("남 또는 여, 공백을 입력하세요. >> ");
				String keyword = scn.nextLine();
				Gender gen = Gender.MALE;
				if (keyword.equals("남") || keyword.equals("남자") || keyword.equals("Men") || keyword.equals("M")) {
					gen = Gender.MALE;
				} else if (keyword.equals("여") || keyword.equals("여자") || keyword.equals("Women")
						|| keyword.equals("W")) {
					gen = Gender.FEMALE;
				}
				for (int i = 0; i < scores.length; i++) {
					if (keyword.equals("") || gen == scores[i].gender) {
						System.out.printf("scores[%d] 이름: %s, 점수: %d 키: %.1f, 성별: %s\n", i, scores[i].studentName,
								scores[i].score, scores[i].height, scores[i].gender);
					}
				}

			} else if (selectNo == 4) {
				if (scores[0] == null) {
					System.out.println("점수 입력이 되지 않았습니다. 점수를 입력해주세요.");
					continue;
				}

//				int max = 0;
				double avg = 0;
				int sum = 0;
				Student stuValue = new Student();

				for (int i = 0; i < scores.length; i++) {
					if (scores[i].score > stuValue.score) {
						stuValue.score = scores[i].score;
						stuValue.studentName = scores[i].studentName;
					}
					sum += scores[i].score;
				}
				avg = (double) sum / scores.length;

				System.out.printf("이름: %s, 최고 점수: %d점\n", stuValue.studentName, stuValue.score);
				System.out.println("평균 점수: " + avg + "점");

			} else if (selectNo == 5) {
				run = false;
			}
		} // while
		System.out.println("프로그램을 종료합니다.");
	} // main

	public static void init() {
		Student s1 = new Student(); // 인스턴스
		s1.studentName = "홍길동";
		s1.score = 80;
		s1.height = 178.8;
		s1.gender = Gender.MALE;

		Student s2 = new Student();
		s2.studentName = "김민규";
		s2.score = 85;
		s2.height = 182.5;
		s2.gender = Gender.MALE;

		Student s3 = new Student();
		s3.studentName = "김소라";
		s3.score = 90;
		s3.height = 166.8;
		s3.gender = Gender.FEMALE;

		// 초기 데이터
		scores = new Student[] { s1, s2, s3 };
	} // init
}
