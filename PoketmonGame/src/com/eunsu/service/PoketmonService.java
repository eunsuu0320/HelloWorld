package com.eunsu.service;

import java.util.List;

import com.eunsu.vo.Poketmon;

public interface PoketmonService {
	public boolean poketmonChoice(String name); // choice 1로 변경
	public boolean choiceRemove(); // choice 0으로 전체변경
	public boolean changeHp(int damage, String name); // 체력 업데이트
	public List<Poketmon> PoketmonList(); // 조회 
}
