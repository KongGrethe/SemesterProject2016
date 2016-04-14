/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Entity;

/**
 *
 * @author christian
 */
public class Files {
    
    String fName;
    int FK_bID, FK_uID;

    public Files(String fName, int FK_bID, int FK_uID) {
        this.fName = fName;
        this.FK_bID = FK_bID;
        this.FK_uID = FK_uID;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public int getFK_bID() {
        return FK_bID;
    }

    public void setFK_bID(int FK_bID) {
        this.FK_bID = FK_bID;
    }

    public int getFK_uID() {
        return FK_uID;
    }

    public void setFK_uID(int FK_uID) {
        this.FK_uID = FK_uID;
    }
    
    
    
}
