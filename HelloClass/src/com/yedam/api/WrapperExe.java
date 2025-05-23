package com.yedam.api;

public class WrapperExe {
	public static void main(String[] args) {
		int num = 10; // 기본 데이터 타입
		Integer num2 = new Integer(20); // 참조 데이터 타입 (클래스)
		Integer num1 = 20; // 우리도 모르게 박싱이 발생
		
		num = num2.intValue();
		
		String str = "10";
		num = Integer.parseInt(str);
		
		double num3 = Double.parseDouble(str);
		num3 = Float.parseFloat(str);
		
		Integer num4 = 10; // 기본타입 -> 랩퍼 타입으로 변환되는 걸 박싱 이라고 함.
		Integer num5 = 10; // 참조타입 -> 기본타입 (언박싱)
		System.out.println(num4.intValue() == num5.intValue());
	}
}
