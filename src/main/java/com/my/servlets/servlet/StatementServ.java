package com.my.servlets.servlet;

import com.my.model.StatementManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/statement")
public class StatementServ extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StatementManager.addApplicantToStatement(Integer.valueOf(req.getParameter("id")));
        req.getSession().setAttribute("faName",req.getParameter("name"));
        resp.sendRedirect("statement");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter().println(req.getSession().getAttribute("faName")+" added");
    }
}
