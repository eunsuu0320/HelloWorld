package com.yedam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

/*
 * 
 */

@WebServlet("/servlet/board.serv")
public class BoardServlet extends HttpServlet {
	
	public BoardServlet() {
		System.out.println("BoardServlet 생성자 호출");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출");
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("service 메소드 호출");
		resp.setContentType("text/html;charset=utf-8");
		
		String boardNo = req.getParameter("bno");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		BoardService svc = new BoardServiceImpl();
		BoardVO board = svc.getBoard(Integer.parseInt(boardNo));
		
		String str = "";
		str += "<table border = '1'>";
		str += "<tbody>";
		str += "<tr><th>글번호</th><td>" + board.getBoardNo() + "</td><th>조회수</th><td>" + board.getReadCnt() + "</td></tr>";
		str += "<tr><th>제목</th><td colspan = '3'>" + board.getTitle() + "</td></tr>";
		str += "<tr><th>내용</th><td colspan = '3'>" + board.getContent() + "</td></tr>";
		str += "<tr><th>작성자</th><td colspan = '3'>" + board.getWriter() + "</td></tr>";
		str += "<tr><th>작성일시</th><td colspan = '3'>" + sdf.format(board.getWriteDate()) + "</td></tr>";
		str += "</tbody>";
		str	+= "</table>";
		
		PrintWriter out = resp.getWriter();
		out.print(str);
	}
}
