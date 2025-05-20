package com.yedam;

import com.yedam.member.Member;

public class CalculatorExe {
	public static void main(String[] args) {
		Calculator cal = new Calculator(); // 객체(인스턴스) 생성
		int num1 = 10;
		String str = "༼ つ ◕_◕ ༽つ ༼ つ ◕_◕ ༽つ";
		String result = cal.printStar(num1, str); // 매개값. 값이 들어가야 하기 때문에 선언하면 당연히 ㅇ안됨
//		System.out.println(result);
		
		double sum = cal.add(num1, 10.5);
		
		int[] numAry = {10, 20, 30};
		sum = cal.add(numAry);
//		System.out.println(sum);
		
		// Member[] 중에서 point가 제일 큰 회원을 반환하는 메소드
		Member[] members = {new Member("user01", "짱구", "1111", 1000), 
							new Member("user02", "맹구", "2222", 2200), 
							new Member("user03", "철수", "3333", 2700), 
							new Member("user04", "유리", "4444", 100)};
		
		Member member = cal.getMaxPoint(members);
		member.showInfo();
	}
}
