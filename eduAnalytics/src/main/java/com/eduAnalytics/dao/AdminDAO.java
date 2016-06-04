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
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author abc
 */
public class AdminDAO {

    public int uploadCourse(String str) {
        DBConnector connector = new DBConnector();
        Connection connection = null;
        Statement statement = null;
        Statement insertStmt = null;
        Statement lastStmt = null;
        int iSuccess = 0;
        try {
            connection = connector.getDBConnection();
            String strArray[] = str.split("\n");
            int length = strArray.length;
            if (length > 1) {
                for (int i = 1; i < length; i++) {
                    statement = connection.createStatement();
                    insertStmt = connection.createStatement();
                    lastStmt = connection.createStatement();
                    System.out.println(strArray[i]);
                    String strCourseArray[] = strArray[i].split(",");

                    if (strCourseArray.length > 0) {
                        String disciplineStr = "select id from discipline where name='" + strCourseArray[2] + "'";
                        ResultSet rs = statement.executeQuery(disciplineStr);
                        int disciplineid = 0;
                        while (rs.next()) {
                            disciplineid = rs.getInt(1);
                        }
                        rs.close();
                        if (disciplineid == 0) {
                            String insertDisciplineQuery = "insert into discipline(name) values ('" + strCourseArray[2] + "')";
                            try {
                                int iRet = insertStmt.executeUpdate(insertDisciplineQuery);
                                if (iRet > 0) {
                                    System.out.println("iRet : " + iRet);
                                    String strLastInsertQuery = "SELECT LAST_INSERT_ID()";

                                    ResultSet rsLast = lastStmt.executeQuery(strLastInsertQuery);
                                    while (rsLast.next()) {
                                        disciplineid = rsLast.getInt(1);
                                    }
                                    rsLast.close();
                                    System.out.println("New disp Id : " + disciplineid);
                                }
                            } catch (Exception e) {
                                System.out.println("Internal Excpetion : " + e);
                                e.printStackTrace();
                            }
                        }

                        String insertQuery = "insert into course(course_name,short_name,discipline_id,"
                                + "duration,comments,course_type,course_group) values"
                                + "('" + strCourseArray[0] + "','" + strCourseArray[1] + "',"
                                + disciplineid + ",'" + strCourseArray[3] + "'"
                                + ",'" + strCourseArray[4] + "','" + strCourseArray[5] + "'"
                                + ",'" + strCourseArray[6] + "')";
                        System.out.println("insertQuery : " + insertQuery);
                        try {
                            int iRet = statement.executeUpdate(insertQuery);
                            System.out.println(iRet);
                            iSuccess++;
                        } catch (Exception e) {
                            System.out.println("Internal Exception");
                            e.printStackTrace();
                        }
                        System.out.println("Discipline : " + disciplineid);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Global Excpetion");
            e.printStackTrace();
        } finally {
            try {
                statement.close();
                lastStmt.close();
                insertStmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return iSuccess;
    }

    public int uploadDiscipline(String str) {
        DBConnector connector = new DBConnector();
        Connection connection = null;
        Statement statement = null;
        int iSuccess = 0;
        try {
            connection = connector.getDBConnection();
            statement = connection.createStatement();
            String strArray[] = str.split("\n");
            int length = strArray.length;
            if (length > 1) {
                for (int i = 1; i < length; i++) {
                    String insertQuery = "insert into discipline(name) values ('" + strArray[i] + "')";
                    try {
                        int iRet = statement.executeUpdate(insertQuery);
                        System.out.println(iRet);
                        iSuccess++;
                    } catch (Exception e) {
                        System.out.println("Internal Excpetion");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Global Excpetion");
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
        return iSuccess;
    }

    public JSONArray getAllDisciplines() throws SQLException {
        DBConnector connector = new DBConnector();
        Statement statement = null;
        ResultSet res = null;
        JSONArray array = new JSONArray();
        try {
            Connection connection = connector.getDBConnection();
            statement = connection.createStatement();
            String sql = "select name from discipline";
            res = statement.executeQuery(sql);
            while (res.next()) {
                JSONObject obj = new JSONObject();
                obj.put("name", res.getString(1));
                array.put(obj);
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
        return array;
    }

    public JSONArray getAllCourses() throws SQLException {
        DBConnector connector = new DBConnector();
        Statement statement = null;
        ResultSet res = null;
        JSONArray array = new JSONArray();
        try {
            Connection connection = connector.getDBConnection();
            statement = connection.createStatement();
            String sql = "select course_name,short_name,discipline.name as discipline,duration,comments,course_type,course_group from course inner join discipline on course.discipline_id=discipline.id";
            res = statement.executeQuery(sql);
            while (res.next()) {
                JSONObject obj = new JSONObject();
                obj.put("course_name", res.getString(1));
                obj.put("short_name", res.getString(2));
                obj.put("discipline", res.getString(3));
                obj.put("duration", res.getInt(4));
                obj.put("comments", res.getString(5));
                obj.put("course_type", res.getString(6));
                obj.put("course_group", res.getString(7));
                array.put(obj);
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
        return array;
    }
}
