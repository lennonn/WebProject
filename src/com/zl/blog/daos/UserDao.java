package com.zl.blog.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.zl.blog.beans.User;
import com.zl.blog.beans.UserInfo;
import com.zl.blog.util.DB;

public class UserDao {

	public boolean login(User login) {
		boolean mark = false;
		//Integer id = null;
		if (login != null) {
			String sql = "select * from login where username='"
					+ login.getUsername() + "' and password='"
					+ login.getPassword() + "'";
			Connection conn = DB.getConn();
			Statement stmt = DB.getStatement(conn);
			ResultSet rs = DB.getResultSet(stmt, sql);

			try {
				if (rs != null && rs.next()) {
					// id = rs.getInt("id");
					mark = true;
				}
			} catch (SQLException e) {
				// mark = false;
				e.printStackTrace();
			} finally {

				try {
					rs.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return mark;
	}

	public int findMaxId() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int maxId = 0;

		try {

			String sql = "select max(id) from login";
			conn = DB.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				maxId = rs.getInt(1);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			DB.close(rs);
			DB.close(stmt);
			DB.close(conn);
		}

		return maxId;
	}

	public List<User> gerUser() {
		User admin = null;
		Connection conn = DB.getConn();
		String sql = "select * from login";
		Statement stmt = DB.getStatement(conn);
		ResultSet rs = DB.getResultSet(stmt, sql);
		List<User> users = new ArrayList<User>();
		try {
			while (rs != null && rs.next()) {
				admin = new User();
				admin.setPassword(rs.getString(2));
				admin.setUsername(rs.getString(3));
				users.add(admin);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return users;
	}

	public void register(UserInfo uinfo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into userinfo values(null,?,?,?,?,?)";
		conn = DB.getConn();
		pstmt = DB.prepare(conn, sql);
		try {
			pstmt.setInt(1, uinfo.getLogin_id());
			pstmt.setString(2, uinfo.getReal_name());
			pstmt.setString(3, uinfo.getEmail());
			pstmt.setDate(4, new Date(System.currentTimeMillis()));
			pstmt.setDate(5, new Date(System.currentTimeMillis()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void register(User u) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into login values(null,?,?)";
		conn = DB.getConn();
		pstmt = DB.prepare(conn, sql);
		try {

			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public UserInfo findUser(User u) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		UserInfo uinfo = null;
		String sql = "select * from userinfo where real_name= '"+ u.getUsername()+"'";
		conn = DB.getConn();
		stmt = DB.prepare(conn, sql);
		try {
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				uinfo = new UserInfo();
				uinfo.setLogin_id(rs.getInt("login_id"));
				uinfo.setReal_name(rs.getString("real_name"));
				uinfo.setEmail(rs.getString("email"));
				uinfo.setRegist_time(rs.getDate("regist_time"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return uinfo;
	}

	public void UpdateUser(User u) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into login values(null,?,?)";
		conn = DB.getConn();
		pstmt = DB.prepare(conn, sql);
		try {

			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());

			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
