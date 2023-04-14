package Project_Kelompok;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrameLihat extends JFrame {
    private JLabel Lihat;
    private JPanel TextPot;
    private JTextField FindProduk;

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
        TextPot.setSize(800, 250);
        TextPot.setBorder(BorderFactory.createLineBorder(Color.red));
        getContentPane().add(TextPot);

        FindProduk = new JTextField();
        FindProduk.setLocation(100, 350);
        FindProduk.setSize(200, 50);
        FindProduk.setToolTipText("Cari Produk");
        getContentPane().add(FindProduk);

        // add event on input text FindProduk

        String[] columnNames = { "No", "Nama", "Harga", "Quantity" };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(700, 200));
        TextPot.add(new JScrollPane(table));

        for (TambahProdukFrame l : main.DataProduk) {
            Object[] newcolumnNames = { l.id, l.getNama(), l.getHarga(), l.getStok(), };
            model.addRow(newcolumnNames);
        }

        FindProduct(model);

        setTitle("FreamLihat");
        setSize(800, 600);
        setVisible(true);
        setResizable(true);

    }

    private void FindProduct(DefaultTableModel model) {
        FindProduk.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String text = FindProduk.getText();
                if (text.length() != 0) {
                    model.setRowCount(0);
                    main.loaddata("SELECT * FROM dataproduk WHERE Nama_produk LIKE '%" + text + "%'");
                    for (TambahProdukFrame l : main.DataProduk) {
                        Object[] newcolumnNames = { l.id, l.getNama(), l.getHarga(), l.getStok(), };
                        model.addRow(newcolumnNames);
                    }
                }
            }

        });
    }

    public static void main(String args[]) {
        new FrameLihat();
    }
}