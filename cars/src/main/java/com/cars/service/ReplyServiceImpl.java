package com.cars.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cars.dao.ReplyDao;
import com.cars.vo.ReplyVo;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Inject
	ReplyDao dao;
	
	@Override
	public List<ReplyVo> getReply(int cno) throws Exception {
		return dao.getReply(cno);
	}

	@Override
	public void register(ReplyVo replyVo) throws Exception {
		dao.register(replyVo);
	}

	

}
