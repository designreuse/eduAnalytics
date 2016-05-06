/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduAnalytics.dao;

import com.eduAnalytics.connector.DBConnector;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.json.JSONObject;

/**
 *
 * @author abc
 */
public class DashboardDAO {

    public JSONObject getDashboardCounts() throws SQLException {
        DBConnector connector = new DBConnector();
        Statement statement = null;
        ResultSet res = null;
        JSONObject dashboardObject = new JSONObject();
        try {
            Connection connection = connector.getDBConnection();
            statement = connection.createStatement();
            String sql = "SELECT COUNT(1) FROM trainingscheme";
            res = statement.executeQuery(sql);
            while (res.next()) {
                dashboardObject.put("trainingschemecount", res.getString(1));
            }
            sql = "SELECT COUNT(1) FROM institute";
            res = statement.executeQuery(sql);
            while (res.next()) {
                dashboardObject.put("institutecount", res.getString(1));
            }
            sql = "SELECT COUNT(1) FROM course";
            res = statement.executeQuery(sql);
            while (res.next()) {
                dashboardObject.put("coursecount", res.getString(1));
            }
            sql = "SELECT COUNT(1) FROM student";
            res = statement.executeQuery(sql);
            while (res.next()) {
                dashboardObject.put("studentcount", res.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (res != null) {
                res.close();
            }
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            connector.closeDBConnection();
        }
        return dashboardObject;
    }

    public static void main(String[] args) throws Exception{
        System.out.println(new DashboardDAO().getDashboardCounts());
    }
}
