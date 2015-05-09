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
import com.pzy.entity.CookBook;
import com.pzy.entity.CookFood;
import com.pzy.entity.CookStep;
import com.pzy.entity.User;
import com.pzy.repository.CookBookRepository;
import com.pzy.repository.CookFoodRepository;
import com.pzy.repository.CookStepRepository;

@Service
public class CookBookService {
	@Autowired
	private CookBookRepository cookBookRepository;
	
	@Autowired
	private CookStepRepository cookStepRepository;
	@Autowired
	private CookFoodRepository cookFoodRepository;
	public Page<CookBook> findAll(final int pageNumber, final int pageSize,
			final String name) {
		PageRequest pageRequest = new PageRequest(pageNumber - 1, pageSize,
				new Sort(Direction.DESC, "id"));

		Specification<CookBook> spec = new Specification<CookBook>() {
			public Predicate toPredicate(Root<CookBook> root,
					CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate = cb.conjunction();
				if (name != null) {
					predicate.getExpressions().add(
							cb.like(root.get("name").as(String.class),"%"+ name
									+ "%"));
				}
				return predicate;
			}
		};
		Page<CookBook> result = (Page<CookBook>) cookBookRepository.findAll(
				spec, pageRequest);
		return result;
	}

	public CookBook save(CookBook cookBook) {
		return cookBookRepository.save(cookBook);
	}

	public List<CookBook> findByUser(User user) {
		return cookBookRepository.findByUser(user);
	}

	public CookBook find(Long id) {
		return cookBookRepository.findOne(id);
	}

	public void delete(Long id) {
		CookBook cookBook=this.cookBookRepository.findOne(id);
		if(cookBook!=null){
			if(cookBook.getCookSteps()!=null)
			for(CookStep bean:cookBook.getCookSteps()){
				this.cookStepRepository.delete(bean);
			}
			if(cookBook.getCookFoods()!=null)
				for(CookFood bean:cookBook.getCookFoods()){
					this.cookFoodRepository.delete(bean);
				}
			
		}
		cookBookRepository.delete(id);
	}

	public List<CookBook> findHot() {
		return cookBookRepository.findAll(
				new PageRequest(0, 8, new Sort(Direction.DESC, "count")))
				.getContent();
	}

	public List<CookBook> findNew() {
		return cookBookRepository.findAll(
				new PageRequest(0, 8, new Sort(Direction.DESC, "createDate")))
				.getContent();
	}
	public List<CookBook> findByCategory( Category category) {
		return cookBookRepository.findByCategory(category);
	}
}