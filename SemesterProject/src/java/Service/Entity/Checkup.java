package Service.Entity;

/**
 * @author Joachim
 * This class is for the Checkup object within the database.
 */
public class Checkup {
    
    String decay;
    int FK_bID, FK_eID;
    
    public Checkup(String decay, int FK_bID, int FK_eID) {
        this.decay = decay;
        this.FK_bID = FK_bID;
        this.FK_eID = FK_eID;
    }

    public String getDecay() {
        return decay;
    }

    public void setDecay(String decay) {
        this.decay = decay;
    }

    public int getFK_bID() {
        return FK_bID;
    }

    public void setFK_bID(int FK_bID) {
        this.FK_bID = FK_bID;
    }

    public int getFK_eID() {
        return FK_eID;
    }

    public void setFK_eID(int FK_eID) {
        this.FK_eID = FK_eID;
    }
}
