package com.model;

import com.obj.Question;
import com.utils.MySQLConnUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class QuestionModel {
    public Question addQuestion(String ID,String questoinText,String questionType,String formID){
        Connection conn=null;
        Question question =null;
        try{
            conn= MySQLConnUtils.getMySQLConnection();
            String sql ="INSERT INTO `Question` (`ID`, `questionText`, `questionType`, `formID`) VALUES ('"+ID+"', '"+questoinText+"', '"+questionType+"', '"+formID+"')";
            Statement stm= conn.createStatement();
            stm.executeUpdate(sql);
            question = new Question(ID,questoinText,questionType,formID);
            conn.close();
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        return  question;
    }

    public Vector<Question> getQuestionsByFormID(String formID){
        Vector<Question> _return = new Vector<Question>();
        Connection conn=null;
        try {
            conn=MySQLConnUtils.getMySQLConnection();
            String sql ="SELECT * FROM `Question` WHERE Question.formID ='"+formID+"'";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                _return.add(new Question(rs.getString("ID"),rs.getString("questionText"),rs.getString("questionType"),rs.getString("formID")) );
            }
            conn.close();
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        return _return;
    }
}
