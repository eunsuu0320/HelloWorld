package com.yedam.inheritance;

/*
 * CellPhone 을 상속. 
 */
//                       상속
public class SmartPhone extends CellPhone {
	// 필드
	int channel;

	// 생성자
	public SmartPhone() {

	}

	public SmartPhone(String model, String color, int channel) {
		super(model, color);
		this.channel = channel;
	}

	// 메소드
	void watch() {
		System.out.println("TV를 봅니다.");
	}

	// 부모 클래스의 기능을 자식 클래스에서 다시 정의할 수 있다. 오버라이딩
	@Override
	void powerOn() {
		System.out.println("✨전원을 킵니다✨");
	}

	@Override // 어노테이션. 부모 클래스에서 powerOff가 올바르게 있는지 확인해주는 친구 타입체크
	void powerOff() {
		System.out.println("✨전원을 끕니다✨");
	}

	@Override
	public String toString() {
		return "SmartPhone [channel=" + channel + "]";
	}

}
