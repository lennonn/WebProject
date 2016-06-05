package com.zl.blog.beans;

import java.util.Date;

public class Message {
	int id;
	String name;
	String content;
	String revert;
	Date time;

	public String getRevert() {
		return revert;
	}

	public void setRevert(String revert) {
		this.revert = revert;
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	
	
	

}
