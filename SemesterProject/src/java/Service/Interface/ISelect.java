package Service.Interface;

import Service.Entity.Building;
import Service.Entity.Checkup;
import Service.Entity.User;
import java.util.List;

/**
 * @author Joachim
 * Interface consisting of Prototype methods for dataAccess
 */
public interface ISelect {
    List<Building> selectBuildings();
    List<User> selectUsers();
    List<Checkup> selectCheckups();
}
