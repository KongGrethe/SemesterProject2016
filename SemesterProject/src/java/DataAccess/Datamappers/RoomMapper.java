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

/**
 *
 * @author Joachim
 */
public class RoomMapper {
        public boolean createRoom(String room, String where, String whatHappened,
            String whatHasBeenDone, String damageType, String wallNotes,
            String ceilingNotes, String floorNotes, String windowDoorNotes,
            String wallName, String ceilingName, String floorName, String windowName,
            String moistScan, String measuringPoint, int FK_bID) {
        try {
            String sql = "INSERT INTO room VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
            pstmt.setString(10, wallName);
            pstmt.setString(11, ceilingName);
            pstmt.setString(12, floorName);
            pstmt.setString(13, windowName);
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
