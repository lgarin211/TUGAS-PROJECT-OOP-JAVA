package Project_Kelompok;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameMenu extends JFrame {
    private JPanel panelUtama = new JPanel(new GridLayout(3, 2));
    private JPanel panelBarisDua = new JPanel(new GridLayout(1, 2));
    private JPanel panelBarisTiga = new JPanel(new GridLayout(1, 2));
    private JButton MenuDeleteProduk = new JButton("Delete Produk");
    private JButton MenuTambahProduk = new JButton("Tambah Produk");
    private JButton MenuUpdateProduk = new JButton("Update Produk");
    private JButton MenuKasir = new JButton("Kasir");
    private JButton MenuLihatProduk = new JButton("Lihat Produk");

    public FrameMenu() {
        panelBarisDua.add(MenuTambahProduk);
        panelBarisDua.add(MenuUpdateProduk);
        panelBarisTiga.add(MenuDeleteProduk);
        panelBarisTiga.add(MenuLihatProduk);

        panelUtama.add(MenuKasir);
        panelUtama.add(panelBarisDua);
        panelUtama.add(panelBarisTiga);
        add(panelUtama);
        Menu();
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void Menu() {

        MenuKasir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new FrameKasir();
            }
        });

        MenuTambahProduk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TambahProdukFrame();
            }
        });

        MenuUpdateProduk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrameUpdate();
            }
        });

        MenuLihatProduk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new FrameLihat();
            }
        });

        MenuDeleteProduk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // new FrameDelete();
            }
        });
    }

    public static void main(String args[]) {
        new FrameMenu();
    }
}