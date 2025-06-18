package com.yedam.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.control.AddBoardControl;
import com.yedam.control.AddEventControl;
import com.yedam.control.AddReplyControl;
import com.yedam.control.AllControl;
import com.yedam.control.BoardControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.ChartControl;
import com.yedam.control.ChartPageControl;
import com.yedam.control.CheckControl;
import com.yedam.control.EventListControl;
import com.yedam.control.GetReplytControl;
import com.yedam.control.LoginControl;
import com.yedam.control.LoginFormControl;
import com.yedam.control.LogoutControl;
import com.yedam.control.MemberListControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.RemoveBoardControl;
import com.yedam.control.RemoveEventControl;
import com.yedam.control.RemoveReplyControl;
import com.yedam.control.ReplyCountControl;
import com.yedam.control.ReplyInfoControl;
import com.yedam.control.ReplyListControl;
import com.yedam.control.SignUpControl;

/*
 * M-V-C
 * url패턴 - 실행서블릿 관리
 */
public class FrontController extends HttpServlet {
	Map<String, Control> map;

	public FrontController() {
		map = new HashMap<String, Control>();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// boardList.do - 글목록 출력 기능
		// 처리순서가 중요
		map.put("/boardList.do", new BoardListControl());
		map.put("/board.do", new BoardControl()); // 상세화면.
		map.put("/addBoard.do", new AddBoardControl());
		map.put("/modifyBoard.do", new ModifyBoardControl()); // 수정화면
		map.put("/removeBoard.do", new RemoveBoardControl()); // 삭제화면 
		map.put("/chart.do", new ChartControl());
		map.put("/chartpage.do", new ChartPageControl());
		
		// 댓글 json파일
		map.put("/replyList.do", new ReplyListControl()); // 목록
		map.put("/addReply.do", new AddReplyControl()); // 등록
		map.put("/removeReply.do", new RemoveReplyControl()); // 삭제
		map.put("/getReply.do", new GetReplytControl()); // 단건조회
		map.put("/replyCount.do", new ReplyCountControl()); // 댓글건수.
		map.put("/replyInfo.do", new ReplyInfoControl());
		
		// member관련
		map.put("/loginForm.do", new LoginFormControl()); // 화면
		map.put("/login.do", new LoginControl()); // id, pw 로그인 처리
		map.put("/logout.do", new LogoutControl()); // 로그아웃
		map.put("/signup.do", new SignUpControl());
		map.put("/checkId.do", new CheckControl());
		
		//회원목록
		map.put("/memberList.do", new MemberListControl());
		
		// 이벤트
		map.put("/eventList.do", new EventListControl());
		map.put("/addEvent.do", new AddEventControl());
		map.put("/removeEvent.do", new RemoveEventControl());
		
		// 연습
		map.put("/allproduct.do", new AllControl());
	}

	@Override
	public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// url이 호출(http://localhost:8080/BoardWeb/boardList.do) -> 페이지 호출 -> Control.
				String uri = req.getRequestURI(); // /BoardWeb/boardList.do
				String context = req.getContextPath(); // BoardWeb or Helloworld
				String page = uri.substring(context.length()); // /boardList.do
				Control sub = map.get(page);
				sub.exec(req, resp);
	}
}
