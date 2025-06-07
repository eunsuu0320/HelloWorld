package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardService {
 public List<BoardVO> boardList();
 public BoardVO getBoard(int bno);
 public boolean registerBoard(BoardVO board);
}
