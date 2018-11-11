package com.cars.dao;

import java.util.List;

import com.cars.vo.PageMaker;
import com.cars.vo.ReplyVo;

public interface ReplyDao {

	List<ReplyVo> getReply(PageMaker pageMaker) throws Exception;

	void register(ReplyVo replyVo) throws Exception;

	int getTotalCount(int cno) throws Exception;

	void deleteReply(int rno) throws Exception;

	void modifyReply(ReplyVo replyVo) throws Exception;

}
