package com.eunsu.service;

import java.util.List;

import com.eunsu.vo.Users;

public interface UsersService {
	public boolean insertUser(Users user); // insert
	public List<Users> userSelect(); // select
}
