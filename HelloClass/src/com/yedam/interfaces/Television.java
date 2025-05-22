package com.yedam.interfaces;

/*
 * 클래스(Television)는 RemoteControl 인터페이스를 상속(x). 구현 클래스 
 */
public class Television implements RemoteControl {

	@Override
	public void turnOn() {
		System.out.println("전원을 킵니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}

}
