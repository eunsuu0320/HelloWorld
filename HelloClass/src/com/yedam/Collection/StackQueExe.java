package com.yedam.Collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueExe {
	public static void main(String[] args) {
		// FirstInFirstOut 구조
		Queue<String> orders = new LinkedList<String>();
		orders.offer("카페라떼");
		orders.offer("아이스 아메리카노");
		orders.offer("딸기라떼");

		while (!orders.isEmpty()) {
			System.out.println(orders.poll());
		}

		System.out.println("-------------------------------");

		Stack<String> books = new Stack<String>();
		// LastInFirstOut 구조
		books.push("이것이 자바다.");
		books.push("HTML, CSS");
		books.push("자바스크립트 구조");

		while (!books.empty()) {
			System.out.println(books.pop());
		}
	}
}
