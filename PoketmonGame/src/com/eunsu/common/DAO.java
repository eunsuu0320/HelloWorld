package com.eunsu.common;
/*
 * 데이터베이스 연결 정보 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DAO {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "poket";
	String password = "poket";
	
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	public void getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, password);
		} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
	public void disConnect() {
		try {
			if (conn != null) conn.close();
			if (psmt != null) psmt.close();
			if (rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
