/*
 * Made By  (c) ZizoNaser
 *  12/18/17 2:43 PM
 *  Twitter: @ZizoNaser
 *  GitHub: github.com/ZizoNaser
 */

package com.model;

import com.obj.Message;
import com.utils.MySQLConnUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class MessageModel {
    public Message addMessage(String text, String aNew, String Sender, String Receiver) {
        aNew = "yes";
        //Create Connection Object
        Connection conn = null;
        //Create Object to be return
        Message msg = null;
        try {
            //Get DataBase Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create SQL Query
            String sql = "INSERT INTO `Message` (`ID`, `text`, `new`, `sender`, `receiver`) VALUES (NULL, '" + text + "', '" + aNew + "', '" + Sender + "', '" + Receiver + "')";
            //Create Statement to Execute the Query
            Statement stm = conn.createStatement();
            //Execute the Query
            stm.executeUpdate(sql);
            //Assign the newly created object to the return object
            msg = new Message(getLastID(), text, aNew, Sender, Receiver);
            //Close DataBase connection
            conn.close();
        } catch (Exception e) {
            //Print out the Exception Text IF any
            System.out.println(e.toString());
        }
        //return the newly created object
        return msg;
        //That's All! Done!! Enjoy ;)
    }

    public Vector<Message> getMessagesForUser(String userName) {
        //Create Connection object
        Connection conn = null;
        //Create Return Vector
        Vector<Message> _return = new Vector<Message>();
        try {
            //Get the Database Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create SQL Query
            String sql = "SELECT * FROM Message WHERE Message.receiver ='" + userName + "'";
            //Create Statement to Execute the Query
            Statement stm = conn.createStatement();
            //Execute the Query
            ResultSet rs = stm.executeQuery(sql);
            //LooP on the Results
            while (rs.next()) {// get Next If any
                //add the result to the vector
                _return.add(new Message(rs.getInt("ID"), rs.getString("text"), rs.getString("new"), rs.getString("sender"), rs.getString("receiver")));
            }
            //Close the DataBase Connection
            conn.close();
        } catch (Exception e) {
            //Print out the Exception Text IF any
            System.out.println(e.toString());
        }
        //return the vector
        return _return;
        //That's All! Done!! Enjoy ;)
    }

    public Message removeMessage(int ID) {
        //Create Connection Object
        Connection conn = null;
        try {
            //Get the Database Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create SQL Query
            String sql = "DELETE FROM Message WHERE Message.ID =" + ID;
            //Create Statement to Execute the Query
            Statement stm = conn.createStatement();
            //Execute the Query
            stm.executeUpdate(sql);
            //Close the DataBase Connection
            conn.close();
        } catch (Exception e) {
            //Print out the Exception Text IF any
            System.out.println(e.toString());
        }
        //return the newly created object
        return getMessage(ID);
        //That's All! Done!! Enjoy ;)
    }

    public Message MarkAsRead(int ID) {
        //Create Connection Object
        Connection conn = null;
        try {
            //Get the Database Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create SQL Query
            String sql = "UPDATE `Message` SET `new` = 'no' WHERE `Message`.`ID` = " + ID;
            //Create Statement to Execute the Query
            Statement stm = conn.createStatement();
            //Execute the Query
            stm.executeUpdate(sql);
            //Close the DataBase Connection
            conn.close();
        } catch (Exception e) {
            //Print out the Exception Text IF any
            System.out.println(e.toString());
        }
        //return the newly created object
        return getMessage(ID);
        //That's All! Done!! Enjoy ;)
    }

    //UPDATE `Message` SET `new` = 'no' WHERE `Message`.`ID` = 3
    public Message getMessage(int ID) {
        //Create Connection Object
        Connection conn = null;
        //Create Object to be return
        Message msg = null;
        try {
            //Get the Database Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create SQL Query
            String sql = "SELECT * FROM Message WHERE Message.ID =" + ID;
            //Create Statement to Execute the Query
            Statement stm = conn.createStatement();
            //Execute the Query
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {//if there's a result
                // create new object contains the result
                msg = new Message(rs.getInt("ID"), rs.getString("text"), rs.getString("new"), rs.getString("sender"), rs.getString("receiver"));
            }
            //Close the DataBase Connection
            conn.close();
        } catch (Exception e) {
            //Print out the Exception Text IF any
            System.out.println(e.toString());
        }
        //return the newly created object
        return msg;
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
            String sql = "SELECT max(ID) as LastID From Message";
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
