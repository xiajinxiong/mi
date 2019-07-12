package com.sure.mi;

import com.sure.mi.model.Overview;
import com.sure.mi.service.OverviewService;
import com.sure.mi.service.OverviewServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListServlet", urlPatterns = "/list")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        OverviewService overviewService = new OverviewServiceImpl();
        List<Overview> overviewList = overviewService.selectAllOverview();
        request.setAttribute("list", overviewList);
        System.out.println("overview+" + overviewList);
        request.getRequestDispatcher("liebiao.jsp").forward(request, response);
    }
}
