package com.my.servlets.filter;

import com.my.db.UserDAO;
import com.my.db.UserInfoDAO;
import com.my.db.entity.User;
import com.my.model.Password;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;

import static java.util.Objects.nonNull;

/**
 * Acidification filter.
 */
@WebFilter("/*")
public class AuOuFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain chain) throws IOException, ServletException {

        request.setCharacterEncoding("UTF-8");
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final String email = req.getParameter("email");
        String passwordTemp = req.getParameter("password");
        String password = "";
        try {
            if(passwordTemp!=null)
                password = Password.hash(passwordTemp);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        final Connection conn = (Connection) req.getServletContext().getAttribute("conn");

        final HttpSession session = req.getSession();

        if (req.getServletPath().equals("/reg_abiturient.jsp")){
           // req.getRequestDispatcher("reg_abiturient.jsp").forward(request, response);

           /* session.removeAttribute("email");
            session.removeAttribute("isAdmin");*/
            chain.doFilter(request, response);
        }
       /* System.out.println(req.getServletPath());
        System.out.println(req.getRequestURL());
        System.out.println(req.getServletPath());*/
        if (req.getServletPath().equals("/reg_abiturient")){

           /* session.removeAttribute("email");
            session.removeAttribute("isAdmin");*/
            req.getRequestDispatcher("reg_abiturient").forward(request, response);
        }

        if (req.getServletPath().equals("/lang_ch")){

           /* session.removeAttribute("email");
            session.removeAttribute("isAdmin");*/
            req.getRequestDispatcher("lang_ch").forward(request, response);
        }

        //Logged user.
        if (nonNull(session) &&
            nonNull(session.getAttribute("email"))
            //&& nonNull(session.getAttribute("password"))
        ) {

            final int isAdmin = (int) session.getAttribute("isAdmin");
            System.out.println(isAdmin+"l");
           // moveTo(req, res, isAdmin);
            chain.doFilter(request, response);

        } else if (new UserDAO().ifUserExist(conn,email, password)) {

            User us = new UserDAO().getUser(conn,email, password);
            final int isAdmin = us.getIsAdmin();
            final int id = us.getId();
            final int isBlocked = us.getIsBlocked();

            String name = new UserInfoDAO().getUserName(conn,id);
            System.out.println(isAdmin+"iex");
            //req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("email", email);
            req.getSession().setAttribute("isAdmin", isAdmin);
            req.getSession().setAttribute("id", id);
            req.getSession().setAttribute("name", name);
            req.getSession().setAttribute("isBlocked", isBlocked);

           /* if (req.getServletPath().equals("/reg_abiturient")){
                req.getRequestDispatcher("reg_abiturient").forward(request, response);// after registr for PRG work
            }*/
            if(!response.isCommitted())
            {
                moveTo(req, res, isAdmin);
            }


        } else if (!req.getServletPath().equals("/reg_abiturient")
                 &&!req.getServletPath().equals("/reg_abiturient.jsp")
                 &&!req.getServletPath().equals("/lang_ch")){
            System.out.println(-1+"aouf");
            moveTo(req, res, -1);
        }
    }

    /**
     * Move user to menu.
     * If access 'admin' move to admin menu.
     * If access 'applicant' move to user menu.
     */
    private void moveTo(final HttpServletRequest req,
                        final HttpServletResponse res,
                        final int isAdmin)
            throws ServletException, IOException {


        if (isAdmin==1) {

            req.getRequestDispatcher("admin_menu.jsp").forward(req, res);
            //res.sendRedirect("admin_menu.jsp");
        } else if (isAdmin==0) {

            req.getRequestDispatcher("abiturient_menu.jsp").forward(req, res);

        } else {

            System.out.println("in-1");
            req.getRequestDispatcher("login.jsp").forward(req, res);
        }
    }

    @Override
    public void destroy() {
    }

}
