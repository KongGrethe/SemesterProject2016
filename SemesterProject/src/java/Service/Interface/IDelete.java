package Service.Interface;

/**
 * @author Joachim
 * Interface consisting of Prototype methods for dataAccess
 */
public interface IDelete {
    boolean deleteBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl);
    boolean deleteCustomer(String cFname, String cLname, String cpw, int eID, int FK_eID, int FK_cID);
    boolean deleteUser(String userName, String upw, String userRole);
    boolean deleteEmployee(String eFname, String eLname, String epw, int FK_uID);
    boolean deleteCheckup(String decay, int FK_bID, int FK_eID);
}
