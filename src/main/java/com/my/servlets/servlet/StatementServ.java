package com.my.servlets.servlet;

import com.my.db.entity.UserInfo;
import com.my.model.StatementManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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
        if (nonNull(req.getParameter("command")) && req.getParameter("command").equals("delete")) {
            StatementManager.removeFromStatement(Integer.valueOf(req.getParameter("userId")));

            req.getSession().setAttribute("comS", "getList");
            if (!req.getParameter("fId").equals(""))
                req.getSession().setAttribute("faculSid",req.getParameter("fId"));
            req.getSession().removeAttribute("com");
            //req.getSession().removeAttribute("fin");
            resp.sendRedirect("statement");
            //req.getRequestDispatcher("statement").forward(req,resp);
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
        if (nonNull(req.getParameter("com")) && req.getParameter("com").equals("getList")) {
            List<UserInfo> userInfoList = StatementManager.getFacultyApplicantList(Integer.valueOf(req.getParameter("id")));
            exec(req,resp,userInfoList);
        }
        if (nonNull(req.getSession().getAttribute("comS")) && req.getSession().getAttribute("comS").equals("getList")) {
            List<UserInfo> userInfoList = StatementManager.getFacultyApplicantList(Integer.valueOf((String) req.getSession().getAttribute("faculSid")));
            req.getSession().removeAttribute("comS");
            exec(req,resp,userInfoList);
        }
    }
        void exec(HttpServletRequest req, HttpServletResponse resp,List<UserInfo> userInfoList){
        System.out.println("inGL");

            req.getSession().setAttribute("userInfoList", userInfoList);
            try {
                req.getRequestDispatcher("applicant_list.jsp").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
