package Service.Interface;

import Service.DataException;
import Service.Entity.Building;
import Service.Entity.Checkup;
import Service.Entity.Files;
import Service.Entity.Notification;
import Service.Entity.User;
import java.util.List;

/**
 * @author Joachim
 * Interface consisting of Prototype methods for dataAccess
 */
public interface ISelect {
    List<Building> selectBuildings() throws DataException;
    List<User> selectUsers() throws DataException;
    List<Checkup> selectCheckups() throws DataException;
    List<Notification> selectAllNotification() throws DataException;
    List<Notification> selectBuildingNotification(int FK_bID) throws DataException;
    List<Files> selectAllFiles(int plID) throws DataException;
}
