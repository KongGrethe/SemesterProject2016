/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Datamappers;

import Service.DataException;
import Service.Entity.Building;
import java.util.List;

/**
 *
 * @author christian
 */
public interface IBuildingMapper {

    boolean createBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl, int FK_uID);

    boolean deleteBuilding(int bID);
    
    List<Building> getBuildings() throws DataException;
    
    List<Building> selectBuildingsByUser() throws DataException;
}
