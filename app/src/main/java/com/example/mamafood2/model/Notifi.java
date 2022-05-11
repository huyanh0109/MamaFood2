package com.example.mamafood2.model;

public class Notifi {
    int IdN;
    String TitleN,ContentN,CodeN,ImgN;

    public Notifi(int idN, String titleN, String contentN, String codeN, String imgN) {
        IdN = idN;
        TitleN = titleN;
        ContentN = contentN;
        CodeN = codeN;
        ImgN = imgN;
    }

    public Notifi(int idN, String titleN, String contentN, String imgN) {
        IdN = idN;
        TitleN = titleN;
        ContentN = contentN;
        ImgN = imgN;
    }

    public Notifi() {
    }

    public int getIdN() {
        return IdN;
    }

    public void setIdN(int idN) {
        IdN = idN;
    }

    public String getTitleN() {
        return TitleN;
    }

    public void setTitleN(String titleN) {
        TitleN = titleN;
    }

    public String getContentN() {
        return ContentN;
    }

    public void setContentN(String contentN) {
        ContentN = contentN;
    }

    public String getCodeN() {
        return CodeN;
    }

    public void setCodeN(String codeN) {
        CodeN = codeN;
    }

    public String getImgN() {
        return ImgN;
    }

    public void setImgN(String imgN) {
        ImgN = imgN;
    }
}
