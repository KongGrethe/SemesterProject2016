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

    boolean createCheckup(int checkupid, String checkDecay, String checkName, String checkAddress, String checkPostnr, String checkDato, String checkFileName, String checkBygÅr, String checkBygAreal, String checkFormål, String checkTag, String checkYderVæg, String TagFilNavn, String yVægFilNavn, String checkUdfør, String chekAnsvar, int FK_uID, int FK_bID);
    List<Checkup> getCheckups() throws DataException;
}
