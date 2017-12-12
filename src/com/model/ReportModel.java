/*
 * Made By  (c) ZizoNaser
 *  12/12/17 8:01 PM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */

package com.model;

import com.obj.Report;
import com.utils.MySQLConnUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReportModel {
    public Report addReport(int reportID, String reportText, int formId) {
        //Create Connection Object
        Connection conn = null;
        //Create return object
        Report report = null;
        try {
            //Get The DataBase connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create SQL Query
            String sql = "INSERT INTO `Report` (`ID`, `reportText`, `formId`) VALUES ('" + reportID + "', '" + reportText + "', '" + formId + "')";
            //Create Statement to Execute the Query
            Statement stm = conn.createStatement();
            //Execute the query
            stm.executeUpdate(sql);
            //Assign the newly Created object to the return object
            report = new Report(getLastID(), reportText, formId);
            //Close Connection
            conn.close();
        } catch (Exception ex) {
            //IF there is Exception print it out
            System.out.println(ex.toString());
        }
        //return the newly created object
        return report;
        //That's All! done!! Enjoy ;)
    }

    public Report removeReport(int reportID) {
        //Create Connection Object
        Connection conn = null;
        try {
            //Get The DataBase connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create SQL Query
            String sql = "DELETE  FROM  Report WHERE Report.ID=" + reportID;
            //Create Statement to Execute the Query
            Statement stm = conn.createStatement();
            //Execute the query
            stm.executeUpdate(sql);
            //Close Connection
            conn.close();
        } catch (Exception ex) {
            //IF there is Exception print it out
            System.out.println(ex.toString());
        }
        //return null if deleted successfully
        return getReport(reportID);
        //That's All! done!! Enjoy ;)
    }

    public Report getReport(int reportID) {
        //Create Connection Object
        Connection conn = null;
        //Create return object
        Report report = null;
        try {
            //Get The DataBase connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create SQL Query
            String sql = "SELECT  FROM  Report WHERE Report.ID=" + reportID;
            //Create Statement to Execute the Query
            Statement stm = conn.createStatement();
            //Execute the query
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                //Assign the result object to the return object
                report = new Report(rs.getInt("ID"), rs.getString("reportText"), rs.getInt("formId"));
            }
            //Close Connection
            conn.close();
        } catch (Exception ex) {
            //IF there is Exception print it out
            System.out.println(ex.toString());
        }
        //return the result object
        return report;
        //That's All! done!! Enjoy ;)
    }


    private int getLastID() {
        //Create Connection object
        Connection conn = null;
        // create Object to carry the LastID
        int Id = -1;
        try {
            //get the DataBase Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create Sql Query
            String sql = "SELECT max(ID) as LastID From Options";
            //Create Statement to Execute the Query
            Statement stm = conn.createStatement();
            //Create ResultSet to get the Result Entries
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {//if there's any
                Id = rs.getInt("LastID");
            }
            //Close the Connection
            conn.close();
        } catch (Exception ex) {
            //If there's an Execption print its  text to the console
            System.out.println(ex.toString());
        }
        //return the result
        return Id;
        //That's All! done!! Enjoy ;)
    }
}
