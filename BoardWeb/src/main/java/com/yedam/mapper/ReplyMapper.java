package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	public int insertReply(ReplyVO reply); // 추가
	public List<ReplyVO> selectReplyList(@Param("bno") int bno, @Param("page") int page); // 조회
	public ReplyVO selectReply(int rno); // 단건 조회
	public int removeReply(int rno); // 삭제
	public int selectTotal(int bno);
}
