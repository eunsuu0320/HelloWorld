package com.yedam.api;

public class SystemExe {
	public static void main(String[] args) {

		long now = System.currentTimeMillis() / 1000; // 현재 시간을 1/1000초로 표현
		System.out.println(now);
		// 3600초 1시간 * 24 = 1일 86,400,000
		// 1747964876544 => 총 며칠인 지 계산 며칠 몇 시간 몇 분 나오는지.
		// 60 * 60 * 24 = 1일
		// 60 * 60 => 1시간
		// 60 => 1분
		// 나머지가 초.
//		now = 1747967116025L / 1000;
		
		long year = now / (60 * 60 * 24 * 365);
//		year = year / 1000;
		
		long day = now % (60 * 60 * 24 * 365);
		day = day / (60 * 60 * 24);
		
		long hour = now % (60 * 60 * 24);
		hour = hour / (60 * 60);
		
		long minute = now % (60 * 60);
		minute = minute / 60;
		
		long second = now % 60;

//		long year = now / (60 * 60 * 24 * 365);
//		year = year / 1000;
//
//		long day = now % (60 * 60 * 24 * 365);
//		day = day / (60 * 60 * 24);
//		
//		long hour = now % (60 * 60 * 24);
//		hour = hour / (60 * 60);
//		
//		long minute = now % (60 * 60);
//		minute = minute / 60;
//		
//		long second = now % 60;

		System.out.printf("몇 년: %d, 며칠: %d, 몇 시간: %d, 몇 분: %d, 몇 초: %d", year, day, hour, minute, second);
	}

	public static void exe() {
		//
		long start = System.nanoTime(); // System.currentTimeMillis(); // long 타입의 현재 시간을 받아옴 근데 1970년부터 누적된 시간.
		System.out.println(start);

		int sum = 0;
		for (int i = 0; i < 100000000; i++) {
			sum += i;
		}
		long end = System.nanoTime(); // System.currentTimeMillis();
		System.out.printf("합: %d, 걸린 시간: %d\n", sum, (end - start));
	}
}
