package com.yedam;

import com.yedam.member.Member;

/*
 * 메소드 연습
 * 1) 메소드 선언.
 * 2) 매개변수
 * 3) 반환유형
 * */
public class Calculator {
	// 필드

	// 생성자

	// 메소드
	
	// 포인트가 제일 큰 회원을 반환하는 메소드
		Member getMaxPoint (Member[] memberAry) {
			Member max = null; // 아이디, 이름, 연락처, 포인트.
			int maxPoint = 0; // 포인트를 비교하기 위한 변수.
			for (int i = 0; i < memberAry.length; i++) {
				Member temp = memberAry[i];
				if (maxPoint < temp.getPoint()) {
					maxPoint = temp.getPoint();
					max = temp;
				}
			}
			return max;
		}
		
	String printStar (int times, String shape) { // 매개변수(times, shape)
		String str = "";
		for (int i = 1; i <= times; i++) {			
//			System.out.print(shape);
			str += shape + "\n";
		}
		return str;
	} // printStar
	
	
	// 메소드 오버로딩 : 메소드의 이름은 똑같아도 매개값이 다르다면 생성이 가능하다. 매개값의 타입, 위치, 개수가 다르면 가능.
	int add(int num1, int num2) {
		return num1 + num2;
	} // add
	
	double add(double num1, double num2) {
		return num1 + num2;
	}
	
	
	//정수 배열을 매개값으로 받는 add, 반환 유형은 double
	double add(int[] numAry) {
		double sum = 0;
		for (int i = 0; i < numAry.length; i++) {
			sum += numAry[i];
		}
		return sum;
	}
}
