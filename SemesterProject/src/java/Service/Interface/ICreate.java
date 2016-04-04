package Service.Interface;

/**
 * @author Joachim
 * Interface consisting of Prototype methods for dataAccess
 */
public interface ICreate {
    boolean createBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl);
    boolean createCustomer(String cFname, String cLname, String cpw, int eID, int FK_eID, int FK_cID);
    boolean createUser(String userName, String upw, String userRole);
    boolean createEmployee(String eFname, String eLname, String epw, int FK_uID);
    boolean createCheckup(String decay, int FK_bID, int FK_eID);
}
