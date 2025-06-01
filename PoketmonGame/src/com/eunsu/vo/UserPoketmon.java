package com.eunsu.vo;

public class UserPoketmon {
	String id;
	String poketmonName;
	int hp;

	public UserPoketmon() {
	}

	public UserPoketmon(String id, String poketmonName, int hp) {
		super();
		this.id = id;
		this.poketmonName = poketmonName;
		this.hp = hp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPoketmonName() {
		return poketmonName;
	}

	public void setPoketmonName(String poketmonName) {
		this.poketmonName = poketmonName;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

}
