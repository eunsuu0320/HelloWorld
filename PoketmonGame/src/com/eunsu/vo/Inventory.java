package com.eunsu.vo;

public class Inventory {
	int poketball;
	int snack;
	int star;
	int money;

	public Inventory() {
	}

	public Inventory(int poketball, int snack, int star, int money) {
		super();
		this.poketball = poketball;
		this.snack = snack;
		this.star = star;
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

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
