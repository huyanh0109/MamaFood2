package com.example.mamafood2.model;

import java.io.Serializable;

public class MamaFood implements Serializable {
    String TenF,MotaF,HinhanhF,HinhanhF2,HinhanhF3;
    int GiaF,MaF,IdF;

    public MamaFood() {
    }

    public String getHinhanhF2() {
        return HinhanhF2;
    }

    public void setHinhanhF2(String hinhanhF2) {
        HinhanhF2 = hinhanhF2;
    }

    public String getHinhanhF3() {
        return HinhanhF3;
    }

    public void setHinhanhF3(String hinhanhF3) {
        HinhanhF3 = hinhanhF3;
    }

    public MamaFood(String tenF, String motaF, String hinhanhF, String hinhanhF2, String hinhanhF3, int giaF, int maF, int idF) {
        TenF = tenF;
        MotaF = motaF;
        HinhanhF = hinhanhF;
        HinhanhF2 = hinhanhF2;
        HinhanhF3 = hinhanhF3;
        GiaF = giaF;
        MaF = maF;
        IdF = idF;
    }

    public int getMaF() {
        return MaF;
    }

    public void setMaF(int maF) {
        MaF = maF;
    }

    public String getHinhanhF() {
        return HinhanhF;
    }

    public void setHinhanhF(String hinhanhF) {
        HinhanhF = hinhanhF;
    }

    public MamaFood(String tenF, String motaF, String hinhanhF, int giaF, int maF, int idF) {
        TenF = tenF;
        MotaF = motaF;
        HinhanhF = hinhanhF;
        GiaF = giaF;
        MaF = maF;
        IdF = idF;
    }

    public int getIdF() {
        return IdF;
    }

    public void setIdF(int idF) {
        IdF = idF;
    }

    public String getTenF() {
        return TenF;
    }

    public void setTenF(String tenF) {
        TenF = tenF;
    }


    public void setIdF(String theLoaiF) {
        IdF = IdF;
    }

    public String getMotaF() {
        return MotaF;
    }

    public void setMotaF(String motaF) {
        MotaF = motaF;
    }

    public int getGiaF() {
        return GiaF;
    }

    public void setGiaF(int giaF) {
        GiaF = giaF;
    }
}
