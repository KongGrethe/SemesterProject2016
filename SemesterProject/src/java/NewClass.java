
import DataAccess.DBFacade;
import Service.Entity.Files;
import Service.Entity.Notification;
import java.sql.SQLException;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lasse
 */
public class NewClass {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        DBFacade dbf = new DBFacade();
        List<Notification> hej = dbf.selectBuildingNotification(2);
        
        System.out.println(hej.size());
        for(int i = 0; i<hej.size();i++) {
            System.out.println(hej.get(i).getContent());
        }
    }
}
