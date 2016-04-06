package DataAccess.Datamappers;

import DataAccess.DBConnector;
import Service.Entity.Building;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Joachim E. Christensen
 */
public class BuildingMapper {

    public boolean createBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl, int FK_uID) {
        try {
            String sql = "INSERT INTO `buildings`(`bID`, `bName`,`bAddress`, `parcelNr`, `bSize`, `bfPlan`, `condLvl`, `FK_uID`) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(sql);
            pstmt.setInt(1, 0);
            pstmt.setString(2, bName);
            pstmt.setString(3, bAddress);
            pstmt.setInt(4, parcelNr);
            pstmt.setDouble(5, bSize);
            pstmt.setInt(6, bfPlan);
            pstmt.setInt(7, condLvl);
            pstmt.setInt(8, FK_uID);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean deleteBuilding(int bID) {
        System.out.println("hej" + bID);
        try {
            String sql = "DELETE FROM buildings WHERE bID=" + bID;
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(sql);

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public List<Building> getBuildings() throws SQLException {
        List<Building> buildings = new ArrayList();
        PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM `buildings` ORDER BY `bID`");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            int bID = rs.getInt("bID");
            String bName = rs.getString("bName");
            String bAddress = rs.getString("bAddress");
            int parcelNr = rs.getInt("parcelNr");
            double bSize = rs.getDouble("bSize");
            int bfPlan = rs.getInt("bfPlan");
            int condLvl = rs.getInt("condLvl");
            int FK_uID = rs.getInt("FK_uID");
            Building building = new Building(bID, bName, bAddress, parcelNr, bSize, bfPlan, condLvl, FK_uID);
            buildings.add(building);
        }
        return buildings;
    }
}
