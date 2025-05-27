package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 1. Driver Manager
 * 2. Connection
 * 3. Statement
 * 4. 쿼리 실행
 * 5. ResultSet
 * 6. 출력 
 */
public class DatabaseExe {
	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String password = "tiger";

		// 세션
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 라이브러리가 있는지 체크
			conn = DriverManager.getConnection(url, id, password);
			conn.setAutoCommit(false); // 자동 커밋을 안 하고 싶을 때.
			System.out.println("연결에 성공하였습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버가 없습니다. 연결하세요.");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// insert 쿼리
		String sql = "INSERT INTO product (p_code, p_name, p_price)" + "VALUES (201, '치토스', 1000)";

		// Statement 객체
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // insert, update, delete를 할 때는 executeUpdate를 써야함.
			if (r > 0) {
				conn.commit(); // 커밋
				System.out.println(r + "건 등록되었습니다.");
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			rs = stmt.executeQuery("select * from product"); // 조회 executeQuery
			System.out.println("상품코드   상품이름          가격");
			System.out.println("----------------------------");
			while (rs.next()) {
				System.out.println(rs.getInt("p_code") + "  " + rs.getString("p_name") + "  " + rs.getInt("p_price"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // main
}
