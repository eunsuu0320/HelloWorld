package com.yedam.inheritance;
/*
 * 부모클래스: Animal(추상클래스)
 */

// 상속받는 부모클래스에 추상메소드가 있으면 상속 받을 때 부터 오류가 발생. -> 메소드를 재정의 해줘야 함.
public class Bird extends Animal {

	@Override
	public void sound() {
		// 부모 클래스의 sound() 반드시 재정의 해야함.
		System.out.println("짹짹");
	}

}
