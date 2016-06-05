package com.zl.blog.beans;

import java.util.Date;

public class Image {
	int id;
	int t_id;
	String imgname ;
	String imgurl;
	String imgdesc;
	String imginfo;
	Boolean imgtype ;
	Date time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getT_id() {
		return t_id;
	}
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getImgdesc() {
		return imgdesc;
	}
	public void setImgdesc(String imgdesc) {
		this.imgdesc = imgdesc;
	}
	public String getImginfo() {
		return imginfo;
	}
	public void setImginfo(String imginfo) {
		this.imginfo = imginfo;
	}
	public Boolean getImgtype() {
		return imgtype;
	}
	public void setImgtype(Boolean imgtype) {
		this.imgtype = imgtype;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
