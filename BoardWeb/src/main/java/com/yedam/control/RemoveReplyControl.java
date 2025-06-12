package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;

public class RemoveReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// rno을 삭제
		String rno = req.getParameter("rno");

		// 데이버테이스 입력 처리
		ReplyService svc = new ReplyServiceImpl();
		if (svc.removeReply(Integer.parseInt(rno))) {
			// {"retCoed" : "Success"
			resp.getWriter().print("{\"retCode\": \"Sussess\"}");
		} else {
			// {"retCode" : "Fail"}
			resp.getWriter().print("{\"retCode\": \"Sussess\"}");
		}

	}

}
