package com.my.servlets.servlet;

import com.my.model.RegAbit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/reg_abiturient")
public class RegAbiturient extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("in_reg_doGet");
       /* request.setAttribute("message","request");
        request.getSession().setAttribute("message","session");
        getServletContext().setAttribute("message","servlet context");*/
        //session.getAttribute("email")
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().println(request.getSession().getAttribute("abitName")+" registred");
        //request.getRequestDispatcher("testprg.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        System.out.println("in_reg_doPost");

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String firstName = request.getParameter("first name");
        String lastName = request.getParameter("last name");
        String partonymic = request.getParameter("partonymic");
        String city = request.getParameter("city");
        String region = request.getParameter("region");
        String school = request.getParameter("school");
        int ukLang = Integer.valueOf(request.getParameter("uk lang"));
        int ukLiter = Integer.valueOf(request.getParameter("uk liter"));
        int eng = Integer.valueOf(request.getParameter("eng"));
        int algebra = Integer.valueOf(request.getParameter("algebra"));
        int informatics = Integer.valueOf(request.getParameter("informatics"));
        int geometry = Integer.valueOf(request.getParameter("geometry"));
        int ukHistory = Integer.valueOf(request.getParameter("uk history"));
        int phTraining = Integer.valueOf(request.getParameter("ph training"));
        int physics = Integer.valueOf(request.getParameter("physics"));
        int eieUkLang = Integer.valueOf(request.getParameter("eie uk lang"));
        int eieMath = Integer.valueOf(request.getParameter("eie math"));

        RegAbit.regAbit(email, password, firstName, lastName, partonymic, city, region, school, ukLang, ukLiter, eng, algebra,
                        informatics, geometry, ukHistory, phTraining, physics, eieUkLang, eieMath);

        final HttpSession session = request.getSession();
        session.removeAttribute("email");
        session.removeAttribute("isAdmin");
        session.setAttribute("abitName", firstName);
        response.sendRedirect("reg_abiturient");
    }
}