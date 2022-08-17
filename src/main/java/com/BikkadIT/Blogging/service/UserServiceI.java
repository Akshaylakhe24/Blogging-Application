package com.BikkadIT.Blogging.service;

import java.util.List;

import com.BikkadIT.Blogging.paylods.UserDto;

public interface UserServiceI {
	
	UserDto createrUser(UserDto user);
	UserDto updateUser(UserDto user,Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto>getAllUser();
	void deleteUser(Integer UserId);
	

}
