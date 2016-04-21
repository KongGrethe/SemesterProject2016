/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import DataAccess.DBConnector;
import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Michael
 */
public class DBConnectorTest {
    
    public DBConnectorTest() {
    }

    /**
     * Test of getConnection method, of class DBConnector.
     */
    @Test
    public void testGetConnection() throws Exception {
        System.out.println("getConnection");
        Connection result = DBConnector.getConnection();
        System.out.println("getConnection2");
        assertNotNull(result);

    }
    //testen fanger fejl, som fanger en fejl men viser den ikke.
}
