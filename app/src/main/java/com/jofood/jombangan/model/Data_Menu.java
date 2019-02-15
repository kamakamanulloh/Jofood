package com.jofood.jombangan.model;

import java.util.ArrayList;

public class Data_Menu {
    public static String[][] data = new String[][]{
            {"Semua", "https://pngimage.net/wp-content/uploads/2018/06/gambar-sendok-garpu-png-4.png"},
            {"Kaki Lima", "https://cdns.klimg.com/merdeka.com/i/w/news/2016/12/02/785799/670x335/indef-nilai-demo-2-desember-untungkan-pedagang-dadakan.png"},
            {"Aneka Nasi", "http://kavlingin.site/Joffod/nasi-lemak-png-3.png"},
            {"Aneka Mie", "http://kwetiausapiachai.com/wp-content/uploads/bakmi-yam-seafood.png"},
            {"Snack & Jajanan", "https://cdn.pixabay.com/photo/2013/07/13/01/24/french-fries-155679_960_720.png"},
            {"Minuman", "https://pngimage.net/wp-content/uploads/2018/06/minuman-segar-png-1.png"},
            {"Ayam dan Bebek", "http://kavlingin.site/Joffod/ayam-goreng-png-1.png"},
            {"Cafe", "https://i.pinimg.com/originals/ea/eb/eb/eaebeb66e7403e2cac1f7fcb679487c6.png"},
            {"Soto, Bakso dan Sop", "https://4.bp.blogspot.com/-kmk3n1fFOic/XApMw133OLI/AAAAAAAABkg/OZjpKMnpyK45z7htMKFFimtli5L01uTNACEwYBhgL/s1600/bakso%2Bcopy.png"},
            {"Sate", "https://pngimage.net/wp-content/uploads/2018/06/sate-ayam-png-1.png"},
            {"Roti", "https://i.dlpng.com/static/png/158247_preview.png"},
            {"Pizza", "http://pngimg.com/uploads/pizza/pizza_PNG44096.png"},
            {"Martabak", "http://kavlingin.site/Joffod/martabak.png"},
            {"Lainnya", "https://pngimage.net/wp-content/uploads/2018/06/gambar-makanan-png-4.png"}
    };

    public static ArrayList<Model_Menu> getListData() {
        Model_Menu model_lagu = null;
        ArrayList<Model_Menu> list = new ArrayList<>();
        for (int x = 0; x < data.length; x++) {
            model_lagu = new Model_Menu();
            model_lagu.setJudul(data[x][0]);
            model_lagu.setImage(data[x][1]);

            list.add(model_lagu);
        }
        return list;
    }
}