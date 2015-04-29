package com.pzy.repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pzy.entity.Category;
import com.pzy.entity.CookStep;
public interface CookStepRepository extends PagingAndSortingRepository<CookStep, Long>,JpaSpecificationExecutor<CookStep>{
    
}

