/*
    Made By ZizoNaser
    @ Sat Dec 9, 5:14pm
    Twitter: @ZizoNaser
 */
package com.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;
import com.obj.Answer;
import com.utils.*;

public class AnswerModel {

    public Vector<Pair<String,Integer>> getAnswersForQuesionID (String questionID){
        Vector<Pair<String,Integer>> _return= new Vector<Pair<String,Integer>>();
        Connection conn =null;
        try{
            conn=MySQLConnUtils.getMySQLConnection();
            String sql ="select answerText, count(*) as answerCount from Answer WHERE Answer.questionID='"+questionID+"' group by answerText";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                _return.add(new Pair<String, Integer>( rs.getString("answerText") , rs.getInt("answerCount") ) );
            }

            conn.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }

        return _return;
    }
    public Answer addAnswer(String ID,String answerText,String questionID){
        Connection conn =null;
        Answer answer=null;
        try{
            conn=MySQLConnUtils.getMySQLConnection();
            String sql ="INSERT INTO `Answer` (`ID`, `answerText`, `questionID`) VALUES ('"+ID+"', '"+answerText+"', '"+questionID+"')";
            Statement stm=conn.createStatement();
            stm.executeUpdate(sql);
            answer=new Answer(ID,answerText,questionID);
            conn.close();
        }catch (Exception e){
            System.out.println(e.toString());
        }
        return answer;
    }
}
