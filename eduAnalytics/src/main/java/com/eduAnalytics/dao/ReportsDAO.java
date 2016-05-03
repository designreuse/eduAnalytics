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
import org.json.JSONArray;

/**
 *
 * @author abc
 */
public class ReportsDAO {
    
    public JSONArray getDisciplineWiseStudentCount() throws SQLException {
        DBConnector connector = new DBConnector();
        Statement statement = null;
        JSONArray array = new JSONArray();
        try {
            Connection connection = connector.getDBConnection();
            statement = connection.createStatement();
            String sql = " SELECT discipline.name,COUNT(1) FROM student "
                         + "INNER JOIN institute_course ON student.attached_course= institute_course.id "
                         + "INNER JOIN course ON institute_course.course_id=course.id  INNER JOIN"
                         + " discipline ON course.discipline_id=discipline.id GROUP BY discipline.name";
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                JSONArray obj = new JSONArray();
                obj.put(res.getString(1));
                obj.put(Integer.parseInt(res.getString(2)));
                array.put(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
        } finally {
            connector.closeDBConnection();
        }
        return array;
    }
    
    public JSONArray getDisciplineWiseStudentCount_year(int year) throws SQLException {
        DBConnector connector = new DBConnector();
        Statement statement = null;
        JSONArray array = new JSONArray();
        try {
            Connection connection = connector.getDBConnection();
            statement = connection.createStatement();
            String sql = " SELECT discipline.name,COUNT(1) FROM student "
                         + "INNER JOIN institute_course ON student.attached_course= institute_course.id "
                         + "INNER JOIN course ON institute_course.course_id=course.id  INNER JOIN"
                         + " discipline ON course.discipline_id=discipline.id WHERE student.passing_year= '"+year+"'"
                        + " GROUP BY discipline.name";
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                JSONArray obj = new JSONArray();
                obj.put(res.getString(1));
                obj.put(Integer.parseInt(res.getString(2)));
                array.put(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
        } finally {
            connector.closeDBConnection();
        }
        return array;
    }
    
    
    public static void main(String[] args) throws Exception{
        System.out.println(new ReportsDAO().getDisciplineWiseStudentCount());
    }
    
}
