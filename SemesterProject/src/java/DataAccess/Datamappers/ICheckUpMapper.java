/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Datamappers;

import Service.Entity.Checkup;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author christian
 */
public interface ICheckUpMapper {

    boolean createCheckup(String decay, int FK_uID, int FK_bID);

    boolean deleteCheckup(String decay, int FK_uID, int FK_bID);

    List<Checkup> getCheckups() throws SQLException;

    boolean updateCheckup(String decay, int FK_uID, int FK_bID);
    
}
