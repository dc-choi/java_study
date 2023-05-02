package board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardDao;
import board.model.BoardDto;
import board.model.MemberDto;

public class BoardList extends AbstractController {
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto dto = (MemberDto)session.getAttribute("member");
		
		ModelAndView mav = new ModelAndView();
		if (dto == null) {
			mav.setViewName("/WEB-INF/board/result.jsp");
			mav.addObject("msg", "먼저 로그인해야 합니다.");
			mav.addObject("url", "Login.do");
		} else {
			String logInfo = dto.getName() + "(" + dto.getId() + ") 님이 로그인 하였습니다.";
			
			BoardDao dao = BoardDao.getInstance();
			List<BoardDto> list = dao.getBoardList();
			
			// for (BoardDto board : list) {
			//	System.out.println("board: " + board);
			// }
			
			mav.setViewName("/WEB-INF/board/list.jsp");
			mav.addObject("logInfo", logInfo);
			mav.addObject("list", list);
		}
		
		return mav;
	}
}
