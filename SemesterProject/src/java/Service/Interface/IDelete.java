package Service.Interface;

/**
 * @author Joachim
 */
public interface IDelete {
    boolean deleteBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl);
    boolean deleteCustomer(String cFname, String cLname, int cpw);
}
