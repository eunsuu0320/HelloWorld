package com.yedam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/boardList.serv")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardList() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 컨텐츠 담고 있는 정보 지정.
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("hello");
		out.print("나는 한글");

		SqlSession sqlSession = DataSource.getInstance().openSession();
		// 인터페이스 - 매퍼.
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		// 목록가져오기
		List<BoardVO> list = mapper.selectList();

		out.print("<table border = '1'>");
		out.print("<thead><tr><th>글번호</th><th>제목</th><th>내용</th><th>작성자</th></tr></thead>");
		out.print("<tbody>");
		for (int i = 0; i < list.size(); i++) {
			out.print("<tr>");
			out.print("<td align='center>" + list.get(i).getBoardNo() + "</tb>");
			out.print("<td>" + list.get(i).getTitle() + "</tb>");
			out.print("<td>" + list.get(i).getContent() + "</tb>");
			out.print("<td>" + list.get(i).getWriter() + "</tb>");
			out.print("</tr>");
		}
		out.print("</tbody></table>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
