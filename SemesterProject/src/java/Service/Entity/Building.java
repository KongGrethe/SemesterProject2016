package Service.Entity;

/**
 * @author Joachim
 * This class is for the Building object within the database.
 */
public class Building {
    private int bID, parcelNr, bfPlan, condLvl, FK_uID;
    private String bName, bAddress;
    private double bSize;
    
    public Building(int bID, String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl, int FK_uID) {
        this.bID = bID;
        this.bName = bName;
        this.bAddress = bAddress;
        this.parcelNr = parcelNr;
        this.bSize = bSize;
        this.bfPlan = bfPlan;
        this.condLvl = condLvl;
        this.FK_uID = FK_uID;
    }

    // HVORFOR ER DER TO? 
    // Der er to hvis vi skal lave et objekt i programmet. Bygningens ID kan laves til en auto increment.
    public Building(String bName, String bAddress, int parcelNr, double bSize, int bfPlan, int condLvl, int FK_uID) {
        this.bName = bName;
        this.bAddress = bAddress;
        this.parcelNr = parcelNr;
        this.bSize = bSize;
        this.bfPlan = bfPlan;
        this.condLvl = condLvl;
        this.FK_uID = FK_uID;
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

    public int getFK_uID() {
        return FK_uID;
    }

    public void setFK_uID(int FK_uID) {
        this.FK_uID = FK_uID;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Building other = (Building) obj;
        if (this.bID != other.bID) {
            return false;
        }
        return true;
    }
    
    
}
