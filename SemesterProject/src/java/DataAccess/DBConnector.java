package DataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Christian
 */
public class DBConnector {
    	public static String driver = "com.mysql.jdbc.Driver";
	public static String URL    = "jdbc:mysql://localhost/semesterproject"; //"jdbc:mysql://localhost/JDBCWebDB" ;
	public static String ID     = "root";
	public static String PW     = "root";
        private static Connection con;

        public static Connection getConnection() {
        if (con == null) { // hvis der ikke er connection
            try {
                Class.forName(driver); //kigger den efter driver 
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace(); //hvis ikke den findes smides en ClassNotFoundException
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
