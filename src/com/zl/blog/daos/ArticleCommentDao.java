package com.zl.blog.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.zl.blog.beans.Article;
import com.zl.blog.beans.ArticleComment;
import com.zl.blog.util.DB;

public class ArticleCommentDao {
	public  void addComment(ArticleComment artcom) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int id= findMaxId()+1;
		String sql = "insert into article_comment values("+id+",?,?,?,?)";
		try {
			conn = DB.getConn();
			pstmt = DB.prepare(conn, sql);
			pstmt.setInt(1, artcom.getA_id());
			pstmt.setString(2, artcom.getA_user());
			pstmt.setString(3, artcom.getA_comment());
			
			//pstmt.setTimestamp(5, new Timestamp(Article.time.getTime()));
			pstmt.setDate(4,  new Date(System.currentTimeMillis()));
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn);
			DB.close(pstmt);
		}

	}
	public int findMaxId() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int maxId = 0;

		try {

			String sql = "select max(id) from article_comment";
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
	
	public List<ArticleComment> commentlist(int pageno, int pagesize) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArticleComment ac=null;
		List<ArticleComment> aclist = null;

		try {
			String sql = "select * from article_comment limit " + (pageno - 1)
					* pagesize + "," + pagesize;
			conn = DB.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				aclist = new ArrayList<ArticleComment>();
				while (rs.next()) {
					 ac= new ArticleComment();
					ac.setA_id(rs.getInt("a_id"));
					ac.setId(rs.getInt("id"));
					ac.setA_user(rs.getString("a_user"));
					ac.setA_comment(rs.getString("a_comment"));
					ac.setA_time(rs.getDate("a_time"));
					aclist.add(ac);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn);
			DB.close(stmt);
			DB.close(rs);
		}
		return aclist;
	}
	public List<ArticleComment> commentlist(int pageno, int pagesize ,int a_id) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArticleComment ac=null;
		List<ArticleComment> aclist = null;

		try {
			String sql = "select * from article_comment where a_id="+a_id+ " limit " + (pageno - 1)
					* pagesize + "," + pagesize;
			conn = DB.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				aclist = new ArrayList<ArticleComment>();
				while (rs.next()) {
					 ac= new ArticleComment();
					ac.setA_id(rs.getInt("a_id"));
					ac.setId(rs.getInt("id"));
					ac.setA_user(rs.getString("a_user"));
					ac.setA_comment(rs.getString("a_comment"));
					ac.setA_time(rs.getDate("a_time"));
					aclist.add(ac);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn);
			DB.close(stmt);
			DB.close(rs);
		}
		return aclist;
	}
	public  void deleteComment(int id) {
		Connection conn = null;
		Statement stmt = null;

		String sql = "delete from article_comment where id ="+id;
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
}

