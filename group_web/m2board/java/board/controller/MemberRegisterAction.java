package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.MemberDao;
import board.model.MemberDto;

public class MemberRegisterAction extends AbstractController {
	@Override
	public ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("user_id");
		String password = request.getParameter("user_pw");
		String name = request.getParameter("user_name");
		String birth = request.getParameter("user_birth");
		String phone = request.getParameter("user_phone");
		String zipcode = request.getParameter("zipcode");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		
		MemberDto dto = new MemberDto();
		dto.setId(id);
		dto.setPassword(password);
		dto.setName(name);
		dto.setBirth(birth);
		dto.setPhone(phone);
		dto.setZipcode(zipcode);
		dto.setAddress1(address1);
		dto.setAddress2(address2);
		
		// System.out.println(dto);
		
		MemberDao dao = MemberDao.getInstance();
		boolean result = dao.registerMember(dto);
		
		ModelAndView mav = new ModelAndView();
		if (result) {
			mav.setViewName("/WEB-INF/board/success.jsp");
			mav.addObject("dto", dto);
		} else {
			mav.setViewName("/WEB-INF/board/result.jsp");
			mav.addObject("msg", "회원 등록에 실패하였습니다.");
			mav.addObject("url", "javascript:history.back()");
		}
		
		return mav;
	}
}
