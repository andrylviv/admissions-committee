package com.my.servlets;

import com.my.db.DBManager;
import com.my.servlets.servlet.StatementServ;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.SQLException;


@WebListener
public class ContextListener implements ServletContextListener {
    private static final Logger logger = LogManager.getLogger(ContextListener.class);

    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();

        //create database connection from init parameters and set it to context
        Connection conn = DBManager.getConnection();
        ctx.setAttribute("conn", conn);
        logger.trace("Database connection initialized for Application.");
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext ctx = servletContextEvent.getServletContext();
        Connection conn = (Connection) ctx.getAttribute("conn");
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        logger.trace("Database connection closed for Application.");

    }

}

