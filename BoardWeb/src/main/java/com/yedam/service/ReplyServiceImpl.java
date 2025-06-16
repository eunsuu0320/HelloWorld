	package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.ReplyMapper;
import com.yedam.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService {

	SqlSession sqlSession = DataSource.getInstance().openSession();
	ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
	
	@Override
	public boolean addReply(ReplyVO reply) {
		int r = mapper.insertReply(reply);
		if (r == 1) {
			sqlSession.commit();
			return true;
		} 
		return false;  
	}

	@Override
	public List<ReplyVO> replyList(int bno, int page) {
		return mapper.selectReplyList(bno, page);
	}

	@Override
	public ReplyVO getReply(int rno) {
		return mapper.selectReply(rno);
	}

	@Override
	public boolean removeReply(int rno) {
		int r = mapper.removeReply(rno);
		
		if (r == 1) {
			sqlSession.commit();
			return true;
		}
		return false;
	}


	@Override
	public int totalCount(int bno) {
		return mapper.selectTotal(bno);
	}

}
