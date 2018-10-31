package com.cars.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cars.service.ReplyService;
import com.cars.vo.MemberVo;
import com.cars.vo.ReplyVo;

@Controller
@RequestMapping("/reply/*")
public class ReplyController {
	
	@Inject
	ReplyService service; 
	
	@RequestMapping(value="/getReply/{cno}", method=RequestMethod.GET)
	@ResponseBody
	public List<ReplyVo> getReply(@PathVariable("cno") int cno) throws Exception{
		List<ReplyVo> list = service.getReply(cno);
		return list;
	}
	
	@RequestMapping(value="/register")
	public void register(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		MemberVo vo = (MemberVo)session.getAttribute("loginMember");
		
		int carNo = Integer.parseInt(request.getParameter("carNo"));
		String comment = request.getParameter("comment");
		String auth = vo.getmName();
		
		ReplyVo replyVo = new ReplyVo();
		replyVo.setAuth(auth);
		replyVo.setCno(carNo);
		replyVo.setComment(comment);
		
		service.register(replyVo);
	}
	

}
