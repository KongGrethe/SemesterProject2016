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

    public static String driver = "com.mysql.jdbc.Driver";
    public static String URL = "jdbc:mysql://localhost/semesterproject"; //"jdbc:mysql://localhost/JDBCWebDB" ;
    public static String ID = "root";
    public static String PW = "root";

    public boolean Transaction(Connection dbCon) throws DataException {
        PreparedStatement preparedStatementInsert = null;
        PreparedStatement preparedStatementInsert1 = null;

        String insertTableSQL = "INSERT INTO buildings"
                + "(bID, bName, bAddress, parcelNr, bSize, bfPlan, condLvl, FK_uID) "
                + "VALUES (?,?,?,?,?,?,?,?)";

        String insertTableSQL1 = "INSERT INTO room (rName, rDato, rWhere, "
                + "rHappened, rHasBeenDone, rDamageType, rWallNotes, rCeilingNotes, "
                + "rFloorNotes, rWindowNotes, rWallName, rCeilingName, rFloorName, "
                + "rWindowDoorName, rMoistScan, rMeasuringPoint, FK_bID) VALUES "
                + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            dbCon = getConnection();

            dbCon.setAutoCommit(false);

            preparedStatementInsert = dbCon.prepareStatement(insertTableSQL);
            preparedStatementInsert.setInt(1, 0);
            preparedStatementInsert.setString(2, "");
            preparedStatementInsert.setString(3, "");
            preparedStatementInsert.setInt(4, 0);
            preparedStatementInsert.setDouble(5, 0.0);
            preparedStatementInsert.setInt(6, 0);
            preparedStatementInsert.setInt(7, 0);
            preparedStatementInsert.setInt(8, 0);
            preparedStatementInsert.executeUpdate();

            preparedStatementInsert1 = dbCon.prepareStatement(insertTableSQL1);
            preparedStatementInsert1.setString(1, "");
            preparedStatementInsert1.setString(2, "");
            preparedStatementInsert1.setString(3, "");
            preparedStatementInsert1.setString(4, "");
            preparedStatementInsert1.setString(5, "");
            preparedStatementInsert1.setString(6, "");
            preparedStatementInsert1.setString(7, "");
            preparedStatementInsert1.setString(8, "");
            preparedStatementInsert1.setString(9, "");
            preparedStatementInsert1.setString(10, "");
            preparedStatementInsert1.setString(11, "");
            preparedStatementInsert1.setString(12, "");
            preparedStatementInsert1.setString(13, "");
            preparedStatementInsert1.setString(14, "");
            preparedStatementInsert1.setString(15, "");
            preparedStatementInsert1.setString(16, "");
            preparedStatementInsert1.setInt(17, 0);
            preparedStatementInsert1.executeUpdate();

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
                if (preparedStatementInsert1 != null) {
                    preparedStatementInsert1.close();
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
