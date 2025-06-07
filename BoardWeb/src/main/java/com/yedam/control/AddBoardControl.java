package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.vo.BoardVO;

public class AddBoardControl implements Control{

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		
		// 요청방식 (GET, POST) 구분 처리
		if (req.getMethod().equals("GET")) {
			req.getRequestDispatcher("WEB-INF/jsp/addBoard.jsp").forward(req, resp);
		} else if (req.getMethod().equals("POST")) {
			String title = req.getParameter("title");
			String content = req.getParameter("content");
			String writer = req.getParameter("writer");
			
			BoardVO board = new BoardVO();
			board.setTitle(title);
			board.setContent(content);
			board.setWriter(writer);
			
			BoardService sve = new BoardServiceImpl();
			if (svc.registerBoard(board)) {
				System.out.println("등록 성공");
				// 목록 페이지로 이동
				// resp.sendRedirect("servlet/boardList.serv");
			} else {
				System.out.println("등록 실패");
			}
		}
	}

}
