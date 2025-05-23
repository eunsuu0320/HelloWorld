package com.yedam.api;

import java.util.HashSet;
import java.util.Set;

public class ObjectExe {
	public static void main(String[] args) {
		// 배열[여러 건 저장] => 컬렉션(1.List 2.Set 3.Map)
		int[] ary = new int[5];
		// 확장된 for
		for (int num : ary) {
			System.out.println(num);
		}
		
		// set컬렉션은 저장 순서 없음. 중복된 값 허용 안됨.
		Set<Integer> set = new HashSet<Integer>(); // 꺽새 안에는 클래스만 올 수 있다 int 이런 ㄱ건 안댐 set => 인터페이스임 
		set.add(10);
		set.add(20);
		set.add(30);
		set.add(30);
		for (Integer num : set) {
			System.out.println(num);
		}
		
		// 선언하는 클래스. Member
		Set<Member> members = new HashSet<Member>(); // 내가 만든 클래스도 담을 수 있다.
		members.add(new Member("홍길동", 10));
		members.add(new Member("김민석", 12));
		members.add(new Member("홍길동", 10)); // 값이 같다고 해서 저장이 안 될 것 같았지만 실제로는 다 저장이 되어있다.
		for (Member mem : members) {
			System.out.println(mem.toString());
		}
		
	} // main
	
	public static void exe1 () {
		int num1 = 10;
		int num2 = 20;
		System.out.println(num1 == num2);
		
		String str1 = new String("Hello");
		String str2 = new String("World");
		System.out.println(str1.equals(str2));
		
		Member mem1 = new Member(); // 인스턴스
		mem1.memberName ="홍길동";
		mem1.age = 10;
		
		Member mem2 = new Member(); // 주소 비교.
		mem2.memberName ="홍길동";
		mem2.age = 10;
		System.out.println(mem1.equals(mem2));
	} // exe1
}
