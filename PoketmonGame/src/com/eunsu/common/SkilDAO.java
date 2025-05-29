package com.eunsu.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eunsu.vo.Skil;
 
public class SkilDAO extends DAO {
	public List<Skil> skilSelect() {
		String sql = "select * from skil";
		List<Skil> list = new ArrayList<Skil>();
		
		getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				Skil skil = new Skil();
				skil.setSkilName(rs.getNString("skil_name"));
				skil.setDamage(rs.getInt("damage"));
				list.add(skil);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}