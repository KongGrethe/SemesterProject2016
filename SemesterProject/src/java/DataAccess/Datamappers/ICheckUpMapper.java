/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Datamappers;

import Service.DataException;
import Service.Entity.Checkup;
import java.util.List;

/**
 *
 * @author christian
 */
public interface ICheckUpMapper{

    boolean createCheckup(int checkupID, String decay, int FK_uID, int FK_bID);

    boolean deleteCheckup(int checkupID, String decay, int FK_uID, int FK_bID);

    List<Checkup> getCheckups() throws DataException;

    boolean updateCheckup(int checkupID, String decay, int FK_uID, int FK_bID);
    
}
