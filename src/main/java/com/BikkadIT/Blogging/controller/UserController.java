package com.BikkadIT.Blogging.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.BikkadIT.Blogging.paylods.ApiResponse;
import com.BikkadIT.Blogging.paylods.UserDto;
import com.BikkadIT.Blogging.service.UserServiceI;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	private UserServiceI userServiceI;
	
	//post-create user
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){	
		UserDto createrUserDto = this.userServiceI.createrUser(userDto);
		return new ResponseEntity<>(createrUserDto,HttpStatus.CREATED);
	}
	
	//put -update user
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto>updateUser(@Valid @RequestBody UserDto userDto,@PathVariable("userId")Integer uid){
		UserDto updatedUser = this.userServiceI.updateUser(userDto, uid);
		return ResponseEntity.ok(updatedUser);
	}

	//Delete - delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable("userId")Integer uid){
		 this.userServiceI.deleteUser(uid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
		
	}
	
	
	
	//Get - user get
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
		return ResponseEntity.ok(this.userServiceI.getUserById(userId));
		
	}
	
	//Get - user get
		@GetMapping("/")
		public ResponseEntity<List<UserDto>> getAllUser(){
			return ResponseEntity.ok(this.userServiceI.getAllUser());
			
		}
	
	
	
	
}



