
package com.pzy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzy.entity.Collect;
import com.pzy.entity.CookBook;
import com.pzy.entity.User;
import com.pzy.repository.CollectRepository;

@Service
public class CollectService {
     @Autowired
     private CollectRepository collectRepository;
     
     public Collect save(Collect collect){
    	 return  this.collectRepository.save(collect);
     }
     public void delete(Collect collect){
    	this.collectRepository.delete(collect);
     }
     public List<Collect> findByUser(User user){
    	 return this.collectRepository.findByUser(user);
     }
     public List<Collect> findByUserAndCookBook(User user,CookBook cookBook){
    	 return this.collectRepository.findByUserAndCookBook(user, cookBook);
     }
}