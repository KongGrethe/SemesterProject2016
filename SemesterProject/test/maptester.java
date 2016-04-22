
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
        //DBFacade dbf = new DBFacade();
        
        
        /*if(dbf.createCheckup("sa", "sb", "sc", "sd","se", "sf", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", 1, 1) == false) {
            System.out.println("false insert checkup");
        } else {
            System.out.println("true insert checkup");
        }*/
        
        //System.out.println(dbf.getReportID("sb", "sa"));
        
        System.out.println((int) Math.floor(Math.random() * 2)+1);
        
        
        
        //dbf.createCheckup("sa", "sb", "sc", "sd", "se", "sf", "sg", "sh", "si", "sj", "sk", "sl", "sm", "sn", "so", 1, 1);
        
        /*
        if(dbf.createRoom("xa", "xb", "xc", "xd", "xe", "xf", "xg", "xh", "xi", "xj", "xk", "xl", "xn", "xm", "xo", 1) == false) {
            System.out.println("false insert room");
        } else {
            System.out.println("true insert room");
        }*/
    }
    
}