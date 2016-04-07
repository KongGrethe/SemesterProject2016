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
import DataAccess.Datamappers.IUserMapper;

/**
 *
 * @author Christian
 */
public class DBFacade implements IUserMapper, IBuildingMapper, ICheckUpMapper{
    
    private UserMapper um = new UserMapper();
    private BuildingMapper bm = new BuildingMapper();
    private CheckUpMapper cm = new CheckUpMapper();

    public DBFacade() throws ClassNotFoundException, SQLException 
    {
        Class.forName(DBConnector.driver);
        con = DriverManager.getConnection(DBConnector.URL, DBConnector.ID, DBConnector.PW);
    }
    
    Connection con;
    
    public boolean validate (String Username, String Password)
    {
        try 
        {  
            Statement stat = con.createStatement();
            String query = "select * from users where uFName='" + Username 
                + "' and upw='" + Password + "'" ;
            ResultSet rs = stat.executeQuery(query);
            return rs.next();
        }
        catch(SQLException ex) 
        {
            return false;
        }
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
    public boolean deleteBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl, int FK_uID) {
        return bm.deleteBuilding(bName, bAddress, parcelNr, bSize, bfPlan, condLvl, FK_uID);
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
    
}
