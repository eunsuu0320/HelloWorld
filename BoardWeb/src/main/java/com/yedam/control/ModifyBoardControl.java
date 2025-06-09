package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8"); // 한글 처리
		
		// 요청 방식에 따라 GET 요청이면 화면 open.
		//POST 요청이면 저장.
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		BoardService svc = new BoardServiceImpl();
		
		if (req.getMethod().equals("GET")) {
			// 요청 재지정(페이지 이동) modifyBoard.do?bno=23
			BoardVO board = svc.getBoard(Integer.parseInt(bno));
			board.setBoardNo(Integer.parseInt(bno));
			board.setTitle(title);
			board.setContent(content);
			
			svc.modifyBoard(board); // 수정
			
			// 목록페이지로 이동
			resp.sendRedirect("boardList.do");
		}
	}

}
