package Project_Kelompok;

import java.awt.*;
import java.awt.event.*;
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

        setTitle("FreamLihat");
        setSize(800, 600);
        setVisible(true);
        setResizable(true);

    }

    public static void main(String args[]) {
        new FrameLihat();
    }
}