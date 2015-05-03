
package com.pzy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzy.entity.CookBook;
import com.pzy.entity.User;
import com.pzy.repository.CookBookRepository;

@Service
public class CookBookService {
     @Autowired
     private CookBookRepository cookBookRepository;
     public CookBook save(CookBook cookBook){
    	 return cookBookRepository.save(cookBook);
     }
     public List<CookBook> findByUser(User user){
    	 return cookBookRepository.findByUser(user);
     }
     public CookBook find(Long id){
    	 return cookBookRepository.findOne(id);
     }
}