package Project_Kelompok;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.Locale;

public class FrameCheckOut extends JFrame {

    // Panel Atas
    // FrameKasir kasir = new FrameKasir();
    JPanel PanelTop = new JPanel(new GridLayout(2, 2, 0, 25));
    JLabel nama = new JLabel("Nama");
    JLabel namaPembeli = new JLabel("Sample Nama");

    JLabel tanggal = new JLabel("Tanggal");
    JLabel tanggalPembelian = new JLabel("01 Mei 2023");

    // Panel Bawah
    public static String[] TableTitle = { "No", "Nama Barang", "Quantity", "Harga" };
    public static Object[][] TableData = {};
    static DefaultTableModel model = new DefaultTableModel(TableData, TableTitle);
    static JTable tabel = new JTable(model);
    static JPanel PanelCenter = new JPanel(new GridLayout(3, 2));
    public static JScrollPane scrollpane = new JScrollPane(tabel);

    // Panel Buat Jumlah Harganya
    JPanel BottomPanel = new JPanel(new GridLayout(1, 2));
    JLabel labelTotal = new JLabel("Total");
    JLabel totalBelanja = new JLabel();
    int TotalHarga = 0;
    String Date;
    String Belanjaan="";

    public FrameCheckOut(String Nama, String Datenow, DefaultTableModel model, int summary, String Belanjaan) {

        add(PanelTop, BorderLayout.NORTH);
        namaPembeli.setText(Nama);
        tanggalPembelian.setText(Datenow);
        PanelTop.add(nama);
        PanelTop.add(namaPembeli);
        PanelTop.add(tanggal);
        PanelTop.add(tanggalPembelian);
        this.model = model;
        tabel = new JTable(this.model);
        TotalHarga = summary;
        scrollpane = new JScrollPane(tabel);
        add(scrollpane, BorderLayout.CENTER);
        add(BottomPanel, BorderLayout.SOUTH);
        BottomPanel.add(labelTotal);
        totalBelanja.setText(String.valueOf(summary));
        BottomPanel.add(totalBelanja);
        Date = Datenow;

        setResizable(false);
        setSize(290, 297);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    // public static void main(String[] args) {
    // new FrameCheckOut();
    // }

}
