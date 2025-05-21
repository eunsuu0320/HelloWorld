package com.yedam.inheritance;

/*
 * 부모: CellPhone
 * 	  - 전원 켜기, 끄기, 볼륩 높이기, 줄이기, 통화
 * 	  - Model, color
 * 자식: SmartPhone
 * 	  - tv 보기
 * 	  - 
 */
// 모든 클래스는 object를 상속 받고 있다. 없더라도 있는 것 처럼 안 보이는 것 뿐
public class CellPhone /* extends Object */ {
	String model;
	String color;

	// 생성자
	public CellPhone() {
		
	}
	
	public CellPhone(String model, String color) {
		this.model = model;
		this.color = color;
	}

	// 메소드
	void powerOn() {
		System.out.println("전원을 켰습니다.");
	}

	void powerOff() {
		System.out.println("전원을 껐습니다.");
	}

	void calling() {
		System.out.println("전화하기");
	}

	// toString() 오버라이딩. 필드가 가지는 값을 보고 싶으면 toString 메소드 쓰면 됨.
	// 부모 클래스에서 메소드 정리가 안 된 메소드를 자식 클래스에서 호출하면 상위 상위로 올라가지만, 부모 클래스에서 오버라이딩 해놓으면 자식
	// 클래스에서 호출하는 메소드는 부모 클래스에 있는 메소드이다.
	// toString이 부모 클래스에 정의가 되어있지 않는 상태에서 자식 클래스에서 toString을 가리키는 곳으로 가면 Object의
	// toString이 나오는데,
	// 부모 클래스에 toString을 정의내린 다음 다시 시도해보면 부모 클래스에 있는 toString을 가리킨다.
	@Override
	public String toString() {
		return "CellPhone [model=" + model + ", color=" + color + "]";
	}
}
