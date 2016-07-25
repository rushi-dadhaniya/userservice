package com.rushi.mybusiness.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.rushi.mybusiness.userservice.model.UserModel;

@Repository
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	public List<UserModel> findAllUsers() {
		return userDao.findAllUsers();
	}

	public UserModel findUser(String userName) {
		return userDao.findUser(userName);
	}

	public void addUser(UserModel user) {
		userDao.addUser(user);
	}

	public void updateUser(UserModel user) {
		userDao.updateUser(user);
	}

	public void deleteUser(UserModel user) {
		userDao.deleteUser(user);
	}

}