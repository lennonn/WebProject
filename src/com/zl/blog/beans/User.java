package com.zl.blog.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zl.blog.util.DB;

public class User {
	int id;
	String username;
	String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void register() {
		Connection conn = DB.getConn();
		String sql = "insert into login values (null, ?, ?)";
		PreparedStatement pstmt = DB.prepare(conn, sql);
		try {
		
			pstmt.setString(1, username);
			pstmt.setString(2, password);
		
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(pstmt);
			DB.close(conn);
		}

	}

}
