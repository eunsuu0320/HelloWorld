package com.yedam.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 클래스가 서블릿이 되는 순서.
 * 상속을 받아야 함. - HttpServlet 상속받기 
 * 필요에 따라서 생성자도 선언 - ini(), service 는 반드시 있어야 함. 생성자 - init - service 순으로 작성.
 * 이 서블릿이 실행하기 위해선 url이 필요. url 등록(board.serv)
 */
@WebServlet("/board.serv")
public class BoardServlet extends HttpServlet{
	// 생성자 선언.
	public BoardServlet() {
		System.out.println("BoardServlet 생성자 호출.");
	}
	
	// init() 메소드.
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출.");
	}
	
	//service() 메소드
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("service 메소드 호출.");
	}
	
	
}
