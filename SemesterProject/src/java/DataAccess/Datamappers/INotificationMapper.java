package DataAccess.Datamappers;

import Service.Entity.Notification;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Joachim E. Christensen
 */
public interface INotificationMapper {
    
    boolean createNotification (int nID, String content, int FK_bID);
    boolean deleteNotification (int nID);
    List<Notification> selectAllNotification() throws SQLException;
    List<Notification> selectBuildingNotification(int FK_bID) throws SQLException;
    boolean updateNotification (int nID, String content, int FK_bID);
}
