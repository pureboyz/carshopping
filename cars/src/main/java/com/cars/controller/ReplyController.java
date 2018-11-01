package com.cars.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cars.service.ReplyService;
import com.cars.vo.PageMaker;
import com.cars.vo.ReplyVo;

@RestController
@RequestMapping("/reply/*")
public class ReplyController {
	
	@Inject
	ReplyService service; 
	
	@RequestMapping(value="/getReply/{cno}", method=RequestMethod.GET)
	public List<ReplyVo> getReply(@PathVariable("cno") int cno, HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		PageMaker pageMaker = (PageMaker)session.getAttribute("replyPageMaker");
		pageMaker.setCno(cno);
		
		List<ReplyVo> list = service.getReply(pageMaker);
		return list;
	}
	
	@RequestMapping(value="/register", method= RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody ReplyVo replyVo){
		
		ResponseEntity<String> entity = null;
		
		try {
			service.register(replyVo);
			entity = new ResponseEntity<String>("SUCCESS",HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		
		return entity;
	}
	

}
