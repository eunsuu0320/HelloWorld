package com.yedam.operator;

public class OperatorExe {
	public static void main(String[] args) {
		test5();
	} // main

	// 연습 1
	public static void test() {
		// 증가, 감소 연산자 (++, --)
		byte num1 = 127; // -128 ~ 127 까지 담을 수 있다.
		num1++;
		System.out.println(num1); // 담을 수 있는 숫자를 넘어가면 증가를 해도 하나씩 줄어든다. \\

		char ch1 = 'A';
		char ch2 = 66;
		char ch3 = '가';
		System.out.println((int) ch1); // 알파벳을 숫자로 바꾸면 유니코드 나옴
		System.out.println(ch2);
		System.out.println((int) ch3);

		ch1 = 'a';
		for (int i = 1; i <= 26; i++) {
			System.out.print(ch1++);
		}

	} // test

	// 연습 2 byte, short, long, int, char
	public static void test1() {
		byte num1 = 10;
		byte num2 = 20;
		byte sum = (byte) (num1 + num2); // 정수형 연산을 하면 타입을 int로 변형 후 연산을 한다. 데이터 타입을 바꾸든, 캐스팅을 하든 해야함.
		System.out.println(sum);

		long num3 = 10000000000l; // 정수의 int 값을 넘어서는 정수에 L을 붙여서 long 데이터타입이라는 걸 알려줘야 함.
		long num4 = 100L; // long 형 리터럴값입니다 ~
		System.out.println(Long.MAX_VALUE);
	} // test1

	public static void test2() {
		int num1 = 10;
		int num2 = 20;

		int result = ++num1 + num2++;
		System.out.printf("num1 : %d, num2 : %d, result : %d\n", num1, num2, result);

		// 논리 부정 연산자
		// == 부정 != | > 부정 <= | >= 부정은 <
		boolean isTrue = true;
		if (!isTrue) {
			System.out.println("거짓입니다.");
		} // if
		result = 30;
		if (!(result >= 30)) { // 결과에 대한 논리 부정이라서 괄호 해줘야 함.
			System.out.println("result 값은 30보다 작습니다.");
		} else {
			System.out.println("result 값은 30보다 같거나 큽니다.");
		} // if

		if (!(--num1 > 10 || num2 < 20)) {
			System.out.printf("num1 : %d\n", num1);
		} // if
	} // test2

	public static void test3() {
		boolean isTrue = true;
		for (int i = 1; i <= 10; i++) {
			if (isTrue) {
				System.out.printf("i의 값은 %d\n", i);
			} // if
			isTrue = !isTrue; // 토글(on -> off, off -> on)
		}
	} // test3

	public static void test4() {
		
		
		int mon = 6;
		
		// 달력 형태로 날짜 출력
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

		// 빈 공간 만들기
		int space = getSpace(mon);
		int lastDate = getLastDate(mon);
		
		for (int i = 0; i < space; i++) {
			System.out.printf("%4s", "");
		}

		for (int i = 1; i <= lastDate; i++) {
			System.out.printf("%4d", i);
			if ((i + space) % 7 == 0) {
				System.out.println("");
			}
		}
	} // test4

	// 월 정보를 입력하면 공란 반환하는 메서드. getSpace
	public static int getSpace(int month) {
		int space = 0;
		if (month == 3) {
			space = 6;
		} else if (month == 4) {
			space = 2;
		} else if (month == 5) {
			space = 4;
		} else if (month == 7) {
			space = 2;
		}
		return space;
	} // getSpace

	// 월 정보를 입력하면 말일을 알려주는 메서드
	public static int getLastDate(int month) {
		int lastDate = 31;
		switch (month) {
		case 2:
			lastDate = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			lastDate = 30;
			break;
		}
		return lastDate;
	} // getLastDate
	
	public static void test5 () {
		String pass = "";
		int score = (int)(Math.random() * 100);
//		if (score > 60) {
//			pass = "합격";
//		} else {
//			pass = "불합격";
//		}
		pass = (score >= 60) ? (score >= 80) ? "우수" : "합격" : (score < 20) ? "불불합격" : "불합격";
		System.out.printf("%d점은 %s\n", score, pass);
	} // test5
}
