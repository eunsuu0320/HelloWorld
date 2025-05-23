package com.yedam.Collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExe {
	public static void main(String[] args) {
		// Set 컬렉션
		// 중복값 입력은 되나 출력 때 안 나옴.
		Set<String> set = new HashSet<String>();
		set.add("월요일");
		set.add("화요일");
		set.add("수요일");
		set.add("목요일");
		set.add("금요일");

		// 삭제
		if (set.contains("화요일")) {			
			set.remove("화요일");
		}
		System.out.println(set.remove("화요일"));
		
		// 반복
		Iterator<String> iter = set.iterator(); // 반복자 획득
		while (iter.hasNext()) {  // 반복 요소의 여부 체크 실제 애들을 빼내오는 게 아니라 순 번을 붙여서 한 번씩 가지고 올 요소가 있는지 없는치 체크. 어케 빼오는거임?
			String result = iter.next();
			System.out.println(result);
		}
	}
}
