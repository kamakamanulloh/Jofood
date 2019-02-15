package com.jofood.jombangan.model;

public class Model_Menu {
   private String judul;
   private String image;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static final String TAG_judul="judul";
   public static final String TAG_image="image";


}
