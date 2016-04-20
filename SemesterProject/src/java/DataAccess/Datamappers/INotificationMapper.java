package DataAccess.Datamappers;

import Service.DataException;
import Service.Entity.Notification;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Joachim E. Christensen
 */
public interface INotificationMapper{
    
    boolean createNotification (int nID, String content, int FK_bID, int FK_uID);
    boolean deleteNotification (int nID);
    List<Notification> selectAllNotification() throws DataException;
    List<Notification> selectBuildingNotification(int FK_bID) throws DataException;
    boolean updateNotification (int nID, String content, int FK_bID);
}
