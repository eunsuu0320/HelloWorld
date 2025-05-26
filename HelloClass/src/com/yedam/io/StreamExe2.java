package com.yedam.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class StreamExe2 {
	public static void main(String[] args) {
		Scanner scn = null;
		try {
			scn = new Scanner(new File("C:/temp/writer.txt"));
			try {
				while (true) {
					String data = scn.nextLine();
					String[] strAry = data.split(",");
					System.out.println(strAry[0] + ", " + strAry[1]);
				}
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			}
			scn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	} // main

	public static void read() {
		// char 기반의 입력스트림.
		try {
			Reader reader = new FileReader("C:/temp/writer.txt");

			while (true) {
				int data = reader.read();
				if (data == -1) {
					break;
				}
				System.out.println((char) data);
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void write() {
		// char기반의 출력 스트림
		// writer
		try {
			Writer wr = new FileWriter("C:/temp/writer.txt");
			wr.write('A');
			wr.write('B');
			wr.write('C');
			wr.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("프로그램 종료");
	}
}
