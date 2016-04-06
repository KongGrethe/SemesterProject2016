package DataAccess.Datamappers;

import DataAccess.DBConnector;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Joachim E. Christensen
 */
public class BuildingMapper {
    public boolean createBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl, int FK_uID) {
        try {
        String sql = "INSERT INTO `buildings`(`bName`,`bAddress`, `parcelNr`, `bSize`, `bfPlan`, `condLvl`, `FK_uID`) VALUES(?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(sql);
        pstmt.setString(1, bName);
        pstmt.setString(2, bAddress);
        pstmt.setInt(3, parcelNr);
        pstmt.setDouble(4, bSize);
        pstmt.setInt(5, bfPlan);
        pstmt.setInt(6, condLvl);
        pstmt.setInt(7, FK_uID);
        pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean deleteBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl, int FK_uID) {
        try {
        String sql = "DELETE FROM `buildings` WHERE `bName`=? AND `bAddress`=? AND `parcelNr`=? AND `bSize`=? AND `bfPlan`=? AND `condLvl`=? AND `FK_uID`=?";
        PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(sql);
        pstmt.setString(1, bName);
        pstmt.setString(2, bAddress);
        pstmt.setInt(3, parcelNr);
        pstmt.setDouble(4, bSize);
        pstmt.setInt(5, bfPlan);
        pstmt.setInt(6, condLvl);
        pstmt.setInt(7, FK_uID);
        pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
