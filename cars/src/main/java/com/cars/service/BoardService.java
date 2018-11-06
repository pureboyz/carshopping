package com.cars.service;

import java.util.List;

import com.cars.vo.BoardVo;

public interface BoardService {

	List<BoardVo> boardList() throws Exception;

	BoardVo readPage(int bno) throws Exception;

	void viewCntUp(int bno) throws Exception;

}