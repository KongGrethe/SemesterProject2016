package Service.Interface;

import javax.servlet.http.Part;

/**
 * @author Joachim
 * Interface consisting of Prototype methods for dataAccess
 */
public interface ICreate {
    boolean createBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl, int FK_uID);
    boolean createUser(int uID, String uFName, String uLName, String upw, String email, String userRole, int FK_cuID);
    boolean createCheckup(int checkupID, String decay, int FK_uID, int FK_bID);
    boolean createNotification (int nID, String content, int FK_bID, int FK_uID);
    boolean createFile(String fName, int FK_bID, int FK_uID);
    boolean createRoom(String room, String where, String whatHappened, String whatHasBeenDone, String damageType, String wallNotes, String ceilingNotes, String floorNotes, String windowDoorNotes, Part wallPart, Part ceilingPart, Part floorPart, Part windowDoorPart, String moistScan, String measuringPoint, int FK_checkupID);
}
