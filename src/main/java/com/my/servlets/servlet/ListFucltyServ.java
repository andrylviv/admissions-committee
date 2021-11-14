package com.my.servlets.servlet;

import com.my.db.FacultyDAO;
import com.my.db.entity.Faculty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/list")
public class ListFucltyServ extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(ListFucltyServ.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Test#doGetList");

        logger.debug("Hello, servlet!");
        resp.setContentType("text/html; charset=UTF-8");
        final Connection conn = (Connection) req.getServletContext().getAttribute("conn");
        List<Faculty> faculties = new FacultyDAO().findAllFaculty(conn,"uk");
        req.setAttribute("faculties", faculties);
        req.getRequestDispatcher("list_fuculty.jsp").forward(req,resp);

    }
}
