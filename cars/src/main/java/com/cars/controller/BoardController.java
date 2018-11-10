package com.cars.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cars.service.BoardService;
import com.cars.service.MemberService;
import com.cars.vo.BoardVo;
import com.cars.vo.MemberVo;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	
	@Inject
	BoardService service;
	
	@Inject
	MemberService mService;
	
	@RequestMapping(value="/boardList",method=RequestMethod.GET)
	public String boardList(Model model) throws Exception {
		List<BoardVo> boardList = service.boardList();
		
		model.addAttribute("boardList", boardList);
		return "/board/listPage";
	}
	
	/*
	//처음 새로고침 시 조회수 올라가는 상태
	@RequestMapping(value="/readPage",method=RequestMethod.GET)
	public String readPage(@RequestParam("bno")int bno,
			Model model) throws Exception{
		System.out.println("글번호 : " + bno);		
		service.viewCntUp(bno);
		BoardVo boardVo =  service.readPage(bno);
		model.addAttribute("boardVo", boardVo);
		System.out.println("readPage" + boardVo);//boardVo 확인
		return "/board/readPage";
	}*/
	
	
	//readPage readDetail로 분리하여 시도 실패
	@RequestMapping(value="/readPage",method=RequestMethod.GET)
	public String readPage(@RequestParam("bno")int bno,
			/*@ModelAttribute("boardVo") BoardVo boardVo,*/
			RedirectAttributes rttr /*Model model*/, HttpServletRequest request) throws Exception{		
		System.out.println("글번호 : " + bno);		
		service.viewCntUp(bno);
		
		/*BoardVo boardVo =  service.readPage(bno);
		model.addAttribute("boardVo", boardVo);*/
		
		rttr.addAttribute("bNo", bno);
		
		String message = (String) request.getAttribute("message");
		rttr.addFlashAttribute("message", message);
		
		
		/*rttr.addFlashAttribute("title", boardVo.getTitle());
		rttr.addFlashAttribute("content", boardVo.getContent());
		rttr.addFlashAttribute("writer", boardVo.getWriter());
		rttr.addFlashAttribute("mNo", boardVo.getmNo());
		rttr.addFlashAttribute("regDate", boardVo.getRegDate());
		rttr.addFlashAttribute("viewCnt", boardVo.getViewCnt());
		rttr.addFlashAttribute("bGrade", boardVo.getbGrade());*/		
		
//		System.out.println("readPage" + boardVo);//boardVo 확인		
//		return "/board/readPage";
//		return "redirect:/board/readPage?bno="+bno;
		return "redirect:/board/readDetail";
	}
	
	@RequestMapping(value="/readDetail", method=RequestMethod.GET)
	public String readDetail(/*@ModelAttribute("bno")int bno,*/
			@RequestParam("bNo")int bno,
			Model model) throws Exception {
		
		BoardVo boardVo = service.readPage(bno);
		model.addAttribute("boardVo", boardVo);
		
		System.out.println("readDetail" + boardVo);//boardVo 확인
		
		return "/board/readPage";
	}
	
	@RequestMapping(value="/write")
	public String write(Model model, HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		MemberVo vo = (MemberVo)session.getAttribute("loginMember");
		MemberVo memberVo = mService.getMember(vo.getmNo());
		model.addAttribute("memberVo", memberVo);
		return "board/writeBoard";
	}
	
	@RequestMapping(value="/writeBoard",method=RequestMethod.POST)
	public String writeBoard(@ModelAttribute("boardVo")BoardVo vo,
							RedirectAttributes rttr) throws Exception {
		System.out.println("writeBoard 확인 : " + vo);
		service.writeBoard(vo);
		rttr.addFlashAttribute("message", "글 작성 완료");
		
		return "redirect:/board/boardList";
	}
	
	@RequestMapping(value="/modify")
	public String modify(@RequestParam("bNo")int bNo, Model model) throws Exception {
		System.out.println("modify : " + bNo);
		model.addAttribute("boardVo", service.readPage(bNo));
		return "/board/modifyPage";
	}
	
	@RequestMapping(value="/modifyComplete",method=RequestMethod.POST)
	public String modifyComplete(BoardVo vo) throws Exception {
		System.out.println("수정된 내용" + vo);
		service.modify(vo);
		return "redirect:/board/boardList";
	}
	
	@RequestMapping(value="/delete")
	public String delete(@RequestParam("bNo")int bNo) throws Exception{		
		service.delete(bNo);
		return "redirect:/board/boardList";
	}
	
	
	
	
	
	
}
