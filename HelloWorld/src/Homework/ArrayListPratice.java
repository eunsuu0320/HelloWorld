package Homework;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListPratice {
/*
 * 🧩 문제: 입력한 순서의 반대로 출력하기 (중복 허용)
사용자로부터 문자열을 계속 입력받아 ArrayList에 저장하고,
"그만"이 입력되면 입력을 종료한 후,
입력한 순서의 반대로 문자열을 출력하라.
 * */
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		ArrayList<String> words = new ArrayList<String>();
		
		while (true) {
			System.out.print("문자열을 입력하세요. >> ");
			String word = scn.nextLine();
			words.add(word);
			if (word.equals("그만")) {
				break;
			}
		}
		
		for (int i = words.size() - 1; i >= 0; i--) {
			System.out.println(words.get(i));
		}
		
	}
}
