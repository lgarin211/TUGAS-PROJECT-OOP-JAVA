package Project_Kelompok;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class main {

    public static ArrayList<TambahProdukFrame> DataProduk = new ArrayList<>();

    public static void loaddata() {
        DataProduk.clear();
        new SQL().SetupConeksi("SELECT * FROM dataproduk", "Read");
    }

    public static void loaddata(String query) {
        DataProduk.clear();
        new SQL().SetupConeksi(query, "Read");
    }

    public static void main(String[] args) {
        loaddata();
        new FrameMenu();
    }

}