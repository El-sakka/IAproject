/*
 * Made By  (c) ZizoNaser
 *  12/11/17 2:45 AM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */

package com.model;

import com.obj.Options;
import com.utils.MySQLConnUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class OptionModel {
    public Options addOption(String optionText, int questionID) {
        //Create Option Object to carry the Newly Created Option
        Options option = null;
        //Create Database Connection
        Connection conn = null;
        try {
            //Get DataBase Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create SQL Query
            String sql = "INSERT INTO `Options` (`optionText`, `questionID`) VALUES ( '" + optionText + "', '" + questionID + "')";
            //Create Statement to execute the statement
            Statement stm = conn.createStatement();
            //Execute the Query
            stm.executeUpdate(sql);
            //Assign the newly Created object to return object
            option = new Options(getLastID(), optionText, questionID);
            //Close Connection
            conn.close();
        } catch (Exception ex) {
            //If there is  An Exception print its text out
            System.out.println(ex.toString());
        }
        //return the newly created object
        return option;
        //That's All! Done!! Enjoy ;)
    }

    public Vector<Options> getOptions(int questionID) {
        //Create Vector to carry the return results
        Vector<Options> _return = new Vector<Options>();
        //Create Connection
        Connection conn = null;
        try {
            //Get the Database connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create Statement to Execute the Query
            Statement stm = conn.createStatement();
            //Create the Query
            String sql = "SELECT `ID`, `optionText`, `questionID` FROM `Options` WHERE Options.questionID = '" + questionID + "'";
            //Create resultSet to carry the return results
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {//Get the next Results IF Exists
                //Add the new Entry to the vector
                _return.add(new Options(rs.getInt("ID"), rs.getString("optionText"), rs.getInt("questionID")));
            }
            //close the DataBase Connection
            conn.close();
        } catch (Exception ex) {
            //IF There's Exception print its text out
            System.out.println(ex.toString());
        }
        //return the carrying results Vector
        return _return;
        //That's All! Done!! Enjoy ;)
    }

    public Options getOption(int ID) {
        //Create Connection object
        Connection conn = null;
        //Create return object of Oprions
        Options option = null;
        try {
            //Get the DataBase Connectoin
            conn = MySQLConnUtils.getMySQLConnection();
            //Create the Query
            String sql = "SELECT FROM Options WHERE ID=" + ID;
            //Create Statement Object to Execute the Query
            Statement stm = conn.createStatement();
            //Execute the Query
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {//Get next if any
                //Assign the result to the return object
                option = new Options(rs.getInt("ID"), rs.getString("optionText"), rs.getInt("questionID"));
            }
            //close The DataBase connection
            conn.close();
        } catch (Exception ex) {
            //IF There's Exception print its text out
            System.out.println(ex.toString());
        }
        //return the result
        return option;
        //That's All! Done!! Enjoy ;)
    }

    public Options removeOption(int ID) {
        //Create Connection object
        Connection conn = null;
        try {
            //Get the DataBase Connectoin
            conn = MySQLConnUtils.getMySQLConnection();
            //Create the Query
            String sql = "DELETE FROM Options WHERE ID=" + ID;
            //Create Statement Object to Execute the Query
            Statement stm = conn.createStatement();
            //Execute the Query
            stm.executeUpdate(sql);
            //close The DataBase connection
            conn.close();
        } catch (Exception ex) {
            //IF There's Exception print its text out
            System.out.println(ex.toString());
        }
        //Checks if Deleted the return will null
        return getOption(ID);
        //That's All! Done!! Enjoy ;)
    }

    public int removeOptionByQuestionID(int questionID) {
        //Create Connection object
        Connection conn = null;
        int affected = -1;
        try {
            //Get the DataBase Connectoin
            conn = MySQLConnUtils.getMySQLConnection();
            //Create the Query
            String sql = "DELETE FROM Options WHERE questionID=" + questionID;
            //Create Statement Object to Execute the Query
            Statement stm = conn.createStatement();
            //Execute the Query
            affected = stm.executeUpdate(sql);
            //close The DataBase connection
            conn.close();
        } catch (Exception ex) {
            //IF There's Exception print its text out
            System.out.println(ex.toString());
        }
        return affected;
        //That's All! Done!! Enjoy ;)
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
