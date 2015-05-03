package com.pzy.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pzy.entity.CookBook;
import com.pzy.entity.User;
public interface CookBookRepository extends PagingAndSortingRepository<CookBook, Long>,JpaSpecificationExecutor<CookBook>{
	public List<CookBook> findByUser(User user);
}

