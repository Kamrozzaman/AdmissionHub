package com.example.admissionhub;

public class userInfo {

    private String fllname,usrname,pssword,phn,ssgpa,hsgpa;

    public userInfo(String fllname, String usrname, String pssword, String phn, String ssgpa, String hsgpa) {
        this.fllname = fllname;
        this.usrname = usrname;
        this.pssword = pssword;
        this.phn = phn;
        this.ssgpa = ssgpa;
        this.hsgpa = hsgpa;


    }

    public String getFllname() {
        return fllname;
    }

    public void setFllname(String fllname) {
        this.fllname = fllname;
    }

    public String getUsrname() {
        return usrname;
    }

    public void setUsrname(String usrname) {
        this.usrname = usrname;
    }

    public String getPssword() {
        return pssword;
    }

    public void setPssword(String pssword) {
        this.pssword = pssword;
    }

    public String getPhn() {
        return phn;
    }

    public void setPhn(String phn) {
        this.phn = phn;
    }

    public String getSsgpa() {
        return ssgpa;
    }

    public void setSsgpa(String ssgpa) {
        this.ssgpa = ssgpa;
    }

    public String getHsgpa() {
        return hsgpa;
    }

    public void setHsgpa(String hsgpa) {
        this.hsgpa = hsgpa;
    }
}
