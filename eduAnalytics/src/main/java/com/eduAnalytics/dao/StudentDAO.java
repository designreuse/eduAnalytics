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
 * @author abc
 */
public class StudentDAO {

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

    public JSONObject getInstituteWiseStudentResultCount() throws SQLException {
        DBConnector connector = new DBConnector();
        Statement statement = null;
        JSONObject resultObj = new JSONObject();
        JSONArray instituteArray = new JSONArray();
        JSONArray passedArray = new JSONArray();
        JSONArray failedArray = new JSONArray();
        try {
            Connection connection = connector.getDBConnection();
            statement = connection.createStatement();
            String sql = "SELECT institute.name FROM student INNER JOIN institute_course ON"
                    + " student.attached_course = institute_course.id INNER JOIN institute ON "
                    + "institute_course.institute_id = institute.id  GROUP BY institute.name";
            System.out.println(sql);
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                instituteArray.put(res.getString(1));
            }

            for (int i = 0; i < instituteArray.length(); i++) {
                String insName = (String) instituteArray.get(i);
                sql = "SELECT COUNT(1) FROM student INNER JOIN institute_course ON student.attached_course = institute_course.id "
                        + "INNER JOIN institute ON institute_course.institute_id=institute.id WHERE student.result=1 and institute.name='" + insName + "';";
                res = statement.executeQuery(sql);
                while (res.next()) {
                    if(res.getInt(1) > 0){
                        passedArray.put(res.getInt(1));
                    }else{
                        passedArray.put(0);
                    }
                }

                sql = "SELECT COUNT(1) FROM student INNER JOIN institute_course ON student.attached_course = institute_course.id "
                        + "INNER JOIN institute ON institute_course.institute_id=institute.id WHERE student.result=0 and institute.name='" + insName + "';";
                res = statement.executeQuery(sql);
                while (res.next()) {
                    if(res.getInt(1) > 0){
                        failedArray.put(res.getInt(1));
                    }else{
                        failedArray.put(0);
                    }
                }
            }
            resultObj.put("institutes", instituteArray);
            resultObj.put("passed", passedArray);
            resultObj.put("failed", failedArray);
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
        return resultObj;
    }
    
    public JSONArray getStudentListFromInstitute(String insName) throws SQLException {
        DBConnector connector = new DBConnector();
        Statement statement = null;
        JSONArray array = new JSONArray();
        try {
            Connection connection = connector.getDBConnection();
            statement = connection.createStatement();
            String sql = "SELECT seat_no,first_name,last_name,middle_name,dob,phy_hand,caste,add1,add2,add3,student.pincode as pincode"
                         + ",result,passing_year,course_name FROM student INNER JOIN institute_course ON " +
                         "student.attached_course = institute_course.id INNER JOIN institute ON " +
                         "institute_course.institute_id=institute.id INNER JOIN course ON institute_course.course_id=course.id " +
                         "WHERE institute.name='"+insName+"';" ;
            System.out.println(sql);
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                JSONObject obj = new JSONObject();
                obj.put("seat_no",res.getInt(1));
                obj.put("first_name",res.getString(2));
                obj.put("last_name",res.getString(3));
                obj.put("middle_name",res.getString(4));
                obj.put("name",res.getString(2) + " "+res.getString(4)+" "+res.getString(3));
                obj.put("dob",res.getString(5));
                if(res.getInt(6) == 0){
                    obj.put("phy_hand","No");
                }else{
                    obj.put("phy_hand","Yes");
                }
                obj.put("caste",res.getString(7));
                obj.put("add1",res.getString(8));
                obj.put("add2",res.getString(9));
                obj.put("add3",res.getString(10));
                obj.put("pincode",res.getInt(11));
                if(res.getInt(12) == 1){
                    obj.put("result","pass");
                }else{
                    obj.put("result","fail");
                }
                obj.put("passing_year",res.getInt(13));
                obj.put("course_name",res.getString(14));
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

    /**
     * SELECT institute.name FROM student INNER JOIN institute_course ON
     * student.attached_course = institute_course.id INNER JOIN institute ON
     * institute_course.institute_id = institute.id GROUP BY institute.name;
     *
     */
    public static void main(String[] args) throws Exception {
        System.out.println(new StudentDAO().getStudentListFromInstitute("kubernagar"));
    }
}
