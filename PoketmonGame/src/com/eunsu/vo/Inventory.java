package com.eunsu.vo;

public class Inventory {
	int poketball;
	int snack;
	int money;
	
	public Inventory(int poketball, int snack, int money) {
		super();
		this.poketball = poketball;
		this.snack = snack;
		this.money = money;
	}
	
	public int getPoketball() {
		return poketball;
	}


	public void setPoketball(int poketball) {
		this.poketball = poketball;
	}


	public int getSnack() {
		return snack;
	}


	public void setSnack(int snack) {
		this.snack = snack;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}
	
}
