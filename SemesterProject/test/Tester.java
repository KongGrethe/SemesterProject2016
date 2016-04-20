/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import DataAccess.DBConnector;
import Service.DataException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Michael
 */
public class Tester {
    public static void main(String[] args) throws DataException {
        try {
         //DBFacade dbf = DBFacade.getInstance();
         Connection con = DBConnector.getConnection();
         PreparedStatement pstmt = con.prepareStatement("SELECT * FROM users");
         ResultSet rs = pstmt.executeQuery();
         while (rs.next()) {
         int uID = rs.getInt(1);
         String uFName = rs.getString("uFName");
         String uLName = rs.getString("uLName");
         String upw = rs.getString("upw");
         String email = rs.getString("email");
         String userRole = rs.getString("userRole");
         int cuID = rs.getInt(1);
         System.out.println(uID + "\t" + uFName + "\t" + uLName + "\t" + upw + "\t" + email + "\t" + userRole + "\t" + cuID);
         }
         } catch (SQLException ex) {
             throw new DataException();
         }
    }
}
