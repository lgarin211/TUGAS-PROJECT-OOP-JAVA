package Project_Kelompok;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameMenu extends JFrame {
    private JPanel panelUtama = new JPanel(new GridLayout(2, 2));
    private JButton MenuTambahProduk = new JButton("Tambah Produk");
    private JButton MenuUpdateProduk = new JButton("Update Produk");
    private JButton MenuKasir = new JButton("Kasir");
    private JButton MenuLihatProduk = new JButton("Lihat Produk");

    public FrameMenu() {
        panelUtama.add(MenuTambahProduk);
        panelUtama.add(MenuUpdateProduk);
        panelUtama.add(MenuKasir);
        panelUtama.add(MenuLihatProduk);
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
    }

    public static void main(String args[]) {
        new FrameMenu();
    }
}