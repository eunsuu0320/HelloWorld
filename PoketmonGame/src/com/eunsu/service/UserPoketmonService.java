package com.eunsu.service;

import java.util.List;

import com.eunsu.vo.UserPoketmon;

public interface UserPoketmonService {
	public boolean uPoketInsert(UserPoketmon uPoket); // insert
	public boolean uPoketDelete(String id); // delete
	
	List<UserPoketmon> uPoketSelect(String id);
}
