package com.my.servlets.servlet;

import com.my.service.RegAbitFlty;
import com.my.service.UserManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Objects.nonNull;

@WebServlet("/reg_fty")
public class RegFtyServ extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (nonNull(req.getParameter("command")) && req.getParameter("command").equals("register")) {
            int facultyId = 0;
            if (nonNull(req.getParameter("facultyId")))
                facultyId = Integer.valueOf(req.getParameter("facultyId"));
            int eieUkLang = 0;
            if (nonNull(req.getParameter("eieUkLang")))
                eieUkLang = Integer.valueOf(req.getParameter("eieUkLang"));
            int eiePhysics = 0;
            if (nonNull(req.getParameter("eiePhysics")))
                eiePhysics = Integer.valueOf(req.getParameter("eiePhysics"));
            int eieMath = 0;
            if (nonNull(req.getParameter("eieMath")))
                eieMath = Integer.valueOf(req.getParameter("eieMath"));
            int userId = (int) req.getSession().getAttribute("id");
            boolean isValid = UserManager.regUserOnFaculty(userId, facultyId, eieUkLang, eieMath, eiePhysics);
            if (!isValid)
                resp.getWriter().println("invalid credentials");

            RegAbitFlty.regUserFlty(userId, facultyId);
            //req.getSession().setAttribute("facultyName", req.getParameter("facultyName"));
            resp.sendRedirect("list");
        }
        if (nonNull(req.getParameter("command")) && req.getParameter("command").equals("unregister")) {
            int facultyId = 0;
            if (nonNull(req.getParameter("id")))
                facultyId = Integer.valueOf(req.getParameter("id"));
            int userId = (int) req.getSession().getAttribute("id");
            RegAbitFlty.unRegUserFlty(userId, facultyId);
            resp.sendRedirect("list");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = (String) req.getSession().getAttribute("name");

        String nameJsp = (String) req.getSession().getAttribute("facultyName");
        resp.setContentType("text/html; charset=UTF-8");
        resp.getWriter()
                .println(userName+" registered on "+nameJsp);
    }
}