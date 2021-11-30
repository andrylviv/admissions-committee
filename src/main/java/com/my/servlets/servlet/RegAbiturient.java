package com.my.servlets.servlet;

import com.my.model.Account;
import com.my.service.RegAbit;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        System.out.println("in_reg_doPost");
        Account account = new Account();

        account.setEmail(request.getParameter("email"));
        account.setPassword(request.getParameter("password"));
        account.setFirstName(request.getParameter("first name"));
        account.setLastName(request.getParameter("last name"));
        account.setPartonymic(request.getParameter("partonymic"));
        account.setCity(request.getParameter("city"));
        account.setRegion(request.getParameter("region"));
        account.setSchool(request.getParameter("school"));
        account.setUkLang(Integer.valueOf(request.getParameter("uk lang")));
        account.setUkLiter(Integer.valueOf(request.getParameter("uk liter")));
        account.setEng(Integer.valueOf(request.getParameter("eng")));
        account.setAlgebra(Integer.valueOf(request.getParameter("algebra")));
        account.setInformatics(Integer.valueOf(request.getParameter("informatics")));
        account.setGeometry(Integer.valueOf(request.getParameter("geometry")));
        account.setUkHistory(Integer.valueOf(request.getParameter("uk history")));
        account.setPhTraining(Integer.valueOf(request.getParameter("ph training")));
        account.setPhysics(Integer.valueOf(request.getParameter("physics")));
       /* int eieUkLang = Integer.valueOf(request.getParameter("eie uk lang"));
        int eieMath = Integer.valueOf(request.getParameter("eie math"));*/

        RegAbit.regAbit(account);

        final HttpSession session = request.getSession();
        session.removeAttribute("email");
        session.removeAttribute("isAdmin");
        session.setAttribute("abitName", account.getFirstName());
        response.sendRedirect("reg_abiturient");
    }

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
}