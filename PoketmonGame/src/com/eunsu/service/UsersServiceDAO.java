package com.eunsu.service;

import java.util.List;

import com.eunsu.common.UsersDAO;
import com.eunsu.vo.Users;

public class UsersServiceDAO implements UsersService {
	UsersDAO dao = new UsersDAO();

	@Override
	public boolean insertUser(Users user) {
		return dao.userInsert(user) == 1;
	}

	@Override
	public List<Users> userSelect() {
		return dao.userSelect();
	}
	
}
