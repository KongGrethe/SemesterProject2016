/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Datamappers;

import DataAccess.DBConnector;
import java.sql.*;

/**
 *
 * @author christian
 */
public class FileMapper implements IFileMapper {

    @Override
    public boolean createFile(String fName, int FK_bID, int FK_uID) {
        try {
           String sql = "INSERT INTO `files`(`fName`, `FK_bID`,`FK_uID`) VALUES(?,?,?)"; 
           PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(sql);
           pstmt.setString(1, fName);
           pstmt.setInt(2, FK_uID);
           pstmt.setInt(3, FK_bID);
           pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
      return true;
    }

    @Override
    public boolean deleteFile(String fName) {
        try {
        String sql = "DELETE FROM `files` WHERE (`fname=?`)";
        PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(sql);
        pstmt.setString(1,fName);
        pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
       return true;
    }
    
    
}
