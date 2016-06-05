package com.zl.blog.beans;

import java.sql.Date;

public class ArticleComment {
	int id;
	int a_id;
	String a_user;
	String a_comment;
	Date a_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getA_user() {
		return a_user;
	}
	public void setA_user(String a_user) {
		this.a_user = a_user;
	}
	public String getA_comment() {
		return a_comment;
	}
	public void setA_comment(String a_comment) {
		this.a_comment = a_comment;
	}
	public Date getA_time() {
		return a_time;
	}
	public void setA_time(Date a_time) {
		this.a_time = a_time;
	}

}
