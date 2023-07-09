package com.sportyshoes.Model;





import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class User {
	
	@Column
	String name;

	@Column
	@Id
	String username;
	
	@Column
	String passwordHash;
	
	@Enumerated(EnumType.STRING)  // stores Enum value in Database as string and not 0 1 
	private Role role;
	
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.passwordHash = password;
	}
	
	public User(String name , String username, String password , Role role) {
		super();
		this.name = name;
		this.username = username;
		this.passwordHash = password;
		this.role = role;
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

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
	

	

}
