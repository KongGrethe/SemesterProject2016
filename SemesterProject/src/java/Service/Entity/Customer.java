package Service.Entity;

/**
 * @author Joachim
 * This class is for the Customer object within the database.
 */
public class Customer {
    int cId, cpw, eID, FK_eID, FK_cID;
    String cFname, cLname;
    
    public Customer(int cId, String cFname, String cLname, int cpw, int eID, int FK_eID, int FK_cID) {
        this.cId = cId;
        this.cFname = cFname;
        this.cLname = cLname;
        this.cpw = cpw;
        this.eID = eID;
        this.FK_eID = FK_eID;
        this.FK_cID = FK_cID;
    }
    
    // HVORFOR ER DER TO? 
    // Der er to hvis vi skal lave et objekt i programmet. Customerens ID kan laves til en auto increment.
    public Customer(String cFname, String cLname, int cpw, int eID, int FK_eID, int FK_cID) {
        this.cFname = cFname;
        this.cLname = cLname;
        this.cpw = cpw;
        this.eID = eID;
        this.FK_eID = FK_eID;
        this.FK_cID = FK_cID;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }
    
    public String getcFname() {
        return cFname;
    }

    public void setcFname(String cFname) {
        this.cFname = cFname;
    }

    public String getcLname() {
        return cLname;
    }

    public void setcLname(String cLname) {
        this.cLname = cLname;
    }
    
    public int getCpw() {
        return cpw;
    }

    public void setCpw(int cpw) {
        this.cpw = cpw;
    }
}
