
package com.pzy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzy.entity.Category;
import com.pzy.repository.CategoryRepository;

@Service
public class CategoryService {
     @Autowired
     private CategoryRepository categoryRepository;
     public List<Category> findAll() {
          return (List<Category>) categoryRepository.findAll();
     }
}