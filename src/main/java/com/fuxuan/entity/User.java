package com.fuxuan.entity;

import java.io.Serializable;


/**
 * 
 * @author Fuxuan
 *
 */
public class User implements Serializable {
	
	private static final long serialVersionUID = -1187504976022830408L;

	private Integer id;//用户ID
	
	private String userName;//用户姓名

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Integer id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}
	
}
