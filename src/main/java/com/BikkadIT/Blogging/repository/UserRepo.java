package com.BikkadIT.Blogging.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.BikkadIT.Blogging.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
