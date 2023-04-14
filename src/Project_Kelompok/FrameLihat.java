package Project_Kelompok;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrameLihat extends JFrame {
    JLabel Lihat;
    JTable Table;
    JPanel TextPot;

    public static Object data[][];

    public FrameLihat() {
        main.DataProduk.clear();
        main.loaddata();
        getContentPane().setLayout(null);
        setupGUI();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    void setupGUI() {
        Lihat = new JLabel();
        Lihat.setLocation(350, 0);
        Lihat.setSize(100, 100);
        Lihat.setText("Lihat Produk");
        Lihat.setToolTipText("");
        getContentPane().add(Lihat);
        int a=0;
        main.DataProduk.removeAll(main.DataProduk);
        main.loaddata();

        for (TambahProdukFrame l : main.DataProduk) {
            data[a][0] = l.id;
            data[a][1] = l.getNama();
            data[a][2] = l.getHarga();
            data[a][3] = l.getStok();
            for (Object[] objects : data) {
                System.out.println(objects[0] + " " + objects[1] + " " + objects[2] + " " + objects[3]);
            }
            a++;
        }



        TextPot = new JPanel();
        TextPot.setLocation(0, 100);
        TextPot.setSize(800, 400);
        getContentPane().add(TextPot);
        String[] columnNames = { "No", "Nama", "Harga", "Quantity" };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(700, 200));
        TextPot.add(new JScrollPane(table));

        for (TambahProdukFrame l : main.DataProduk) {
            Object[] newcolumnNames = { l.id, l.getNama(), l.getHarga(), l.getStok(), };
            model.addRow(newcolumnNames);
        }

        setTitle("FrameLihat");
        setSize(800, 600);
        setVisible(true);
        setResizable(true);

    }

    public static void main(String args[]) {
        new FrameLihat();
    }
}