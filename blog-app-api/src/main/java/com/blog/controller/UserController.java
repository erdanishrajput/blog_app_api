//(7)
package com.blog.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blog.payloads.ApiResponse;
import com.blog.payloads.UserDto;
import com.blog.services.UserService;

import jakarta.persistence.Id;

@RestController
@RequestMapping("/api/users")
public class UserController {

	//diff methods will be created to handle diff urls
	@Autowired
	private UserService userService;
	//POST - create user
	@PostMapping("/")
	public ResponseEntity< UserDto> createUser(@RequestBody UserDto userDto){
		UserDto createUserDto =this.userService.createUser(userDto);
		
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
		
	}
	
	//PUT - update user
	@PutMapping("/{userId}")  //{userId} ->it tells which user you want to update and to fatch @PathVariable
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("userId") Integer userId){
		UserDto updateUser=this.userService.updateUser(userDto, userId);
		return new ResponseEntity<UserDto>(updateUser,HttpStatus.OK) ;
		//return new ResponseEntity.ok(updateUser)
	}
	
	//DELETE -delete user
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteById(@RequestParam("userId") Integer userId){
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted succesfully", true),HttpStatus.OK);
//		return ResponseEntity.ok(Map.of("message","User Deleted Successfully"));
		//return new ResponseEntity(Map.of("message","User Deleted Successfully"),HttpStatus.ok);
	}
	//GET -user get
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	
}
