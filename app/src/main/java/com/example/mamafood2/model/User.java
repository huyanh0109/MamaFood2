package com.example.mamafood2.model;

import java.io.Serializable;

public class User implements Serializable {
    String TenU,DiachiU,GmailU,AnhU,TdnU,PassU;
    int MaU,SdtU;

    public User() {
    }

    public User(String tenU, String diachiU, String gmailU, String anhU, String tdnU, String passU, int maU, int sdtU) {
        TenU = tenU;
        DiachiU = diachiU;
        GmailU = gmailU;
        AnhU = anhU;
        TdnU = tdnU;
        PassU = passU;
        MaU = maU;
        SdtU = sdtU;
    }

    public String getTdnU() {
        return TdnU;
    }

    public void setTdnU(String tdnU) {
        TdnU = tdnU;
    }

    public String getPassU() {
        return PassU;
    }

    public void setPassU(String passU) {
        PassU = passU;
    }

    public User(String tenU, String diachiU, String gmailU, String anhU, int maU, int sdtU) {
        TenU = tenU;
        DiachiU = diachiU;
        GmailU = gmailU;
        AnhU = anhU;
        MaU = maU;
        SdtU = sdtU;
    }

    @Override
    public String toString() {
        return "User{" +
                "TenU='" + TenU + '\'' +
                ", DiachiU='" + DiachiU + '\'' +
                ", GmailU='" + GmailU + '\'' +
                ", AnhU='" + AnhU + '\'' +
                ", TdnU='" + TdnU + '\'' +
                ", PassU='" + PassU + '\'' +
                ", MaU=" + MaU +
                ", SdtU=" + SdtU +
                '}';
    }

    public String getTenU() {
        return TenU;
    }

    public void setTenU(String tenU) {
        TenU = tenU;
    }

    public String getDiachiU() {
        return DiachiU;
    }

    public void setDiachiU(String diachiU) {
        DiachiU = diachiU;
    }

    public String getGmailU() {
        return GmailU;
    }

    public void setGmailU(String gmailU) {
        GmailU = gmailU;
    }

    public String getAnhU() {
        return AnhU;
    }

    public void setAnhU(String anhU) {
        AnhU = anhU;
    }

    public int getMaU() {
        return MaU;
    }

    public void setMaU(int maU) {
        MaU = maU;
    }

    public int getSdtU() {
        return SdtU;
    }

    public void setSdtU(int sdtU) {
        SdtU = sdtU;
    }
}
