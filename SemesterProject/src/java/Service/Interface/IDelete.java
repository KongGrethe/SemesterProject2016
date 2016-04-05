package Service.Interface;

/**
 * @author Joachim
 * Interface consisting of Prototype methods for dataAccess
 */
public interface IDelete {
    boolean deleteBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl, int FK_uID);
    boolean deleteUser(String uFName, String uLName, String upw, String email, String userRole, int FK_cuID);
    boolean deleteCheckup(String decay, int FK_uID, int FK_bID);
}
