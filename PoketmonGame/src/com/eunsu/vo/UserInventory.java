package com.eunsu.vo;

public class UserInventory {
	String id;
	int myPoketball;
	int mySnack;
	int myStar;
	int myMoney;
	
	public UserInventory() {}

	public UserInventory(String id, int myPoketball, int mySnack, int myStar, int myMoney) {
		super();
		this.id = id;
		this.myPoketball = myPoketball;
		this.mySnack = mySnack;
		this.myStar = myStar;
		this.myMoney = myMoney;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getMyPoketball() {
		return myPoketball;
	}

	public void setMyPoketball(int myPoketball) {
		this.myPoketball = myPoketball;
	}

	public int getMySnack() {
		return mySnack;
	}

	public void setMySnack(int mySnack) {
		this.mySnack = mySnack;
	}

	public int getMyStar() {
		return myStar;
	}

	public void setMyStar(int myStar) {
		this.myStar = myStar;
	}

	public int getMyMoney() {
		return myMoney;
	}

	public void setMyMoney(int myMoney) {
		this.myMoney = myMoney;
	}
}
