package com.zl.blog.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.zl.blog.beans.ImageType;
import com.zl.blog.util.DB;

public class ImageTypeDao {
	public  ImageType findImageType(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		ImageType imgtype = null;
		try {
			String sql = "select * from img_type where id = " +id;
			conn = DB.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				imgtype = new ImageType();

				imgtype.setId(rs.getInt("id"));
				imgtype.setType_name(rs.getString("type_name"));
				imgtype.setType_desc(rs.getString("type_desc"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn);
			DB.close(stmt);
			DB.close(rs);
		}
		return imgtype;
	}

	public List<ImageType> findImageType() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<ImageType> imgtypes = null;
		ImageType imgtype = null;
		try {
			String sql = "select * from img_type";
			conn = DB.getConn();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			imgtypes = new ArrayList<ImageType>();
			while (rs.next()) {
				imgtype = new ImageType();
				imgtype.setId(rs.getInt("id"));
				imgtype.setType_name(rs.getString("type_name"));
				imgtype.setType_desc(rs.getString("type_desc"));
				imgtypes.add(imgtype);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DB.close(conn);
			DB.close(stmt);
			DB.close(rs);
		}
		return imgtypes;
	}
}
