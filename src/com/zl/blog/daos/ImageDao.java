package com.zl.blog.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.zl.blog.beans.Article;
import com.zl.blog.beans.Image;
import com.zl.blog.util.DB;

public class ImageDao {
	public static Image findImage() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Image img = null;
		try {
			String sql = "select * from img";
			conn = DB.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				img = new Image();

				img.setId(rs.getInt("id"));
				img.setT_id(rs.getInt("t_id"));
				img.setImgname(rs.getString("imgname"));
				img.setImgurl(rs.getString("imgurl"));
				img.setImgdesc(rs.getString("imgdesc"));
				//img.setImginfo(rs.getString("imginfo"));
				//img.setImgtype(rs.getBoolean("imgtype"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn);
			DB.close(stmt);
			DB.close(rs);
		}
		return img;
	}

	public int findMaxId() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int maxId = 0;

		try {

			String sql = "select max(id) from img";
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

	public List<Image> findImage(int tid) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Image> imgs = null;
		Image img = null;
		try {
			String sql = "select * from img where t_id=" + tid;
			conn = DB.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			imgs = new ArrayList<Image>();
			while (rs.next()) {
				img = new Image();

				img.setId(rs.getInt("id"));
				img.setT_id(rs.getInt("t_id"));
				img.setImgname(rs.getString("imgname"));
				img.setImgurl(rs.getString("imgurl"));
				img.setImgdesc(rs.getString("imgdesc"));
				imgs.add(img);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn);
			DB.close(stmt);
			DB.close(rs);
		}
		return imgs;
	}
	public List<Image> 	photoList() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Image> imgs = null;
		Image img = null;
		try {
			String sql = "select * from img ";
			conn = DB.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			imgs = new ArrayList<Image>();
			while (rs.next()) {
				img = new Image();

				img.setId(rs.getInt("id"));
				img.setT_id(rs.getInt("t_id"));
				img.setImgname(rs.getString("imgname"));
				img.setImgurl(rs.getString("imgurl"));
				img.setImgdesc(rs.getString("imgdesc"));
				img.setTime(rs.getDate("time"));
				imgs.add(img);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn);
			DB.close(stmt);
			DB.close(rs);
		}
		return imgs;
	}
	public boolean uploadImage(Image img ,int tid){
		boolean mark =false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		if(img!=null){
		String sql="insert into img values(null,"+tid+",?,?,?,?)";
		conn = DB.getConn();
		pstmt=DB.prepare(conn, sql);
		try {
			pstmt.setString(1, img.getImgname());
			pstmt.setString(2, img.getImgurl());
			pstmt.setString(3, img.getImgdesc());
			pstmt.setDate(4, new Date(System.currentTimeMillis()));
			pstmt.executeUpdate();
			mark=true;
		} catch (SQLException e) {
			mark=false;
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return mark;
	}
	
}
