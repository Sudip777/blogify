package com.sudip.blogify.service;

import java.util.List;

import com.sudip.blogify.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
	
	UserDTO createUser(UserDTO user);
	
	UserDTO updateUser(UserDTO user , Integer userId);
	
	UserDTO getUserById(Integer userId);
	
	List<UserDTO> getAllUsers();
	
	void deleteUser(Integer userId);

}