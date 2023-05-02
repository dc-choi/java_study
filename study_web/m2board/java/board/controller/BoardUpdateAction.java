package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardDao;
import board.model.BoardDto;
import board.model.MemberDto;

public class BoardUpdateAction extends AbstractController {
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto auth = (MemberDto)session.getAttribute("member");
		ModelAndView mav = new ModelAndView();
		if (auth == null) {
			mav.setViewName("/WEB-INF/board/result.jsp");
			mav.addObject("msg", "먼저 로그인해야 합니다.");
			mav.addObject("url", "Login.do");
			return mav;
		}
		
		Long no = Long.parseLong(request.getParameter("no"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String id = auth.getId();
		
		MemberDto member = new MemberDto();
		member.setId(id);
		
		BoardDto board = new BoardDto();
		board.setNo(no);
		board.setTitle(title);
		board.setContent(content);
		board.setMemberDto(member);
		
		BoardDao dao = BoardDao.getInstance();
		boolean result = dao.updateBoard(board);
		
		if (result) {
			mav.setViewName("redirect:BoardView.do?no=" + board.getNo());
		} else {
			mav.setViewName("/WEB-INF/board/result.jsp");
			mav.addObject("msg", "글 수정 실패");
			mav.addObject("url", "javascript:history.back();");
			return mav;
		}
		
		return mav;
	}
}
