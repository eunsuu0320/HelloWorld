package Homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Homework3 {
	/*
	 * 🧩 문제: 단어 필터링 후 정렬 출력하기 🔸설명: 사용자로부터 문자열(단어)을 계속 입력받아 ArrayList에 저장하자. 단, 다음
	 * 조건을 만족해야 한다:
	 * 
	 * 길이가 3자 이상인 단어만 저장
	 * 이미 저장된 단어는 중복 저장하지 않는다
	 * "그만"을 입력하면 입력을 종료한다
	 * 최종적으로 저장된 단어들을 사전 순 정렬해서 출력하라
	 */
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		
		while (true) {
			System.out.print("문자를 입력하세요. >>  ");
			String word = scn.nextLine();
			if (word.equals("그만")) {
				break;
			}
			addWord(list, word);
		}
		Collections.sort(list);
		System.out.println(list);
	} // main
	
	public static void addWord(ArrayList<String> list, String word) {
		if (word.length() >= 3 && !list.contains(word)) {
			list.add(word);
		}
	}
}
