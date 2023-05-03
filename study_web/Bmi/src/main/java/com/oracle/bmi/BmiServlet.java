package com.oracle.bmi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "BmiServlet", value = "/bmi")
public class BmiServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        double height = Double.parseDouble(request.getParameter("height"));
        double weight = Double.parseDouble(request.getParameter("weight"));

        double pow = Math.pow((height / 100), 2);
        double bmi = weight / pow;

        // response.getWriter().println("키는 " + height + "cm, 몸무게 " + weight + "는 BMI " + bmi + "입니다.");

        request.setAttribute("height", height);
        request.setAttribute("weight", weight);
        request.setAttribute("bmi", String.format("%.2f", bmi));

        request.getRequestDispatcher("result.jsp").forward(request, response);
    }
}
