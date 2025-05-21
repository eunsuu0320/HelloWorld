package com.yedam.board;
/*
 * User: 아이디, 비밀번호, 이름.
 */

class User {
	private String userId;
	private String password;
	private String userName;

	// 생성자
	public User(String userId, String password, String userName) {
		super();
		this.userId = userId;
		this.password = password;
		this.userName = userName;
	}

	// getter
	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}

	// setter
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
} // class user

public class UserExe {
	static User[] users = { new User("holy", "1111", "김영광"), 
			                new User("cutie", "2222", "홍예쁨"),
			                new User("guest", "3333", "밤손님") };

	// 사용자 아이디와 비밀번호를 매개값으로 받아와서 user에서 찾아보고 있으면 true
	static boolean login(String userId, String password) {
		for (int i = 0; i < users.length; i++) {
			if (users[i] != null && users[i].getUserId().equals(userId) && users[i].getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	} // login
	
	public static String userName(String userId) {
		for (int i = 0; i < users.length; i++) {
			if (users[i] != null && users[i].getUserId().equals(userId)) {
				return users[i].getUserName();
			}
		}
		return null;
	}
} // class UserExe
