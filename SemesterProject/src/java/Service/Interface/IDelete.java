package Service.Interface;

/**
 * @author Joachim
 * Interface consisting of Prototype methods for dataAccess
 */
public interface IDelete {
    boolean deleteBuilding(int bID);
    boolean deleteUser(int uID);
    boolean deleteNotification (int nID);
    boolean deleteFile(String fName);
}
