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
import java.util.logging.Level;
import java.util.logging.Logger;

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
            preparedStatementInsert.setInt(1, 0);
            preparedStatementInsert.setString(2, "");
            preparedStatementInsert.setString(3, "");
            preparedStatementInsert.setString(4, "");
            preparedStatementInsert.setString(5, "");
            preparedStatementInsert.setString(6, "");
            preparedStatementInsert.setString(7, "");
            preparedStatementInsert.setString(8, "");
            preparedStatementInsert.setString(9, "");
            preparedStatementInsert.setString(10, "");
            preparedStatementInsert.setString(11, "");
            preparedStatementInsert.setString(12, "");
            preparedStatementInsert.setString(13, "");
            preparedStatementInsert.setString(14, "");
            preparedStatementInsert.setString(15, "");
            preparedStatementInsert.setString(16, "");
            preparedStatementInsert.setInt(17, 0);
            preparedStatementInsert.setInt(18, 0);
            preparedStatementInsert.executeUpdate();

            preparedStatementUpdate = dbCon.prepareStatement(updateTableSQL);
            preparedStatementUpdate.setString(1, "Ny String");
            preparedStatementUpdate.setInt(2, 0);
            preparedStatementUpdate.executeUpdate();

            dbCon.commit();

            System.out.println("Færdig");

        } catch (SQLException ex) {
            ex.printStackTrace();
            try {
                dbCon.rollback();
            } catch (SQLException ex1) {
                ex1.printStackTrace();
                throw new DataException();
            }
            throw new DataException();

        } finally {
            try {
                if (preparedStatementInsert != null) {
                    preparedStatementInsert.close();
                }
                if (preparedStatementUpdate != null) {
                    preparedStatementUpdate.close();
                }
                if (dbCon != null) {
                    dbCon.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                throw new DataException();
            }

        }
        return true;
    }
}
