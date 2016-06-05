package com.zl.blog.daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.zl.blog.beans.Article;
import com.zl.blog.beans.ArticleType;
import com.zl.blog.util.DB;

//import java.util.Date;

public class ArticleDao {
	public static Article findArticle(int id) {

		Connection conn = null;
		Statement stmt = null;
		
		ResultSet rs = null;
		Article art = null;

		try {
			String sql = "select * from article where id =" + id;
			conn = DB.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				art = new Article();
				art.setId(rs.getInt("id"));
				art.setT_id(rs.getInt("t_id"));
				art.setTitle(rs.getString("title"));
				art.setAuthor(rs.getString("author"));
				art.setContent(rs.getString("content"));
				art.setScan(rs.getInt("scan"));
				art.setTime(rs.getTimestamp("time"));
				int count=rs.getInt("scan")+1;
				String sql2="update article set scan ="+count+" where id="+id;
				stmt.executeUpdate(sql2);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			DB.close(conn);
			DB.close(stmt);
			DB.close(rs);
		}
		return art;
	}
	public  Article findArticle(ArticleType type) {

		Connection conn = null;
		Statement stmt = null;
		
		ResultSet rs = null;
		Article art = null;

		try {
			String sql = "select * from article where id ="+type.getId()+" limit 1" ;
			conn = DB.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				art = new Article();
				art.setId(rs.getInt("id"));
				art.setT_id(rs.getInt("t_id"));
				art.setTitle(rs.getString("title"));
				art.setAuthor(rs.getString("author"));
				art.setContent(rs.getString("content"));
				art.setScan(rs.getInt("scan"));
				art.setTime(rs.getTimestamp("time"));
			
				

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			DB.close(conn);
			DB.close(stmt);
			DB.close(rs);
		}
		return art;
	}

	public List<Article> scanArticle() {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Article art = null;
		List<Article> artlist = null;

		try {
		

				String sql = "select * from article order by scan limit 5"; 
						
				conn = DB.getConn();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
			
			if (rs != null) {
				artlist = new ArrayList<Article>();
				while (rs.next()) {
					art = new Article();
					art.setId(rs.getInt("id"));
					art.setT_id(rs.getInt("t_id"));
					art.setTitle(rs.getString("title"));
					art.setAuthor(rs.getString("author"));
					art.setContent(rs.getString("content"));
					art.setScan(rs.getInt("scan"));
					art.setTime(rs.getTimestamp("time"));
					artlist.add(art);
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
		return artlist;
	}
	public List<Article> goodArticle() {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Article art = null;
		List<Article> artlist = null;

		try {
		

				String sql = "select * from article where scan >=40 limit 11"; 
						
				conn = DB.getConn();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
			
			if (rs != null) {
				artlist = new ArrayList<Article>();
				while (rs.next()) {
					art = new Article();
					art.setId(rs.getInt("id"));
					art.setT_id(rs.getInt("t_id"));
					art.setTitle(rs.getString("title"));
					art.setAuthor(rs.getString("author"));
					art.setContent(rs.getString("content"));
					art.setScan(rs.getInt("scan"));
					art.setTime(rs.getTimestamp("time"));
					artlist.add(art);
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
		return artlist;
	}
	public List<Article> findArticle(int typeId, int pageno, int pagesize) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Article art = null;
		List<Article> artlist = null;

		try {
			

				String sql = "select * from article where t_id =" + typeId
						+ " limit " + (pageno - 1) * pagesize + "," + pagesize;
				conn = DB.getConn();
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
		
			if (rs != null) {
				artlist = new ArrayList<Article>();
				while (rs.next()) {
					art = new Article();
					art.setId(rs.getInt("id"));
					art.setT_id(rs.getInt("t_id"));
					art.setTitle(rs.getString("title"));
					art.setAuthor(rs.getString("author"));
					art.setContent(rs.getString("content"));
					art.setScan(rs.getInt("scan"));
					art.setTime(rs.getTimestamp("time"));
					artlist.add(art);
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
		return artlist;
	}

	public static void addArticle(Article art) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into article values(null,? ,?,?,?,0,?)";
		try {
			conn = DB.getConn();
			pstmt = DB.prepare(conn, sql);
			pstmt.setInt(1, art.getT_id());
			pstmt.setString(2, art.getTitle());
			pstmt.setString(3, art.getAuthor());
			pstmt.setString(4, art.getContent());
			//pstmt.setTimestamp(5, new Timestamp(Article.time.getTime()));
			pstmt.setDate(5,  new Date(System.currentTimeMillis()));
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn);
			DB.close(pstmt);
		}

	}

	public List<Article> findArticle(int pageno, int pagesize) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Article art = null;
		List<Article> artlist = null;

		try {
			String sql = "select * from article  limit " + (pageno - 1)
					* pagesize + "," + pagesize;
			conn = DB.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				artlist = new ArrayList<Article>();
				while (rs.next()) {
					art = new Article();
					art.setId(rs.getInt("id"));
					art.setT_id(rs.getInt("t_id"));
					art.setTitle(rs.getString("title"));
					art.setAuthor(rs.getString("author"));
					art.setContent(rs.getString("content"));
					art.setScan(rs.getInt("scan"));
					art.setTime(rs.getDate("time"));
					artlist.add(art);
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
		return artlist;
	}
	public List<Article> newArticle() {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Article art = null;
		List<Article> artlist = null;

		try {
			String sql = "select * from article  order by time desc limit 10" ;
			conn = DB.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs != null) {
				artlist = new ArrayList<Article>();
				while (rs.next()) {
					art = new Article();
					art.setId(rs.getInt("id"));
					art.setT_id(rs.getInt("t_id"));
					art.setTitle(rs.getString("title"));
					art.setAuthor(rs.getString("author"));
					art.setContent(rs.getString("content"));
					art.setScan(rs.getInt("scan"));
					art.setTime(rs.getDate("time"));
					artlist.add(art);
					
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
		return artlist;
	}
	public  void deleteArticle(int id) {
		Connection conn = null;
		Statement stmt = null;

		String sql = "delete from article where id ="+id;
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
	public  void articleModify(Article art) {
		Connection conn = DB.getConn();
		String sql = "update article set title = ?, author = ?,content=? where id = "+art.getId();
		PreparedStatement pstmt = DB.prepare(conn, sql);
		try {
			
			pstmt.setString(1, art.getTitle());
			pstmt.setString(2, art.getAuthor());
			pstmt.setString(3, art.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(pstmt);
			DB.close(conn);
		}

	}
}
