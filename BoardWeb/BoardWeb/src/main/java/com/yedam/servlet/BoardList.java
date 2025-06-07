package com.yedam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/servlet/boardList.serv")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BoardList() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("hello");
		out.print("<p>안녕<p/>");
		
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList();
		
		out.print("<table border='1'>");
		out.print("<thead><tr><th>글번호</th><th>제목</th><th>내용</th><th>작성자</th></thead>");
		out.print("<tbody>");
		for (int i = 0; i < list.size(); i++) {
			out.print("<tr>");
			out.print("<td align = 'center'>" + list.get(i).getBoardNo() + "</td>");
			out.print("<td><a href='board.serv?bno=" + list.get(i).getBoardNo() + "'>" + list.get(i).getTitle() + "</a></td>");
			out.print("<td>" + list.get(i).getContent() + "</td>");
			out.print("<td>" + list.get(i).getWriter() + "</td>");
			out.print("</tr>");			
		}
		out.print("</tbody></table>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		out.print("<p><a href='../index.html'>인덱스 페이지</a><p/>");
		out.print("<a href='../html/addForm.html'>등록 페이지</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
