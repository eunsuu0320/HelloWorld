package com.yedam.exception;
/*
 * 1) 일반예외 - 컴파일러가 에러부분을 파악
 * 2) 실행예외 - 실행 시점에 에러가 발생하는 경우.
 */
public class ExceptionExe {
	public static void main(String[] args) {
		
		// 실행예외 - 실행을 해봐야 오류가 뜨는 것.
		String numStr = "A";
//		int num = Integer.parseInt(numStr);
//		System.out.println(num);
		
		int num = 0;
		// 위 코드의 예외를 처리하기 위한 try
		try {
			num = Integer.parseInt(numStr);
		} catch (NumberFormatException e) {
			// 예외가 발생하면 대체할 코드
			System.out.println("예외 발생");
		}
		System.out.println(num);
		
		//Class.forName("java.util.Scanner");  일반예외
		// 예외를 처리하기 위한 try
		try {			
			Class.forName("java.util.Scanner"); 
		} catch(ClassNotFoundException e) { 
			System.out.println("일반 예외 발생");
		}
		System.out.println("프로그램이 종료되었습니다.");
	} // main
}
