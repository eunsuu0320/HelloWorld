package com.yedam.Collection;

import java.util.ArrayList;
import java.util.List;

import com.yedam.api.Member;

/*
 * 인덱스를 사용해서 객체를 관리
 * 순서를 가지고 중복된 값도 가능.
 */


public class ListExe {
	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		int number = 1001;
		int sum = 0;
		double avg = 0;
		for (int i = 0; i < 10; i++) {
			students.add(new Student(number, (int)(Math.random() * 91 + 10)));
			number++;
			sum += students.get(i).getScore();
		}
		avg = sum * 1.0 / students.size();
		System.out.printf("합: %d, 평균: %.1f", sum, avg);
	} // main

	public static void exe1() {
//		int[] ary = {10, 20, 30, 40};
		// 인터페이스 - 구현 클래스
//		ArrayList list = new ArrayList();
		// list에 여러 개의 타입이 들어가지만 나중에 쓸 때 쓰기가 많이 복잡하다 그래서 꺽새 안으로 난 이 리스트에 이 타입만 넣겠다 하는
		// 타입을 적어준다.
		// 같은 유형의 데이터만 처리하기 위함.
		List<String> list = new ArrayList<String>();
		list.add("10");
		list.add(new String("Hello"));

		// 인덱스 위치 지정 가능. 아래 코드로 하면 2번째에 20이 들어간다.
		list.add(1, "20");

		// 삭제 | 인덱스로 위치 지정
		list.remove(0);

		// 변경 | 인덱스로 위치 지정 후 변경하고자 하는 문자열 입력
		list.set(1, "World");

		// 컬렉션이기 때문에 length가 아니라 size(), list의 get을 이용해야 순차적으로 뽑혀서 출력됨 아래 코드 참조.
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		System.out.println("-------------------------------------");

		for (Object item : list) {
			System.out.println(item);
//			String result = (String) item; // Object 라서 String에 안 들어감. 그래서 캐스팅이 필요하다. 그치만 실행하면 에러가 남.
		}
	} // exe1

	public static void exe2() {
		List<Member> members = new ArrayList<>();

		Member member = new Member("짱구", 5);

		members.add(new Member("수지", 10));
		members.add(member);
		members.add(new Member("맹구", 5));

		// 삭제
//		members.remove(member);
		String search = "짱구";
		// 배열에 i를 넣었지만 list는 get안에 i 를 넣어야 for문을 돌면서 일치하는 값을 찾아올 수 있다.
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).memberName.equals(search)) {
				members.remove(i);
			}
		}

		// 출력
		for (int i = 0; i < members.size(); i++) {
			System.out.println(members.get(i).toString()); // .toString()을 Member에 오버라이딩을 해 놨으면 출력할 때 toString()을 붙이지
															// 않아도 자동으로 호출이 된다.
															// 고로 저 코드에서 toString()을 지우더라도 오버라이딩한 toString() 형태로 출력 됨.
															// toString 객체를 출력하면 자동으로 호출되는 메소드.
		}
	} // exe2
	
	public static void exe3 () {
		// 10 ~ 100점 점수를 임의의 값 10개 생성.
				// 10개의 점수의 합, 평균 출력
				List<Integer> numbers = new ArrayList<Integer>();
				int sum = 0;
				double avg = 0;

				for (int i = 0; i < 10; i++) {
					numbers.add((int) (Math.random() * 91 + 10));
					sum += numbers.get(i);
				}

				avg = sum * 1.0 / numbers.size();
				System.out.printf("합계: %d, 평균: %.1f", sum, avg);
	}
}
