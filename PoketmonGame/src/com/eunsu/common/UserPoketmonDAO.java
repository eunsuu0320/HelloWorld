package com.eunsu.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eunsu.vo.UserPoketmon;

public class UserPoketmonDAO extends DAO {
	//insert
	public int uPoketInsert(UserPoketmon uPoket) {
		String sql = "insert into user_poketmon (id, poketmon_name, hp) "
				+ "values (?, ?, ?)";
		
		getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, uPoket.getId());
			psmt.setString(2, uPoket.getPoketmonName());
			psmt.setInt(3, uPoket.getHp());
			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;
	}
	
	//update
	public int uPoketDelete(String id) {
		String sql = "delete from user_poketmon where id = ? ";
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, id);
			
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
	public List<UserPoketmon> uPoketSelect(String id) {
		String sql = "select * from user_poketmon where id = ?";
		List<UserPoketmon> list = new ArrayList<UserPoketmon>();
		
		getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				UserPoketmon uPoket = new UserPoketmon();
				uPoket.setId(rs.getString("id"));
				uPoket.setPoketmonName(rs.getString("poketmon_name"));
				uPoket.setHp(rs.getInt("hp"));
				list.add(uPoket);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}
}
