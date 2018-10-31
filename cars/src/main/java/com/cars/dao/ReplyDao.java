package com.cars.dao;

import java.util.List;

import com.cars.vo.ReplyVo;

public interface ReplyDao {

	List<ReplyVo> getReply(int cno) throws Exception;

	void register(ReplyVo replyVo) throws Exception;

}
