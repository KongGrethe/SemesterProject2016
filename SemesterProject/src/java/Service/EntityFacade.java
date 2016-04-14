/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DataAccess.DBFacade;
import Service.Entity.Building;
import Service.Entity.Checkup;
import Service.Entity.Notification;
import Service.Entity.User;
import Service.Interface.ICreate;
import Service.Interface.IDelete;
import Service.Interface.ISelect;
import Service.Interface.IUpdate;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author christian
 */
public class EntityFacade implements ICreate, IUpdate, IDelete, ISelect{
        DBFacade DBF;

    public EntityFacade() throws ClassNotFoundException, SQLException {
            DBF = new DBFacade();
    }

    @Override
    public boolean createBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl, int FK_uID) {
        return DBF.createBuilding(bName, bAddress, parcelNr, bSize, bfPlan, condLvl, FK_uID);
    }

    @Override
    public boolean createUser(int uID, String uFName, String uLName, String upw, String email, String userRole, int FK_cuID) {
        return DBF.createUser(uID, uFName, uLName, upw, email, userRole, FK_cuID);
    }

    @Override
    public boolean createCheckup(int checkupID, String decay, int FK_uID, int FK_bID) {
        return DBF.createCheckup(checkupID, decay, FK_uID, FK_bID);
    }

    @Override
    public boolean updateCheckup(int checkupID, String decay, int FK_uID, int FK_bID) {
        return DBF.updateCheckup(checkupID, decay, FK_uID, FK_bID);
    }

    @Override
    public boolean deleteBuilding(int bID) {
        return DBF.deleteBuilding(bID);
    }

    @Override
    public boolean deleteUser(String uFName, String uLName, String upw, String email, String userRole, int FK_cuID) {
        return DBF.deleteUser(FK_cuID, uFName, uLName, upw, email, userRole, FK_cuID);
    }

    @Override
    public boolean deleteCheckup( int checkupID, String decay, int FK_uID, int FK_bID) {
        return DBF.deleteCheckup(checkupID,decay, FK_uID, FK_bID);
    }

    @Override
    public List<Building> selectBuildings()throws SQLException {
        return DBF.getBuildings();
    }

    @Override
    public List<User> selectUsers() throws SQLException {
        return DBF.getUsers();
    }

    @Override
    public List<Checkup> selectCheckups() throws SQLException {
        return DBF.getCheckups();
    }

    @Override
    public boolean createNotification(int nID, String content, int FK_bID,int FK_uID) {
        return DBF.createNotification(nID, content, FK_bID, FK_uID);
    }

    @Override
    public boolean updateNotification(int nID, String content, int FK_bID) {
        return DBF.updateNotification(nID, content, FK_bID);
    }

    @Override
    public boolean deleteNotification(int nID) {
        return DBF.deleteNotification(nID);
    }
    
    @Override
    public List<Notification> selectAllNotification() throws SQLException {
        return DBF.selectAllNotification();
    }

    @Override
    public List<Notification> selectBuildingNotification(int FK_bID) throws SQLException {
        return DBF.selectBuildingNotification(FK_bID);
    }

    @Override
    public boolean createFile(String fName, int FK_bID, int FK_uID) {
        return DBF.createFile(fName, FK_bID, FK_uID);
    }

    @Override
    public boolean deleteFile(String fName) {
        return DBF.deleteFile(fName);
    }
}
