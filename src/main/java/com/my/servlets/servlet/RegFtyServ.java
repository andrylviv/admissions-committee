package com.my.servlets.servlet;

import com.my.model.RegAbitFlty;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/reg_fty")
public class RegFtyServ extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = (int)req.getSession().getAttribute("id");
        String userName = (String) req.getSession().getAttribute("email");
        String idJsp = req.getParameter("id");
        String nameJsp = req.getParameter("name");
        RegAbitFlty.regUserFlty(userId,Integer.valueOf(idJsp));
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter()
                .println(userName+" registered on "+nameJsp);
    }
}