package com.model;

import com.obj.Question;
import com.utils.MySQLConnUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class QuestionModel {
    public Question addQuestion(int ID, String questionText, String questionType, int formID) {
        //Create connection object
        Connection conn=null;
        //Create return object with the newly created object
        Question question =null;
        try{
            //Get Database Connection
            conn= MySQLConnUtils.getMySQLConnection();
            //Create SQL Query
            String sql = "INSERT INTO `Question` (`ID`, `questionText`, `questionType`, `formID`) VALUES ('" + ID + "', '" + questionText + "', '" + questionType + "', '" + formID + "')";
            //Create Statement to Execute the Query
            Statement stm= conn.createStatement();
            //Execute the Query
            stm.executeUpdate(sql);
            //Assign the newly created object to the return object
            question = new Question(getLastID(), questionText, questionType, formID);
            //Close database connection
            conn.close();
        }catch (Exception ex){
            //Print the Exception Text IF any
            System.out.println(ex.toString());
        }
        //return the newly Created object
        return  question;
        //That's All! Done!! Enjoy ;)
    }

    public Vector<Question> getQuestionsByFormID(int formID) {
        //Create vector to carry  the return results
        Vector<Question> _return = new Vector<Question>();
        //Create Connection object
        Connection conn=null;
        try {
            //Get DataBase Connection
            conn=MySQLConnUtils.getMySQLConnection();
            //Create SQL Query
            String sql ="SELECT * FROM `Question` WHERE Question.formID ='"+formID+"'";
            //Create Statement object to Execute the Query
            Statement stm = conn.createStatement();
            //Create Resultset to carry the result
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {//Get Next Entry if Exists
                //Pushing the result to the return vector
                _return.add(new Question(rs.getInt("ID"), rs.getString("questionText"), rs.getString("questionType"), rs.getInt("formID")));
            }
            //Close the DataBase Connection
            conn.close();
        }catch (Exception ex){
            //Print the Exception if any
            System.out.println(ex.toString());
        }
        //return the result vector
        return _return;
    }

    public Question getQuestion(int ID) {
        //Create connection object
        Connection conn = null;
        //Create return object
        Question question = null;
        try {
            //Get Database Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create SQL Query
            String sql = "SELECT FROM Question WHERE Question.ID=" + ID;
            //Create Statement to Execute the Query
            Statement stm = conn.createStatement();
            //Execute the Query
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {//Get Next if Exists
                //Assign object to the return object'
                question = new Question(rs.getInt("ID"), rs.getString("questionText"), rs.getString("questionType"), rs.getInt("formID"));
            }
            //Close database connection
            conn.close();
        } catch (Exception ex) {
            //Print the Exception Text IF any
            System.out.println(ex.toString());
        }
        //return  object
        return question;
        //That's All! Done!! Enjoy ;)
    }

    public Question removeQuestion(int ID) {
        //Create connection object
        Connection conn = null;
        //Create return object
        Question question = null;
        try {
            //Get Database Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create SQL Query
            String sql = "DELETE FROM Question WHERE Question.ID=" + ID;
            //Create Statement to Execute the Query
            Statement stm = conn.createStatement();
            //Execute the Query
            stm.executeUpdate(sql);
            //Close database connection
            conn.close();
        } catch (Exception ex) {
            //Print the Exception Text IF any
            System.out.println(ex.toString());
        }
        //return  check if it done the return would be null
        return question;
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
            String sql = "SELECT max(ID) as LastID From Question";
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
