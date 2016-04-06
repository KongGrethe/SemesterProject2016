package Service.Interface;

/**
 * @author Joachim
 * Interface consisting of Prototype methods for dataAccess
 */
public interface IDelete {
    boolean deleteBuilding(int bID);
    boolean deleteUser(String uFName, String uLName, String upw, String email, String userRole, int FK_cuID);
    boolean deleteCheckup(String decay, int FK_uID, int FK_bID);
}
