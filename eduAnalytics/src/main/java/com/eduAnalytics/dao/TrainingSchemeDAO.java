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
public class TrainingSchemeDAO {
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
    public static void main(String[] args) {
        
    }
}
