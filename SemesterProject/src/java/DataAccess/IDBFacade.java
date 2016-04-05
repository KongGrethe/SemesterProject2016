/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Service.Entity.Building;
import Service.Entity.Checkup;
import Service.Entity.User;
import java.util.List;

/**
 *
 * @author Christian
 */
public interface IDBFacade {

    //User Metode-Interfaces
    boolean createUser(String uFName, String uLName, String upw, String email, String userRole, int FK_cuID);
    boolean deleteUser(String uFName, String uLName, String upw, String email, String userRole, int FK_cuID);
    boolean updateUser(String uFName, String uLName, String upw, String email, String userRole, int FK_cuID);
    List<User> selectUsers();
    
    boolean createBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl, int FK_uID);
    boolean deleteBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl, int FK_uID);
    boolean updateBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl, int FK_uID);
    List<Building> selectBuildings();

    boolean createCheckup(String decay, int FK_uID, int FK_bID);
    boolean deleteCheckup(String decay, int FK_uID, int FK_bID);
    boolean updateCheckup(String decay, int FK_uID, int FK_bID);
    List<Checkup> selectCheckups();
    
}