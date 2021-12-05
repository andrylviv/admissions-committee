package com.my.servlets.servlet;

import com.my.db.UserFacultyDAO;
import com.my.db.entity.Faculty;
import com.my.service.FacultyList;
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

import static java.util.Objects.nonNull;

@WebServlet("/list")
public class ListFucltyServ extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(ListFucltyServ.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (nonNull(req.getParameter("command")) && req.getParameter("command").equals("langchange")) {
            String lang = req.getParameter("lang");
            String uriVal = req.getParameter("uriVal");
            req.getSession().setAttribute("lang", lang);
            List<Faculty> faculties = FacultyList.getFacultyList(lang);
            String sortType = (String) req.getSession().getAttribute("sortType");
            if (nonNull(sortType))
                FacultyList.sortFaculty(faculties,sortType);
            req.getSession().setAttribute("faculties", faculties);
            resp.sendRedirect(uriVal);
        }
        if (nonNull(req.getParameter("command")) && req.getParameter("command").equals("sort")) {
            String sortType = req.getParameter("sortType");
            req.getSession().setAttribute("sortType", sortType);
            String uriVal = req.getParameter("uriVal");
            req.getSession().setAttribute("faculties",FacultyList.sortFaculty((List<Faculty>)req.getSession().getAttribute("faculties"),sortType));
            resp.sendRedirect(uriVal);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        logger.debug("page "+ req.getSession().getAttribute("page"));
        resp.setContentType("text/html; charset=UTF-8");
        String language = (String) req.getSession().getAttribute("lang");
        if (!nonNull(language)){
            language = "uk";
            req.getSession().setAttribute("lang", language);
        }
        List<Faculty> faculties = (List<Faculty>)req.getSession().getAttribute("faculties");
        if (!nonNull(faculties)) {
            faculties = FacultyList.getFacultyList(language);
            FacultyList.sortFaculty(faculties,"byName");
            req.getSession().setAttribute("sortType", "byName");
            req.getSession().setAttribute("faculties", faculties);
        }

        req.getSession().setAttribute("usfaculty",new UserFacultyDAO().getAppFaculty((Connection)req.getServletContext().getAttribute("conn")));

        req.getRequestDispatcher("list_faculty.jsp").forward(req,resp);
    }
}
