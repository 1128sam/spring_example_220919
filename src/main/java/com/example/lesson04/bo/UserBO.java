package com.example.lesson04.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.lesson04.dao.UserDAO;
import com.example.lesson04.model.User;

@Service
public class UserBO {

	@Autowired
	private UserDAO userDAO;

	public void addUser(String name, String yyyymmdd, String introduce, String email) {
		userDAO.insertUser(name, yyyymmdd, introduce, email);
	}
	
	public User getLastUser() {
		return userDAO.selectLastUser();
	}
	
	public boolean existUserByName(String name) {
		return userDAO.existUserByName(name);
	}
}