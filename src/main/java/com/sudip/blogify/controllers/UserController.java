package com.sudip.blogify.controllers;

import java.util.List;

import com.sudip.blogify.dto.ApiResponse;
import com.sudip.blogify.dto.UserDTO;
import com.sudip.blogify.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/create")
	public ResponseEntity<UserDTO> createUserdd(@RequestBody UserDTO userdto){
		
		UserDTO createUserDTO = userService.createUser(userdto);
		return new ResponseEntity<>(createUserDTO , HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{userId}")
	public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userdto , @PathVariable("userId") Integer userId){
		
		UserDTO userdtos = userService.updateUser(userdto, userId);
		return new ResponseEntity<UserDTO>(userdtos , HttpStatus.OK);
		
	} 
	
	@GetMapping("/get/{userId}")
	public ResponseEntity<UserDTO> getUserById(@PathVariable("userId") Integer userId){
		
		UserDTO userdto = userService.getUserById(userId);
		return new ResponseEntity<UserDTO>(userdto , HttpStatus.OK);	
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<UserDTO>> getAllusers(){
		
		List<UserDTO> userdto = userService.getAllUsers();
		return new ResponseEntity<List<UserDTO>>(userdto , HttpStatus.OK);
			
	}
	
	@DeleteMapping("delete/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId") Integer userId){
		 userService.deleteUser(userId);
		 
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully" , true), HttpStatus.OK);
		 
			
	}
}