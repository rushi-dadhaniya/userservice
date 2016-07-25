package com.rushi.mybusiness.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rushi.mybusiness.userservice.model.UserModel;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public List<UserModel> findAllUsers() {
		return (List<UserModel>) hibernateTemplate.loadAll(UserModel.class);
	}

	@Transactional
	public UserModel findUser(String userName) {
		return hibernateTemplate.get(UserModel.class, userName);
	}

	@Transactional
	public void addUser(UserModel user) {
		hibernateTemplate.save(user);
	}

	@Transactional
	public void updateUser(UserModel user) {
		hibernateTemplate.update(user);
	}

	@Transactional
	public void deleteUser(UserModel user) {
		hibernateTemplate.delete(user);
	}

}