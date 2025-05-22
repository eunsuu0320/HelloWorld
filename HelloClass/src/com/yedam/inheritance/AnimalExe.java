package com.yedam.inheritance;

public class AnimalExe {
	public static void main(String[] args) {
		// 추상클래스는 인스턴스 생성 불가능
//		Animal animal = new Animal(); => 추상클래스라서 인스턴스 생성이 불가능하다.
		
		Animal a1 = new Bird(); // 자식클래스의 인스턴스를 부모 클래스가 받아줄 수 있다. 고로 이건 가능함. 이건 자동 형 변환!!!!!!!!!!!!!
		a1.breathe();
		a1.sound();
		
		a1 = new Fish();
		a1.breathe();
		a1.sound();
		// 다형성, 똑같은 메소드를 호출하고 있지만 결과가 다를 땐 메소드의 다형성 이라고 한다. 예시로 위 breathe 와 sound 는 똑같은 메소드를 호출한 거지만 인스턴스가 누구냐에 따라서 결과가 다르기 때문에 다형성이다.
		
		
	}
}
