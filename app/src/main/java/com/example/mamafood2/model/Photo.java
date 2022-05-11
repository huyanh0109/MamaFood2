package com.example.mamafood2.model;

import java.io.Serializable;

public class Photo implements Serializable {
    String IdPhoto1,IdPhoto2,Idphoto3;

    public Photo(String idPhoto1, String idPhoto2, String idphoto3) {
        IdPhoto1 = idPhoto1;
        IdPhoto2 = idPhoto2;
        Idphoto3 = idphoto3;
    }

    public Photo(String idPhoto1) {
        IdPhoto1 = idPhoto1;
    }

    public Photo() {
    }

    public String getIdPhoto1() {
        return IdPhoto1;
    }

    public void setIdPhoto1(String idPhoto1) {
        IdPhoto1 = idPhoto1;
    }

    public String getIdPhoto2() {
        return IdPhoto2;
    }

    public void setIdPhoto2(String idPhoto2) {
        IdPhoto2 = idPhoto2;
    }

    public String getIdphoto3() {
        return Idphoto3;
    }

    public void setIdphoto3(String idphoto3) {
        Idphoto3 = idphoto3;
    }
}
