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
    public Options addOption(String ID, String optionText, String questionID) {
        Options option = null;
        Connection conn = null;
        try {
            conn = MySQLConnUtils.getMySQLConnection();
            String sql = "INSERT INTO `Options` (`ID`, `optionText`, `questionID`) VALUES ('" + ID + "', '" + optionText + "', '" + questionID + "')";
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            option = new Options(ID, optionText, questionID);
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return option;
    }

    public Vector<Options> getOptions(String questionID) {
        Vector<Options> _return = new Vector<Options>();
        Connection conn = null;
        Options option = null;
        try {
            conn = MySQLConnUtils.getMySQLConnection();
            Statement stm = conn.createStatement();
            String sql = "SELECT `ID`, `optionText`, `questionID` FROM `Options` WHERE Options.questionID = '" + questionID + "'";
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                _return.add(new Options(rs.getString("ID"), rs.getString("optionText"), rs.getString("questionID")));
            }
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return _return;
    }

}
