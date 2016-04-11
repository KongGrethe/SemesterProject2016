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

/**
 *
 * @author christian
 */
public class Ctrl implements ICreate, IUpdate, IDelete, ISelect{
    DBFacade DBF;

    @Override
    public boolean createBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl, int FK_uID) {
        return DBF.createBuilding(bName, bAddress, parcelNr, bSize, bfPlan, condLvl, FK_uID);
    }

    @Override
    public boolean createUser(String uFName, String uLName, String upw, String email, String userRole, int FK_cuID) {
        return DBF.createUser(FK_cuID, uFName, uLName, upw, email, userRole, FK_cuID);
    }

    @Override
    public boolean createCheckup(String decay, int FK_uID, int FK_bID) {
        return DBF.createCheckup(decay, FK_uID, FK_bID);
    }

    @Override
    public boolean updateCheckup(String decay, int FK_uID, int FK_bID) {
        return DBF.updateCheckup(decay, FK_uID, FK_bID);
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
    public boolean deleteCheckup(String decay, int FK_uID, int FK_bID) {
        return DBF.deleteCheckup(decay, FK_uID, FK_bID);
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
    public boolean createNotification(int nID, String content, int FK_bID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateNotification(int nID, String content, int FK_bID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteNotification(int nID, String content, int FK_bID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Notification> selectNotification() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
