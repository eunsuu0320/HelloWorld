package com.eunsu.service;

import java.util.List;

import com.eunsu.common.UserPoketmonDAO;
import com.eunsu.vo.UserPoketmon;

public class UserPoketmonServiceDAO implements UserPoketmonService {
	UserPoketmonDAO dao = new UserPoketmonDAO();

	@Override
	public boolean uPoketInsert(UserPoketmon uPoket) {
		return dao.uPoketInsert(uPoket) == 1;
	}

	@Override
	public boolean uPoketUpdate(UserPoketmon uPoket) {
		return dao.uPoketUpdate(uPoket) == 1;
	}

	@Override
	public List<UserPoketmon> uPoketSelect(String id) {
		return dao.uPoketSelect(id);
	}

}
