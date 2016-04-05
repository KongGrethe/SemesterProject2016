package Service.Interface;

/**
 * @author Joachim
 * Interface consisting of Prototype methods for dataAccess
 */
public interface ICreate {
    boolean createBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl, int FK_uID);
    boolean createUser(String uFName, String uLName, String upw, String email, String userRole, int FK_cuID);
    boolean createCheckup(String decay, int FK_uID, int FK_bID);
}
