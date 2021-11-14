package com.my;

import com.my.db.FacultyDAO;
import com.my.db.UserDAO;
import com.my.db.entity.Faculty;
import com.my.db.entity.User;
import com.my.model.Password;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/tgu")
public class T extends HttpServlet{

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            System.out.println("Test#doGet");

           /* User u = new UserDAO().getUser("exem@mail.com","adm");

                resp.getWriter()
                        .println(u.getEmail());*/
            final HttpSession session = req.getSession();
            final String password = (String) session.getAttribute("password");
            try {
                String p = Password.hash(password);
                System.out.println(p.length());
                System.out.println(p);
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
            final Connection conn = (Connection) req.getServletContext().getAttribute("conn");
            List<Faculty> f = new FacultyDAO().findAllFaculty(conn,"uk");
            resp.setContentType("text/html; charset=UTF-8");
            resp.getWriter()
                    .println(f);

        }
    }