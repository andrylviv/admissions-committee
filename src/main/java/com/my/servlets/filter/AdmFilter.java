package com.my.servlets.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.nonNull;


/**
 * Administrator filter.
 */

@WebFilter(urlPatterns = { "/list" })
public class AdmFilter implements Filter {

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

        if (isAdmin==1) {
            System.out.println(isAdmin+"inadf");

        req.getRequestDispatcher("err.jsp").forward(req, res);
        }

        chain.doFilter(request, response);
    }
    @Override
    public void destroy() {
    }
}