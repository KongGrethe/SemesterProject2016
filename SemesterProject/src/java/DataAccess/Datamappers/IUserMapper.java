/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Datamappers;

import Service.DataException;
import Service.Entity.User;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author christian
 */
public interface IUserMapper{

    boolean createUser(int uID, String uFName, String uLName, String upw, String email, String userRole, int FK_cuID) throws DataException;

    boolean deleteUser(int uID) throws DataException;

    List<User> getUsers() throws DataException;
    
    int[] validate(String Username, String Password) throws DataException;
}
