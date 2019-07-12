package com.sure.mi;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogOutServlet", urlPatterns = "/logout")
public class LogOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        if (cookies == null) {
            response.getWriter().write("n");
            return;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username") && cookie.getValue() != null &&
            !cookie.getValue().equals("")) {
                cookie.setValue(null);
                response.addCookie(cookie);
                response.getWriter().write("s");
                return;
            }
        }
        response.getWriter().write("n");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
