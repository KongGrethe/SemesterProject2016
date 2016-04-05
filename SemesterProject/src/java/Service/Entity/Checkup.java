package Service.Entity;

/**
 * @author Joachim
 * This class is for the Checkup object within the database.
 */
public class Checkup {
    
    String decay;
    int FK_uID, FK_bID;
    
    public Checkup(String decay, int FK_uID, int FK_bID) {
        this.decay = decay;
        this.FK_uID = FK_uID;
        this.FK_bID = FK_bID;
    }

    public String getDecay() {
        return decay;
    }

    public void setDecay(String decay) {
        this.decay = decay;
    }

    public int getFK_uID() {
        return FK_uID;
    }

    public void setFK_bID(int FK_uID) {
        this.FK_uID = FK_uID;
    }

    public int getFK_bID() {
        return FK_bID;
    }

    public void setFK_eID(int FK_bID) {
        this.FK_bID = FK_bID;
    }
}
