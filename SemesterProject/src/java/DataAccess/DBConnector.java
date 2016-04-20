package DataAccess;

import Service.DataException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Christian
 */
public class DBConnector {

    public static String driver = "com.mysql.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost/semesterproject"; //"jdbc:mysql://localhost/JDBCWebDB" ;
    public static String ID = "root";
    public static String PW = "";
    private static Connection con;
    private static PreparedStatement preparedStatement;

    public static Connection getConnection() throws DataException, SQLException {
        if (con == null) { // hvis der ikke er connection
            try {
                Class.forName(driver); //kigger den efter driver 
            } catch (ClassNotFoundException ex) {
                System.out.println("Du har lavet fejl i DATABASE CONNECTOR!");
                throw new DataException();
            }
        }

        con = (Connection) DriverManager.getConnection(URL, ID, PW);

        return con;
    }
}


//hejsa
