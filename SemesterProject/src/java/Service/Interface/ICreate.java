package Service.Interface;

/**
 * @author Joachim
 */
public interface ICreate {
    boolean createBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl);
    boolean createCustomer(String cFname, String cLname, int cpw);
}
