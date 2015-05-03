
package com.pzy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzy.entity.Collect;
import com.pzy.repository.CollectRepository;

@Service
public class CollectService {
     @Autowired
     private CollectRepository collectRepository;
     
     public Collect save(Collect collect){
    	 return  this.collectRepository.save(collect);
     }
    
}