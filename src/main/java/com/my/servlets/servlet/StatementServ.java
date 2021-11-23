package com.my.servlets.servlet;

import com.my.model.StatementManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Objects.nonNull;

@WebServlet("/statement")
public class StatementServ extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (nonNull(req.getParameter("command")) && req.getParameter("command").equals("ats")) {
            StatementManager.addApplicantToStatement(Integer.valueOf(req.getParameter("id")));
            req.getSession().setAttribute("faName", req.getParameter("name"));
            req.getSession().setAttribute("com", "ats");
            resp.sendRedirect("statement");
        }
        if (nonNull(req.getParameter("command")) && req.getParameter("command").equals("fin")) {
            StatementManager.finaliseStatement();
            req.getSession().setAttribute("com", "fin");
            resp.sendRedirect("statement");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (nonNull(req.getSession().getAttribute("com")) && req.getSession().getAttribute("com").equals("ats")) {
            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().println(req.getSession().getAttribute("faName") + " added");
        }
        if (nonNull(req.getSession().getAttribute("com")) && req.getSession().getAttribute("com").equals("fin")) {
            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter().println("finalised");
        }
    }
}
