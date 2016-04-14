/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Datamappers;

import DataAccess.DBConnector;
import Service.Entity.Files;
import Service.Entity.Notification;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
           pstmt.setInt(2, FK_bID);
           pstmt.setInt(3, FK_uID);
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
    
    
    
    /*
            @Override
    public List<Checkup> getCheckups() throws SQLException{
        List<Checkup> checkups = new ArrayList();
        PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM `checkup` ORDER BY `checkupID`");
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            int checkupID = rs.getInt("checkupID");
            String decay = rs.getString("decay");
            int FK_uID = rs.getInt("FK_uID");
            int FK_bID = rs.getInt("FK_bID");
            Checkup checkup = new Checkup(checkupID, decay, FK_uID, FK_bID);
            checkups.add(checkup);
        }
        return checkups;
    }
            */

     @Override
    public List<Files> selectAllFiles(int FK_bID) throws SQLException {
        List<Files> list = new ArrayList();
        PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM files WHERE FK_bID=?");
        pstmt.setInt(1, FK_bID);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String fName = rs.getString("fName");
            int bid = rs.getInt(2);
            int uid = rs.getInt(3);
            Files file = new Files(fName, bid, uid);
            list.add(file);
        }
        return list;
    }
    
    /*
    public List<Notification> selectBuildingNotification(int FK_bID) throws SQLException {
        List<Notification> notifications = new ArrayList();
        PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM `notifications` WHERE `FK_bID`=? ORDER BY `nID`");
        pstmt.setInt(1, FK_bID);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            int nID = rs.getInt("nID");
            String content = rs.getString("content");
            Notification notification = new Notification(nID, content, FK_bID);
            notifications.add(notification);
        }
        return notifications;
    }
    */
}
