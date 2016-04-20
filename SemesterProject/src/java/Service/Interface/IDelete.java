package Service.Interface;

/**
 * @author Joachim
 * Interface consisting of Prototype methods for dataAccess
 */
public interface IDelete {
    boolean deleteBuilding(int bID);
    boolean deleteUser(int uID);
    boolean deleteCheckup(int checkupID, String decay, int FK_uID, int FK_bID);
    boolean deleteNotification (int nID);
    boolean deleteFile(String fName);
}
