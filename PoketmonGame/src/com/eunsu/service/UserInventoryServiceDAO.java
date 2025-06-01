package com.eunsu.service;

import com.eunsu.common.UserInventoryDAO;
import com.eunsu.vo.UserInventory;

public class UserInventoryServiceDAO implements UserInventoryService {
	UserInventoryDAO dao = new UserInventoryDAO();

	@Override
	public boolean userInventoryInsert(UserInventory uInven) {
		return dao.uInvenInsert(uInven) == 1;
	}

	@Override
	public boolean userInventoryUpdate(UserInventory uInven) {
		return dao.uInvenUpdate(uInven) == 1;
	}

	@Override
	public UserInventory userInvenSelect(String id) {
		return dao.uInvenSelect(id);
	}

}
