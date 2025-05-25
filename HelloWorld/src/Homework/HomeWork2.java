package Homework;

import java.util.ArrayList;
import java.util.Scanner;

public class HomeWork2 {
	public static void main(String[] args) {
		/*
		 * 🔢 문제 1: 중복 없이 숫자 저장하기
		 * 
		 * 정수를 입력받아 ArrayList에 저장하되, 중복된 숫자는 저장하지 않는다. 5개의 고유한 숫자가 저장되면 리스트를 출력하라.
		 */

//		Scanner sc = new Scanner(System.in);
//		ArrayList<Integer> numbers = new ArrayList<>();
//
//		while (numbers.size() < 5) {
//			System.out.print("숫자 입력: ");
//			int input = sc.nextInt();
//			saveUniqueNumber(numbers, input);
//		}
//
//		System.out.println("저장된 숫자들: " + numbers);
//		sc.close();
//
//		System.out.println("-----------------------------------------------------");
		
		/*
		 * 🔁 문제 2: 문자열 뒤집기
		 * 
		 * 문자열을 계속 입력받아 ArrayList에 저장하고, "끝"이 입력되면 저장된 문자열들을 역순으로 출력하라.
		 */

		Scanner sc1 = new Scanner(System.in);
		ArrayList<String> words = new ArrayList<>();

		while (true) {
			System.out.print("문자 입력: ");
			String input = sc1.nextLine();
			if (input.equals("끝"))
				break;
			addWord(words, input);
		}

		printReverse(words);
		sc1.close();
	}
	
	

	public static void addWord(ArrayList<String> list, String word) {
		if (!list.contains(word) ) {			
			list.add(word);
		}
	}

	public static void printReverse(ArrayList<String> list) {
		ArrayList<String> numbers = new ArrayList<String>();
		for (int i = list.size() - 1; i >= 0; i--) {
			numbers.add(list.get(i));
		} 
		System.out.println("역순: " + numbers);
	}
	
	public static void saveUniqueNumber(ArrayList<Integer> list, int number) {
		list.add(number);
	}

}
