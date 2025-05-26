package Homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Homework4 {
	/*
	 * 사용자가 단어를 계속 입력한다. (종료는 "끝" 입력) 입력된 단어를 ArrayList에 저장한 뒤, 각 단어가 몇 번 입력됐는지 세어서
	 * 출력하라. 대소문자 구분은 하지 않는다. (예: "Apple" == "apple") 출력은 단어와 빈도수를 쌍으로 보여주고, 빈도수가 높은
	 * 순으로 출력한다. 빈도수가 같으면 사전 순으로 정렬한다.
	 */
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		ArrayList<String> words = new ArrayList<String>();
		int count = 0;

		while (true) {
			System.out.print("단어를 입력하세요. >> ");
			String word = scn.nextLine();
			words.add(word);
			if (word.equals("끝")) {
				break;
			}
			selectWords(words, count);
			for (int i = 0; i < words.size(); i++) {				
				System.out.printf("%s: %d", words.get(i), count);
			}
			
		}
	} // main
	
	public static void selectWords(ArrayList<String> words, int count) {
	}
}
