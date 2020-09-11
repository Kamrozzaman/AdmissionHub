package com.example.admissionhub;

public class universityInfo {

    private String university,apstart,apend,exm,uid;

    public universityInfo(){

    }

    public universityInfo(String university, String apstart, String apend, String exm, String uid) {
        this.university = university;
        this.apstart = apstart;
        this.apend = apend;
        this.exm = exm;
        this.uid = uid;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getApstart() {
        return apstart;
    }

    public void setApstart(String apstart) {
        this.apstart = apstart;
    }

    public String getApend() {
        return apend;
    }

    public void setApend(String apend) {
        this.apend = apend;
    }

    public String getExm() {
        return exm;
    }

    public void setExm(String exm) {
        this.exm = exm;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
