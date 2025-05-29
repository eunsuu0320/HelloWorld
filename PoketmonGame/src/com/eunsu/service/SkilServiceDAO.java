package com.eunsu.service;

import java.util.List;

import com.eunsu.common.SkilDAO;
import com.eunsu.vo.Skil;

public class SkilServiceDAO implements SkilService {
	SkilDAO dao = new SkilDAO();
	
	@Override
	public List<Skil> poketmonSkil() {
		return dao.skilSelect();
	} 
	
}
