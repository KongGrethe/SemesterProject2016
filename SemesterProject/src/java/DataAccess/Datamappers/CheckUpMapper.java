package DataAccess.Datamappers;

import DataAccess.DBConnector;
import Service.DataException;
import Service.Entity.Checkup;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Joachim E. Christensen
 */
public class CheckUpMapper {

    public boolean createCheckup(int checkupid, String checkDecay, String checkName, String checkAddress, String checkPostnr, String checkDato, String checkFileName, String checkBygÅr, String checkBygAreal, String checkFormål, String checkTag, String checkYderVæg, String TagFilNavn, String yVægFilNavn, String checkUdfør, String checkAnsvar, int FK_uID, int FK_bID) {
        try {
            String sql = "INSERT INTO `checkup` (`checkupid`, `checkDecay`, `checkName`, `checkAddress`, `checkPostnr`, `checkDato`, `checkFileName`, `checkBygÅr`, `checkBygAreal`, `checkFormål`, `checkTag`, `checkYderVæg`, `TagFilNavn`, `yVægFilNavn`, `checkUdfør`, `checkAnsvar`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement(sql);
            pstmt.setInt(1, checkupid);
            pstmt.setString(2, checkDecay);
            pstmt.setString(3, checkName);
            pstmt.setString(4, checkAddress);
            pstmt.setString(5, checkPostnr);
            pstmt.setString(6, checkDato);
            pstmt.setString(7, checkFileName);
            pstmt.setString(8, checkBygÅr);
            pstmt.setString(9, checkBygAreal);
            pstmt.setString(10, checkFormål);
            pstmt.setString(11, checkTag);
            pstmt.setString(12, checkYderVæg);
            pstmt.setString(13, TagFilNavn);
            pstmt.setString(14, yVægFilNavn);
            pstmt.setString(15, checkUdfør);
            pstmt.setString(16, checkAnsvar);
            pstmt.setInt(17, FK_uID);
            pstmt.setInt(18, FK_bID);
            pstmt.executeUpdate();
        } catch (SQLException | DataException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
   
    public List<Checkup> getCheckups() throws DataException {
        List<Checkup> checkups = new ArrayList();
        try {
            PreparedStatement pstmt = DBConnector.getConnection().prepareStatement("SELECT * FROM `checkup` ORDER BY `checkupid`");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int checkupid = rs.getInt("checkupID");
                String checkDecay = rs.getString("checkDecay");
                String checkName = rs.getString("checkName");
                String checkAddress = rs.getString("checkAddress");
                String checkPostnr = rs.getString("checkPostnr");
                String checkDato = rs.getString("checkDato");
                String checkFileName = rs.getString("checkFileName");
                String checkBygÅr = rs.getString("checkBygÅr");
                String checkBygAreal = rs.getString("checkBygAreal");
                String checkFormål = rs.getString("checkFormål");
                String checkTag = rs.getString("checkTag");
                String checkYderVæg = rs.getString("checkYderVæg");
                String TagFilNavn = rs.getString("TagFilNavn");
                String yVægFilNavn = rs.getString("yVægFilNavn");
                String checkUdfør = rs.getString("checkUdfør");
                String checkAnsvar = rs.getString("checkAnsvar");
                int FK_uID = rs.getInt("FK_uID");
                int FK_bID = rs.getInt("FK_bID");
                Checkup checkup = new Checkup(checkupid, checkDecay, checkName, checkAddress, checkPostnr, checkDato, checkFileName, checkBygÅr, checkBygAreal, checkFormål, checkTag, checkYderVæg, TagFilNavn, yVægFilNavn, checkUdfør,checkAnsvar, FK_uID, FK_bID);
                checkups.add(checkup);
            }
            
        } catch (SQLException ex) {
            throw new DataException(ex.getMessage());
        }
        return checkups;
    }
}
