
package com.pzy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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
     public List<CookBook> findHot(){
    	 return cookBookRepository.findAll( new PageRequest(0, 8, new Sort(Direction.DESC, "count"))).getContent();
     }
     public List<CookBook> findNew(){
      	 return cookBookRepository.findAll( new PageRequest(0, 8, new Sort(Direction.DESC, "createDate"))).getContent();
     }
}