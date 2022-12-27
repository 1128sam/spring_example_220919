package com.example.lesson04.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {

	public void addUser(String name, String yyyymmdd, String introduce, String email);
}