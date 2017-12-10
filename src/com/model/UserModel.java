/*
    Made By ZizoNaser
    @ Sat Dec 9, 3:24pm
    Twitter: @ZizoNaser
 */
package com.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.obj.User;
import com.utils.MySQLConnUtils;

public class UserModel {
        public User addUser(String userName,String password,String type,String name,String email){
             Connection conn = null;
             User user=null;
             if(getUserByuserName(userName) != null) return null;
             if(getUserByEmail(email) != null) return null;
             try {
                 conn =MySQLConnUtils.getMySQLConnection();
                 String sql="INSERT INTO `User` (`userName`, `name`, `password`, `email`, `type`) VALUES ('"+userName+"', '"+name+"', '"+password+
                         "', '"+email+"', '"+type+"')";
                 Statement stm = conn.createStatement();
                 stm.executeUpdate(sql);
                 user=new User(name,userName,password,email,type);
                conn.close();
             }catch (Exception ex){
                System.out.println(ex.toString());
             }
            return user;
        }

        public User getUserByuserName(String userName){
            Connection conn = null;
            User user=null;
            try{
                conn=MySQLConnUtils.getMySQLConnection();
                String sql ="SELECT * FROM `User` WHERE User.userName = '"+userName+"' ";
                Statement stm=conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                if(rs.next()){
                    user=new User(rs.getString("name"),rs.getString("userName"),rs.getString("password"),rs.getString("email"),rs.getString("type"));
                }
                conn.close();
            }catch (Exception ex){
                System.out.println(ex.toString());
            }
            return user;
        }

        public  User getUserByEmail(String email){
            Connection conn = null;
            User user=null;
            try{
                conn=MySQLConnUtils.getMySQLConnection();
                String sql ="SELECT * FROM `User` WHERE User.email = '"+email+"' ";
                Statement stm=conn.createStatement();
                ResultSet rs = stm.executeQuery(sql);
                if(rs.next()){
                    user=new User(rs.getString("name"),rs.getString("userName"),rs.getString("password"),rs.getString("email"),rs.getString("type"));
                }
                conn.close();
            }catch (Exception ex){
                System.out.println(ex.toString());
            }
            return user;
        }
        public boolean checkUserNameAndEmail (String userName,String email){
            return (getUserByuserName(userName) == null && getUserByEmail(email) == null) ? true : false ;
        }
}

