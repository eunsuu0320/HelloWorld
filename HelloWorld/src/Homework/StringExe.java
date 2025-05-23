package Homework;

import java.util.Calendar;

public class StringExe {
	public static void main(String[] args) {
		/*
		 * 주민번호에서 생년월일 정보를 추출해서 "YYYY년 MM월 DD일" 형식으로 출력하세요.
		 * 
		 * java 복사 편집 String[] samples = { "9503061234567", "990603 2345678",
		 * "030502-3456789" };
		 * 
		 * 출력 예시: 9503061234567의 생일은 1995년 03월 06일입니다.
		 */

		String[] samples = { "9503061234567", "990603 2345678", "030502-3456789" };

		for (int i = 0; i < samples.length; i++) {
			String birth = birth(samples[i]);
			System.out.printf("%s는 %s입니다.\n", samples[i], birth);
		}
		
		System.out.println("-----------------------------------------------------------");

		/*
		 * 🧩 문제 2: 이메일 아이디 추출하기 설명: 이메일 주소가 주어졌을 때, @ 앞에 있는 사용자 아이디만 추출하세요.
		 * 
		 * String[] emails = { "apple123@gmail.com", "banana.kim@naver.com",
		 * "cherry_007@daum.net" }; 출력 예시:
		 */

		String[] emails = { "apple123@gmail.com", "banana.kim@naver.com", "cherry_007@daum.net" };

		for (int i = 0; i < emails.length; i++) {
			String email = emailSearch(emails[i]);
			System.out.printf("%s는 %s입니다.\n", emails[i], email);
		}

		System.out.println("-----------------------------------------------------------");
		/*
		 * 🔍 문제 1: 주민번호로 나이 계산하기 (출생년도 + 성별 기준) 설명: 주민등록번호를 이용해 현재 연도를 기준으로 나이를 계산하세요.
		 * (성별 자리 숫자에 따라 1900년대인지 2000년대인지 구분)
		 */

		String[] numbers = {
				  "9503061234567",
				  "030502-3456789"
				};
		
		for (int i = 0; i < numbers.length; i++) {
			String jomin = jomin(numbers[i]);
			System.out.printf("%s는 %s입니다.\n", numbers[i], jomin);
		}
	} // main
	
	public static String jomin(String jomin) {
		Calendar now = Calendar.getInstance();
		
		String year = jomin.substring(0, 2);
		
		return null;
	}

	public static String emailSearch(String email) {
		int result = email.indexOf("@");
		return email.substring(0, result);

	}

	public static String birth(String birth) {

		String year = birth.substring(0, 2);
		String month = birth.substring(2, 4);
		String day = birth.substring(4, 6);

		String last = birth.substring(birth.length() - 7, birth.length());

		if (last.charAt(0) == '1' || last.charAt(0) == '2') {
			return "19" + year + "년 " + month + "월 " + day + "일";
		}
		return "20" + year + "년 " + month + "월 " + day + "일";
	}
}
