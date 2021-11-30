package com.my.servlets.servlet;

import com.my.model.Account;
import com.my.service.RegAbit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.io.IOException;
import java.util.Set;

@WebServlet("/reg_abiturient")
public class RegAbiturient extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(RegAbiturient.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        System.out.println("in_reg_doPost");
        Account account = new Account();

        account.setEmail(request.getParameter("email"));
        account.setPassword(request.getParameter("password"));
        account.setFirstName(request.getParameter("first name").trim());
        account.setLastName(request.getParameter("last name").trim());
        account.setPartonymic(request.getParameter("partonymic").trim());
        account.setCity(request.getParameter("city").trim());
        account.setRegion(request.getParameter("region").trim());
        account.setSchool(request.getParameter("school").trim());
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
        //-----------------------------
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        Set<ConstraintViolation<Account>> constraintViolations = validator.validate(account);
        if (!constraintViolations.isEmpty()) {
            String errors = "<ul>";
            for (ConstraintViolation<Account> constraintViolation : constraintViolations) {
                errors += "<li>" + constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage()
                        + "</li>";
            }
            errors += "</ul>";
            request.setAttribute("account", account);
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("reg_abiturient.jsp").forward(request, response);

        } else {
            final HttpSession session = request.getSession();
            session.setAttribute("account", account);
            //request.getRequestDispatcher("account/success.jsp").forward(request, response);
            //--------------------------
            RegAbit.regAbit(account);

            session.removeAttribute("email");
            session.removeAttribute("isAdmin");
            //session.setAttribute("abitName", account.getFirstName());
            response.sendRedirect("reg_abiturient");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.trace("in reg abiturient");
       /* request.setAttribute("message","request");
        request.getSession().setAttribute("message","session");
        getServletContext().setAttribute("message","servlet context");*/
        //session.getAttribute("email")
        response.setContentType("text/html; charset=UTF-8");
        //response.getWriter().println(request.getSession().getAttribute("abitName")+" registred");
        request.getRequestDispatcher("registered.jsp").forward(request,response);
    }
}