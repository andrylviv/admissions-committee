package com.my.servlets.servlet;

import com.my.db.FacultyDAO;
import com.my.db.UserDAO;
import com.my.db.UserInfoDAO;
import com.my.db.entity.Faculty;
import com.my.db.entity.User;
import com.my.db.entity.UserInfo;
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

@WebServlet("/list_user")
public class ListUserServ extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(ListUserServ.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Test#doGetList");

        //logger.debug("Hello, servlet!");
        resp.setContentType("text/html; charset=UTF-8");
        final Connection conn = (Connection) req.getServletContext().getAttribute("conn");
        List<UserInfo> usersInfo = new UserInfoDAO().getUserInf(conn);
        /*try {
            conn.close();
        } catch (SQLException e) {//refactor
            e.printStackTrace();
        }*/
        req.setAttribute("usersInfo", usersInfo);
        req.getRequestDispatcher("list_user.jsp").forward(req,resp);

    }
}