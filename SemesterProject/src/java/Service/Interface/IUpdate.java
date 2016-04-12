package Service.Interface;

/**
 * @author Joachim
 * Interface consisting of Prototype methods for dataAccess
 */
public interface IUpdate {
    boolean updateCheckup(int checkupID, String decay, int FK_uID, int FK_bID);
    boolean updateNotification (int nID, String content, int FK_bID);
}
