package com.my.servlets.servlet;

import com.my.service.FacultyManager;
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
            if (nonNull(req.getParameter("command")) && (req.getParameter("command").equals("edit")|| req.getParameter("command").equals("add"))) {
                int id = 0;
                if (!(req.getParameter("facultyId")).equals(""))
                    id = Integer.valueOf(req.getParameter("facultyId"));
                System.out.println(req.getParameter("facultyId"));
                String name = req.getParameter("fname");
                int stfpl = Integer.valueOf(req.getParameter("stfpl"));
                int totpl = Integer.valueOf(req.getParameter("totpl"));
                String lang = req.getParameter("lang");
                int ukLang = 0;
                if (nonNull(req.getParameter("ukLang")))
                     ukLang = Integer.valueOf(req.getParameter("ukLang"));
                int math = 0;
                if (nonNull(req.getParameter("math")))
                     math = Integer.valueOf(req.getParameter("math"));
                int physics = 0;
                if (nonNull(req.getParameter("physics")))
                     physics = Integer.valueOf(req.getParameter("physics"));
                System.out.println(physics);
                if (req.getParameter("command").equals("edit")) {
                    if (stfpl>totpl) {
                        req.setAttribute("wrongCr",1);
                        req.getRequestDispatcher("/edit_faculty.jsp").forward(req, resp);
                    }
                    if (stfpl<=totpl) {
                        FacultyManager.updateFaculty(id, stfpl, totpl, name, lang, ukLang, math, physics);
                        req.setAttribute("wrongCr",0);
                        req.getSession().removeAttribute("faculties");
                        req.getRequestDispatcher("/list").forward(req, resp);
                    }
                }
                if (req.getParameter("command").equals("add")) {
                    if (stfpl>totpl) {
                        req.setAttribute("wrongCr",1);
                        req.getRequestDispatcher("/edit_faculty.jsp").forward(req, resp);
                    }
                    if (stfpl<=totpl) {
                        FacultyManager.addFaculty(stfpl, totpl, name, lang, ukLang, math, physics);
                        req.setAttribute("wrongCr",0);
                        req.getSession().removeAttribute("faculties");
                        req.getRequestDispatcher("/list").forward(req, resp);
                    }
                }
            }

            if (nonNull(req.getParameter("command")) && req.getParameter("command").equals("addLocale")) {
                int id = Integer.valueOf(req.getParameter("facultyId"));
                String name = req.getParameter("fname");
                String lang = req.getParameter("lang");
                FacultyManager.addFacultyLocal(id, name, lang);
                req.getSession().removeAttribute("faculties");
                req.getRequestDispatcher("/list").forward(req, resp);
            }

            if (nonNull(req.getParameter("command")) && req.getParameter("command").equals("remove")) {
                int id = Integer.valueOf(req.getParameter("facultyId"));
                FacultyManager.removeFaculty(id);
                req.getSession().removeAttribute("faculties");
                req.getRequestDispatcher("/list").forward(req, resp);
            }

        }
}
