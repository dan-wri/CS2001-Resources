package com.example.demo.Controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.UserPostDTO;
import com.example.demo.Models.User;
import com.example.demo.Services.UserService;

@RestController

public class UserController {
    @Autowired
	UserService userService;
    
    //Get All Users (done)

    @GetMapping("/user")
    public ResponseEntity<List<User>> getAllUsers() 
    {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Post a User (done)

    @PostMapping("/user")
    public ResponseEntity<Void> createUser(@RequestBody UserPostDTO userPostDTO) 
    {
        // Convert UserPostDTO to User
        User newUser = new User();
        newUser.setName(userPostDTO.getName());
        newUser.setEmail(userPostDTO.getEmail());
        newUser.setPassword(userPostDTO.getPassword());
        newUser.setUserType(userPostDTO.getUserType());
        userService.addUser(newUser);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    //Get User by ID (done)
    
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) 
    {
        Optional<User> user = userService.findByID(id);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
               .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //Delete a User by ID

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) 
    {
        try 
        {
            userService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } 
        catch (Exception e) 
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    //Get User by Email (done)

    @GetMapping("/user/findByEmail")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email) 
    {
        User user = userService.findByEmail(email);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
   
}
