package com.eunsu.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eunsu.vo.Poketmon;

public class PoketmonDAO extends DAO {
	
	// choice 1로 변경 (내 포켓몬)
	public int poketmonChoice(String name) {
		String sql = "update poketmon " + "set choice = ? " + "where name = ?";
		
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, 1);
			psmt.setString(2,  name);
			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;
	}
	
	// choice 0으로 변경 (내 포켓몬 아님)
	public int choiceRemove(String name) {
		String sql = "update poketmon " + "set choice = ?" + "where name = ?";
		
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, 0);
			psmt.setString(2, name);
			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;
	}
	
	// 조회
	public List<Poketmon> select() {
		String sql = "select * from poketmon";
		List<Poketmon> list = new ArrayList<Poketmon>(); 
		
		getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Poketmon poketmon = new Poketmon();
				poketmon.setName(rs.getString("name"));
				poketmon.setType(rs.getString("type"));
				poketmon.setHp(rs.getInt("hp"));
				poketmon.setSkil1(rs.getString("skil1"));
				poketmon.setSkil2(rs.getString("skil2"));
				poketmon.setSkil3(rs.getString("skil3"));
				poketmon.setChoice(rs.getInt("choice"));
				list.add(poketmon);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
