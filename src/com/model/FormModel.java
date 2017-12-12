package com.model;

import com.obj.Form;
import com.utils.MySQLConnUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class FormModel {
    public Form addForm(String name, String suspended, String userName) {
        //Create the Connection Object
        Connection conn=null;
        //Create Form Object to carry the returned newly created Form
        Form form =null;
        try{
            //Get the Database Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create the SQL Query
            String sql = "INSERT INTO `Form` (, `name`, `suspended`, `userName`) VALUES ( '" + name + "', '" + suspended + "', '" + userName + "')";
            //Create Statement to Execute the Query
            Statement stm = conn.createStatement();
            //Execute the Query
            stm.executeUpdate(sql);
            //Assign the form to the newly created form
            form = new Form(getLastID(), name, suspended, userName);
            //Close the Database Connection
            conn.close();
        }catch (Exception ex){
            //If there's an Exception prints the text of it
            System.out.println(ex.toString());
        }
        // return the newly created Form
        return form;
        //That's All! Done!! Enjoy ;)
    }

    public Form getForm(int ID) {
        //Create Form object to carry the return results
        Form form = null;
        //Create the Connection
        Connection conn = null;
        try {
            //Get the DataBase Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create Sql Query
            String sql = "SELECT  FROM `Form` WHERE Form.ID='" + ID + "' ";
            //Create Statement to Execute the Query
            Statement stm = conn.createStatement();
            //Create ResultSet Object to carry the results
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {//get the Next (if exists)
                //Add Entry to the Return Vector
                form = new Form(rs.getInt("ID"), rs.getString("name"), rs.getString("suspended"), rs.getString("userName"));
            }
            //Close the Database Connection
            conn.close();
        } catch (Exception ex) {
            //If Exist Exception
            System.out.println(ex.toString());
        }
        //return the object which carries the results
        return form;
        //That's All! Done!! Enjoy ;)

    }
    public Vector<Form> getFormsByUserName(String userName){
        //Create Vector to carry the return results
        Vector<Form> _return =new Vector<Form>();
        //Create the Connection
        Connection conn=null;
        try {
            //Get the DataBase Connection
            conn=MySQLConnUtils.getMySQLConnection();
            //Create Sql Query
            String sql = "SELECT * FROM `Form` WHERE Form.userName='"+userName+"' ";
            //Create Statement to Execute the Query
            Statement stm = conn.createStatement();
            //Create ResultSet Object to carry the results
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next()) {//get the Next (if exists)
                //Add Entry to the Return Vector
                _return.add(new Form(rs.getInt("ID"), rs.getString("name"), rs.getString("suspended"), rs.getString("userName")));
            }
            //Close the Database Connection
            conn.close();
        }catch (Exception ex){
            //If Exist Exception
            System.out.println(ex.toString());
        }
        //return the Vector which carries the results
        return _return;
        //That's All! Done!! Enjoy ;)
    }

    public Vector<Form> getAllForms(){
        //Create Vector to carry the return results
        Vector<Form> _return =new Vector<Form>();
        //Create the Connection
        Connection conn=null;
        try {
            //Get DataBase Connection
            conn=MySQLConnUtils.getMySQLConnection();
            //Create the Query
            String sql = "SELECT * FROM `Form`  ";
            //Create the Statement to Excute the Query
            Statement stm = conn.createStatement();
            //Create the ResultSet object to carry the results
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next()) {//Get the next result (if any)
                //Add Form to the Vector
                _return.add(new Form(rs.getInt("ID"), rs.getString("name"), rs.getString("suspended"), rs.getString("userName")));
            }
            //close DataBase Connection
            conn.close();
        }catch (Exception ex){
            //If There is An Exception printout its text
            System.out.println(ex.toString());
        }
        //return the vector which carries the results
        return _return;
        //That's All! Done!! Enjoy ;)
    }

    public Form SuspendForm(int ID) {
        //Create form object to carry the return results
        Form form = null;
        //Create the Connection
        Connection conn = null;
        try {
            //Get the DataBase Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create Sql Query
            String sql = "UPDATE `Form` SET `suspended` = 'yes' WHERE `Form`.`ID` = " + ID + "";
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
        //return the updated object which carries the results
        return form = getForm(ID);
        //That's All! Done!! Enjoy ;)
    }

    public Form UnSuspendForm(int ID) {
        //Create form object to carry the return results
        Form form = null;
        //Create the Connection
        Connection conn = null;
        try {
            //Get the DataBase Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create Sql Query
            String sql = "UPDATE `Form` SET `suspended` = 'no' WHERE `Form`.`ID` = " + ID + "";
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
        //return the updated object which carries the results
        return form = getForm(ID);
        //That's All! Done!! Enjoy ;)
    }

    public Form removeForm(int ID) {
        //Create the Connection
        Connection conn = null;
        try {
            //Get the DataBase Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create Sql Query
            String sql = "DELETE FROM `Form`  WHERE `Form`.`ID` = " + ID + "";
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
        return getForm(ID);
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
            String sql = "SELECT max(ID) as LastID From Form";
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
