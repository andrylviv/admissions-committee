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

@WebServlet("/final_list")
public class FinalListServ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserInfo> userInfoStFounList = StatementManager.getStFondFinalList(Integer.valueOf(req.getParameter("id")));
        List<UserInfo> userInfoNonStFounList = StatementManager.getNonStFondFinalList(Integer.valueOf(req.getParameter("id")));
        req.setAttribute("finStF", userInfoStFounList);
        req.setAttribute("finNonStF", userInfoNonStFounList);
        req.getRequestDispatcher("final_list.jsp").forward(req, resp);
    }
}
