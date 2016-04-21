/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import DataAccess.Datamappers.BuildingMapper;
import DataAccess.Datamappers.CheckUpMapper;
import DataAccess.Datamappers.FileMapper;
import DataAccess.Datamappers.UserMapper;
import Service.Entity.Building;
import Service.Entity.Checkup;
import Service.Entity.User;
import java.util.List;
import DataAccess.Datamappers.IBuildingMapper;
import DataAccess.Datamappers.ICheckUpMapper;
import DataAccess.Datamappers.IFileMapper;
import DataAccess.Datamappers.INotificationMapper;
import DataAccess.Datamappers.IRoomMapper;
import DataAccess.Datamappers.IUserMapper;
import DataAccess.Datamappers.NotificationMapper;
import DataAccess.Datamappers.RoomMapper;
import Service.DataException;
import Service.Entity.Files;
import Service.Entity.Notification;
import javax.servlet.http.Part;

/**
 *
 * @author Christian
 */
public class DBFacade implements IUserMapper, IBuildingMapper, ICheckUpMapper, INotificationMapper, IFileMapper, IRoomMapper{
    
    private UserMapper um = new UserMapper();
    private BuildingMapper bm = new BuildingMapper();
    private CheckUpMapper cm = new CheckUpMapper();
    private NotificationMapper nm = new NotificationMapper();
    private FileMapper fm = new FileMapper();
    private RoomMapper rm = new RoomMapper();
    
    public DBFacade() throws DataException //Skal denne Constructor overhovedet være der?
    {
              
    }
    @Override
    public boolean createUser(int uID, String uFName, String uLName, String upw, String email, String userRole, int FK_cuID){
        return um.createUser(uID, uFName, uLName, upw, email, userRole, FK_cuID);
    }
    
    @Override
    public boolean deleteUser(int uID) {
        return um.deleteUser(uID);
    }
    
    @Override
    public List<User> getUsers() throws DataException{
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
    public List<Building> getBuildings() throws DataException {
        return bm.getBuildings();
    }
    
    @Override
    public boolean createCheckup(int checkupid, String checkName, String checkAddress, String checkPostnr, String checkdato, String checkFileName, String checkBygÅr, String checkBygAreal, String checkFormål, String checkTag, String checkYderVæg, String TagFilNavn, String yVægFilNavn, String checkDecay, String checkUdfør, String chekAnsvar, int FK_uID, int FK_bID) {
        return cm.createCheckup(checkupid,checkName, checkAddress, checkPostnr, checkdato, checkFileName, checkBygÅr, checkBygAreal,checkFormål,checkTag, checkYderVæg,TagFilNavn,yVægFilNavn, checkDecay, checkUdfør, chekAnsvar,FK_uID,FK_bID);
    }
    

    @Override
    public List<Checkup> getCheckups() throws DataException {
        return cm.getCheckups();
    }
    

    @Override
    public boolean createNotification(int nID, String content, int FK_bID, int FK_uID) {
        return nm.createNotification(nID, content, FK_bID, FK_uID);
    }

    @Override
    public boolean deleteNotification(int nID) {
        return nm.deleteNotification(nID);
    }

    @Override
    public List<Notification> selectAllNotification() throws DataException {
        return nm.selectAllNotification();
    }

    @Override
    public List<Notification> selectBuildingNotification(int FK_bID) throws DataException {
        return nm.selectBuildingNotification(FK_bID);
    }

    @Override
    public boolean updateNotification(int nID, String content, int FK_bID) {
        return nm.updateNotification(nID, content, FK_bID);
    }

    @Override
    public List<Building> selectBuildingsByUser() throws DataException {
        return bm.selectBuildingsByUser();
    }

    @Override
    public boolean createFile(String fName, int FK_bID, int FK_uID) {
        return fm.createFile(fName, FK_bID, FK_uID);
    }

    @Override
    public boolean deleteFile(String fName) {
        return fm.deleteFile(fName);
    }

    @Override
    public List<Files> selectAllFiles(int FK_bID) throws DataException {
        return fm.selectAllFiles(FK_bID);
    }

    @Override
    public int[] validate(String Username, String Password) throws DataException {
        return um.validate(Username, Password);
    }

    @Override
    public boolean createRoom(String room, String where, String whatHappened, String whatHasBeenDone, String damageType, String wallNotes, String ceilingNotes, String floorNotes, String windowDoorNotes, Part wallPart, Part ceilingPart, Part floorPart, Part windowDoorPart, String moistScan, String measuringPoint, int FK_checkupID) {
        return rm.createRoom(room, where, whatHappened, whatHasBeenDone, damageType, wallNotes, ceilingNotes, floorNotes, windowDoorNotes, wallPart, ceilingPart, floorPart, windowDoorPart, moistScan, measuringPoint, FK_checkupID);
    }

    @Override
    public int getReportID(String bAddress, String bName) throws DataException {
        return cm.getReportID(bAddress, bName);
    }

    
    
}
