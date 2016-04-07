package DataAccess.Datamappers;

import DataAccess.DBConnector;
import Service.Entity.Checkup;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Joachim E. Christensen
 */
public class CheckUpMapper implements ICheckUpMapper {
    @Override
    public boolean createCheckup(String decay, int FK_uID, int FK_bID) {
        try {
        String sql = "INSERT INTO `checkup` (`decay`, `FK_uID`, `FK_bID`) VALUES (?, ?, ?)";
        PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(sql);
        pstmt.setString(1, decay);
        pstmt.setInt(2, FK_uID);
        pstmt.setInt(3, FK_bID);
        pstmt.executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    @Override
    public boolean updateCheckup(String decay, int FK_uID, int FK_bID) {
        try {
        String sql = "UPDATE `checkup` SET `decay`=? WHERE `FK_uID`=? AND 'FK_bID`=?";
        PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(sql);
        pstmt.setString(1, decay);
        pstmt.setInt(2, FK_uID);
        pstmt.setInt(3, FK_bID);
        pstmt.executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    public boolean deleteCheckup(String decay, int FK_uID, int FK_bID) {
        try {
        String sql = "DELETE FROM `checkup` WHERE `decay`=? AND `FK_uID`=? AND `FK_bID` =?";
        PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(sql);
        pstmt.setString(1, decay);
        pstmt.setInt(2, FK_uID);
        pstmt.setInt(3, FK_bID);
        pstmt.executeUpdate();
        } catch(SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    @Override
    public List<Checkup> getCheckups() throws SQLException{
        List<Checkup> checkups = new ArrayList();
        PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM `checkup` ORDER BY `FK_bID`");
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()){
            String decay = rs.getString("decay");
            int FK_uID = rs.getInt("FK_uID");
            int FK_bID = rs.getInt("FK_bID");
            Checkup checkup = new Checkup(decay, FK_uID, FK_bID);
            checkups.add(checkup);
        }
        return checkups;
    }
}
