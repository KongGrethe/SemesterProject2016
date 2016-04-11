package DataAccess.Datamappers;

import DataAccess.DBConnector;
import Service.Entity.Notification;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Joachim E. Christensen
 */
public class NotificationMapper {
    
    public boolean createNotification (int nID, String content, int FK_bID) {
        try {
            String sql = "INSERT INTO `notification`(`nID`, `content`,`FK_bID`) VALUES(?, ?, ?)";
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(sql);
            pstmt.setInt(1, nID);
            pstmt.setString(2, content);
            pstmt.setInt(3, FK_bID);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean deleteNotification (int nID) {
        try {
            String sql = "DELETE FROM buildings WHERE nID=" + nID;
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public List<Notification> selectAllNotification() throws SQLException {
        List<Notification> notifications = new ArrayList();
        PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM `notifications` ORDER BY `nID`");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            int nID = rs.getInt("nID");
            String content = rs.getString("content");
            int FK_bID = rs.getInt("FK_bID");
            Notification notification = new Notification(nID, content, FK_bID);
            notifications.add(notification);
        }
        return notifications;
    }
    
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
    
    public boolean updateNotification (int nID, String content) {
        try {
        String sql = "UPDATE `notification` SET `content`=? WHERE `nID`=?";
        PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(sql);
        pstmt.setString(1, content);
        pstmt.setInt(2, nID);
        pstmt.executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
