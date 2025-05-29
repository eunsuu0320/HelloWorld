package com.eunsu.service;

import java.util.List;

import com.eunsu.vo.Inventory;

public interface InventoryService {
	public boolean plusInven(Inventory inven); // 0으로 기본값, 여기서 추가되거나 삭제되거나
	public List<Inventory> invenSelect(); // 인벤 조회
	
}
