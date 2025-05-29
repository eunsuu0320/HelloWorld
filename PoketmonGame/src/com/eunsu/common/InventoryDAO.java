package com.eunsu.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eunsu.vo.Inventory;

public class InventoryDAO extends DAO {
	// 인벤에 기본 0, 포켓볼이나 돈, 스낵이 추가되거나 삭제되면 업데이트
	public int update(Inventory inven) {
		String sql = "update inventory "
				+ "set poketball = ?, snack = ?, star = ?, money = ? ";
		
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, inven.getPoketball());
			psmt.setInt(2, inven.getSnack());
			psmt.setInt(3, inven.getStar());
			psmt.setInt(4, inven.getMoney());
			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;
	} // insert
	
	// 인벤 조회
	public List<Inventory> select() {
		String sql = "select * from inventory";
		List<Inventory> list = new ArrayList<Inventory>();
		
		getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Inventory inven = new Inventory();
				inven.setPoketball(rs.getInt("poketball"));
				inven.setSnack(rs.getInt("snack"));
				inven.setStar(rs.getInt("star"));
				inven.setMoney(rs.getInt("money"));
				list.add(inven);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	} // select
}
