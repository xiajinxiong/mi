package com.sure.mi;

import com.sure.mi.model.Transaction;
import com.sure.mi.service.TransactionService;
import com.sure.mi.service.TransactionServiceImpl;
import com.sure.mi.util.UserNameUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderServlet", urlPatterns = "/order")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = UserNameUtil.getUsername(request.getCookies());
        if (username == null) {
            response.sendRedirect("login");
            return;
        }
        TransactionService transactionService = new TransactionServiceImpl();
        List<Transaction> transactions = transactionService.displayTransactions(username);
        System.out.println("transactions" + transactions);
        request.setAttribute("transaction", transactions);
        request.getRequestDispatcher("dingdanzhongxin.jsp").forward(request, response);
    }
}
