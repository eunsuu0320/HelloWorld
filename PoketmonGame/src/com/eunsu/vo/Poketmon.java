package com.eunsu.vo;

public class Poketmon {
	String name;
	String type;
	int hp;
	String skil1;
	String skil2;
	String skil3;
	int choice;
	
	public Poketmon() {}

	public Poketmon(String name, String type, int hp, String skil1, String skil2, String skil3, int choice) {
		super();
		this.name = name;
		this.type = type;
		this.hp = hp;
		this.skil1 = skil1;
		this.skil2 = skil2;
		this.skil3 = skil3;
		this.choice = choice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public String getSkil1() {
		return skil1;
	}

	public void setSkil1(String skil1) {
		this.skil1 = skil1;
	}

	public String getSkil2() {
		return skil2;
	}

	public void setSkil2(String skil2) {
		this.skil2 = skil2;
	}

	public String getSkil3() {
		return skil3;
	}

	public void setSkil3(String skil3) {
		this.skil3 = skil3;
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}
	
	
}
