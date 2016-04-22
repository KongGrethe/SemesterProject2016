/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DataAccess.DBFacade;
import Service.Entity.Building;
import Service.Entity.Checkup;
import Service.Entity.Files;
import Service.Entity.Notification;
import Service.Entity.User;
import Service.Interface.ICreate;
import Service.Interface.IDelete;
import Service.Interface.ISelect;
import Service.Interface.IUpdate;
import java.util.List;
import javax.servlet.http.Part;

/**
 *
 * @author christian
 */
public class EntityFacade implements ICreate, IUpdate, IDelete, ISelect{
        DBFacade DBF;

    public EntityFacade() throws DataException {
            DBF = new DBFacade();
    }

    @Override
    public boolean createBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl, int FK_uID) {
        return DBF.createBuilding(bName, bAddress, parcelNr, bSize, bfPlan, condLvl, FK_uID);
    }

    @Override
    public int createUser(int uID, String uFName, String uLName, String upw, String email, String userRole, int FK_cuID) {
        return DBF.createUser(uID, uFName, uLName, upw, email, userRole, FK_cuID);
    }

    @Override
    public boolean createCheckup(int checkupid,  String checkName, String checkAddress, String checkPostnr, 
            String checkdato, String checkFileName, String checkBygÅr, String checkBygAreal, String checkFormål, String checkTag, 
            String checkYderVæg, String TagFilNavn, String yVægFilNavn, String checkDecay,String checkUdfør, String chekAnsvar, int FK_uID, int FK_bID) 
    {
        return DBF.createCheckup(checkName, checkAddress, checkPostnr, checkdato, checkFileName, checkBygÅr, checkBygAreal, checkFormål, 
                checkTag, checkYderVæg, TagFilNavn, yVægFilNavn, checkDecay,checkUdfør, chekAnsvar, FK_uID, FK_bID);
    }

    @Override
    public boolean deleteBuilding(int bID) {
        return DBF.deleteBuilding(bID);
    }

    @Override
    public boolean deleteUser(int uID) {
        return DBF.deleteUser(uID);
    }


    @Override
    public List<Building> selectBuildings()throws DataException{
        return DBF.getBuildings();
    }

    @Override
    public List<User> selectUsers() throws DataException {
        return DBF.getUsers();
    }

    @Override
    public List<Checkup> selectCheckups() throws DataException {
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
    public List<Notification> selectAllNotification() throws DataException {
        return DBF.selectAllNotification();
    }

    @Override
    public List<Notification> selectBuildingNotification(int FK_bID) throws DataException {
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

    @Override
    public List<Files> selectAllFiles(int FK_bID) throws DataException {
        return DBF.selectAllFiles(FK_bID);
    }

    @Override
    public boolean createRoom(String room, String where, String whatHappened, String whatHasBeenDone, String damageType, String wallNotes, String ceilingNotes, String floorNotes, String windowDoorNotes, Part wallPart, Part ceilingPart, Part floorPart, Part windowDoorPart, String moistScan, String measuringPoint, int FK_checkupID) {
        return DBF.createRoom(room, where, whatHappened, whatHasBeenDone, damageType, wallNotes, ceilingNotes, floorNotes, windowDoorNotes, wallPart, ceilingPart, floorPart, windowDoorPart, moistScan, measuringPoint, FK_checkupID);
    }

}
