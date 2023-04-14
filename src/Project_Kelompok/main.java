package Project_Kelompok;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class main {

    public static ArrayList<TambahProdukFrame> DataProduk = new ArrayList<>();

//    public static void loaddata() {
//        new SQL().SetupConeksi("SELECT * FROM dataproduk", "Read");
//    }
    public static void main(String[] args) {
        loaddata();
        new FrameMenu();
    }

    public static void loaddata(){
        new SQL().SetupConeksi("SELECT * FROM dataproduk", "Read");
    }

}