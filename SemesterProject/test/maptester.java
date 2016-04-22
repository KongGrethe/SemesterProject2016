
import DataAccess.DBFacade;
import Service.DataException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lasse
 */
public class maptester {
    public static void main(String[] args) throws DataException {
        DBFacade dbf = new DBFacade();
        /*if(dbf.createCheckup("a", "b", "c", "d","e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", 1, 1) == false) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }*/
        
        if(dbf.createRoom("za", "zb", "zc", "zd", "ze", "zf", "zg", "zh", "zi", "zj", "zk", "zl", "zn", "zm", "zo", 1) == false) {
            System.out.println("false");
        } else {
            System.out.println("true");
        }
    }
    
}