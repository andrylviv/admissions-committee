package com.my.servlets.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    @WebServlet("/lang_ch")
    public class LangCh extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String lang = req.getParameter("lang");
            String uriVal = req.getParameter("uriVal");
            req.getSession().setAttribute("lang", lang);
            req.getRequestDispatcher(uriVal).forward(req, resp);
        }
}
