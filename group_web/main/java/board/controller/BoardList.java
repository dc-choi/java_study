package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.BoardDao;
import board.model.BoardDto;

public class BoardList extends AbstractController {
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		List<BoardDto> list = BoardDao.getInstance().getBoardList();
		return new ModelAndView("/WEB-INF/board/list.jsp", "list", list);
	}
}
