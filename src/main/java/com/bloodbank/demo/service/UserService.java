package com.bloodbank.demo.service;

import com.bloodbank.demo.model.BloodDetails;
import com.bloodbank.demo.model.User;
import com.bloodbank.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Long saveUser(User user){
        User savedUser = userRepository.save(user);
        return savedUser.getUserId();
    }

    public Optional<User> findByUserId(long userId){
        return userRepository.findById(userId);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void deleteById(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            userRepository.deleteById(id);
        }else {
            throw new RuntimeException("BloodDetails does not exist");
        }
    }




}
