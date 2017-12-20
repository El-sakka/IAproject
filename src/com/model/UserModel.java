/*
    Made By ZizoNaser
    @ Sat Dec 9, 3:24pm
    Twitter: @ZizoNaser
 */
package com.model;

import com.obj.User;
import com.utils.MySQLConnUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

public class UserModel {
        public User addUser(String userName,String password,String type,String name,String email){
            //Create Connection Object
             Connection conn = null;
            //Create Return Object
             User user=null;
            //check if userName exits or the E-mail
            if (getUserByUserName(userName) != null) return null;
             if(getUserByEmail(email) != null) return null;
             try {
                 //get The DataBase connection
                 conn =MySQLConnUtils.getMySQLConnection();
                 //Create SQL Query
                 String sql="INSERT INTO `User` (`userName`, `name`, `password`, `email`, `type`) VALUES ('"+userName+"', '"+name+"', '"+password+
                         "', '"+email+"', '"+type+"')";
                 //Create Statement to Execute the Query
                 Statement stm = conn.createStatement();
                 //Execute the Query
                 stm.executeUpdate(sql);
                 //Assign the Newly Created Object to the return object
                 user=new User(name,userName,password,email,type);
                 //Close Connection
                conn.close();
             }catch (Exception ex){
                 //Print the Exception's Text (if any)
                System.out.println(ex.toString());
             }
            //return the newly created object
            return user;
            //That's All! done!! Enjoy ;)
        }

    public void ChangePassword(String userName, String password) {
        //
        //Create Connection Object
        Connection conn = null;
        try {
            //get The DataBase connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create SQL Query
            String sql = "UPDATE `User` SET `password` = '" + password + "' WHERE `User`.`userName` = '" + userName + "'";
            //Create Statement to Execute the Query
            Statement stm = conn.createStatement();
            //Execute the Query
            stm.executeUpdate(sql);
            //Close Connection
            conn.close();
        } catch (Exception ex) {
            //Print the Exception's Text (if any)
            System.out.println(ex.toString());
        }
    }

    public User getUserByUserName(String userName) {
        //Create Connection Object
            Connection conn = null;
        //Create Return Object
            User user=null;
            try{
                //Get the Database connection
                conn=MySQLConnUtils.getMySQLConnection();
                //Create SQL Query
                String sql ="SELECT * FROM `User` WHERE User.userName = '"+userName+"' ";
                //Create Statement Object to Execute the Query
                Statement stm=conn.createStatement();
                //Execute the Query and push results to the ResultSet object
                ResultSet rs = stm.executeQuery(sql);
                if (rs.next()) {//get the next (if any)
                    //Assign the result object to the return object
                    user=new User(rs.getString("name"),rs.getString("userName"),rs.getString("password"),rs.getString("email"),rs.getString("type"));
                }
                //Close the dataBase connection
                conn.close();
            }catch (Exception ex){
                //If There's any Exception print its text
                System.out.println(ex.toString());
            }
        //return the result object
            return user;
        //That's All! done!! Enjoy ;)
        }

    public Vector<User> getAll() {
        //Create Connection Object
        Connection conn = null;
        //Create Return Object
        Vector<User> users = new Vector<User>();
        try {
            //Get the Database connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create SQL Query
            String sql = "SELECT * FROM `User` WHERE 1";
            //Create Statement Object to Execute the Query
            Statement stm = conn.createStatement();
            //Execute the Query and push results to the ResultSet object
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {//get the next (if any)
                //Assign the result object to the return object
                users.add(new User(rs.getString("name"), rs.getString("userName"), rs.getString("password"), rs.getString("email"), rs.getString("type")));
            }
            //Close the dataBase connection
            conn.close();
        } catch (Exception ex) {
            //If There's any Exception print its text
            System.out.println(ex.toString());
        }
        //return the result object
        return users;
        //That's All! done!! Enjoy ;)
    }
        public  User getUserByEmail(String email){
            //Create Connection Object
            Connection conn = null;
            //Create Return Object
            User user=null;
            try{
                //Get the Database connection
                conn=MySQLConnUtils.getMySQLConnection();
                //Create SQL Query
                String sql ="SELECT * FROM `User` WHERE User.email = '"+email+"' ";
                //Create Statement Object to Execute the Query
                Statement stm=conn.createStatement();
                //Execute the Query and push results to the ResultSet object
                ResultSet rs = stm.executeQuery(sql);
                if (rs.next()) {//get the next (if any)
                    //Assign the result object to the return object
                    user=new User(rs.getString("name"),rs.getString("userName"),rs.getString("password"),rs.getString("email"),rs.getString("type"));
                }
                //Close the dataBase connection
                conn.close();
            }catch (Exception ex){
                //If There's any Exception print its text
                System.out.println(ex.toString());
            }
            //return the result object
            return user;
            //That's All! done!! Enjoy ;)
        }

    public User SuspendUser(String userName) {
        //Create the Connection
        Connection conn = null;
        try {
            //Get the DataBase Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create Sql Query
            String sql = "UPDATE `User` SET User.type = 'sus' WHERE `User`.`userName` = " + userName + "";
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
        return getUserByUserName(userName);
        //That's All! Done!! Enjoy ;)
    }

    public User AdministratingUser(String userName) {
        //Create the Connection
        Connection conn = null;
        try {
            //Get the DataBase Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create Sql Query
            String sql = "UPDATE `User` SET User.type = 'admin' WHERE `User`.`userName` = " + userName + "";
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
        return getUserByUserName(userName);
        //That's All! Done!! Enjoy ;)
    }

    public User NormalizeUser(String userName) {
        //Create the Connection
        Connection conn = null;
        try {
            //Get the DataBase Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Create Sql Query
            String sql = "UPDATE `User` SET User.type = 'norm' WHERE `User`.`userName` = " + userName + "";
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
        return getUserByUserName(userName);
        //That's All! Done!! Enjoy ;)
    }


    public User RemoveUser(String userName) {
        //Create Connection Object
        Connection conn = null;
        try {
            //Get the Database Connection
            conn = MySQLConnUtils.getMySQLConnection();
            //Creating MySQL Query
            String sql = "DELETE FROM User WHERE userName=" + userName;
            //Creating Statement object to execute the query
            Statement stm = conn.createStatement();
            //Execute the query
            stm.executeUpdate(sql);
            //Close The DataBase Connection
            conn.close();
        } catch (Exception ex) {
            //IF There's an Exception print out its text
            System.out.println(ex.toString());
        }
        //checks if it successfully deleted
        return getUserByUserName(userName);
        //That's All! done!! Enjoy ;)
    }

    public boolean checkUserNameAndEmail(String userName, String email) {
        // check if the userName or the Email exists
        return getUserByUserName(userName) == null && getUserByEmail(email) == null;
        //That's All! done!! Enjoy ;)
    }

}

