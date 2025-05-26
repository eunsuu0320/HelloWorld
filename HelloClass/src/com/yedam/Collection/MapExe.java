package com.yedam.Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/*
 * Map 컬렉션 
 * {키(k): 값(v)} - 쌍으로 추가 가능. 엔트리 구조
 * k 값은 중복될 수 없음. k 값이 동일하면 기존 키의 v가 변경됨.
 */

// 학생 (이름, 점수)가 있는 클래스
class Student2 {
	private String studentName;
	private int score;

	// 생성자
	public Student2(String studentName, int score) {
		this.studentName = studentName;
		this.score = score;
	}
	
	// hashCode, equals -> 동등객체
	@Override
	public int hashCode() {
		return score;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student2) {
			Student2 std = (Student2) obj;
			return this.studentName.equals(std.getStudentName()) && this.score == std.getScore();
		}
		return false;
	}

	// getter
	public String getStudentName() {
		return studentName;
	}

	public int getScore() {
		return score;
	}
} // class Student

public class MapExe {
	public static void main(String[] args) {
		// 학생, 반 (key 값에 반복된 값이 들어올 수 없음)
		Map<Student2, String> map = new HashMap<Student2, String>();
		
		map.put(new Student2("짱구", 70), "1반");
		map.put(new Student2("맹구", 80), "2반");
		map.put(new Student2("철수", 95), "1반");
		map.put(new Student2("유리", 75), "2반");
		
		// 반복문.
		String keyword = "짱구";
		int score = 70;
		
		System.out.println(new Student2(keyword, score) == new Student2(keyword, score));
		
		if (map.containsKey(new Student2(keyword, score))) {
			System.out.println("반: " + map.get(new Student2(keyword, score)));
		}
//		Set<Student2> set = map.keySet();
//		Iterator<Student2> iter = set.iterator();
//		
//		while (iter.hasNext()) {
//			Student2 std = iter.next(); // 하나 하나 가져와서 변수 std 에 저장. 순번은 따로 없음. 
//			if (std.getStudentName().equals(keyword)) {
//				System.out.println("점수: " + std.getScore());
//				// 이름, score 기준으로 몇 반인지 알고 싶을 때
//				String cls = map.get(std);
//				System.out.printf("이름: %s, 점수: %d, 반: %s\n", std.getStudentName(), std.getScore(), cls);
//			}
//		}
		
	} // main

	public static void exe2() {
		// String, String>
		Map<String, String> map;
		map = new HashMap<String, String>();

		map.put("user01", "1111");
		map.put("user02", "2222");
		map.put("user03", "3333");

		Scanner scn = new Scanner(System.in);

		while (true) {
			System.out.print("아이디를 입력하세요. >> ");
			String id = scn.nextLine();

			if (map.containsKey(id)) {
				System.out.print("비밀번호를 입력하세요. >> ");
				String password = scn.nextLine();
				// 키가 존재하면 값도 체크 (일치하는 아이디가 존재하면 비밀번호 체크)
				if (map.get(id).equals(password)) { // map.get(id) -> value 반환해줌
					System.out.println("로그인 되었습니다.");
					break;
				}
				System.out.println("비밀번호가 일치하지 않습니다.");
			} else {
				System.out.println("일치하는 아이디가 없습니다.");
			}
		}

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map);
		System.out.println(json);
	}

	public static void exe() {
		// k 값은 String, V 값은 Integer <> 사이에는 어떤 클래스든 올 수 있다.
		Map<String, Integer> map = new HashMap<String, Integer>();

		// 추가
		map.put("짱구", 80);
		map.put("맹구", 70);
		map.put("짱구", 85);
		map.put("철수", 90);

		// json 추가 후 자바 객체(map) -> JSON 문자열 출력. 객체 만드는 방법 중 한 개.
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(map); // 문자열로 만들어줌
		System.out.println(json);
		System.out.println("--------------------------");

		// 삭제
//				map.remove("짱구");

		// 조회(k 값을 넣어주면 v를 반환)
		Integer score = map.get("맹구");
		score = map.get("짱구");
		System.out.println(score);

		// 반복
		Set<String> keyset = map.keySet();
		// 반복자.
		Iterator<String> iter = keyset.iterator();

		while (iter.hasNext()) { // 반복된 요소가 있는지 없는지 체크, 있으면 true, 없으면 false
			String key = iter.next(); // 반복요소 획득
			Integer value = map.get(key);
			System.out.printf("키: %s, 값: %d\n", key, value);
		}

		// {키: 값} 반환. map.Entry 타입.
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Entry<String, Integer>> iter2 = entrySet.iterator();
		while (iter2.hasNext()) {
			Entry<String, Integer> entry = iter2.next(); // next가 호출 될 때 마다 하나씩 하나씩 가져온다 뭐를..?
			System.out.printf("키: %s, 값: %d\n", entry.getKey(), entry.getValue());
		}
	}
}
