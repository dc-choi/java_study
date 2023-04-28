package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Iam extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		Integer age = Integer.parseInt(request.getParameter("age"));
		
//		System.out.println("name: " + name + ", age: " + age);
		String iam = say(name, age);
		
		request.setAttribute("iam", iam);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ajax01/iam2.jsp");
		dispatcher.forward(request, response);
	}

	private String say(String name, Integer age) {
		return "그래 난 " + name + ". 나이는" + age + "살이야.";
	}
}
