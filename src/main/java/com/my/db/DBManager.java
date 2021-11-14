package com.my.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBManager {
    private  static DataSource ds;

    public static synchronized Connection getConnection() {

        if (ds == null) {
            try {
                Context initCtx = new InitialContext();
                Context envCtx = (Context) initCtx.lookup("java:comp/env");
                ds = (DataSource) envCtx.lookup("jdbc/testDB");
            } catch (Exception ex) {
                throw new IllegalStateException("Cannot init DataSource", ex);
            }
        }


        Connection con = null;
        try {
            con = ds.getConnection();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
