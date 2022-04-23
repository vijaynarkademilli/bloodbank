package com.bloodbank.demo.controller;

import com.bloodbank.demo.model.User;
import com.bloodbank.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registerUser")
    public ResponseEntity<User> register(@RequestBody User user){
        Long aLong = userService.saveUser(user);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getUserProfile/{userId}")
    public User getUserProfile(@PathVariable("userId") Long userId){
        return userService.findByUserId(userId).get();
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @DeleteMapping("/deleteUser/{userId}")
    public void deleteOrder(@PathVariable("userId") Long userId){
        userService.deleteById(userId);
    }

}
