package Service.Interface;

import Service.Entity.Building;
import Service.Entity.Checkup;
import Service.Entity.User;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Joachim
 * Interface consisting of Prototype methods for dataAccess
 */
public interface ISelect {
    List<Building> selectBuildings() throws SQLException;
    List<User> selectUsers() throws SQLException;
    List<Checkup> selectCheckups() throws SQLException;
}
