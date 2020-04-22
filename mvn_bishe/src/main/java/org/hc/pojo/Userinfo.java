package org.hc.pojo;

public class Userinfo {
    private int userId;
    private String loginName;
    private String loginPass;
    private String phone;
    private String realname;
    private String identify;
    private int admin;

    public Userinfo(int userId, String loginName, String loginPass, String phone, String realname, String identify, int admin) {
        this.userId = userId;
        this.loginName = loginName;
        this.loginPass = loginPass;
        this.phone = phone;
        this.realname = realname;
        this.identify = identify;
        this.admin = admin;
    }

    public Userinfo(String loginName, String loginPass, String phone) {
        this.loginName = loginName;
        this.loginPass = loginPass;
        this.phone = phone;
    }

    public Userinfo(String loginName, String loginPass) {
        this.loginName = loginName;
        this.loginPass = loginPass;
    }

    public Userinfo(int userId, String loginName, String loginPass, String phone, String realname, String identify) {
        this.userId = userId;
        this.loginName = loginName;
        this.loginPass = loginPass;
        this.phone = phone;
        this.realname = realname;
        this.identify = identify;
    }

    public Userinfo() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPass() {
        return loginPass;
    }

    public void setLoginPass(String loginPass) {
        this.loginPass = loginPass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }
}
