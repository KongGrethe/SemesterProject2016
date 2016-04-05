package Service.Entity;

/**
 * @author Joachim
 * This class is for the User object within the database.
 */
public class User {
    
    private int uID, FK_cuID;
    private String uFName, uLName, upw, email, userRole;
    
    public User(int uID, String uFName, String uLName, String upw, String email, String userRole, int FK_cuID) {
        this.uID = uID;
        this.uFName = uFName;
        this.uLName = uLName;
        this.upw = upw;
        this.email = email;
        this.userRole = userRole;
        this.FK_cuID = FK_cuID;
    }
    
    public User(String uFName, String uLName, String upw, String email, String userRole, int FK_cuID) {
        this.uFName = uFName;
        this.uLName = uLName;
        this.upw = upw;
        this.email = email;
        this.userRole = userRole;
        this.FK_cuID = FK_cuID;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public String getuFName() {
        return uFName;
    }

    public void setuFName(String uFName) {
        this.uFName = uFName;
    }

    public String getuLName() {
        return uLName;
    }

    public void setuLName(String uLName) {
        this.uLName = uLName;
    }

    public String getUpw() {
        return upw;
    }

    public void setUpw(String upw) {
        this.upw = upw;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
    
    public int getFK_cuID() {
        return FK_cuID;
    }

    public void setFK_cuID(int FK_cuID) {
        this.FK_cuID = FK_cuID;
    }
}