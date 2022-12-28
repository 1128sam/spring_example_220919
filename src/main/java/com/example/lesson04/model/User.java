package com.example.lesson04.model;

import java.util.Date;

public class User {
	private String name;
	private int yyyymmdd;
	private String email;
	private String introduce;
	private Date createdAt;
	private Date updatedAt;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYyyymmdd() {
		return yyyymmdd;
	}

	public void setYyyymmdd(int yyyymmdd) {
		this.yyyymmdd = yyyymmdd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
}