package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.BoardVO;

/*
 * 인터페이스 - XML 매칭
 */

public interface BoardMapper {
	public List<BoardVO> selectList();
	public BoardVO selectBoard(int bno);
	public int updateReadCnt(int bno);
	public int insertBoard(BoardVO board);
	public int updateBoard(BoardVO board);
	public int deleteBoard(int bno);
}
