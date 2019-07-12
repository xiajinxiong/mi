package com.sure.mi;

import com.google.gson.Gson;
import com.sure.mi.model.LogInInfo;
import com.sure.mi.model.User;
import com.sure.mi.service.LogInService;
import com.sure.mi.service.LogInServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogInServlet", urlPatterns = "/login")
public class LogInServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        User user = gson.fromJson(request.getParameter("test"), User.class);
        String username = user.getUsername();
        String pword = user.getPword();
        LogInService logInService = new LogInServiceImpl();
        boolean result = logInService.logIn(new LogInInfo(username, pword));
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        if (result) {
            request.getSession().setAttribute("username", username);
            Cookie[] cookies = request.getCookies();
            if (cookies == null) {
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(-1);
                response.addCookie(cookie);
                response.getWriter().write("s");
                return;
            }
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("username")) {
                    cookie.setValue(username);
                    response.addCookie(cookie);
                    response.getWriter().write("s");
                    return;
                }
            }
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(-1);
            response.addCookie(cookie);
            response.getWriter().write("s");
            return;
        }
        response.getWriter().write("n");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username") && cookie.getValue() != null
                    && !cookie.getValue().equals("")) {
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }
        }
        request.getRequestDispatcher("login.html").forward(request, response);
    }
}
