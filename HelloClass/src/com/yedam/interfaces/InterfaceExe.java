package com.yedam.interfaces;

public class InterfaceExe {
	public static void main(String[] args) {
		final int num = 10; // 상수.
		
		// 인터페이스의 변수에 구현클래스의 인스턴스를 할당.
		RemoteControl rc = new Television();
		rc.turnOn();
		rc.turnOff();
		
		RemoteControl rc1 = new Radio();
		rc1.turnOn();
		rc1.turnOff();
	}
}
