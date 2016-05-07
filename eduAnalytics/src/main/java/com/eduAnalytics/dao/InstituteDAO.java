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
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author vinits
 */
public class InstituteDAO {
    
    public JSONArray getTrainingSchemeWiseInstituteCount(int year) throws SQLException {
        DBConnector connector = new DBConnector();
        Statement statement = null;
        JSONArray array = new JSONArray();
        try {
            Connection connection = connector.getDBConnection();
            statement = connection.createStatement();
            String sql = " SELECT trainingscheme.schemetype,COUNT(1) FROM institute INNER JOIN"
                    + " trainingscheme ON institute.training_scheme=trainingscheme.id ";
            if (year != 0) {
                sql += " WHERE institute.established_year= " + year;
            }
            sql += " GROUP BY trainingscheme.schemetype";
            System.out.println(sql);
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
    
    public JSONArray getSubTrainingSchemeWiseInstituteCount(String schemetype, int year) throws SQLException {
        DBConnector connector = new DBConnector();
        Statement statement = null;
        JSONArray array = new JSONArray();
        System.out.println(schemetype);
        try {
            Connection connection = connector.getDBConnection();
            statement = connection.createStatement();
           String sql = " SELECT trainingscheme.name,COUNT(1) FROM institute INNER JOIN"
                    + " trainingscheme ON institute.training_scheme=trainingscheme.id "
                    + " WHERE trainingscheme.schemetype='" + schemetype + "'";
            if (year != 0) {
                sql += " AND institute.established_year= " + year;
            }
            sql += " GROUP BY trainingscheme.name";
            System.out.println(sql);
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
            System.out.println(sql);
            res = statement.executeQuery(sql);
            while (res.next()) {
                JSONArray obj = new JSONArray();
                obj.put(res.getString(1));
                obj.put(res.getInt(2));
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
            System.out.println(sql);
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
            System.out.println(sql);
            res = statement.executeQuery(sql);
            while (res.next()) {
                JSONArray obj = new JSONArray();
                obj.put(res.getString(1));
                obj.put(res.getInt(2));
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
            String sql ="SELECT course.course_name AS coursename,institute.name AS institutename FROM institute"
                        + " INNER JOIN institute_course ON institute_course.institute_id = institute.id " +
                        "INNER JOIN course ON institute_course.course_id = course.id "+
                        "WHERE course.course_name='"+course+"' GROUP BY course.course_name,institute.name;";
            System.out.println(sql);
            res = statement.executeQuery(sql);
            while (res.next()) {
                JSONObject obj = new JSONObject();
                obj.put("coursename", res.getString(1));
                obj.put("institutename", res.getString(2));
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
    
    
    public JSONArray getYearWiseInstituteCount() throws SQLException {
        DBConnector connector = new DBConnector();
        Statement statement = null;
        ResultSet res = null;
        JSONArray array = new JSONArray();
        try {
            Connection connection = connector.getDBConnection();
            statement = connection.createStatement();
            String sql = "SELECT DISTINCT(schemetype) as schemetype FROM trainingscheme";
            System.out.println(sql);
            res = statement.executeQuery(sql);
            while (res.next()) {
                String schemetype = res.getString(1);
                System.out.println(schemetype);
                JSONObject schemeJSONObject = new JSONObject();

                List<Integer> yearWiseInstituteList = new ArrayList<Integer>();
                Statement stmt = connection.createStatement();
                for (int i = 2000; i <= 2016; i++) {
                    String yearSQL = "SELECT COUNT(1) FROM institute INNER JOIN trainingscheme ON "
                            + "institute.training_scheme = trainingscheme.id WHERE schemetype='" + schemetype + "' AND established_year='" + i + "'";
                    ResultSet rs = stmt.executeQuery(yearSQL);
                    while (rs.next()) {
                        yearWiseInstituteList.add(rs.getInt(1));
                    }
                    rs.close();
                }
                if (stmt != null && !stmt.isClosed()) {
                    stmt.close();
                }
                schemeJSONObject.put("name", schemetype);
                schemeJSONObject.put("data", yearWiseInstituteList.toArray());
                array.put(schemeJSONObject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
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
        return array;
    }
    
     public JSONArray getYearWiseInsCountPerSubTS() throws SQLException {
        DBConnector connector = new DBConnector();
        Statement statement = null;
        ResultSet res = null;
        JSONArray array = new JSONArray();
        try {
            Connection connection = connector.getDBConnection();
            statement = connection.createStatement();
            String sql = "SELECT DISTINCT(NAME) AS NAME FROM trainingscheme";
            System.out.println(sql);
            res = statement.executeQuery(sql);
            while (res.next()) {
                String name = res.getString(1);
                System.out.println(name);
                JSONObject schemeJSONObject = new JSONObject();

                List<Integer> yearWiseInstituteList = new ArrayList<Integer>();
                Statement stmt = connection.createStatement();
                for (int i = 2000; i <= 2016; i++) {
                    String yearSQL = "SELECT COUNT(1) FROM institute INNER JOIN trainingscheme ON "
                            + "institute.training_scheme = trainingscheme.id WHERE trainingscheme.name='" + name + "' AND established_year='" + i + "'";
                    ResultSet rs = stmt.executeQuery(yearSQL);
                    while (rs.next()) {
                        yearWiseInstituteList.add(rs.getInt(1));
                    }
                    rs.close();
                }
                if (stmt != null && !stmt.isClosed()) {
                    stmt.close();
                }
                schemeJSONObject.put("name", name);
                schemeJSONObject.put("data", yearWiseInstituteList.toArray());
                array.put(schemeJSONObject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
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
        return array;
    }
     
     public JSONObject getInstituteDetailByName(String insname) throws SQLException {
        DBConnector connector = new DBConnector();
        Statement statement = null;
        ResultSet res = null;
        JSONObject obj = new JSONObject();
        try {
            Connection connection = connector.getDBConnection();
            statement = connection.createStatement();
            String sql ="select name,established_year,email,address,city,pincode,zone,district from institute where name='"+insname+"'";
            res = statement.executeQuery(sql);
            while (res.next()) {
                obj.put("name", res.getString(1));
                obj.put("established_year", res.getInt(2));
                obj.put("email", res.getString(3));
                obj.put("address", res.getString(4));
                obj.put("city", res.getString(5));
                obj.put("pincode", res.getString(6));
                obj.put("zone", res.getString(7));
                obj.put("distict", res.getString(8));
            }
            sql="SELECT course.course_name FROM institute INNER JOIN institute_course"
                + " ON institute.id=institute_course.institute_id INNER JOIN course" +
                " ON institute_course.course_id=course.id " +
                " WHERE institute.name='"+insname+"'";
            res = statement.executeQuery(sql);
            JSONArray courseArray = new JSONArray();
            while (res.next()) {
                courseArray.put(res.getString(1));
            }
            obj.put("courseArray", courseArray);
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
        return obj;
    }
     
    public static void main(String[] args) throws Exception{
        System.out.println(new InstituteDAO().getInstituteListFromSubDiscipline("Draughtsman Mechanic"));
    }
}
