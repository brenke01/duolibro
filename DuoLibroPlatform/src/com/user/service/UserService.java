package com.user.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pojo.User;
import com.security.LoginUtility;
import com.user.dao.UserDAO;
import com.user.dao.UserDAOImpl;

@Service("UserService")
@Transactional
public class UserService{
    private UserDAO userDAO;
    
    public void setUserDAO(UserDAO dao){
    	this.userDAO = dao;
    	}
	public void registerUser(String username, String password, String firstName, String lastName, String email) {
		User user = new User();
		user.setEmail(email);
		user.setFirstname(firstName);
		user.setLastname(lastName);
		user.setPassword(password);
		user.setUsername(username);

	
		userDAO.saveUser(user);
		
		
	}
	
	public boolean login(String userName, String password) {
		User user = userDAO.getUserByUsername(userName);
		if (user == null) {
			return false;
		}else if (!LoginUtility.matchesHashedPassword(password, user.getPassword())) {
			return false;
		}else {
			return true;
		}
		
	}
}