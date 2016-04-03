package Service.Entity;

/**
 * @author Joachim
 * This class is for the User object within the database.
 */
public class User {
    
    int uID, upw;
    String userName, userRole;
    
    public User(int uID, String userName, int upw, String userRole) {
        this.uID = uID;
        this.userName = userName;
        this.upw = upw;
        this.userRole = userRole;
    }
    
    public User(String userName, int upw, String userRole) {
        this.userName = userName;
        this.upw = upw;
        this.userRole = userRole;
    }

    public int getuID() {
        return uID;
    }

    public void setuID(int uID) {
        this.uID = uID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    public int getUpw() {
        return upw;
    }

    public void setUpw(int upw) {
        this.upw = upw;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}