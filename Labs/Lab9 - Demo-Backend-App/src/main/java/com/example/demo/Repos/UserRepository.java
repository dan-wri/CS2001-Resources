package com.example.demo.Repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Models.User;


public interface UserRepository extends CrudRepository<User,Long>
{
	User findByEmail(String email);
}
