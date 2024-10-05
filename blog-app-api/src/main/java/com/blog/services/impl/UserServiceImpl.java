//(5) implementation of UserService interface

package com.blog.services.impl;

import java.util.List;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.exceptions.*;
import com.blog.entities.User;
import com.blog.payloads.UserDto;
import com.blog.repositories.UserRepo;
import com.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;   //TO update , delete and create of user
	@Override
	public UserDto createUser(UserDto userDto) {
		
		//(ii)conversion can apply here
		User user = this.userDtoToUser(userDto);
		
	    User savedUser=this.userRepo.save(user);
		return this.userToUserDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		
		//(iii) to update user details by id
		//get by id
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		
		//set
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		//update
		User updatedUser=this.userRepo.save(user);
		UserDto userDto1 =this.userToUserDto(updatedUser);
		
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
	
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","Id",userId));
		
		return userToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		
		List<User> users=this.userRepo.findAll();
		//we can get each user
		//lembda stream api is used here to convert List<User> to List<UserDto>
		List<UserDto> userDtos=users.stream().map(user->this.userToUserDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user=this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id",userId));
		this.userRepo.delete(user);
	}

	// (i) methods to conversion 
	private User userDtoToUser(UserDto userDto) {
		
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setAbout(userDto.getAbout());
		user.setPassword(userDto.getPassword());
		return user;
		
	}
	public UserDto userToUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setAbout(user.getAbout());
		userDto.setPassword(user.getPassword());
		return userDto;
		
	}
}
