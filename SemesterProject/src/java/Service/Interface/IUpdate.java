package Service.Interface;

/**
 * @author Joachim
 * Interface consisting of Prototype methods for dataAccess
 */
public interface IUpdate {
    boolean updateBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl, int FK_uID);
    boolean updateUser(String uFName, String uLName, String upw, String email, String userRole, int FK_cuID);
    boolean updateCheckup(String decay, int FK_uID, int FK_bID);
}
