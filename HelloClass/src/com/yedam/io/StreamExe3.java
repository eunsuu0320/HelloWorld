package com.yedam.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import com.yedam.Collection.Student;

/*
 * 학생(추가, 수정, 삭제, 목록) -> studentList.txt
 * add(추가: 이름, 점수 입력)
 * modify(수정: 이름, 점수 수정)
 * remove(삭제: 이름)
 * list (목록)
 * 종료 시 저장 
 */
public class StreamExe3 {

	static Scanner scn = new Scanner(System.in);
	static List<Student> studentList = new ArrayList<>();

	public static void main(String[] args) {

		try {
			init();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchElementException e) {
			// 파일 끝 부분에서 더 이상 읽을 값이 없음.

		}

		boolean run = true;

		while (run) {
			System.out.println("1.추가 2.수정 3.삭제 4.목록 5.종료");
			System.out.print("선택하세요. >> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				add();
				break;
			case 2:
				modify();
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				run = false;
				save();
				break;
			default:
				System.out.println("아몰라");
				break;
			}

		} // while
		System.out.println("프로그램이 종료되었습니다.");
	} // main

	static void add() {
		System.out.print("학생번호: ");
		String studentNo = scn.nextLine();
		System.out.print("점수: ");
		String score = scn.nextLine();

		Student student = new Student(Integer.parseInt(studentNo), Integer.parseInt(score));
		if (studentList.add(student)) {
			System.out.println("입력되었습니다.");
		}
	} // add

	// 수정
	static void modify() {
		System.out.print("학생번호: ");
		int sno = Integer.parseInt(scn.nextLine());
		System.out.print("점수: ");
		int score = Integer.parseInt(scn.nextLine());
		scn.nextLine();
		// 컬렉션에서 검색
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getStudentNo() == sno) {
				studentList.get(i).setScore(score);
				System.out.println("수정되었습니다.");
			}
		}

	}

	// 저장
	static void save() {
		// 문자 기반의 출력스트림
		try {
			Writer writer = new FileWriter("C:/temp/studentList.txt");
			for (Student student : studentList) {
				String txt = student.getStudentNo() + " " + student.getScore() + "\n";
				writer.write(txt);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	} // save

	// 초기화
	static void init() throws IOException, NoSuchElementException {
		Scanner scan = new Scanner(new File("C:/temp/studentList.txt"));
		while (true) {
			String txt = scan.nextLine();
			String[] strAry = txt.split(" ");
			// studentList 컬렉션에 추가
			studentList.add(new Student(Integer.parseInt(strAry[0]), Integer.parseInt(strAry[1])));

		}

	} // init
}
