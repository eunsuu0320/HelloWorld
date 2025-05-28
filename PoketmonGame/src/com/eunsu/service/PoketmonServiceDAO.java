package com.eunsu.service;

import java.util.List;

import com.eunsu.common.PoketmonDAO;
import com.eunsu.vo.Poketmon;

public class PoketmonServiceDAO implements PoketmonService {
	PoketmonDAO dao = new PoketmonDAO();
	
	@Override
	public boolean poketmonChoice(String name) {
		return dao.poketmonChoice(name) == 1;
	}

	@Override
	public boolean choiceRemove(String name) {
		return dao.choiceRemove(name) == 1;
	}
	
	@Override
	public List<Poketmon> PoketmonList() {
		return dao.select();
	}

}
