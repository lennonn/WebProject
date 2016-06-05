package com.zl.blog.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

import java.util.ArrayList;

import java.util.List;

import com.zl.blog.beans.Article;
import com.zl.blog.beans.Message;
import com.zl.blog.util.DB;

public class MessageDao {

	public Message findMessage(int id) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Message msg = null;
		String sql = "";

		conn = DB.getConn();
		stmt = DB.getStatement(conn);
		sql = "select  * from leave_msg where id=" + id;
		rs = DB.getResultSet(stmt, sql);
		try {
			while (rs.next()) {
				msg = new Message();
				msg.setId(rs.getInt("id"));
				msg.setName(rs.getString("name"));
				msg.setContent(rs.getString("content"));
				msg.setTime(rs.getDate("time"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return msg;
	}

	public List<Message> messageList(int pageno, int pagesize) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Message> msglist = null;
		Message msg = null;
		String sql = "";

		conn = DB.getConn();
		stmt = DB.getStatement(conn);
		sql = "select  * from leave_msg order by time desc  limit " + (pageno - 1) * pagesize + "," + pagesize ; 
		rs = DB.getResultSet(stmt, sql);
		try {
			msglist = new ArrayList<Message>();
			while (rs.next()) {

				msg = new Message();
				msg.setId(rs.getInt("id"));
				msg.setName(rs.getString("name"));
				msg.setContent(rs.getString("content"));
				msg.setRevert(rs.getString("revert"));
				msg.setTime(rs.getDate("time"));
				msglist.add(msg);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return msglist;
	}

	public void deleteMessage(int id) {
		Connection conn = null;
		Statement stmt = null;

		String sql = "delete from leave_msg where id =" + id;
		try {
			conn = DB.getConn();
			stmt = DB.getStatement(conn);

			stmt.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn);
			DB.close(stmt);
		}

	}
	
	public  void messageModify(Message msg) {
		Connection conn = DB.getConn();
		Statement stmt=null;
		String name= msg.getName();
		String revert= msg.getRevert();
		String sql = "update leave_msg SET revert=CONCAT(revert,"+"'"+"<font color=#ff0000>"+""+name+"</font>"+"回复:"+revert+"</br>"+"'"+") WHERE id ="+msg.getId();

		
		try {
			 stmt = DB.getStatement(conn);
			stmt.executeUpdate(sql);
		//	pstmt.setDate(1,  new Date(System.currentTimeMillis()));
		//	pstmt.setString(2,REPLACE(revert,'1','2')+msg.getName()+"�ظ�"+msg.getRevert());

			
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(stmt);
			DB.close(conn);
		}

	}
	
	public static void addMessage(Message msg) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into leave_msg values(null,?,?,?,null)";
		try {
			conn = DB.getConn();
			pstmt = DB.prepare(conn, sql);

		
			pstmt.setString(1, msg.getName());
			pstmt.setString(2, msg.getContent());
			pstmt.setDate(3,new Date(System.currentTimeMillis()));
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn);
			DB.close(pstmt);
		}

	}


}
