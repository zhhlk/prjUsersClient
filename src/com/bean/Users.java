package com.bean;

import java.io.Serializable;

public class Users implements Serializable {
    private String uname;
    private String passwd;

    public Users() {
    }

    public Users(String uname, String passwd) {
        this.uname = uname;
        this.passwd = passwd;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
