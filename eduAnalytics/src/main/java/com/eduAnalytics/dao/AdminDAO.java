/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduAnalytics.dao;

import com.eduAnalytics.connector.DBConnector;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abc
 */
public class AdminDAO {

    public void uploadDiscipline(String str) {
        DBConnector connector = new DBConnector();
        Connection connection = null;
        Statement statement = null;
        try {
            connection = connector.getDBConnection();
            statement = connection.createStatement();
            System.out.println("************************************************");
            String strArray[] = str.split("\n");
            for (int i = 1; i < strArray.length; i++) {
                String insertQuery = "insert into discipline(name) values ('" + strArray[i] + "')";
                int iRet = statement.executeUpdate(insertQuery);
                System.out.println(iRet);
            }
            System.out.println("************************************************");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
