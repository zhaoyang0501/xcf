
package com.pzy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pzy.entity.MsgBoard;
import com.pzy.entity.User;
import com.pzy.repository.MsgBoardRepository;

@Service
public class MsgCategoryService {
	@Autowired
    private MsgBoardRepository msgBoardRepository;
	
	public MsgBoard save(MsgBoard msgBoard){
		return msgBoardRepository.save(msgBoard);
	}
	public void delete(MsgBoard msgBoard){
		 msgBoardRepository.delete(msgBoard);
	}
	public List<MsgBoard> findByUser(User user){
		return msgBoardRepository.findByUser(user);
	}
}