package com.yedam.service;
// 댓글 추가, 목록, 단건 조회, 삭제

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyService {
	public boolean addReply(ReplyVO reply); // 추가
	public List<ReplyVO> replyList(int bno, int page); //목록
	public ReplyVO getReply(int rno); // 단건조회
	public boolean removeReply(int rno); // 삭제
	public int totalCount(int bno); //댓글 건수
}
