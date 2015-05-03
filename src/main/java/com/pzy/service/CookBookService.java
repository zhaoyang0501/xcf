
package com.pzy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzy.entity.CookBook;
import com.pzy.repository.CookBookRepository;

@Service
public class CookBookService {
     @Autowired
     private CookBookRepository cookBookRepository;
     public CookBook save(CookBook cookBook){
    	 return cookBookRepository.save(cookBook);
     }
  
}