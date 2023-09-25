package com.emp.test;
import java.io.*;
public class UserBean implements Serializable
{
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String address;
	private String mailId;
	private long phnoNumber;
	
	public UserBean(){}

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public long getPhnoNumber() {
		return phnoNumber;
	}

	public void setPhnoNumber(long phnoNumber) {
		this.phnoNumber = phnoNumber;
	}
	
	
	
	

}
