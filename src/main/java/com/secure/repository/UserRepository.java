package com.secure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.secure.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {


	User findByUsername(String username);


}
