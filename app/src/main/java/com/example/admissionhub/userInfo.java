package com.example.admissionhub;

public class userInfo {

    private String fllname,usrname,pssword,phn,ssgpa,hsgpa,grp,usrId,aust;
    private String ju,du,buet,iut,sust,quiz_marks;


    public userInfo(){

    }

    public userInfo(String fllname, String usrname, String pssword, String phn, String ssgpa, String hsgpa,String grp,String usrId,String aust,String sust, String iut, String du , String buet, String ju, String quiz_marks) {
        this.fllname = fllname;
        this.usrname = usrname;
        this.pssword = pssword;
        this.phn = phn;
        this.ssgpa = ssgpa;
        this.hsgpa = hsgpa;
        this.grp = grp;
        this.usrId=usrId;
        this.aust = aust;
        this.sust=sust;
        this.ju=ju;
        this.du=du;
        this.buet =buet;
        this.iut=iut;
        this.quiz_marks=quiz_marks;
    }

    public String getGrp() {
        return grp;
    }

    public void setGrp(String grp) {
        this.grp = grp;
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

    public String getUSERID() {
        return usrId;
    }

    public void setUSERID(String usrId) {
        this.usrId = usrId;
    }

    public String getAust() {
        return aust;
    }

    public void setAust(String aust) {
        this.aust = aust;
    }

    public String getSust() { return sust; }

    public void setSust(String sust) {
        this.sust = sust;
    }

    public String getJu() {
        return ju;
    }

    public void setJu(String ju) {
        this.ju = ju;
    }

    public String getBuet() {
        return buet;
    }

    public void setBuet(String buet) {
        this.buet = buet;
    }

    public String getDu() {
        return du;
    }

    public void setDu(String du) {
        this.du = du;
    }

    public String getIut() {
        return iut;
    }

    public void setIut(String iut) {
        this.iut = iut;
    }

    public String getQuiz_marks() {
        return quiz_marks;
    }

    public void setQuiz_marks(String quiz_marks) {
        this.quiz_marks = quiz_marks;
    }




}
