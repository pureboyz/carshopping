package com.cars.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cars.service.BoardService;
import com.cars.vo.BoardVo;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	BoardService service;
	
	@RequestMapping(value="/boardList",method=RequestMethod.GET)
	public String boardList(Model model) throws Exception {
		List<BoardVo> boardList = service.boardList();
		
		model.addAttribute("boardList", boardList);
		return "/board/boardList";
	}
	
	@RequestMapping(value="/readPage",method=RequestMethod.GET)
	public String readPage(@RequestParam("bno")int bno,/*RedirectAttributes rttr*/ Model model) throws Exception{
		
		System.out.println("글번호 : " + bno);
		
		service.viewCntUp(bno);
		BoardVo boardVo =  service.readPage(bno);
		
		model.addAttribute("boardVo", boardVo);		
		/*
		rttr.addFlashAttribute("bNo", boardVo.getbNo());
		rttr.addFlashAttribute("title", boardVo.getTitle());
		rttr.addFlashAttribute("content", boardVo.getContent());
		rttr.addFlashAttribute("writer", boardVo.getWriter());
		rttr.addFlashAttribute("mNo", boardVo.getmNo());
		rttr.addFlashAttribute("regDate", boardVo.getRegDate());
		rttr.addFlashAttribute("viewCnt", boardVo.getViewCnt());
		rttr.addFlashAttribute("bGrade", boardVo.getbGrade());		
		*/
		System.out.println(boardVo);//boardVo 확인
		
		return "/board/readPage";
		//return "redirect:/board/readPage?bno="+bno;
	}
	
}
