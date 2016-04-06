/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import Service.Entity.Building;
import Service.Entity.Checkup;
import Service.Entity.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author christian
 */
public class DBFacade implements IDBFacade{

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
    public boolean createUser(String uFName, String uLName, String upw, String email, String userRole, int FK_cuID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteUser(String uFName, String uLName, String upw, String email, String userRole, int FK_cuID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateUser(String uFName, String uLName, String upw, String email, String userRole, int FK_cuID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> selectUsers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl, int FK_uID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl, int FK_uID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateBuilding(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl, int FK_uID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Building> selectBuildings() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createCheckup(String decay, int FK_uID, int FK_bID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteCheckup(String decay, int FK_uID, int FK_bID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCheckup(String decay, int FK_uID, int FK_bID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Checkup> selectCheckups() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
