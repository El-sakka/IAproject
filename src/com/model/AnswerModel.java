/*
    Made By ZizoNaser
    @ Sat Dec 9, 5:14pm
    Twitter: @ZizoNaser
 */
package com.model;

import com.obj.Answer;
import com.utils.MySQLConnUtils;
import com.utils.Pair;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class AnswerModel {

    public Vector<Pair<String, Integer>> getAnswersForQuestionID(int questionID) {
        //Create Vector to contain the result which is every answer and its count
        Vector<Pair<String,Integer>> _return= new Vector<Pair<String,Integer>>();
        //Create Connection object
        Connection conn =null;
        try{
            //Get the Database Connection
            conn=MySQLConnUtils.getMySQLConnection();
            //create sql query
            String sql = "select answerText, count(*) as answerCount from Answers WHERE Answers.questionID='" + questionID + "'  group by answerText";
            //create statement object to execute the query
            Statement stm = conn.createStatement();
            //execute the query and save the return to ResultSet
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {//go to the next entry (if exists)
                _return.add(new Pair<String, Integer>( rs.getString("answerText") , rs.getInt("answerCount") ) );
            }
            //Close the Connection
            conn.close();
        }catch (Exception e){
            //If There is exception print its text to the console
            System.out.println(e.toString());
        }
        //returns the vector with the results
        return _return;
        //That's All! done!! Enjoy ;)
    }

    public Vector<Pair<String, Integer>> getShortAnswersForQuestionID(int questionID) {
        //Create Vector to contain the result which is every answer and its count
        Vector<Pair<String, Integer>> _return = new Vector<Pair<String, Integer>>();
        //Create Connection object
        Connection conn = null;
        try {
            //Get the Database Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //create sql query
            String sql = "select answerText from Answers WHERE Answers.questionID=" + questionID;
            //create statement object to execute the query
            Statement stm = conn.createStatement();
            //execute the query and save the return to ResultSet
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {//go to the next entry (if exists)
                _return.add(new Pair<String, Integer>(rs.getString("answerText"), 0));
            }
            //Close the Connection
            conn.close();
        } catch (Exception e) {
            //If There is exception print its text to the console
            System.out.println(e.toString());
        }
        //returns the vector with the results
        return _return;
        //That's All! done!! Enjoy ;)
    }

    public Vector<String> getUserNameForQuestionID(int questionID) {
        //Create Vector to contain the result which is every answer and its count
        Vector<String> _return = new Vector<String>();
        //Create Connection object
        Connection conn = null;
        try {
            //Get the Database Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //create sql query
            String sql = "select userName from Answers WHERE Answers.questionID=" + questionID;
            //create statement object to execute the query
            Statement stm = conn.createStatement();
            //execute the query and save the return to ResultSet
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {//go to the next entry (if exists)
                _return.add(new String(rs.getString("userName")));
            }
            //Close the Connection
            conn.close();
        } catch (Exception e) {
            //If There is exception print its text to the console
            System.out.println(e.toString());
        }
        //returns the vector with the results
        return _return;
        //That's All! done!! Enjoy ;)
    }

    public Answer addAnswer(String answerText, int questionID, int formId, String userName, String avail) {
        //Create connection object
        Connection conn =null;
        //Create Answer object to carry the new created answer and to be returned
        Answer answer=null;
        try{
            //get the connection to the databse
            conn=MySQLConnUtils.getMySQLConnection();
            //create sql query
            String sql = "INSERT INTO `Answers` ( `answerText`, `questionID` , `formId`, `userName`,`avail`) VALUES ( '" + answerText + "', '" + questionID + "', '" + formId + "', '" + userName + "', '" + avail + "')";
            //create Statement to execute the query
            Statement stm=conn.createStatement();
            //execute the query
            stm.executeUpdate(sql);
            //assign the new  created answer
            answer = new Answer(getLastID(), answerText, questionID, formId, userName, avail);
            //close connection
            conn.close();
        }catch (Exception e){
            //If there's an Execption print its  text to the console
            System.out.println(e.toString());
        }
        //return the newly created Answer object
        return answer;
        //That's All! done!! Enjoy ;)
    }


    public Answer getAnswer(int ID) {
        //Create Answer object to carry the return results
        Answer answer = null;
        //Create the Connection
        Connection conn = null;
        try {
            //Get the DataBase Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create Sql Query
            String sql = "SELECT  FROM `Answers` WHERE Answers.ID='" + ID + "' ";
            //Create Statement to Execute the Query
            Statement stm = conn.createStatement();
            //Create ResultSet Object to carry the results
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {//get the Next (if exists)
                //Assign Entry to the Return object
                answer = new Answer(rs.getInt("ID"), rs.getString("answerText"), rs.getInt("questionID"), rs.getInt("formId"), rs.getString("userName"), rs.getString("avail"));
            }
            //Close the Database Connection
            conn.close();
        } catch (Exception ex) {
            //If Exist Exception
            System.out.println(ex.toString());
        }
        //return the object which carries the results
        return answer;
        //That's All! Done!! Enjoy ;)

    }

    public Answer removeAnswer(int ID) {
        //Create the Connection
        Connection conn = null;
        try {
            //Get the DataBase Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create Sql Query
            String sql = "DELETE FROM Answers  WHERE `Answers`.`ID` = " + ID + "";
            //Create Statement to Execute the Query
            Statement stm = conn.createStatement();
            //Execute the Query
            stm.executeUpdate(sql);
            //Close the Database Connection
            conn.close();
        } catch (Exception ex) {
            //If Exist Exception
            System.out.println(ex.toString());
        }
        //Checks if it done then return would be Null
        return getAnswer(ID);
        //That's All! Done!! Enjoy ;)
    }

    public int removeAnswerByQuestionID(int questionID) {
        //Create the Connection
        Connection conn = null;
        int affected = -1;
        try {
            //Get the DataBase Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create Sql Query
            String sql = "DELETE FROM Answers  WHERE `Answers`.questionID = " + questionID + "";
            //Create Statement to Execute the Query
            Statement stm = conn.createStatement();
            //Execute the Query
            affected = stm.executeUpdate(sql);
            //Close the Database Connection
            conn.close();
        } catch (Exception ex) {
            //If Exist Exception
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
            String sql = "SELECT max(ID) as LastID From Answers";
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
