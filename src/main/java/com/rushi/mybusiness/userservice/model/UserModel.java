package com.rushi.mybusiness.userservice.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "users")
public class UserModel implements Serializable {

	private static final long serialVersionUID = 9066870333168397131L;

	@Column(name = "user_name")
	@Id
	private String userName;

	@Column(name = "password")
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "attempts")
	private int attempts;

	@Column(name = "user_type")
	private int userType;

	@Column(name = "is_company_added")
	private boolean isCompanyCreated;

	@Column(name = "is_password_changed")
	private boolean isPasswordChanged;

	public UserModel(String userName, String password, String email, String firstName, String lastName, int attempts,
			int userType, boolean isCompanyCreated, boolean isPasswordChanged) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.attempts = attempts;
		this.userType = userType;
		this.isCompanyCreated = isCompanyCreated;
		this.isPasswordChanged = isPasswordChanged;
	}

	public UserModel() {
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAttempts() {
		return attempts;
	}

	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public boolean isCompanyCreated() {
		return isCompanyCreated;
	}

	public void setCompanyCreated(boolean isCompanyCreated) {
		this.isCompanyCreated = isCompanyCreated;
	}

	public boolean isPasswordChanged() {
		return isPasswordChanged;
	}

	public void setPasswordChanged(boolean isPasswordChanged) {
		this.isPasswordChanged = isPasswordChanged;
	}

}