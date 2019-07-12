package com.sure.mi;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "ReturnServlet", urlPatterns = "/return_url")
public class ReturnServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> parameters = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        System.out.println("支付宝同步参数" + requestParams);
        for (Map.Entry<String, String[]> entry : requestParams.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            parameters.put(key, valueStr);
        }
        request.getRequestDispatcher("return_url.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> parameters = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        System.out.println("支付宝同步参数" + requestParams);
        for (Map.Entry<String, String[]> entry : requestParams.entrySet()) {
            String key = entry.getKey();
            String[] values = entry.getValue();
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            parameters.put(key, valueStr);
        }


        request.getRequestDispatcher("return_url.jsp").forward(request, response);

    }
}
