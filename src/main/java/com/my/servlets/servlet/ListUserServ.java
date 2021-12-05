package com.my.servlets.servlet;

import com.my.db.entity.UserInfo;
import com.my.service.UserManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static java.util.Objects.nonNull;

@WebServlet("/list_user")
public class ListUserServ extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(ListUserServ.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            resp.setContentType("text/html; charset=UTF-8");
        if (nonNull(req.getParameter("command")) && req.getParameter("command").equals("lou")) {
            int pp = 0;
            int p = 0;
            int pn = 0;
            int page = 0;
            if (!nonNull(req.getParameter("page"))){
                pp = 1;
                p =2;
                pn = 3;
                page = 1;
            }
            if (nonNull(req.getParameter("page"))){
                pp = Integer.valueOf(req.getParameter("page")) - 1;
                p = Integer.valueOf(req.getParameter("page"));
                pn = Integer.valueOf(req.getParameter("page")) +1;
                page = Integer.parseInt(req.getParameter("page"));
            }
            logger.debug(req.getParameter("page"));
            req.setAttribute("usersInfo", UserManager.getUsersInfo(page));
            req.setAttribute("pageP",pp);
            req.setAttribute("page",p);
            req.setAttribute("pageN",pn);
            req.getRequestDispatcher("list_user.jsp").forward(req, resp);
        }
        if (nonNull(req.getParameter("command")) && req.getParameter("command").equals("userInfo")) {
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
        if (nonNull(req.getParameter("command")) && req.getParameter("command").equals("listApplFaculty")) {
            List<UserInfo> userInfoList = UserManager.getApplicantFaculty(Integer.valueOf(req.getParameter("facultyId")));
            req.setAttribute("userInfoList", userInfoList);
            req.getRequestDispatcher("app_faculty_list.jsp").forward(req, resp);
        }
    }
}