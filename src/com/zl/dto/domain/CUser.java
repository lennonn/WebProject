package com.zl.dto.domain;

public class CUser {
	private int userid;
	private String username;
	private String password;
	private  Integer access;
	
	
	public Integer getAccess() {
		return access;
	}

	public void setAccess(Integer access) {
		this.access = access;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public CUser() {
		super();
	}

	public CUser(String name, String password) {
		super();
		this.username = name;
		this.password = password;
	}
	
	public CUser(int userid, String name, String password) {
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
