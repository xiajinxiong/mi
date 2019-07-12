package com.sure.mi;

import com.google.gson.Gson;
import com.sure.mi.model.LogUpInfo;
import com.sure.mi.model.User;
import com.sure.mi.service.LogUpService;
import com.sure.mi.service.LogUpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet(name = "LogUpServlet", urlPatterns = "/logup")
public class LogUpServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        User user = gson.fromJson(request.getParameter("test"), User.class);
        String username = user.getUsername();
        String pword = user.getPword();
        String phone = user.getPhone();
        System.out.println("logupuser=" + user);
        LogUpService logUpService = new LogUpServiceImpl();
        int re = logUpService.logUp(new LogUpInfo(username, pword, phone));
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(String.valueOf(re));
        /*if (re == 0) {
            //注册成功
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        if (re == -1 || re == -2) {
            //用户名重复
            request.setAttribute("username", "duplicate");
        }
        if (re == -1 || re == -3) {
            //手机重复
            request.setAttribute("phone", "duplicate");
        }
        request.getRequestDispatcher("register.jsp").forward(request,  response);*/

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }
}
