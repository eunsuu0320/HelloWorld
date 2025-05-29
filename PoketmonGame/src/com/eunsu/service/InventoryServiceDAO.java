package com.eunsu.service;

import java.util.List;

import com.eunsu.common.InventoryDAO;
import com.eunsu.vo.Inventory;

public class InventoryServiceDAO implements InventoryService {
	InventoryDAO dao = new InventoryDAO();
	
	@Override
	public boolean plusInven(Inventory inven) {
		return dao.update(inven) == 1;
	}

	@Override
	public List<Inventory> invenSelect() {
		return dao.select();
	}
 
}
