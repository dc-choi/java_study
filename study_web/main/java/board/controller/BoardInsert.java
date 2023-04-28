package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardInsert extends AbstractController {
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		// WEB-INF는 브라우저에서 직접 접근할 수 없다.
		// 이렇게 Servlet을 통해서 접근해야한다.
		return new ModelAndView("/WEB-INF/board/insert.jsp");
	}
}
