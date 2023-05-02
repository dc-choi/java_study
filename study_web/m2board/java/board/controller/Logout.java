package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import board.model.MemberDto;

public class Logout extends AbstractController {
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
			String logInfo = dto.getName() + "(" + dto.getId() + ") 님이 로그아웃 하였습니다.";
			mav.setViewName("/WEB-INF/board/result.jsp");
			mav.addObject("msg", logInfo);
			mav.addObject("url", "Login.do");
		}
		
		// 세션 종료
		session.invalidate();
		
		return mav;
	}
}
