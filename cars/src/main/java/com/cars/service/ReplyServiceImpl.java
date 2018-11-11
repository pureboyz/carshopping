package com.cars.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cars.dao.ReplyDao;
import com.cars.vo.PageMaker;
import com.cars.vo.ReplyVo;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Inject
	ReplyDao dao;
	
	@Override
	public List<ReplyVo> getReply(PageMaker pageMaker) throws Exception {
		return dao.getReply(pageMaker);
	}

	@Override
	public void register(ReplyVo replyVo) throws Exception {
		dao.register(replyVo);
	}

	@Override
	public void deleteReply(int rno) throws Exception {
		dao.deleteReply(rno);
	}

	@Override
	public void modifyReply(ReplyVo replyVo) throws Exception {
		dao.modifyReply(replyVo);
	}

	

}
