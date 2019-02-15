package com.jofood.jombangan.model;

import java.util.ArrayList;

public class Data_Help {
    public static String[][] data = new String[][]{
            {"Daftarkan Kuliner Anda", "https://pngimage.net/wp-content/uploads/2018/06/gambar-sendok-garpu-png-4.png","Daftarkan Kuliner Anda"},
            {"Call Center", "https://cdn.pixabay.com/photo/2015/09/12/17/54/icon-937080_960_720.png","Telepom Call Centre JoFood"},
            {"Chat Via WhatsApp", "http://pluspng.com/img-png/whatsapp-png-whatsapp-logo-png-1000.png","Percakapan WhatsApp"},
            {"Website Jo Food", "https://pngimage.net/wp-content/uploads/2018/06/website-logo-png-1.png","Kunjungi di Jofood.com"}
    };

    public static ArrayList<Model_Help> getListData() {
        Model_Help model_help = null;
        ArrayList<Model_Help> list = new ArrayList<>();
        for (int x = 0; x < data.length; x++) {
            model_help = new Model_Help();
            model_help.setJudul(data[x][0]);
            model_help.setImage(data[x][1]);
            model_help.setTag(data[x][2]);

            list.add(model_help);
        }
        return list;
    }
}
