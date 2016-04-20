package DataAccess.Datamappers;

import DataAccess.DBConnector;
import Service.DataException;
import Service.Entity.Checkup;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Joachim E. Christensen
 */
public class CheckUpMapper {

    public boolean createCheckup(int checkupID, String decay, int FK_uID, int FK_bID) {
        try {
            String sql = "INSERT INTO `checkup` (`checkupID`, `decay`, `FK_uID`, `FK_bID`) VALUES (?, ?, ?)";
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(sql);
            pstmt.setInt(1, checkupID);
            pstmt.setString(2, decay);
            pstmt.setInt(3, FK_uID);
            pstmt.setInt(4, FK_bID);
            pstmt.executeUpdate();
        } catch (SQLException | DataException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateCheckup(int checkupID, String decay, int FK_uID, int FK_bID) {
        try {
            String sql = "UPDATE `checkup` SET `decay`=? WHERE `FK_uID`=? AND 'FK_bID`=?";
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(sql);
            pstmt.setInt(1, checkupID);// jeg ved ikke om denne skal med? 
            pstmt.setString(2, decay);
            pstmt.setInt(3, FK_uID);
            pstmt.setInt(4, FK_bID);
            pstmt.executeUpdate();
        } catch (SQLException | DataException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteCheckup(int checkupID, String decay, int FK_uID, int FK_bID) {
        try {
            String sql = "DELETE FROM `checkup` WHERE `decay`=? AND `FK_uID`=? AND `FK_bID` =?";
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(sql);
            pstmt.setInt(1, checkupID);
            pstmt.setString(2, decay);
            pstmt.setInt(3, FK_uID);
            pstmt.setInt(4, FK_bID);
            pstmt.executeUpdate();
        } catch (SQLException | DataException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Checkup> getCheckups() throws DataException {
        List<Checkup> checkups = new ArrayList();
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM `checkup` ORDER BY `checkupID`");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int checkupID = rs.getInt("checkupID");
                String decay = rs.getString("decay");
                int FK_uID = rs.getInt("FK_uID");
                int FK_bID = rs.getInt("FK_bID");
                Checkup checkup = new Checkup(checkupID, decay, FK_uID, FK_bID);
                checkups.add(checkup);
            }
        } catch (SQLException ex) {
            throw new DataException();
        }
        return checkups;
    }
}
