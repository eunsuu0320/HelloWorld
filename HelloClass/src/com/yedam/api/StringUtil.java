package com.yedam.api;

public class StringUtil {

	public static String getGender(String s) {
		String value = s.replace("-", " ").substring(6).trim();
		if (value.charAt(0) == '1' || value.charAt(0) == '3') {
			return "남성";
		}
		return "여성";
	}

	public static String getExtName (String file) {
		int idx = file.indexOf(".");
		return file.substring(idx + 1, file.length());
	}
}
