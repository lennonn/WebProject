package com.zl.dto.domain;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 6910584263183142037L;
	private int userid;
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public User() {
		super();
	}

	public User(String name, String password) {
		super();
		this.username = name;
		this.password = password;
	}
	
	public User(int userid, String name, String password) {
		super();
		this.userid=userid;
		this.username = name;
		this.password = password;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
