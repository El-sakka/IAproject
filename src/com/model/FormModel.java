package com.model;

import com.obj.Form;
import com.utils.MySQLConnUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class FormModel {
    public Form addForm(String ID, String name,String suspended ,String userName){
        Connection conn=null;
        Form form =null;
        try{
            conn = MySQLConnUtils.getMySQLConnection();
            String sql = "INSERT INTO `Form` (`ID`, `name`, `suspended`, `userName`) VALUES ('"+ID+"', '"+name+"', '"+suspended+"', '"+userName+"')";
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            form=new Form(ID,name,suspended,userName);
            conn.close();
        }catch (Exception ex){
            System.out.println(ex.toString());
        }

        return form;
    }
    public Vector<Form> getFormsByUserName(String userName){
        Vector<Form> _return =new Vector<Form>();
        Connection conn=null;
        try {
            conn=MySQLConnUtils.getMySQLConnection();
            String sql = "SELECT * FROM `Form` WHERE Form.userName='"+userName+"' ";
            Statement stm = conn.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next()) {
                _return.add(new Form(rs.getString("ID"),rs.getString("name"),rs.getString("suspended"),rs.getString("userName")));
            }
            conn.close();
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        return _return;
    }

    public Vector<Form> getAllForms(){
        Vector<Form> _return =new Vector<Form>();
        Connection conn=null;
        try {
            conn=MySQLConnUtils.getMySQLConnection();
            String sql = "SELECT * FROM `Form`  ";
            Statement stm = conn.createStatement();
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next()) {
                _return.add(new Form(rs.getString("ID"),rs.getString("name"),rs.getString("suspended"),rs.getString("userName")));
            }
            conn.close();
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        return _return;
    }
}
