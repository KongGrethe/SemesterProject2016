/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DataMapperInterfaces;

import Service.DataException;
import Service.Entity.Files;
import java.util.List;

/**
 *
 * @author christian
 */
public interface IFileMapper {
    boolean createFile(String fName, int FK_bID, int FK_uID);
    boolean deleteFile(String fName);
    List<Files> selectAllFiles(int FK_bID) throws DataException; 
    
//    fName VARCHAR(50),
//    FK_bID INT(7),
//    FK_uID INT(7),
//    FOREIGN KEY (FK_bID) REFERENCES buildings(bid),
//    FOREIGN KEY (FK_uID) REFERENCES users(uID)
}
