package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GameServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int you = Integer.parseInt(request.getParameter("you"));
		int com = (int)(Math.random() * 3) + 1;
		
		// System.out.println(you + ", " + com);
		request.setAttribute("you", choice(you));
		request.setAttribute("com", choice(com));
		request.setAttribute("result", check(you, com));
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/game/game_action.jsp");
		dispatcher.forward(request, response);
	}
	
	public String choice(int key) {
		switch(key) {
			case 1: return "가위";
			case 2: return "바위";
			case 3: return "보";
			default: return "에러";
		}
	}
	
	public String check(int you, int com) {
		if ((you == 1 && com == 3) ||
			(you == 2 && com == 1) ||
			(you == 3 && com == 2)) return "당신의 승리입니다.";
		else if (you == com) return "비겼습니다.";
		else return "당신의 패배입니다.";
//		switch(you) {
//			case 1:
//				if (com == 1) {
//					return "비겼습니다.";
//				} else if (com == 2) {
//					return "당신의 패배입니다.";
//				} else if (com == 3) {
//					return "당신의 승리입니다.";
//				}
//			case 2:
//				if (com == 1) {
//					return "당신의 패배입니다.";
//				} else if (com == 2) {
//					return "비겼습니다.";
//				} else if (com == 3) {
//					return "당신의 패배입니다.";
//				}	
//			case 3:
//				if (com == 1) {
//					return "당신의 패배입니다.";
//				} else if (com == 2) {
//					return "당신의 승리입니다.";
//				} else if (com == 3) {
//					return "비겼습니다.";
//				}
//			default:
//				return "에러입니다.";
//		}
	}
}
