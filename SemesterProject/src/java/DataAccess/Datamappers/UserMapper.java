/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Datamappers;

import DataAccess.DBConnector;
import Service.Entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class UserMapper implements IUserMapper {

    @Override
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

    @Override
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

    @Override
    public List<User> getUsers() throws SQLException { //Med denne metode, laver vi en liste af Users, som vi hiver ud af databasen.
        List<User> users = new ArrayList<>();          // Laver en ny liste ved navn users
        PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM ´Users´ SORTED BY ´uID´");
                                                       // ^Forbereder statement fra databasen, hvor vi hiver alle users ud og sorterer efter userID'et,        
        ResultSet rs = pstmt.executeQuery();           // og laver et resultset (rs) ud af det.

        while (rs.next())                              //Så længe vi ikke er nået til slutningen..
        {
            int uID = rs.getInt("uID");
            String uFName = rs.getString("uFName");
            String uLName = rs.getString("uLName");
            String upw = rs.getString("upw");
            String email = rs.getString("email");
            String userRole = rs.getString("userRole");
            int FK_cuID = rs.getInt("FK_cuID");

            User user = new User(uID, uFName, uLName, upw, email, userRole, FK_cuID); 
                                                       // ..laver vi en ny bruger..
            users.add(user);                           //.. og tilføjer til vores liste, som vi lavede i starten,..^
        }
        return users;                                  //.. og retunerer listen.
    }
}
