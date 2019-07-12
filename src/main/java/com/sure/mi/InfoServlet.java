package com.sure.mi;

import com.google.gson.Gson;
import com.sure.mi.model.CartItem;
import com.sure.mi.model.Order;
import com.sure.mi.model.Product;
import com.sure.mi.model.User;
import com.sure.mi.service.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.io.IOException;

@WebServlet(name = "InfoServlet", urlPatterns = "/info")
public class InfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name_sub");
        String version = request.getParameter("version_sub");
        String color = request.getParameter("color_sub");
        Cookie[] cookies = request.getCookies();
        String username = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) {
                username = cookie.getValue();
                break;
            }
        }
        if (username == null) {
            response.sendRedirect("login");
        }
        else {
            String type = request.getParameter("cart_hi");
            if (type.equals("1")) {
                /*
                ////立即选购
                Order order = new Order(name, version, color, username, 1, 0, new Date());
                OrderService orderService = new OrderServiceImpl();
                orderService.placeOrder(order);
                response.sendRedirect("order");
                 */
            }
            else {
                //加入购物车
                Gson gson = new Gson();
                CartItem cartItem = gson.fromJson(request.getParameter("test"), CartItem.class);
                CartService cartService = new CartServiceImpl();
                cartService.addToCart(username, cartItem.getName(), cartItem.getVersion(), cartItem.getColor());
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("product");
        InfoService infoService = new InfoServiceImpl();
        Product product = infoService.searchInfo(name);
        System.out.println("product+" + product);
        request.setAttribute("info" , product);
        request.getRequestDispatcher("xiangqing.jsp").forward(request, response);
    }
}
