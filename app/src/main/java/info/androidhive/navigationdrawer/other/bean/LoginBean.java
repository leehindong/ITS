package info.androidhive.navigationdrawer.other.bean;

/**
 * Created by apple on 16/10/11.
 */

public class LoginBean {
    private String USER_ID;
    private String PASSWORD;

    public String getPASSWORD() {
        return PASSWORD;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public LoginBean(String id, String pwd) {
        this.PASSWORD = pwd;
        this.USER_ID = id;
    }
}
