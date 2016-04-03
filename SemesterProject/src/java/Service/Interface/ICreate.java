package Service.Interface;

/**
 * @author Joachim
 * Interface consisting of Prototype methods for dataAccess
 */
public interface ICreate {
    boolean createBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl);
    boolean createCustomer(String cFname, String cLname, int cpw);
    boolean createUser(String userName, int upw);
    boolean createEmployee(String eFname, String eLname, int epw, int FK_uID);
    boolean createCheckup(String decay, int FK_bID, int FK_eID);
}
