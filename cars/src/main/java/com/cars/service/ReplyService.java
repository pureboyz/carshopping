package com.cars.service;

import java.util.List;

import com.cars.vo.PageMaker;
import com.cars.vo.ReplyVo;

public interface ReplyService {

	List<ReplyVo> getReply(PageMaker pageMaker) throws Exception;

	void register(ReplyVo replyVo) throws Exception;

	

}
