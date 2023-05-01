package Project_Kelompok;

//Code Genarated by JGuiD
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class FrameKasir extends JFrame {
    JPanel namaPembeliPanel = new JPanel(new GridLayout(4, 2, 0, 25));
    JLabel namaPembeliLabel = new JLabel("Nama Pembeli");
    JTextField namaPembeliField = new JTextField();

    JPanel centerPanel = new JPanel(new GridLayout(3, 2, 0, 25));
    JLabel barangLabel = new JLabel("Barang");
    JComboBox listBarang = new JComboBox();
    JLabel hargaLabel = new JLabel("Harga");
    JTextField hargaField = new JTextField(20);
    JLabel quantityLabel = new JLabel("Quantity");

    JPanel addQuantityPanel = new JPanel(new GridLayout(1, 2));
    JTextField quantityField = new JTextField();
    JButton addButton = new JButton("Add");

    public static String[] TableTitle = { "No", "Nama", "Harga", "Quantity" };
    public static Object[][] TableData = {};

    static DefaultTableModel model = new DefaultTableModel(TableData, TableTitle);
    static JTable table = new JTable(model);

    public static JScrollPane scrollPane = new JScrollPane(table);
    int i = 1;
    JPanel checkoutButton = new JPanel(new GridLayout(1, 2));
    JTextField sum = new JTextField();
    JButton checkout = new JButton("Checkout");

    int summary = 0;
    int QTY = 0;

    public static ArrayList<String> BarangBeli = new ArrayList<>();

    public FrameKasir() {
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

        for (TambahProdukFrame l : main.DataProduk) {
            Object[] newcolumnNames = { l.getHarga() };
        }

        table.setPreferredScrollableViewportSize(new Dimension(700, 200));

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (TambahProdukFrame l : main.DataProduk) {
                    if (l.getNama().equals(listBarang.getSelectedItem())) {
                        int qty = Integer.parseInt(quantityField.getText().toString());
                        if (qty > QTY) {
                            System.out.println("Terlalu Banyak Stok Tidak Cukup");
                            Alert.Alert("Stok Melebihi Ketentuan");
                        } else {
                            QTY = QTY - qty;
                            Object[] newcolumnNames = { i, listBarang.getSelectedItem(), l.getHarga(),
                                    quantityField.getText() };
                            model.addRow(newcolumnNames);
                            //////////////////
                            BarangBeli.add(listBarang.getSelectedItem().toString());
                            //////////////////
                            i++;
                            int price = l.getHarga();
                            summary += qty * price;
                            System.out.println(summary);
                            sum.setText(String.valueOf(summary));
                            String commend = ("UPDATE dataproduk SET `Stok` = '" + QTY + "'" + " WHERE `dataproduk`.`Nama_produk` = '" + l.getNama() + "'");
                            new SQL().SetupConeksi(commend, "Insert");
                        }
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
                        QTY = l.getStok();
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

    public static void main(String[] args) {
        BarangBeli.clear();
    }

}
