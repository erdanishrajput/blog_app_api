//(4) make interfaces of dto to perform operation on dto

package com.blog.services;

import java.util.List;

import com.blog.payloads.UserDto;

public interface UserService {

	//UserDto will be used to return type
	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(UserDto userDto,Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUsers();
	
	void deleteUser(Integer userId);
}
