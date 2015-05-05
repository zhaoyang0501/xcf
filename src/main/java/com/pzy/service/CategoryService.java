
package com.pzy.service;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.pzy.entity.Category;
import com.pzy.entity.CategorySub;
import com.pzy.repository.CategoryRepository;
import com.pzy.repository.CategorySubRepository;

@Service
public class CategoryService {
     @Autowired
     private CategorySubRepository categorySubRepository;
     @Autowired
     private CategoryRepository categoryRepository;
     public List<CategorySub> findAll() {
          return (List<CategorySub>) categorySubRepository.findAll();
     }
     public List<CategorySub> findCategorySubs() {
         return (List<CategorySub>) categorySubRepository.findAll();
     }
     public List<CategorySub> findCategorySubs(Category category) {
         return (List<CategorySub>) categorySubRepository.findByCategory(category);
     }
     public List<Category> findCategorys() {
         return (List<Category>) categoryRepository.findAll();
     }
     
     public Page<CategorySub> findAll(final int pageNumber, final int pageSize,final String name){
         PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize, new Sort(Direction.DESC, "id"));
        
         Specification<CategorySub> spec = new Specification<CategorySub>() {
              public Predicate toPredicate(Root<CategorySub> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
              Predicate predicate = cb.conjunction();
              if (name != null) {
                   predicate.getExpressions().add(cb.like(root.get("name").as(String.class), name+"%"));
              }
              return predicate;
              }
         };
         Page<CategorySub> result = (Page<CategorySub>) categorySubRepository.findAll(spec, pageRequest);
         return result;
     	}
		public void delete(Long id){
			categorySubRepository.delete(id);
		}
		public Category findCategory(Long id){
			  return categoryRepository.findOne(id);
		}
		public CategorySub find(Long id){
			  return categorySubRepository.findOne(id);
		}
		public void save(CategorySub categorySub){
			categorySubRepository.save(categorySub);
		}
}