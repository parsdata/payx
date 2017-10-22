package project.parsdata.com.V;

public class RegisterUser {


    private String UserID;
    private String AppID;
    private String ActivationCode;

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String UserID) {
        this.UserID = UserID;
    }

    public String getAppID() {
        return AppID;
    }

    public void setAppID(String AppID) {
        this.AppID = AppID;
    }
    public String getActiveCode() {
        return ActivationCode;
    }
    public void setActiveCode(String ActiveCode) {
        this.ActivationCode = ActiveCode;
    }
}