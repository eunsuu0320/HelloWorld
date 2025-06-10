package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public interface BoardService {
 public List<BoardVO> boardList(SearchDTO search); // 목록조회
 public BoardVO getBoard(int bno); // 단건조회
 public boolean registerBoard(BoardVO board); // 등록가능
 public boolean modifyBoard(BoardVO board); // 수정기능
 public boolean removeBoard(int bno); // 삭제기능
 
 // 전체카운트 계산
 public int getTotalCount(SearchDTO search); // selectCount() : 매퍼쪽
}
