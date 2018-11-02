package com.cars.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.cars.dao.BoardDao;
import com.cars.vo.BoardVo;

@Service
public class BoardServiceImpl implements BoardService{

	@Inject
	BoardDao dao;
	
	@Override
	public List<BoardVo> boardList() throws Exception {
		
		return dao.boardList();
	}

	@Override
	public BoardVo readPage(int bno) throws Exception {
		return dao.readPage(bno);
	}

	@Override
	public void viewCntUp(int bno) throws Exception {
		dao.viewCntUp(bno);		
	}

	
	
	
	

}
