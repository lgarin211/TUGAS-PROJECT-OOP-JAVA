package Project_Kelompok;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.util.Locale;

public class FrameCheckOut extends JFrame {

    // Panel Atas
    // FrameKasir kasir = new FrameKasir();
    private JPanel PanelTop = new JPanel(new GridLayout(2, 2, 0, 25));
    private JLabel nama = new JLabel("Nama");
    private JLabel namaPembeli = new JLabel("Sample Nama");

    private JLabel tanggal = new JLabel("Tanggal");
    private JLabel tanggalPembelian = new JLabel("01 Mei 2023");

    // Panel Bawah
    private String[] TableTitle = { "No", "Nama Barang", "Quantity", "Harga" };
    private Object[][] TableData = {};
    private DefaultTableModel model = new DefaultTableModel(TableData, TableTitle);
    private JTable tabel = new JTable(model);
    private JPanel PanelCenter = new JPanel(new GridLayout(3, 2));
    private JScrollPane scrollpane = new JScrollPane(tabel);

    // Panel Buat Jumlah Harganya
    private JPanel BottomPanel = new JPanel(new GridLayout(1, 2));
    private JLabel labelTotal = new JLabel("Total");
    private JLabel totalBelanja = new JLabel();
    private int TotalHarga = 0;
    private String Date;
    private String Belanjaan = "";

    public int getTotalHarga() {
        return TotalHarga;
    }
    public String getDate() {
        return Date;
    }
    public String getBelanjaan() {
        return Belanjaan;
    }

    public JLabel getNamaPembeli() {
        return namaPembeli;
    }

    public FrameCheckOut(String id, String pembeli, String harga, String Item, String tgl) {
        Date = tgl;
        Belanjaan = Item;
        TotalHarga = Integer.parseInt(harga);
        namaPembeli.setText(pembeli);
        tanggalPembelian.setText(tgl);
        main.getDataTransaksi().add(this);
    }

    public FrameCheckOut(String Nama, String Datenow, DefaultTableModel model, int summary, String Belanjaan) {

        this.Belanjaan = Belanjaan;

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

}
