package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;
import board.model.BoardDto;

public class BoardView extends AbstractController {
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		Long no = Long.parseLong(request.getParameter("no"));
		BoardDao dao = BoardDao.getInstance();
		boolean result = dao.updateReadcount(no);
		
		ModelAndView mav = new ModelAndView();
		if (result) {
			BoardDto dto = dao.getBoardView(no);
			mav.setViewName("/WEB-INF/board/content.jsp");
			mav.addObject("dto", dto);
		} else {
			mav.setViewName("/WEB-INF/board/result.jsp");
			mav.addObject("msg", no +"번 글 이 존재하지않습니다...");
			mav.addObject("url", "javascript:history.back()");
		}
		
		return mav;
	}
}
