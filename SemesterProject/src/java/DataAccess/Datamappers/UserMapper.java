/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Datamappers;

import DataAccess.DBConnector;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Christian
 */
public class UserMapper {

    public boolean createUser(int uID, String uFName, String uLName, String upw, String email, String userRole, int FK_cuID) {
        try {
            String sql = "INSERT INTO ´users´ (`uID`, `uFName`, `uLName`, `upw`, `email`, `userRole`, `FK_cuID` ) VALUES(?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(sql);
            pstmt.setInt(1, uID);
            pstmt.setString(2, uFName);
            pstmt.setString(3, uLName);
            pstmt.setString(4, upw);
            pstmt.setString(5, email);
            pstmt.setString(6, userRole);
            pstmt.setInt(7, FK_cuID);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteUser(int uID, String uFName, String uLName, String upw, String email, String userRole, int FK_cuID) {
        try {
            String sql = "DELETE FROM `users` WHERE (`uID`=?, `uFName`=?, `uLName`=?, `upw`=?, `email`=?, `userRole`=?, `FK_cuID`=?)";
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(sql);
            pstmt.setInt(1, uID);
            pstmt.setString(2, uFName);
            pstmt.setString(3, uLName);
            pstmt.setString(4, upw);
            pstmt.setString(5, email);
            pstmt.setString(6, userRole);
            pstmt.setInt(7, FK_cuID);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
