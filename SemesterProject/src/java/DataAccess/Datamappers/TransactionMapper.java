/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.Datamappers;

import DataAccess.DBConnector;
import static DataAccess.DBConnector.getConnection;
import Service.DataException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Michael
 */
public class TransactionMapper {
    //insert checkup rapport
    //update checkup liste

    public static String driver = "com.mysql.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost/semesterproject"; //"jdbc:mysql://localhost/JDBCWebDB" ;
    public static String ID = "root";
    public static String PW = "root";

    public boolean Transaction(Connection dbcon) throws DataException {
        Connection dbCon = null;
        PreparedStatement preparedStatementInsert = null;
        PreparedStatement preparedStatementUpdate = null;

        String insertTableSQL = "INSERT INTO checkup"
                + "(checkupid, checkName, checkAddress, checkPostnr, checkDato, checkFileName, checkBygÅr, "
                + "checkBygAreal, checkFormål, checkTag, checkYderVæg, TagFilNavn, yVægFilNavn, checkDecay "
                + "checkUdfør, checkAnsvar, FK_uID, FK_bID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        String updateTableSQL = "UPDATE checkup SET checkName =? "
                + "WHERE checkupid = ?";

        try {
            dbCon = getConnection();
        
            dbCon.setAutoCommit(false);
            
            preparedStatementInsert = dbCon.prepareStatement(insertTableSQL);
            
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return true;
    }
}
