package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	public int insertReply(ReplyVO reply); // 추가
	public List<ReplyVO> selectReplyList(int bno); // 조회
	public ReplyVO selectReply(int rno); // 단건 조회
	public int removeReply(int rno); // 삭제
}
