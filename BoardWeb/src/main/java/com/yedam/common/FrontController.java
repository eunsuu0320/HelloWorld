package com.yedam.common;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.yedam.control.BoardListControl;

/*
 * M-V-C
 * url패턴 - 실행서블릿 관리
 */
public class FrontController extends HttpServlet {
	Map<String, Control> map;		
	
	public FrontController() {
		map = new HashMap<String, Control>();
	}
	
	@override
	public void init(ServletConfig config) throws ServletException {
		// boardList.do - 글목록 출력 기능
		map.put("/boardList.do", new BoardListControl());
	}
}
