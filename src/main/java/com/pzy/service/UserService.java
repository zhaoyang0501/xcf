
package com.pzy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzy.entity.User;
import com.pzy.repository.UserRepository;

@Service
public class UserService {
     @Autowired
     private UserRepository userRepository;
     
     public  User save(User user){
    	 return userRepository.save(user);
     }
     public User login(String userName,String password){
    	 List<User> users=userRepository.findByNameAndPassword(userName,password);
    	 return users.size()==0?null:users.get(0);
     }
}