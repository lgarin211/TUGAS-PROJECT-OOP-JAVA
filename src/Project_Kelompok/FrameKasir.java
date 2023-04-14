package Project_Kelompok;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
//
//public class FrameKasir extends JFrame {
//    JPanel panelUtamaAtas = new JPanel(new GridLayout(4, 2, 30, 0));
//    JPanel panelUtamaBawah = new JPanel();
//    JLabel hargaLabel = new JLabel("Harga");
//    JTextField hargaField = new JTextField();
//    JLabel namaPembeliLabel = new JLabel("Nama Pembeli");
//    JTextField namaPembeliField = new JTextField();
//    JLabel barangLabel = new JLabel("Pilih Barang");
//    JComboBox barangField = new JComboBox();
//    JLabel quantityLabel = new JLabel("Quantity");
//    JTextField quantityField = new JTextField();
//
//    String[] TableTitle = { "No", "Nama", "Harga", "Quantity" };
//    Object[][] TableData = { { "1", "Baju", "Rp. 100.000", "2" }, { "2", "Celana", "Rp. 50.000", "1" },
//            { "3", "Yoyo", "Rp. 50.000", "1" } };
//    JDesktopPane desktopPane = new JDesktopPane();
//
//    JInternalFrame frame = new JInternalFrame("Internal Frame", true, true, true, true);
//    JTable table = new JTable(TableData, TableTitle);
//    JScrollPane scrollPane = new JScrollPane(table);
//
//    public FrameKasir() {
//        panelUtamaAtas.add(hargaLabel);
//        panelUtamaAtas.add(namaPembeliLabel);
//        panelUtamaAtas.add(hargaField);
//        panelUtamaAtas.add(namaPembeliField);
//        panelUtamaAtas.add(barangLabel);
//        panelUtamaAtas.add(quantityLabel);
//        barangField.addItem("Pilih Barang");
//        for (TambahProdukFrame L : main.DataProduk) {
//            barangField.addItem(L.getNama());
//        }
//        panelUtamaAtas.add(barangField);
//        panelUtamaAtas.add(quantityField);
//
//        add(panelUtamaAtas, BorderLayout.NORTH);
//        add(scrollPane, BorderLayout.CENTER);
//        setSize(400, 400);
//        setVisible(true);
//        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//    }
//
//    public static void main(String args[]) {
//        new FrameKasir();
//    }
//}

import Project_Kelompok.TambahProdukFrame;
import Project_Kelompok.main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrameKasir extends JFrame {
    JPanel namaPembeliPanel = new JPanel(new GridLayout(4,2,0,25));
    JLabel namaPembeliLabel = new JLabel("Nama Pembeli");
    JTextField namaPembeliField = new JTextField();

    JPanel centerPanel = new JPanel(new GridLayout(3,2,0,25));
    JLabel barangLabel = new JLabel("Barang");
    JComboBox listBarang = new JComboBox();
    JLabel hargaLabel = new JLabel("Harga");
    JTextField hargaField = new JTextField(20);
    JLabel quantityLabel = new JLabel("Quantity");

    JPanel addQuantityPanel = new JPanel(new GridLayout(1,2));
    JTextField quantityField = new JTextField();
    JButton addButton = new JButton("Add");

    public static String[] TableTitle = { "No", "Nama", "Harga", "Quantity" };
//    public static Object[][] TableData = { { 1, "Baju", "Rp. 100.000", "2" }, { "2", "Celana", "Rp. 50.000", "1" },
//            { "3", "Yoyo", "Rp. 50.000", "1" } };
    public static Object[][] TableData = {};

//    JDesktopPane desktopPane = new JDesktopPane();

//    JInternalFrame frame = new JInternalFrame("Internal Frame", true, true, true, true);


//    public static JTable table = new JTable(TableData, TableTitle);

    static DefaultTableModel model = new DefaultTableModel(TableData,TableTitle);
    static JTable table = new JTable(model);

    public static JScrollPane scrollPane = new JScrollPane(table);
    int i = 1;
    JPanel checkoutButton = new JPanel(new GridLayout(1,2));
    JTextField sum = new JTextField();
    JButton checkout = new JButton("Checkout");

    int summary = 0;

    public FrameKasir(){
        for (TambahProdukFrame l : main.DataProduk) {
            listBarang.addItem(l.getNama());
        }

        add(namaPembeliPanel, BorderLayout.NORTH);
        namaPembeliPanel.add(namaPembeliLabel);
        namaPembeliPanel.add(namaPembeliField);


        add(centerPanel, BorderLayout.CENTER);
        namaPembeliPanel.add(barangLabel);
        namaPembeliPanel.add(listBarang);
        namaPembeliPanel.add(hargaLabel);
        namaPembeliPanel.add(hargaField);
        namaPembeliPanel.add(quantityLabel);
        addQuantityPanel.add(quantityField);
        addQuantityPanel.add(addButton);
        namaPembeliPanel.add(addQuantityPanel);

        add(scrollPane);

        for(TambahProdukFrame l : main.DataProduk){
            Object[] newcolumnNames = {l.getHarga()};
        }

        table.setPreferredScrollableViewportSize(new Dimension(700,200));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(TambahProdukFrame l : main.DataProduk){
                    if (l.getNama().equals(listBarang.getSelectedItem())){
                        Object[] newcolumnNames = {i, listBarang.getSelectedItem(), l.getHarga(), quantityField.getText()};
                        model.addRow(newcolumnNames);
                        i++;
                        int qty = Integer.parseInt(quantityField.getText().toString());
                        int price = l.getHarga();
                        summary += qty*price;
                        System.out.println(summary);
                        sum.setText(String.valueOf(summary));
                    }
                }

                table = new JTable(TableData, TableTitle);
                scrollPane = new JScrollPane(table);
                add(scrollPane, BorderLayout.CENTER);
            }
        });

        setResizable(false);
        setSize(1000, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        listBarang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (TambahProdukFrame l : main.DataProduk) {
                    if (l.getNama().equals(listBarang.getSelectedItem())) {
                        hargaField.setText(l.getHarga().toString());
                    }
                }
            }
        });

        add(checkoutButton, BorderLayout.SOUTH);
        checkoutButton.add(sum);
        checkoutButton.add(checkout);

        checkout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

//    void action(){
//        addButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("AAAA");
////                for (TambahProdukFrame l : main.DataProduk) {
////                    if (l.getNama().equals(listBarang.getSelectedItem())) {
////                        hargaField.setText(l.getHarga().toString());
////                        Object[][] newData= {{2, l.getNama(), l.getHarga(), quantityField.getText()}};
////                        table.add(newData);
//                Object[][] newData = { { 1, "Bajuuuuuu", "Rp. 100.000", "2" }, { "2", "Celana", "Rp. 50.000", "1" },
//                        { "3", "Yoyo", "Rp. 50.000", "1" } };
//                table = new JTable(newData, TableTitle);
//                scrollPane = new JScrollPane(table);
//                add(scrollPane, BorderLayout.CENTER);
//            }
////                }
////            }
//        });
//    }

    public static void main(String[] args) {
        new FrameKasir();
    }
}
