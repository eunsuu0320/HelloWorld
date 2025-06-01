package com.eunsu.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.eunsu.vo.Users;

public class UsersDAO extends DAO {
	
	// insert
	public int userInsert(Users user) {
		String sql = "insert into users (id, password, name, phone) "
				+ "values (?, ?, ?, ?)";
		
		getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, user.getId());
			psmt.setString(2, user.getPassword());
			psmt.setString(3, user.getName());
			psmt.setString(4, user.getPhone());
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
	public List<Users> userSelect() {
		String sql = "select * from users";
		List<Users> list = new ArrayList<>();
		
		getConnect();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				Users user = new Users();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setPhone(rs.getString("phone"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}
}
