package com.rushi.mybusiness.userservice.service;

import java.util.List;

import com.rushi.mybusiness.userservice.model.UserModel;

public interface UserDao {

	public List<UserModel> findAllUsers();

	public UserModel findUser(String userName);

	public void addUser(UserModel user);

	public void updateUser(UserModel user);

	public void deleteUser(UserModel user);

}