package com.rushi.mybusiness.userservice.controller;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rushi.mybusiness.userservice.model.UserModel;
import com.rushi.mybusiness.userservice.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	private static final String ALGORITHM = "SHA-256";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<UserModel> getUsers() {
		return userService.findAllUsers();
	}

	@RequestMapping(value = "/{userName}/", method = RequestMethod.GET)
	public UserModel getUser(@PathVariable(value = "userName") String userName) {
		return userService.findUser(userName);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void addUser(@RequestBody UserModel user) {
		user = buildUser(user);
		userService.addUser(user);
	}

	private UserModel buildUser(UserModel user) {
		String encryptedPassword = generateEncryptedPassword(user.getPassword());
		if (encryptedPassword != null) {
			user.setPassword(generateEncryptedPassword(user.getPassword()));
		}
		user.setAttempts(0);
		user.setCompanyCreated(false);
		user.setPasswordChanged(false);
		return user;
	}

	private String generateEncryptedPassword(String password) {

		if (password != null) {
			try {
				MessageDigest instance = MessageDigest.getInstance(ALGORITHM);
				byte[] digest = instance.digest(password.getBytes(StandardCharsets.UTF_8));
				StringBuffer encryptedPassword = new StringBuffer();
				for (int i = 0; i < digest.length; i++) {
					encryptedPassword.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
				}

				return encryptedPassword.toString();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@RequestMapping(value = "/", method = RequestMethod.PUT)
	public void updateUser(@RequestBody UserModel user) {
		userService.updateUser(user);
	}

	@RequestMapping(value = "/", method = RequestMethod.DELETE)
	public void deleteUser(@RequestBody UserModel user) {
		userService.deleteUser(user);
	}

}