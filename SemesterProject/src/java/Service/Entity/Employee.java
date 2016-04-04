package Service.Entity;

/**
 * @author Joachim
 * This class is for the Employee object within the database.
 */
public class Employee {
    int eID, FK_uID;
    String eFname, eLname, epw;
    
    public Employee(int eID, String eFname, String eLname, String epw, int FK_uID) {
        this.eID = eID;
        this.eFname = eFname;
        this.eLname = eLname;
        this.epw = epw;
        this.FK_uID = FK_uID;
    }
    
    public Employee(String eFname, String eLname, String epw, int FK_uID) {
        this.eFname = eFname;
        this.eLname = eLname;
        this.epw = epw;
        this.FK_uID = FK_uID;
    }

    public int geteID() {
        return eID;
    }

    public void seteID(int eID) {
        this.eID = eID;
    }

    public String geteFname() {
        return eFname;
    }

    public void seteFname(String eFname) {
        this.eFname = eFname;
    }

    public String geteLname() {
        return eLname;
    }

    public void seteLname(String eLname) {
        this.eLname = eLname;
    }
    
    public String getEpw() {
        return epw;
    }

    public void setEpw(String epw) {
        this.epw = epw;
    }

    public int getFK_uID() {
        return FK_uID;
    }

    public void setFK_uID(int FK_uID) {
        this.FK_uID = FK_uID;
    }
}
