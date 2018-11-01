package com.cars.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cars.service.ReplyService;
import com.cars.vo.ReplyVo;

@RestController
@RequestMapping("/reply/*")
public class ReplyController {
	
	@Inject
	ReplyService service; 
	
	@RequestMapping(value="/getReply/{cno}", method=RequestMethod.GET)
	public List<ReplyVo> getReply(@PathVariable("cno") int cno) throws Exception{
		List<ReplyVo> list = service.getReply(cno);
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
