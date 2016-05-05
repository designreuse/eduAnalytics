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
import org.json.JSONObject;

/**
 *
 * @author vinits
 */
public class InstituteDAO {
    
    public JSONArray getDisciplineWiseInstituteCount() throws SQLException {
        DBConnector connector = new DBConnector();
        Statement statement = null;
        ResultSet res = null;
        JSONArray array = new JSONArray();
        try {
            Connection connection = connector.getDBConnection();
            statement = connection.createStatement();
            String sql = "SELECT discipline.name,COUNT(1) as count FROM institute INNER JOIN institute_course ON "
                        + "institute.id= institute_course.institute_id INNER JOIN course " 
                        + "ON institute_course.course_id = course.id INNER JOIN discipline ON "
                        + "course.discipline_id=discipline.id GROUP BY discipline.name;";
            res = statement.executeQuery(sql);
            while (res.next()) {
                JSONObject obj = new JSONObject();
                obj.put("name", res.getString(1));
                obj.put("count", res.getInt(2));
                array.put(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(res != null){
                res.close();
            }
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            connector.closeDBConnection();
        }
        return array;
    }
    
    public JSONArray getSubDisciplineWiseInstituteCount() throws SQLException {
        DBConnector connector = new DBConnector();
        Statement statement = null;
        ResultSet res = null;
        JSONArray array = new JSONArray();
        try {
            Connection connection = connector.getDBConnection();
            statement = connection.createStatement();
            String sql = "SELECT course.course_name as name,COUNT(1) AS count FROM institute INNER JOIN "
                        + "institute_course ON institute.id= institute_course.institute_id INNER JOIN course " +
                          "ON institute_course.course_id = course.id  GROUP BY course.course_name;";
            res = statement.executeQuery(sql);
            while (res.next()) {
                JSONObject obj = new JSONObject();
                obj.put("name", res.getString(1));
                obj.put("count", res.getInt(2));
                array.put(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(res != null){
                res.close();
            }
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            connector.closeDBConnection();
        }
        return array;
    }

    public JSONArray getInstituteListFromDiscipline(String discipline) throws SQLException {
        DBConnector connector = new DBConnector();
        Statement statement = null;
        ResultSet res = null;
        JSONArray array = new JSONArray();
        try {
            Connection connection = connector.getDBConnection();
            statement = connection.createStatement();
            String sql ="SELECT discipline.name AS discipline,institute.name AS institutename,schemetype FROM institute"
                        + " INNER JOIN institute_course ON institute_course.institute_id = institute.id " +
                        "INNER JOIN course ON institute_course.course_id = course.id INNER JOIN discipline ON"
                        + " course.discipline_id=discipline.id INNER JOIN trainingscheme " +
                        "ON trainingscheme.id=institute.training_scheme " +
                        "WHERE discipline.name='"+discipline+"' GROUP BY discipline.name,institute.name;";
            res = statement.executeQuery(sql);
            while (res.next()) {
                JSONObject obj = new JSONObject();
                obj.put("discipline", res.getString(1));
                obj.put("institutename", res.getString(2));
                obj.put("schemetype", res.getString(3));
                array.put(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(res != null){
                res.close();
            }
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            connector.closeDBConnection();
        }
        return array;
    }
    
    public JSONArray getInstituteListFromSubDiscipline(String course) throws SQLException {
        DBConnector connector = new DBConnector();
        Statement statement = null;
        ResultSet res = null;
        JSONArray array = new JSONArray();
        try {
            Connection connection = connector.getDBConnection();
            statement = connection.createStatement();
            String sql ="SELECT discipline.name AS discipline,institute.name AS institutename,schemetype FROM institute"
                        + " INNER JOIN institute_course ON institute_course.institute_id = institute.id " +
                        "INNER JOIN course ON institute_course.course_id = course.id INNER JOIN discipline ON"
                        + " course.discipline_id=discipline.id INNER JOIN trainingscheme " +
                        "ON trainingscheme.id=institute.training_scheme " +
                        "WHERE discipline.name='"+discipline+"' GROUP BY discipline.name,institute.name;";
            res = statement.executeQuery(sql);
            while (res.next()) {
                JSONObject obj = new JSONObject();
                obj.put("discipline", res.getString(1));
                obj.put("institutename", res.getString(2));
                obj.put("schemetype", res.getString(3));
                array.put(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(res != null){
                res.close();
            }
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            connector.closeDBConnection();
        }
        return array;
    }
    
    public static void main(String[] args) throws Exception{
        System.out.println(new InstituteDAO().getInstituteListFromDiscipline("Information & Communication Technology"));
    }
}
