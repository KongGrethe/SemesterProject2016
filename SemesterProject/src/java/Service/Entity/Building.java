package Service.Entity;

/**
 * @author Joachim
 * This class is for the Building object within the database.
 */
public class Building {
    int bID, parcelNr, bfPlan, condLvl;
    String bName, bAddress;
    double bSize;
    
    public Building(int bID, String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl) {
        this.bID = bID;
        this.bName = bName;
        this.bAddress = bAddress;
        this.parcelNr = parcelNr;
        this.bSize = bSize;
        this.bfPlan = bfPlan;
        this.condLvl = condLvl;
    }

    public Building (String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl) {
        this.bName = bName;
        this.bAddress = bAddress;
        this.parcelNr = parcelNr;
        this.bSize = bSize;
        this.bfPlan = bfPlan;
        this.condLvl = condLvl;
    }
    
    public int getbID() {
        return bID;
    }

    public void setbID(int bID) {
        this.bID = bID;
    }
    
    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }
    
    public String getbAddress() {
        return bAddress;
    }

    public void setbAddress(String bAddress) {
        this.bAddress = bAddress;
    }

    public int getParcelNr() {
        return parcelNr;
    }

    public void setParcelNr(int parcelNr) {
        this.parcelNr = parcelNr;
    }
    
    public double getbSize() {
        return bSize;
    }

    public void setbSize(double bSize) {
        this.bSize = bSize;
    }
    
    public int getBfPlan() {
        return bfPlan;
    }

    public void setBfPlan(int bfPlan) {
        this.bfPlan = bfPlan;
    }
    
    public int getCondLvl() {
        return condLvl;
    }

    public void setCondLvl(int condLvl) {
        this.condLvl = condLvl;
    }
}
