package com.my.servlets.servlet;

import com.my.model.FacultyManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Objects.nonNull;

@WebServlet("/update_fty")
    public class FacultyServ extends HttpServlet {
        private static final Logger logger = LogManager.getLogger(com.my.servlets.servlet.ListUserServ.class);
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            if (nonNull(req.getParameter("command")) && req.getParameter("command").equals("edit")) {
                int id = Integer.valueOf(req.getParameter("facultyId"));
                String nName = req.getParameter("fname");
                int nStfpl = Integer.valueOf(req.getParameter("stfpl"));
                int nTotpl = Integer.valueOf(req.getParameter("totpl"));
                String lang = req.getParameter("lang");
                FacultyManager.updateFaculty(id, nStfpl, nTotpl, nName, lang);
                req.getSession().removeAttribute("faculties");
                req.getRequestDispatcher("/list").forward(req, resp);
            }
            if (nonNull(req.getParameter("command")) && req.getParameter("command").equals("add")) {
                String name = req.getParameter("fname");
                int stfpl = Integer.valueOf(req.getParameter("stfpl"));
                int totpl = Integer.valueOf(req.getParameter("totpl"));
                String lang = req.getParameter("lang");
                FacultyManager.addFaculty(stfpl, totpl, name, lang);
                req.getSession().removeAttribute("faculties");
                req.getRequestDispatcher("/list").forward(req, resp);
            }
            if (nonNull(req.getParameter("command")) && req.getParameter("command").equals("addLocale")) {
                int id = Integer.valueOf(req.getParameter("facultyId"));
                String name = req.getParameter("fname");
                String lang = req.getParameter("lang");
                FacultyManager.addFacultyLocal(id, name, lang);
                req.getSession().removeAttribute("faculties");
                req.getRequestDispatcher("/list").forward(req, resp);
            }
        }
}
