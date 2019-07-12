package com.sure.mi;

import com.google.gson.Gson;
import com.sure.mi.model.User;
import com.sure.mi.service.UserService;
import com.sure.mi.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = "/profile")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        User user = gson.fromJson(request.getParameter("test"), User.class);
        System.out.println("user:" + user);
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                user.setUsername(cookie.getValue());
                break;
            }
        }
        System.out.println(user);
        UserService userService = new UserServiceImpl();
        userService.updateUser(user);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            response.sendRedirect("login");
            return;
        }
        String username = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username") && cookie.getValue() != null
                    && !cookie.getValue().equals("")){
                username = cookie.getValue();
            }
        }
        if (username == null) {
            response.sendRedirect("login");
            return;
        }
        UserService userService = new UserServiceImpl();
        User user = userService.displayUserInfo(username);
        System.out.println("userinfo" + user);
        request.setAttribute("user", user);
        request.getRequestDispatcher("self_info.jsp").forward(request, response);
    }
}
