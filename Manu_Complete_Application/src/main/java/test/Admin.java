package test;

import java.io.Serializable;

public class Admin implements Serializable
{
	private String adminFirstName;
	private String adminLastName;
	private String adminMail;
	private String password;
	private  int contact;
	
	
	
	
	public Admin() {
		super();
		
	}




	public String getAdminFirstName() {
		return adminFirstName;
	}




	public void setAdminFirstName(String adminFirstName) {
		this.adminFirstName = adminFirstName;
	}




	public String getAdminLastName() {
		return adminLastName;
	}




	public void setAdminLastName(String adminLastName) {
		this.adminLastName = adminLastName;
	}




	public String getAdminMail() {
		return adminMail;
	}




	public void setAdminMail(String adminMail) {
		this.adminMail = adminMail;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public int getContact() {
		return contact;
	}




	public void setContact(int contact) {
		this.contact = contact;
	}


	
	
	
}

	