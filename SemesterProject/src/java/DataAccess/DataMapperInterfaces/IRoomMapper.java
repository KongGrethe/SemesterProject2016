/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DataMapperInterfaces;

/**
 *
 * @author Joachim
 */
public interface IRoomMapper {
    boolean createRoom(String room, String where, String whatHappened, String whatHasBeenDone, String damageType, String wallNotes, String ceilingNotes, String floorNotes, String windowDoorNotes, String wallName, String ceilingName, String floorName, String windowName, String moistScan, String measuringPoint, int FK_bID);
}
