package com.sportyshoes.Repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoes.Model.Role;
import com.sportyshoes.Model.User;


@Qualifier("userRepository")
public interface UserRepository extends JpaRepository<User, String> {
		
	public User findByUsername(String username);
	public List<User> findByRole(Role role);
	public User findByUsernameAndRole(String username , Role role);
	
}