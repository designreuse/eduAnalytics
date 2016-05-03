/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduAnalytics.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author abc
 */
public class DBConnector {

    private static String driverName = null;
    private static String userName = null;
    private static String password = null;
    private static String dbName = null;
    private static String url = null;
    private Connection con;

    static {
        try {
            driverName = "com.mysql.jdbc.Driver";
            userName = "root";
            password = "root";
            dbName = "edudb";
            url = "jdbc:mysql://localhost:4928/" + dbName;
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.exit(1);
        }
    }

    public Connection getDBConnection() throws SQLException {
        try {
            if (this.con == null) {
                this.con = DriverManager.getConnection(url, userName, password);
            }
            return this.con;
        } catch (Exception e) {
            System.out.println("Error in getting DB Connection :" + e);
            throw new SQLException("Error in getting DB Connection");
        }
    }
    
    public void closeDBConnection() {
        try {
            if (this.con != null && !this.con.isClosed()) {
                this.con.close();
            }
        } catch (Exception e) {
        }
    }
}
