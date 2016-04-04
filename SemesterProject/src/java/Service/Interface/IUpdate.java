package Service.Interface;

/**
 * @author Joachim
 * Interface consisting of Prototype methods for dataAccess
 */
public interface IUpdate {
    boolean updateBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl);
    boolean updateCustomer(String cFname, String cLname, String cpw, int eID, int FK_eID, int FK_cID);
    boolean updateUser(String userName, String upw, String userRole);
    boolean updateEmployee(String eFname, String eLname, String epw, int FK_uID);
    boolean updateCheckup(String decay, int FK_bID, int FK_eID);
}
