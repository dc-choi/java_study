package com.oraclejava.hellospringmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HelloControllerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object o) throws Exception {
        System.out.println("preHandle : 인터셉터 호출됨");
        HttpSession session = request.getSession();
        String id = (String) session.getAttribute("id");

        if (id == null) {
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }

        System.out.println("preHandle : " + id);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle 인터셉터 호출됨");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion 인터셉터 호출됨");
    }
}
