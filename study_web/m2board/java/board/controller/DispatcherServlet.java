package board.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {
	private Map<String, AbstractController> actionMap = new HashMap<String, AbstractController>();
	
	/**
	 * Servlet 객체가 실행될 때 자동으로 실행되는 메서드
	 * 요청 URL에 따라 객체를 계속 생성해주는 부분을 막기 위해서 선언한다.
	 */
	@Override
	public void init() throws ServletException {
		String path = this.getClass().getResource("dispatcher.properties").getPath();
		Properties props = new Properties();
		FileInputStream stream = null;
		
		try {
			stream = new FileInputStream(path);
			props.load(stream);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stream != null) try { stream.close(); } catch(Exception e) {}
		}
		
		// props를 반복하면서 객체를 추가한다.
		for (Object obj : props.keySet()) {
			String key = ((String)obj).trim();
			String value = props.getProperty(key).trim();
			
			try {
				// 각 value의 값을 참조한다.
				Class<?> actionClass = Class.forName(value);
				// value의 값을 가져온 값으로 선언한다.
				AbstractController controller = (AbstractController) actionClass.getConstructor().newInstance();
				actionMap.put(key, controller);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String requestURI = request.getRequestURI();
		// request.getContextPath()는 기본 컨텍스트 경로(/webdev)에 해당하는 부분이다.
		String action = requestURI.substring(request.getContextPath().length());
		
		// 추상화된 부분
		AbstractController controller = actionMap.get(action.trim());
		ModelAndView mav = controller.handleRequestInternal(request, response);

		if (mav != null) {
			String viewName = mav.getViewName();
			if (viewName.startsWith("redirect:")) {
				response.sendRedirect(viewName.substring("redirect:".length()));
				return;
			}
			
			Map<String, Object> model = mav.getModel();
			for (String key : model.keySet()) {
				request.setAttribute(key, model.get(key));
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
			dispatcher.forward(request, response);
		} else {
			// 500 처리하기...
			System.out.println("서버 오류...");
		}
	}
}
