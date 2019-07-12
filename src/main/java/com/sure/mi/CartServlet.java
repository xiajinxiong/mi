package com.sure.mi;

import com.google.gson.Gson;
import com.sure.mi.model.CartItem;
import com.sure.mi.service.CartService;
import com.sure.mi.service.CartServiceImpl;
import com.sure.mi.util.UserNameUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "CartServlet", urlPatterns = "/cart")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("aaa");
        System.out.println(request.getPathInfo());
        if (request.getParameter("delete") != null) {
            dele(request, response);
            return;
        }
        if (request.getParameter("add") != null) {
            add(request, response);
            return;
        }
        if (request.getParameter("drop") != null) {
            drop(request, response);
            return;
        }
        String username = UserNameUtil.getUsername(request.getCookies());
        if (username == null) {
            response.sendRedirect("login");
        }
        Gson gson = new Gson();
        CartItem cartItem = gson.fromJson(request.getParameter("test"), CartItem.class);
        System.out.println("cartitem+" + cartItem);
        CartService cartService = new CartServiceImpl();
        cartService.addToCart(username, cartItem.getName(), cartItem.getVersion(), cartItem.getColor());

    }

    private void dele(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = UserNameUtil.getUsername(request.getCookies());
        if (username == null) {
            response.sendRedirect("login");
        }
        Gson gson = new Gson();
        CartItem cartItem = gson.fromJson(request.getParameter("test"), CartItem.class);
        CartService cartService = new CartServiceImpl();
        cartService.dropItem(username, cartItem.getName(), cartItem.getVersion(), cartItem.getColor());
    }

    private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = UserNameUtil.getUsername(request.getCookies());
        if (username == null) {
            response.sendRedirect("login");
        }
        Gson gson = new Gson();
        CartItem cartItem = gson.fromJson(request.getParameter("test"), CartItem.class);
        CartService cartService = new CartServiceImpl();
        cartService.addToCart(username, cartItem.getName(), cartItem.getVersion(), cartItem.getColor());
    }

    private void drop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = UserNameUtil.getUsername(request.getCookies());
        if (username == null) {
            response.sendRedirect("login");
        }
        Gson gson = new Gson();
        CartItem cartItem = gson.fromJson(request.getParameter("test"), CartItem.class);
        CartService cartService = new CartServiceImpl();
        cartService.dropCart(username, cartItem.getName(), cartItem.getVersion(), cartItem.getColor());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = UserNameUtil.getUsername(request.getCookies());
        if (username == null) {
            response.sendRedirect("login");
            return;
        }
        CartService cartService = new CartServiceImpl();
        List<CartItem> cartItems = cartService.displayItems(username);
        request.setAttribute("item", cartItems);
        if (request.getParameter("buy") != null && request.getParameter("buy").equals("1")) {
            String[] para = URLDecoder.decode(request.getQueryString(), StandardCharsets.UTF_8).split("&");
            request.setAttribute("name", para[1].split("=")[1]);
            request.setAttribute("version", para[2].split("=")[1]);
            //System.out.println("decode" + URLDecoder.decode(request.getParameter("version"), StandardCharsets.UTF_8.name()));
            request.setAttribute("color", para[3].split("=")[1]);
        }
        request.getRequestDispatcher("gouwuche.jsp").forward(request, response);
    }
}
