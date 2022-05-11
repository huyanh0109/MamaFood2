package com.example.mamafood2.model;

public class Cart {
    int IdF,SoluongF;
    String TenF,HinhF;
    long GiaF;

    public Cart(int idF, int soluongF, long giaF, String tenF, String hinhF) {
        IdF = idF;
        SoluongF = soluongF;
        GiaF = giaF;
        TenF = tenF;
        HinhF = hinhF;
    }

    public Cart() {
    }

    public int getIdF() {
        return IdF;
    }

    public void setIdF(int idF) {
        IdF = idF;
    }

    public int getSoluongF() {
        return SoluongF;
    }

    public void setSoluongF(int soluongF) {
        SoluongF = soluongF;
    }

    public long getGiaF() {
        return GiaF;
    }

    public void setGiaF(long giaF) {
        GiaF = giaF;
    }

    public String getTenF() {
        return TenF;
    }

    public void setTenF(String tenF) {
        TenF = tenF;
    }

    public String getHinhF() {
        return HinhF;
    }

    public void setHinhF(String hinhF) {
        HinhF = hinhF;
    }
}
