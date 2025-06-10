package com.yedam.control;

import java.io.IOException;
import java.net.URLEncoder;

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

		req.setCharacterEncoding("utf-8"); // 요청 파라미터를 올바르게 읽기 위해서 사용

		// 요청 방식에 따라 GET 요청이면 화면 open.
		// POST 요청이면 저장.
		String bno = req.getParameter("bno");
		String title = req.getParameter("title");
		String content = req.getParameter("content");

		// 추가 파라미터
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");

		BoardService svc = new BoardServiceImpl();

		if (req.getMethod().equals("GET")) {
			// 요청 재지정(페이지 이동) modifyBoard.do?bno=23
			BoardVO board = svc.getBoard(Integer.parseInt(bno));
			req.setAttribute("board", board);
			req.setAttribute("page", page);
			req.setAttribute("searchCondition", sc);
			req.setAttribute("keyword", kw);
			
			req.getRequestDispatcher("WEB-INF/jsp/modifyForm.jsp").forward(req, resp);

		} else if (req.getMethod().equals("POST")) {
			BoardVO board = svc.getBoard(Integer.parseInt(bno));
			board.setBoardNo(Integer.parseInt(bno));
			board.setTitle(title);
			board.setContent(content);

			svc.modifyBoard(board); // 수정
			
			
			// 목록페이지로 이동																	
			// 응답의 헤더에서 인코딩이 필요한 경우에 Location 같은 HTTP 헤더에는 ASCII 문자만 가능하기 때문에, 별도로 URL 인코딩을 해줘야 함
			resp.sendRedirect("boardList.do?page=" + page + "&searchCondition=" + sc + "&keyword=" + URLEncoder.encode(kw, "UTF-8"));
		}
	}

}
