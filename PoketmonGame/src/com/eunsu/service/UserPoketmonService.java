package com.eunsu.service;

import java.util.List;

import com.eunsu.vo.UserPoketmon;

public interface UserPoketmonService {
	public boolean uPoketInsert(UserPoketmon uPoket);
	public boolean uPoketUpdate(UserPoketmon uPoket);
	List<UserPoketmon> uPoketSelect(String id);
}
