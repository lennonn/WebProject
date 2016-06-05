package com.zl.blog.daos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.zl.blog.beans.ArticleType;
import com.zl.blog.util.DB;

public class ArticleTypeDao {
	public ArticleType findArticleType(int id) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArticleType artt = null;
		try {
			String sql = "select * from article_type where id =" + id;
			conn = DB.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				artt = new ArticleType();
				artt.setId(rs.getInt("id"));
				artt.setType_name(rs.getString("type_name"));
				artt.setType_desc(rs.getString("type_desc"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn);
			DB.close(stmt);
			DB.close(rs);
		}
		return artt;
	}

	public List<ArticleType> findArticleType() {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<ArticleType> arttlist = null;

		try {
			String sql = "select * from article_type ";
			conn = DB.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs != null) {
				arttlist = new ArrayList<ArticleType>();
				while (rs.next()) {
					ArticleType arttype = new ArticleType();
					arttype.setId(rs.getInt("id"));
					arttype.setType_name(rs.getString("type_name"));
					arttype.setType_desc(rs.getString("type_desc"));
					arttlist.add(arttype);
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
		return arttlist;
	}

	public static void addArticleType(ArticleType at) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into article_type values(null,?,?)";
		try {
			conn = DB.getConn();
			pstmt = DB.prepare(conn, sql);

			pstmt.setString(1, at.getType_name());
			pstmt.setString(2, at.getType_desc());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn);
			DB.close(pstmt);
		}

	}

	public  void articleTypeDelete(int id) {
		Connection conn = null;
		Statement stmt = null;

		String sql = "delete from article_type where id ="+id;
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
	public  void articleTypeDelete(String tname) {
		Connection conn = null;
		Statement stmt = null;
		String sql ;

		try {
			
			conn = DB.getConn();
			stmt = DB.getStatement(conn);
			sql = "delete from article_type where type_name ="+tname;
			DB.executeUpdate(stmt, sql);

		} finally {
			DB.close(conn);
			DB.close(stmt);
		}

	}
	public  void articleTypeModify(ArticleType at) {
		Connection conn = DB.getConn();
		String sql = "update article_type set type_name = ?, type_desc = ? where id = "+at.getId();
		PreparedStatement pstmt = DB.prepare(conn, sql);
		try {
			
			pstmt.setString(1, at.getType_name());
			pstmt.setString(2, at.getType_desc());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DB.close(pstmt);
			DB.close(conn);
		}

	}
}
