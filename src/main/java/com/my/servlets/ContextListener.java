package com.my.servlets;

import com.my.db.DBManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.SQLException;


@WebListener
public class ContextListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();

       /* String url = ctx.getInitParameter("DBURL");
        String u = ctx.getInitParameter("DBUSER");
        String p = ctx.getInitParameter("DBPWD");*/

        //create database connection from init parameters and set it to context
        Connection conn = DBManager.getConnection();
        ctx.setAttribute("conn", conn);
        System.out.println("Database connection initialized for Application.");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
        Connection conn = (Connection) ctx.getAttribute("conn");
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Database connection closed for Application.");

    }

}

