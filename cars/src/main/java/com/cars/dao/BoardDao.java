package com.cars.dao;

import java.util.List;

import com.cars.vo.BoardVo;

public interface BoardDao {

	List<BoardVo> boardList() throws Exception;

	BoardVo readPage(int bno) throws Exception;

	void viewCntUp(int bno) throws Exception;

	void writeBoard(BoardVo vo) throws Exception;

	void modify(BoardVo vo) throws Exception;

	void delete(int bNo) throws Exception;

	int getTotalCount() throws Exception;

}
