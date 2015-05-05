package com.pzy.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pzy.entity.Category;
import com.pzy.entity.CategorySub;
public interface CategorySubRepository extends PagingAndSortingRepository<CategorySub, Long>,JpaSpecificationExecutor<CategorySub>{
    public List<CategorySub> findByCategory(Category category);
}

