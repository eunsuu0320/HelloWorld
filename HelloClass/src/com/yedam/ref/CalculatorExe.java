package com.yedam.ref;

// 실행클래스
public class CalculatorExe {
	public static void main(String[] args) {
		int a = 20;
		int b = 30;
		
		// sum의 기능활용.
		Calculator c1 = new Calculator(); // 인스턴스 생성
		c1.sum(a,b);  // 정적 메소드
		// 위 두 줄 코드는 static이 없을 때.
		
		// 아래는 static이 있을 때 호출 가능
//		Calculator.sum(a, b);
		
		CalculatorExe cal = new CalculatorExe();
		cal.printStar();
		
//		printStar(); printStar 메소드에 static이 붙으면 이렇게만 불러와도 사용이 가능하다.
	}
	
	// static이 없으면 인스턴스 생성을 해야만 메소드를 호출 할 수 있다.
	void printStar() { 
		System.out.println("*");
	}
}
