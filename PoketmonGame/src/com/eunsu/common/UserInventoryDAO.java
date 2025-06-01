package com.eunsu.common;

import java.sql.SQLException;

import com.eunsu.vo.UserInventory;

public class UserInventoryDAO extends DAO {
	// insert
	public int uInvenInsert(UserInventory userInven) {
		String sql = "insert into user_inventory (id, my_poketball, my_snack, my_star, my_money)"
				+ " values (?, ?, ?, ?, ?)";

		getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, userInven.getId());
			psmt.setInt(2, userInven.getMyPoketball());
			psmt.setInt(3, userInven.getMySnack());
			psmt.setInt(4, userInven.getMyStar());
			psmt.setInt(5, userInven.getMyMoney());
			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;
	}

	// update
	public int uInvenUpdate(UserInventory userInven) {
		String sql = "UPDATE user_inventory " + "SET my_poketball = ?, my_snack = ?, my_star = ?, my_money = ? "
				+ "WHERE id = ?";

		getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, userInven.getMyPoketball());
			psmt.setInt(2, userInven.getMySnack());
			psmt.setInt(3, userInven.getMyStar());
			psmt.setInt(4, userInven.getMyMoney());
			psmt.setString(5, userInven.getId());
			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;
	}

	// select
	public UserInventory uInvenSelect(String id) {
		String sql = "select * from user_inventory where id = ?";

		getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();

			if (rs.next()) {
				UserInventory userInven = new UserInventory();
				userInven.setId(rs.getString("id"));
				userInven.setMyPoketball(rs.getInt("my_poketball"));
				userInven.setMySnack(rs.getInt("my_snack"));
				userInven.setMyStar(rs.getInt("my_star"));
				userInven.setMyMoney(rs.getInt("my_money"));
				return userInven;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return null;
	}
}
