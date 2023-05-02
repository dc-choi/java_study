package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardDao;
import board.model.BoardDto;
import board.model.MemberDto;

public class BoardView extends AbstractController {
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
		
		BoardDao dao = BoardDao.getInstance();
		
		if (dao.updateReadcount(no)) {
			BoardDto dto = dao.getBoardView(no);
			mav.setViewName("/WEB-INF/board/content.jsp");
			mav.addObject("dto", dto);
		} else {
			mav.setViewName("/WEB-INF/board/result.jsp");
			mav.addObject("msg", no + "번 게시물이 존재하지 않습니다.");
			mav.addObject("url", "BoardList.do");
		}
		
		return mav;
	}
}
