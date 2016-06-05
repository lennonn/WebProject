package com.zl.blog.beans;

import java.util.Date;
import java.sql.Timestamp;
public class Article {
	int id;
	int t_id;
	String title;
	String author;
	String content;
	int scan;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}
	public String getContent(int len) {
	
		if(len<=0||len>content.length())
			len=content.length();
		return content.substring(0,len)+"......";
	}


	public void setContent(String content) {
		this.content = content;
	}

	public int getScan() {
		return scan;
	}

	public void setScan(int scan) {
		this.scan = scan;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	
}
