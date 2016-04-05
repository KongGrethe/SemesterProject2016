/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author christian
 */
public class DBConnector {
    	public static String driver = "com.mysql.jdbc.Driver";
	public static String URL    = "jdbc:mysql://localhost/semesterproject"; //"jdbc:mysql://localhost/JDBCWebDB" ;
	public static String ID     = "root";
	public static String PW     = "xxxxxxxxxxxxx"; // put ya cod for ya server in
        private static Connection con;

        public static Connection getConnection() {
        if (con == null) {
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
        try {
            con = (Connection) DriverManager.getConnection(URL, ID, PW);
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return con;
    }
}
