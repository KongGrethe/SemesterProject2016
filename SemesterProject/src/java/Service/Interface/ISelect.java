package Service.Interface;

import Service.Entity.Building;
import Service.Entity.Customer;
import java.util.List;

/**
 * @author Joachim
 */
public interface ISelect {
    List<Building> selectBuildings();
    List<Customer> selectCustomers();
}
