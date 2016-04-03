package Service.Interface;

/**
 * @author Joachim
 * Interface consisting of Prototype methods for dataAccess
 */
public interface IDelete {
    boolean deleteBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl);
    boolean deleteCustomer(String cFname, String cLname, int cpw);
    boolean deleteUser(String userName, int upw);
    boolean deleteEmployee(String eFname, String eLname, int epw, int FK_uID);
    boolean deleteCheckup(String decay, int FK_bID, int FK_eID);
}
