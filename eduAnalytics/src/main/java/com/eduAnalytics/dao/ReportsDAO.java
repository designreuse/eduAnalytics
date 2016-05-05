package com.eduAnalytics.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author abc
 */
public class ReportsDAO {

    public JSONArray getDisciplineWiseStudentCount(int year) throws SQLException {
        DBConnector connector = new DBConnector();
        Statement statement = null;
        JSONArray array = new JSONArray();
        try {
            Connection connection = connector.getDBConnection();
            statement = connection.createStatement();
            String sql = " SELECT discipline.name,COUNT(1) FROM student "
                    + "INNER JOIN institute_course ON student.attached_course= institute_course.id "
                    + "INNER JOIN course ON institute_course.course_id=course.id  INNER JOIN"
                    + " discipline ON course.discipline_id=discipline.id ";
            if (year != 0) {
                sql += " WHERE student.passing_year= " + year;
            }
            sql += " GROUP BY discipline.name";
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

    public JSONArray getSubDisciplineWiseStudentCount(String discipline, int year) throws SQLException {
        DBConnector connector = new DBConnector();
        Statement statement = null;
        JSONArray array = new JSONArray();
        System.out.println(discipline);
        try {
            Connection connection = connector.getDBConnection();
            statement = connection.createStatement();
            String sql = " SELECT course.course_name,COUNT(1) FROM student INNER JOIN institute_course ON "
                    + "student.attached_course= institute_course.id INNER JOIN course ON institute_course.course_id=course.id"
                    + "  INNER JOIN discipline ON course.discipline_id=discipline.id "
                    + "WHERE discipline.name='" + discipline + "'";
            if (year != 0) {
                sql += " AND student.passing_year= " + year;
            }
            sql += "  GROUP BY course.course_name";
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

    public JSONArray getTrainingSchemeWiseStudentCount(int year) throws SQLException {
        DBConnector connector = new DBConnector();
        Statement statement = null;
        JSONArray array = new JSONArray();
        try {
            Connection connection = connector.getDBConnection();
            statement = connection.createStatement();
            String sql = " SELECT trainingscheme.schemetype,COUNT(1) FROM student INNER JOIN institute_course"
                    + " ON student.attached_course= institute_course.id "
                    + " INNER JOIN institute ON institute_course.institute_id=institute.id "
                    + " INNER JOIN trainingscheme ON institute.training_scheme=trainingscheme.id ";
            if (year != 0) {
                sql += " WHERE student.passing_year= " + year;
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

    public JSONArray getSubTrainingSchemeWiseStudentCount(String schemetype, int year) throws SQLException {
        DBConnector connector = new DBConnector();
        Statement statement = null;
        JSONArray array = new JSONArray();
        System.out.println(schemetype);
        try {
            Connection connection = connector.getDBConnection();
            statement = connection.createStatement();
            String sql = "SELECT trainingscheme.name,COUNT(1) FROM student INNER JOIN institute_course ON "
                    + "student.attached_course= institute_course.id "
                    + " INNER JOIN institute ON institute_course.institute_id=institute.id "
                    + " INNER JOIN trainingscheme ON institute.training_scheme=trainingscheme.id "
                    + " WHERE trainingscheme.schemetype='" + schemetype + "'";
            if (year != 0) {
                sql += " AND student.passing_year= " + year;
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

    public JSONArray getAllTrainingSchemes() throws SQLException {
        DBConnector connector = new DBConnector();
        Statement statement = null;
        ResultSet res = null;
        JSONArray array = new JSONArray();
        try {
            Connection connection = connector.getDBConnection();
            statement = connection.createStatement();
            String sql = "select name,schemetype,comment from trainingscheme";
            res = statement.executeQuery(sql);
            while (res.next()) {
                JSONObject obj = new JSONObject();
                obj.put("name", res.getString(1));
                obj.put("schemetype", res.getString(2));
                if(res.getString(3) != null){
                    obj.put("comment", res.getString(3));
                }else{
                    obj.put("comment", "");
                }
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
    
    public static void main(String[] args) throws Exception {
        System.out.println(new ReportsDAO().getTrainingSchemeWiseStudentCount(0));
    }

}
