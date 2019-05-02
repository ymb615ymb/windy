package com.ymb.windy.datasource1.entity;


import java.io.Serializable;

public class User implements Serializable {

	private Integer userId;

	private String userName;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
