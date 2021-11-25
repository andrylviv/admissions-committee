package com.my.servlets.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Logout.
 * Delete session.
 */
public class Logout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        final HttpSession session = req.getSession();

        //session.removeAttribute("password");
        session.removeAttribute("email");
        session.removeAttribute("isAdmin");
        session.removeAttribute("faculties");
        //session.removeAttribute("lang");
        //session.invalidate();
        resp.sendRedirect(super.getServletContext().getContextPath());
       // resp.sendRedirect("login.jsp");
        // resp.sendRedirect("/");
    }

}