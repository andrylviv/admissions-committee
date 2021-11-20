package com.my.servlets.servlet;

import com.my.db.FacultyDAO;
import com.my.db.UserDAO;
import com.my.db.UserInfoDAO;
import com.my.db.entity.Faculty;
import com.my.db.entity.User;
import com.my.db.entity.UserInfo;
import com.my.model.UserManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static java.util.Objects.nonNull;

@WebServlet("/list_user")
public class ListUserServ extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(ListUserServ.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Test#doGetList");
            resp.setContentType("text/html; charset=UTF-8");
        if (nonNull(req.getParameter("command")) && req.getParameter("command").equals("lou")) {
            //logger.debug("Hello, servlet!");

            req.setAttribute("usersInfo", UserManager.getUsersInfo());
            req.getRequestDispatcher("list_user.jsp").forward(req, resp);
        }
        if (nonNull(req.getParameter("command")) && req.getParameter("command").equals("userInfo")) {
           // req.setAttribute("usersInfo", UserManager.getUserInfo());
            int id = Integer.valueOf(req.getParameter("userId"));
            req.setAttribute("uInfo", UserManager.getUserIn(id));
            req.setAttribute("user", UserManager.getUser(id));
            req.getRequestDispatcher("user_info.jsp").forward(req, resp);
        }
        if (nonNull(req.getParameter("command")) && req.getParameter("command").equals("block")) {
            UserManager.stBlockFlag(Integer.valueOf(req.getParameter("id")),Integer.valueOf(req.getParameter("bf")));
            int id = Integer.valueOf(req.getParameter("id"));
            req.setAttribute("uInfo", UserManager.getUserIn(id));
            req.setAttribute("user", UserManager.getUser(id));
            req.getRequestDispatcher("user_info.jsp").forward(req, resp);
        }
    }
}