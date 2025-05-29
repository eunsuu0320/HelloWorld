package com.eunsu.vo;

public class Skil {
	String skilName;
	int damage;
	
	public Skil () {}
 
	public Skil(String pName, String skilName, int damage) {
		this.skilName = skilName;
		this.damage = damage;
	}

	public String getSkilName() {
		return skilName;
	}

	public void setSkilName(String skilName) {
		this.skilName = skilName;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}		
}
