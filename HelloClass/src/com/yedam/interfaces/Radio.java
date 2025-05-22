package com.yedam.interfaces;
/*
 * RemoteControl을 구현하는 클래스. 
 */
public class Radio implements RemoteControl {
	
	@Override
	public void turnOn() {
		System.out.println("전원을 킵니다.");
	}

	@Override
	public void turnOff() {
		System.out.println("전원을 끕니다.");
	}

}
