package Service.Interface;

/**
 * @author Joachim
 * Interface consisting of Prototype methods for dataAccess
 */
public interface IUpdate {
    boolean updateCheckup(String decay, int FK_uID, int FK_bID);
}
