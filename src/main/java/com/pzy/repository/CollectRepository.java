package com.pzy.repository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.pzy.entity.Collect;
public interface CollectRepository extends PagingAndSortingRepository<Collect, Long>,JpaSpecificationExecutor<Collect>{
}

