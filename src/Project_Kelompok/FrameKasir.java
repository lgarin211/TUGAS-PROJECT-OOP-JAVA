package Project_Kelompok;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class FrameKasir extends JFrame {
    private JPanel namaPembeliPanel = new JPanel(new GridLayout(4, 2, 0, 25));
    private JLabel namaPembeliLabel = new JLabel("Nama Pembeli");
    private JTextField namaPembeliField = new JTextField();

    private JPanel centerPanel = new JPanel(new GridLayout(3, 2, 0, 25));
    private JLabel barangLabel = new JLabel("Barang");
    private JComboBox listBarang = new JComboBox();
    private JLabel hargaLabel = new JLabel("Harga");
    private JTextField hargaField = new JTextField(20);
    private JLabel quantityLabel = new JLabel("Quantity");

    private JPanel addQuantityPanel = new JPanel(new GridLayout(1, 2));
    private JTextField quantityField = new JTextField();
    private JButton addButton = new JButton("Add");

    private String[] TableTitle = { "No", "Nama", "Harga", "Quantity" };
    private Object[][] TableData = {};

    private DefaultTableModel model = new DefaultTableModel(TableData, TableTitle);
    private JTable table = new JTable(model);

    private JScrollPane scrollPane = new JScrollPane(table);
    private int i = 1;
    private JPanel checkoutButton = new JPanel(new GridLayout(1, 2));
    private JTextField sum = new JTextField();
    private JButton checkout = new JButton("Checkout");

    private int summary = 0;
    private int QTY = 0;

//    public static ArrayList<String> BarangBeli = new ArrayList<>();

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
//                            BarangBeli.add(listBarang.getSelectedItem().toString());
                            //////////////////
                            i++;
                            int price = l.getHarga();
                            summary += qty * price;
                            System.out.println(summary);
                            sum.setText(String.valueOf(summary));
                            String commend = ("UPDATE dataproduk SET `Stok` = '" + QTY + "'"
                                    + " WHERE `dataproduk`.`Nama_produk` = '" + l.getNama() + "'");
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
                String a = "";
                for (int i = 0; i < model.getRowCount(); i++) {
                    a += model.getValueAt(i, 1).toString() + "(" + model.getValueAt(i, 3).toString() + ")";
                    if(i != model.getRowCount()-1){
                        a += ", ";
                    }
                }
                FrameCheckOut newone = new FrameCheckOut(namaPembeliField.getText().toString(),
                        LocalDate.now().toString(),
                        model, summary,a);
                main.printToPrinter(newone);
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
                String timestamp = now.format(formatter);
                String filename = "out/" + timestamp + ".jpg";
                main.printToImage(newone, filename);
                main.DataTransaksi.add(newone);


                System.out.println(model.toString());
                String commend = ("INSERT INTO Transaksi VALUES (NULL, '" + namaPembeliField.getText() + "', '"
                        + summary
                        + "', current_timestamp(),'" + a
                        + "')");
                new SQL().SetupConeksi(commend, "Insert");
                dispose();
            }
        });
    }

    public static void main(String[] args) {
//        BarangBeli.clear();
    }

}
