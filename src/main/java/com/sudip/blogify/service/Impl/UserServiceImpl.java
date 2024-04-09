package com.sudip.blogify.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import com.sudip.blogify.dto.UserDTO;
import com.sudip.blogify.entities.Users;
import com.sudip.blogify.exceptions.ResourseNotFoundExceptions;
import com.sudip.blogify.repositories.UserRepository;
import com.sudip.blogify.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDTO createUser(UserDTO userdto) {
		Users user = DtoToUser(userdto);
		Users saveUser = userRepository.save(user);
		return usersToDTO(saveUser);

	}

	@Override
	public UserDTO updateUser(UserDTO userdto, Integer userId) {
		
		Users finduser = userRepository.findById(userId)
                    .orElseThrow(() -> new ResourseNotFoundExceptions("Users" , "id" , userId));
		
		finduser.setName(userdto.getName());
		finduser.setEmail(userdto.getEmail());
		finduser.setPassword(userdto.getPassword());
		finduser.setAbout(userdto.getAbout());
		
		Users updatedUser = userRepository.save(finduser);
        return usersToDTO(updatedUser);
			
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		
		Users user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourseNotFoundExceptions("Users" , "id" , userId));
		return usersToDTO(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		
		List<Users> users = userRepository.findAll();
		List<UserDTO> userdto = users.stream().map(e -> usersToDTO(e)).collect(Collectors.toList());
		return userdto;
	}

	@Override
	public void deleteUser(Integer userId) {
		
		Users users = userRepository.findById(userId)
				.orElseThrow(() -> new ResourseNotFoundExceptions("Users" , "id" , userId));
		
		userRepository.delete(users);

	}
	
	
	// Conversion DTO to user or vice versa
	private Users DtoToUser(UserDTO userdto) {
		
		Users user = new Users();
		user.setName(userdto.getName());
		user.setPassword(userdto.getPassword());
		user.setEmail(userdto.getEmail());
		user.setAbout(userdto.getAbout());
		return user;
	
	}
	
	private UserDTO usersToDTO(Users users) {
		UserDTO userDTO = new UserDTO();
	
			userDTO.setName(users.getName());
			userDTO.setPassword(users.getPassword());
			userDTO.setEmail(users.getEmail());
			userDTO.setAbout(users.getAbout());
			return userDTO;
	}
	

}