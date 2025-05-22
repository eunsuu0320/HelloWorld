package com.yedam.inheritance;
/*
 * 추상클래스 : 인스턴스 생성 불가, 추상메소드 
 * 자식클래스 : Bird, Fish.
 */   
       // 가상의
public abstract class Animal {
// Animal 이라는 인스턴스를 생성할 수 없다.
	String kind;
	
	public void breathe() {
		System.out.println("숨을 쉽니다.");
	}
	
	// 추상메소드 : 자식 클래스에서 반드시 재정의가 필요함. 추상메소드는 실행하는 블록이 빠짐(중괄호).
	// 기능이 구현되어 있지 않아서 규칙만 만들어주는 느낌적인 느낌 느낌
	public abstract void sound();
}
