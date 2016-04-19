/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service.Entity;

import javax.servlet.http.Part;

/**
 *
 * @author Lasse
 */
public class Room {
    String room, date, where, whatHappened, whatHasBeenDone, damageType;
    
    String wallNotes, ceilingNotes, floorNotes, windowDoorNotes;
    Part wallPart, ceilingPart, floorPart, windowDoorPart;//kan det være rigtigt at det skal være en SERVLET part? skal det overhovedet være her?
    //skal der også være en FK_checkupID?
    
    String moistScan, measuringPoint;

    public Room(String room, String date, String where, String whatHappened, String whatHasBeenDone, String damageType, String wallNotes, String ceilingNotes, String floorNotes, String windowDoorNotes, Part wallPart, Part ceilingPart, Part floorPart, Part windowDoorPart, String moistScan, String measuringPoint) {
        this.room = room;
        this.date = date;
        this.where = where;
        this.whatHappened = whatHappened;
        this.whatHasBeenDone = whatHasBeenDone;
        this.damageType = damageType;
        this.wallNotes = wallNotes;
        this.ceilingNotes = ceilingNotes;
        this.floorNotes = floorNotes;
        this.windowDoorNotes = windowDoorNotes;
        this.wallPart = wallPart;
        this.ceilingPart = ceilingPart;
        this.floorPart = floorPart;
        this.windowDoorPart = windowDoorPart;
        this.moistScan = moistScan;
        this.measuringPoint = measuringPoint;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getWhatHappened() {
        return whatHappened;
    }

    public void setWhatHappened(String whatHappened) {
        this.whatHappened = whatHappened;
    }

    public String getWhatHasBeenDone() {
        return whatHasBeenDone;
    }

    public void setWhatHasBeenDone(String whatHasBeenDone) {
        this.whatHasBeenDone = whatHasBeenDone;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public String getWallNotes() {
        return wallNotes;
    }

    public void setWallNotes(String wallNotes) {
        this.wallNotes = wallNotes;
    }

    public String getCeilingNotes() {
        return ceilingNotes;
    }

    public void setCeilingNotes(String ceilingNotes) {
        this.ceilingNotes = ceilingNotes;
    }

    public String getFloorNotes() {
        return floorNotes;
    }

    public void setFloorNotes(String floorNotes) {
        this.floorNotes = floorNotes;
    }

    public String getWindowDoorNotes() {
        return windowDoorNotes;
    }

    public void setWindowDoorNotes(String windowDoorNotes) {
        this.windowDoorNotes = windowDoorNotes;
    }

    public Part getWallPart() {
        return wallPart;
    }

    public void setWallPart(Part wallPart) {
        this.wallPart = wallPart;
    }

    public Part getCeilingPart() {
        return ceilingPart;
    }

    public void setCeilingPart(Part ceilingPart) {
        this.ceilingPart = ceilingPart;
    }

    public Part getFloorPart() {
        return floorPart;
    }

    public void setFloorPart(Part floorPart) {
        this.floorPart = floorPart;
    }

    public Part getWindowDoorPart() {
        return windowDoorPart;
    }

    public void setWindowDoorPart(Part windowDoorPart) {
        this.windowDoorPart = windowDoorPart;
    }

    public String getMoistScan() {
        return moistScan;
    }

    public void setMoistScan(String moistScan) {
        this.moistScan = moistScan;
    }

    public String getMeasuringPoint() {
        return measuringPoint;
    }

    public void setMeasuringPoint(String measuringPoint) {
        this.measuringPoint = measuringPoint;
    }
    
    
}
