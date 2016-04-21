package Service.Entity;

/**
 * @author Joachim
 * This class is for the Checkup object within the database.
 */
public class Checkup {
    
    private String checkDecay,checkName, checkAddress, checkPostnr, checkdato, checkFileName, checkBygÅr, checkBygAreal,checkFormål,checkTag, checkYderVæg,TagFilNavn,yVægFilNavn, checkUdfør, checkAnsvar;
    private int checkupid, FK_uID, FK_bID;

    public Checkup( int checkupid, String checkName, String checkAddress, String checkPostnr, String checkdato, String checkFileName, String checkBygÅr, String checkBygAreal, String checkFormål, String checkTag, String checkYderVæg, String TagFilNavn, String yVægFilNavn, String checkDecay,String checkUdfør, String checkAnsvar, int FK_uID, int FK_bID) {
        this.checkupid = checkupid;
        this.checkName = checkName;
        this.checkAddress = checkAddress;
        this.checkPostnr = checkPostnr;
        this.checkdato = checkdato;
        this.checkFileName = checkFileName;
        this.checkBygÅr = checkBygÅr;
        this.checkBygAreal = checkBygAreal;
        this.checkFormål = checkFormål;
        this.checkTag = checkTag;
        this.checkYderVæg = checkYderVæg;
        this.TagFilNavn = TagFilNavn;
        this.yVægFilNavn = yVægFilNavn;
        this.checkDecay = checkDecay;
        this.checkUdfør = checkUdfør;
        this.checkAnsvar = checkAnsvar;
        this.FK_uID = FK_uID;
        this.FK_bID = FK_bID;
    }

    public String getCheckDecay() {
        return checkDecay;
    }

    public void setCheckDecay(String checkDecay) {
        this.checkDecay = checkDecay;
    }
    
    public int getCheckupid() {
        return checkupid;
    }

    public void setCheckupid(int checkupid) {
        this.checkupid = checkupid;
    }


    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public String getCheckAddress() {
        return checkAddress;
    }

    public void setCheckAddress(String checkAddress) {
        this.checkAddress = checkAddress;
    }

    public String getCheckPostnr() {
        return checkPostnr;
    }

    public void setCheckPostnr(String checkPostnr) {
        this.checkPostnr = checkPostnr;
    }

    public String getCheckdato() {
        return checkdato;
    }

    public void setCheckdato(String checkdato) {
        this.checkdato = checkdato;
    }

    public String getCheckFileName() {
        return checkFileName;
    }

    public void setCheckFileName(String checkFileName) {
        this.checkFileName = checkFileName;
    }

    public String getCheckBygÅr() {
        return checkBygÅr;
    }

    public void setCheckBygÅr(String checkBygÅr) {
        this.checkBygÅr = checkBygÅr;
    }

    public String getCheckBygAreal() {
        return checkBygAreal;
    }

    public void setCheckBygAreal(String checkBygAreal) {
        this.checkBygAreal = checkBygAreal;
    }

    public String getCheckFormål() {
        return checkFormål;
    }

    public void setCheckFormål(String checkFormål) {
        this.checkFormål = checkFormål;
    }

    public String getCheckTag() {
        return checkTag;
    }

    public void setCheckTag(String checkTag) {
        this.checkTag = checkTag;
    }

    public String getCheckYderVæg() {
        return checkYderVæg;
    }

    public void setCheckYderVæg(String checkYderVæg) {
        this.checkYderVæg = checkYderVæg;
    }

    public String getTagFilNavn() {
        return TagFilNavn;
    }

    public void setTagFilNavn(String TagFilNavn) {
        this.TagFilNavn = TagFilNavn;
    }

    public String getyVægFilNavn() {
        return yVægFilNavn;
    }

    public void setyVægFilNavn(String yVægFilNavn) {
        this.yVægFilNavn = yVægFilNavn;
    }
    
    public String getCheckUdfør() {
        return checkUdfør;
    }

    public void setCheckUdfør(String checkUdfør) {
        this.checkUdfør = checkUdfør;
    }

    public String getCheckAnsvar() {
        return checkAnsvar;
    }

    public void setCheckAnsvar(String checkAnsvar) {
        this.checkAnsvar = checkAnsvar;
    }

    public int getFK_uID() {
        return FK_uID;
    }

    public void setFK_uID(int FK_uID) {
        this.FK_uID = FK_uID;
    }

    public int getFK_bID() {
        return FK_bID;
    }

    public void setFK_bID(int FK_bID) {
        this.FK_bID = FK_bID;
    }
    
    

    
}
