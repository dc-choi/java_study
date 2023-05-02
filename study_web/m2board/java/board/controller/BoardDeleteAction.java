package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.BoardDao;
import board.model.BoardDto;
import board.model.MemberDto;

public class BoardDeleteAction extends AbstractController {
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MemberDto auth = (MemberDto)session.getAttribute("member");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/WEB-INF/board/result.jsp");
		if (auth == null) {
			mav.addObject("msg", "먼저 로그인해야 합니다.");
			mav.addObject("url", "Login.do");
			return mav;
		}
		
		Long no = Long.parseLong(request.getParameter("no"));
		String id = auth.getId();
		
		MemberDto member = new MemberDto();
		member.setId(id);
		
		BoardDto board = new BoardDto();
		board.setNo(no);
		board.setMemberDto(member);
		
		BoardDao dao = BoardDao.getInstance();
		boolean result = dao.deleteBoard(board);
		
		if (result) {
			mav.addObject("msg", no + "번 글 삭제 성공");
			mav.addObject("url", "BoardList.do");
		} else {
			mav.addObject("msg", "글 삭제를 하는데 실패하였습니다.");
			mav.addObject("url", "javascript:history.back();");
		}
		
		return mav;
	}
}
