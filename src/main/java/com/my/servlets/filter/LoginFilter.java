package com.my.servlets.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

/**
 * Login filter.
 */
@WebFilter("/login.jsp")
public class LoginFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(LoginFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain chain)
            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpSession session = req.getSession();

        //Logged user.
        if (nonNull(session) &&
            nonNull(session.getAttribute("email"))) {

            final int isAdmin = (int) session.getAttribute("isAdmin");

            if (isAdmin==0) {
                logger.trace(isAdmin+"inLogf");

                req.getRequestDispatcher("abiturient_menu.jsp").forward(request, response);
            }
            if (isAdmin==1) {
                logger.trace(isAdmin+"inLogf");

                req.getRequestDispatcher("admin_menu.jsp").forward(request, response);
            }
        }
            chain.doFilter(request, response);
    }
}