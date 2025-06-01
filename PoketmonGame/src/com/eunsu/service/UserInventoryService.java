package com.eunsu.service;

import com.eunsu.vo.UserInventory;

public interface UserInventoryService {
	public boolean userInventoryInsert(UserInventory uInven); // insert
	public boolean userInventoryUpdate(UserInventory uInven); // update
	public UserInventory userInvenSelect(String id); // select
}
