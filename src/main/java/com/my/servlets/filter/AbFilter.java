package com.my.servlets.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;

/**
 * Acidification filter.
 */

@WebFilter(urlPatterns = { "/admin_menu.jsp","/list_user","/list_user.jsp","/edit_faculty.jsp","/final_list" })
public class AbFilter implements Filter {
    private static final Logger logger = LogManager.getLogger(AbFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(final ServletRequest request,
                         final ServletResponse response,
                         final FilterChain chain)

            throws IOException, ServletException {

        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;
        final HttpSession session = req.getSession();
        int isAdmin = -1;
        if (nonNull(session)&&nonNull(session.getAttribute("isAdmin")))
         isAdmin = (int) session.getAttribute("isAdmin");

        if (isAdmin==0) {
            logger.trace(isAdmin+"inabf");
            logger.trace(req.getHeader("Referer"));
        req.getRequestDispatcher("err.jsp").forward(req, res);
        return;
        }
        if (isAdmin==-1) {
            logger.trace(isAdmin+"inabf");

            req.getRequestDispatcher("login.jsp").forward(req, res);
            return;
        }
        chain.doFilter(request, response);
    }
    @Override
    public void destroy() {
    }
}