package Service.Interface;

/**
 * @author Joachim
 * Interface consisting of Prototype methods for dataAccess
 */
public interface IUpdate {
    boolean updateBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl);
    boolean updateCustomer(String cFname, String cLname, int cpw);
    boolean updateUser(String userName, int upw);
    boolean updateEmployee(String eFname, String eLname, int epw, int FK_uID);
    boolean updateCheckup(String decay, int FK_bID, int FK_eID);
}
