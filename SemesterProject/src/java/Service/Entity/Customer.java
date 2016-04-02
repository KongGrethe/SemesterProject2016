package Service.Entity;

/**
 * @author Joachim
 * This class is for the Customer object within the database.
 */
public class Customer {
    int cId, cpw;
    String cFname, cLname;
    
    public Customer (int cId, String cFname, String cLname, int cpw) {
        this.cId = cId;
        this.cFname = cFname;
        this.cLname = cLname;
        this.cpw = cpw;
    }
    
    public Customer (String cFname, String cLname, int cpw) {
        this.cFname = cFname;
        this.cLname = cLname;
        this.cpw = cpw;
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
