package com.sportyshoes.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Admin {
	
	@Column
	String name;

	@Column
	@Id
	String username;
	
	@Column
	String password;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [name=" + name + ", username=" + username + ", password=" + password + "]";
	}
	
	
	

}
