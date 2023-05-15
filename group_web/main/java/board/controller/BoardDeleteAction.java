package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;
import board.model.BoardDto;

public class BoardDeleteAction extends AbstractController {
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		Long no = Long.parseLong(request.getParameter("no"));
		String password = request.getParameter("password");
		
		BoardDto board = new BoardDto();
		board.setNo(no);
		board.setPassword(password);
		
		boolean result = BoardDao.getInstance().deleteBoard(board);
		
		ModelAndView mav = new ModelAndView("/WEB-INF/board/result.jsp");
		if (result) {
			mav.addObject("msg", "글 삭제 성공하였습니다.");
			mav.addObject("url", "BoardList.do");
		} else {
			mav.addObject("msg", "글 삭제에 실패하였습니다.");
			mav.addObject("url", "javascript:history.back()");
		}
		
		return mav;
	}
}
