/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import DataAccess.Datamappers.BuildingMapper;
import DataAccess.Datamappers.CheckUpMapper;
import DataAccess.Datamappers.UserMapper;
import Service.Entity.Building;
import Service.Entity.Checkup;
import Service.Entity.User;
import java.util.List;
import DataAccess.Datamappers.IBuildingMapper;
import DataAccess.Datamappers.ICheckUpMapper;
import DataAccess.Datamappers.INotificationMapper;
import DataAccess.Datamappers.IUserMapper;
import DataAccess.Datamappers.NotificationMapper;
import Service.Entity.Notification;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Christian
 */
public class DBFacade implements IUserMapper, IBuildingMapper, ICheckUpMapper, INotificationMapper{
    
    private UserMapper um = new UserMapper();
    private BuildingMapper bm = new BuildingMapper();
    private CheckUpMapper cm = new CheckUpMapper();
    private NotificationMapper nm = new NotificationMapper();

    public DBFacade() throws ClassNotFoundException, SQLException 
    {
        Class.forName(DBConnector.driver);
        con = DriverManager.getConnection(DBConnector.URL, DBConnector.ID, DBConnector.PW);
    }
    
    Connection con;
    
    public int[] validate(String Username, String Password) {
        int res[] = new int[2];
        System.out.println("kom her til" + Username);
        try {            
            Statement stat = con.createStatement();
            String query = "select * from users where uFName='" + Username
                    + "' and upw='" + Password + "'";
            ResultSet rs = stat.executeQuery(query);
            if (rs.next()) {
                res[0] = rs.getInt(1);
                if(rs.getString(6).equals("employee")) {
                    res[1] = 2;
                } else {
                    res[1] = 1;
                }
                System.out.println(res[0]);
                System.out.println(res[1]);
            }
        } catch (SQLException ex) {
            res[0] = 0;
            res[1] = 0;
        }
        return res;
    }

    @Override
    public boolean createUser(int uID, String uFName, String uLName, String upw, String email, String userRole, int FK_cuID) {
        return um.createUser(uID, uFName, uLName, upw, email, userRole, FK_cuID);
    }
    
    @Override
    public boolean deleteUser(int uID, String uFName, String uLName, String upw, String email, String userRole, int FK_cuID) {
        return um.deleteUser(uID, uFName, uLName, upw, email, userRole, FK_cuID);
    }
    
    @Override
    public List<User> getUsers() throws SQLException {
        return um.getUsers();
    }
    
    @Override
    public boolean createBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl, int FK_uID) {
        return bm.createBuilding(bName, bAddress, parcelNr, bSize, bfPlan, condLvl, FK_uID);
    }
    
    @Override
    public boolean deleteBuilding(int bID) {
        return bm.deleteBuilding(bID);
    }
    
    @Override
    public List<Building> getBuildings() throws SQLException {
        return bm.getBuildings();
    }
    
    @Override
    public boolean createCheckup(String decay, int FK_uID, int FK_bID) {
        return cm.createCheckup(decay, FK_uID, FK_bID);
    }
    
    @Override
    public boolean deleteCheckup(String decay, int FK_uID, int FK_bID) {
        return cm.deleteCheckup(decay, FK_uID, FK_bID);
    }

    @Override
    public List<Checkup> getCheckups() throws SQLException {
        return cm.getCheckups();
    }
    
    @Override
    public boolean updateCheckup(String decay, int FK_uID, int FK_bID) {
        return cm.updateCheckup(decay, FK_uID, FK_bID);
    }

    @Override
    public boolean createNotification(int nID, String content, int FK_bID) {
        return nm.createNotification(nID, content, FK_bID);
    }

    @Override
    public boolean deleteNotification(int nID) {
        return nm.deleteNotification(nID);
    }

    @Override
    public List<Notification> selectAllNotification() throws SQLException {
        return nm.selectAllNotification();
    }

    @Override
    public List<Notification> selectBuildingNotification(int FK_bID) throws SQLException {
        return nm.selectBuildingNotification(FK_bID);
    }

    @Override
    public boolean updateNotification(int nID, String content, int FK_bID) {
        return nm.updateNotification(nID, content);
    }

    
    
}
