package com.yedam.api;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ClassExe {
	public static void main(String[] args) {
		// 클래스의 애들을 불러올 수 있다. 쓰이나?
		try {
			Class cls = Class.forName("com.yedam.api.Member");
			System.out.println(cls.getName());
			// 선언된 필드.
			System.out.println("필드");
			Field[] fieldAry = cls.getDeclaredFields();
			for (Field field : fieldAry) {
				System.out.println(field.getName()); // 필드명
			}
			System.out.println();
		
			// 메소드
			System.out.println("메소드");
			Method[] methodAry = cls.getDeclaredMethods();
			for (Method method : methodAry) {
				System.out.println(method.getName()); // 메소드명
			}
			System.out.println();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
