package Service.Interface;

/**
 * @author Joachim
 */
public interface IUpdate {
    boolean updateBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl);
    boolean updateCustomer(String cFname, String cLname, int cpw);
}
