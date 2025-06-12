package com.yedam.common;

import java.util.List;

import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class appTest {
	public static void main(String[] args) {
		ReplyService svc = new ReplyServiceImpl();
		
		// 인서트
		ReplyVO reply = new ReplyVO();
		reply.setBoardNo(1302);
		reply.setReply("아 세상에 마상에 집 가고 싶다");
		reply.setReplyer("아무개");
		svc.addReply(reply);
		
		//목록
		List<ReplyVO> list = svc.replyList(1302);
		for (ReplyVO rep : list) {
			System.out.println(rep.toString());
		}
		
		//단건조회
		reply = svc.getReply(3);
		System.out.println(reply.toString());
		
		//삭제
		svc.removeReply(3);
	}
}
