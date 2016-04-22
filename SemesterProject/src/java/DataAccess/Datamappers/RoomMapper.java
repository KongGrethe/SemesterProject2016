/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Datamappers;

import DataAccess.DBConnector;
import Service.DataException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.http.Part;

/**
 *
 * @author Joachim
 */
public class RoomMapper {
    public boolean createRoom(String room, String where, String whatHappened, String whatHasBeenDone, String damageType, String wallNotes, String ceilingNotes, String floorNotes, String windowDoorNotes, Part wallPart, Part ceilingPart, Part floorPart, Part windowDoorPart, String moistScan, String measuringPoint, int FK_bID) {
        try {
            String sql = "INSERT INTO `room`(`rName`, `rWhere`, `rHappened`, `rHasBeenDone`, `rDamageType`, `rWallNotes`, `rCeilingNotes`, `rFloorNotes`, `rWindowNotes`, `rWallName`, `rCeilingName`, `rFloorName`, `rWindowDoorName`, `rMoistScan`, `rMeasuringPoint`, `FK_bID`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(sql);
            pstmt.setString(1, room);
            pstmt.setString(2, where);
            pstmt.setString(3, whatHappened);
            pstmt.setString(4, whatHasBeenDone);
            pstmt.setString(5, damageType);
            pstmt.setString(6, wallNotes);
            pstmt.setString(7, ceilingNotes);
            pstmt.setString(8, floorNotes);
            pstmt.setString(9, windowDoorNotes);
            pstmt.setString(10, wallPart.toString());
            pstmt.setString(11, ceilingPart.toString());
            pstmt.setString(12, floorPart.toString());
            pstmt.setString(13, windowDoorPart.toString());
            pstmt.setString(14, moistScan);
            pstmt.setString(15, measuringPoint);
            pstmt.setInt(16, FK_bID);
            pstmt.executeUpdate();
        } catch (SQLException | DataException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
}
