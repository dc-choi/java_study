package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;
import board.model.BoardDto;

public class BoardInsertAction extends AbstractController {
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String content = request.getParameter("content");
		
		BoardDto board = new BoardDto();
		board.setTitle(title);
		board.setName(name);
		board.setPassword(password);
		board.setContent(content);
		
		boolean result = BoardDao.getInstance().insertBoard(board);
		
		ModelAndView mav = new ModelAndView();
		if (result) {
			mav.setViewName("redirect:BoardList.do");
		} else {
			mav.setViewName("/WEB-INF/board/result.jsp");
			mav.addObject("msg", "글 등록에 실패하였습니다.");
			mav.addObject("url", "javascript:history.back()");
		}
		
		return mav;
	}
}
