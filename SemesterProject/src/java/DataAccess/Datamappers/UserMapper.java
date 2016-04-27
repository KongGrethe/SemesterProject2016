/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Datamappers;

import DataAccess.DBConnector;
import Service.DataException;
import Service.Entity.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Christian
 */
public class UserMapper{
    
    

    public int createUser(int uID, String uFName, String uLName, String upw, String email, String userRole, int FK_cuID){
            int result; 
        try {
            String sql = "INSERT INTO users (`uFName`, `uLName`, `upw`, `email`, `userRole`, `FK_cuID` ) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(sql);
            
            pstmt.setString(1, uFName);
            pstmt.setString(2, uLName);
            pstmt.setString(3, upw);
            pstmt.setString(4, email);
            pstmt.setString(5, userRole);
            pstmt.setInt(6, FK_cuID);
            pstmt.executeUpdate();
            //Get last inserted id from auto increment
            sql = "SELECT AUTO_INCREMENT FROM information_schema.tables WHERE table_name ='users' AND table_schema = DATABASE()";
            ResultSet rs = DBConnector.getConnection().prepareStatement(sql).executeQuery();
            rs.next();
            result = rs.getInt(1);
        } catch (SQLException | DataException ex) {
            ex.printStackTrace(); //HVORDAN SMIDER VI SÅ EN SPECIFIK FEJLMEDDELELSE??
            return -1;
        }
        return result;
    }

    public boolean deleteUser(int uID){
        try {
            String sql = "DELETE FROM `users` WHERE `uID`=" + uID;
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(sql);
            pstmt.setInt(1, uID);
            pstmt.executeUpdate();
        return true;
        } catch (SQLException | DataException ex) {
            ex.printStackTrace();
            return false;
        }
    }

                                                        
    public List<User> getUsers() throws DataException { //Med denne metode, laver vi en liste af Users, som vi hiver ud af databasen.
        try {
        List<User> users = new ArrayList<>();          // Laver en ny liste ved navn users
        PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM `Users` ORDER BY `uID`");
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
        } catch (SQLException ex) {
            throw new DataException();
        }
    }
    
    public int[] validate(String Username, String Password) throws DataException { // FLYT DENNE METODE TIL EN MAPPER OG REFERER
        int res[] = new int[2];
        System.out.println("kom her til" + Username);
        try {            
            Statement stat = DBConnector.getConnection().createStatement();
            String query = "select * from users where uFName='" + Username
                    + "' and upw='" + Password + "'";
            ResultSet rs = stat.executeQuery(query);
            if (rs.next()) {
                res[0] = rs.getInt(1);
                if(rs.getString(6).equals("employee")) {
                    res[1] = 2;
                } else {
                    res[1] = 1;
                }
                System.out.println(res[0]);
                System.out.println(res[1]);
            }
        } catch (SQLException | DataException ex) {
            res[0] = 0;
            res[1] = 0;
            throw new DataException("Der gik noget galt i valideringen");
        }
        return res;
    }

}
