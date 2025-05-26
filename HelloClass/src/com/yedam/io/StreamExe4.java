package com.yedam.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * 객체 입출력 스트림.
 * 기본타임 - 참조타입
 * int num = 10;
 * Member member = new Member();
 * 직렬화(Serialization) : 객체 -> 기본
 *  Serialization 인터페이스 구현 클래스.
 *  역직렬화
 */
class Product implements Serializable {
	String prodCode;

	public Product(String prodCode) {
		this.prodCode = prodCode;
	}
}

public class StreamExe4 {
	public static void main(String[] args) {
		
		try {
			InputStream is = new FileInputStream("C:/temp/object.db");
			ObjectInputStream ois = new ObjectInputStream(is);
			
			List<Product> list = (List<Product>) ois.readObject(); // ClassNotFoundException
			for (Product product : list) {
				System.out.println("상품코드: " + product.prodCode);
			}
			
		} catch (Exception e) { // 오류의 최상위의 대장 Exception, 이거 catch로 잡아놓으면 오류 다 잡음 ㅋ
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료");
	} // main

	static void serial() {  // 객체 -> 출력 스트림에 전달.
		List<Product> list = new ArrayList<>();
		list.add(new Product("P001"));
		list.add(new Product("P002"));

		try {
			// 기본스트림.
			OutputStream os = new FileOutputStream("C:/temp/object.db");
			// 객체 입출력 보조 스트림.
			ObjectOutputStream oos = new ObjectOutputStream(os);

			oos.writeObject(list); // 객체
			oos.close();
			os.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
