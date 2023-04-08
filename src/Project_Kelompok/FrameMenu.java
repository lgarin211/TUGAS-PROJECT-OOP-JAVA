package Project_Kelompok;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameMenu extends JFrame {
    JButton MenuTambahProduk;
    JButton MenuUpdateProduk;
    JButton MenuKasir;
    JButton MenuLihatProduk;

    public FrameMenu() {
        this.setLayout(null);
        setupGUI();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void setupGUI() {
        MenuTambahProduk = new JButton();
        MenuTambahProduk.setLocation(100, 35);
        MenuTambahProduk.setSize(100, 100);
        MenuTambahProduk.setText("Tambah Produk");
        add(MenuTambahProduk);

        MenuUpdateProduk = new JButton();
        MenuUpdateProduk.setLocation(200, 35);
        MenuUpdateProduk.setSize(100, 100);
        MenuUpdateProduk.setText("Update Produk");
        add(MenuUpdateProduk);

        MenuKasir = new JButton();
        MenuKasir.setLocation(100, 135);
        MenuKasir.setSize(100, 100);
        MenuKasir.setText("Kasir");
        add(MenuKasir);

        MenuLihatProduk = new JButton();
        MenuLihatProduk.setLocation(200, 135);
        MenuLihatProduk.setSize(100, 100);
        MenuLihatProduk.setText("Lihat Produk");
        add(MenuLihatProduk);

        setTitle("Frame Menu");
        setSize(400, 400);
        setVisible(true);
        setResizable(true);

    }

    public static void main(String args[]) {
        new FrameMenu();
    }
}