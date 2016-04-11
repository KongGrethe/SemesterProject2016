package Service.Entity;

/**
 * @author Joachim
 */
public class Notification {
    private int nID, FK_bID;
    private String content;
    
    public Notification (int nID, String content, int FK_bID) {
        this.nID = nID;
        this.content = content;
        this.FK_bID = FK_bID;
    }
    
    public Notification (String content, int FK_bID) {
        this.content = content;
        this.FK_bID = FK_bID;
    }

    public int getnID() {
        return nID;
    }

    public void setnID(int nID) {
        this.nID = nID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    public int getFK_bID() {
        return FK_bID;
    }

    public void setFK_bID(int FK_bID) {
        this.FK_bID = FK_bID;
    }
}
