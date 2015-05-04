package com.pzy.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.pzy.entity.Category;
import com.pzy.entity.MsgBoard;
import com.pzy.entity.User;
public interface MsgBoardRepository extends PagingAndSortingRepository<MsgBoard, Long>,JpaSpecificationExecutor<MsgBoard>{
	public List<MsgBoard> findByUser(User user);
}

