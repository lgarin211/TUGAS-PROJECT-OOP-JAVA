package Project_Kelompok;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> 5fe9e1de9942d62c06da9c65a242f5d9a6a87b8c

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameUpdate extends JFrame implements ActionListener {
    private JLabel headerUpdateProduk = new JLabel("Update Produk");
    private JPanel centerPanel = new JPanel(new GridLayout(3, 2));
    private JPanel footerPanel = new JPanel();
    private JComboBox list = new JComboBox();
    private JTextField updateHarga = new JTextField("0");
    private JTextField updateStok = new JTextField("0");
    private JLabel labelProduk = new JLabel("List Produk");
    private JLabel labelHarga = new JLabel("Update Harga");
    private JLabel labelStok = new JLabel("Update Stok");
    private JButton updateButton = new JButton("Update");

<<<<<<< HEAD
    

    public FrameUpdate(){
        getContentPane().setLayout(null);
        UpdateProduk();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void UpdateProduk(){
        //Ini buat dropdown combobox
        list = new JComboBox();
        list.setLocation(25,10);
        list.setSize(200,50);
        list.setEditable(false);
        getContentPane().add(list);

        //Ini buat update harganya
        updateHarga = new JTextArea();
//        updateHarga.setText("Update Harga");
        updateHarga.setLocation(150,100);
        updateHarga.setSize(200,50);
        updateHarga.setRows(5);
        updateHarga.setColumns(5);
        getContentPane().add(updateHarga);

        //label untuk updateHarga
        labelHarga = new JLabel("Update Harga");
        labelHarga.setLocation(25,100);
        labelHarga.setSize(200,50);
        getContentPane().add(labelHarga);

        //label untuk updateStok
        labelStok = new JLabel("Update Stok");
        labelStok.setLocation(25,200);
        labelStok.setSize(200,50);
        getContentPane().add(labelStok);

        //Ini buat update stoknya
        updateStok = new JTextArea();
//        updateStok.setText("Update Stok");
        updateStok.setLocation(150,200);
        updateStok.setSize(200,50);
        updateStok.setRows(5);
        updateStok.setColumns(5);
        getContentPane().add(updateStok);

        //Button update
        updateButton = new JButton();
        updateButton.setLocation(150, 300);
        updateButton.setSize(100,50);
        updateButton.setText("Update");
        getContentPane().add(updateButton);

        setTitle("Update");
        setSize(400,400);
        setVisible(true);
        setResizable(false);
    }
=======
>>>>>>> 5fe9e1de9942d62c06da9c65a242f5d9a6a87b8c
    public static void main(String[] args) {
        new FrameUpdate();
    }

    public FrameUpdate() {
        headerUpdateProduk.setHorizontalAlignment(SwingConstants.CENTER);
        add(headerUpdateProduk, BorderLayout.NORTH);
        for (TambahProdukFrame l : main.DataProduk) {
            list.addItem(l.getNama());
        }

        centerPanel.add(labelProduk);
        centerPanel.add(list);

        centerPanel.add(labelHarga);
        centerPanel.add(updateHarga);

        centerPanel.add(labelStok);
        centerPanel.add(updateStok);

        add(centerPanel);

        footerPanel.add(updateButton);
        add(footerPanel, BorderLayout.SOUTH);

        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (TambahProdukFrame l : main.DataProduk) {
                    if (l.getNama().equals(list.getSelectedItem())) {
                        updateHarga.setText(l.getHarga().toString());
                        updateStok.setText(l.getStok().toString());
                    }
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int po = 0;
                for (TambahProdukFrame l : main.DataProduk) {
                    if (l.getNama().equals(list.getSelectedItem())) {
                        l.setHargaField(updateHarga.getText());
                        l.setStokField(updateStok.getText());
                        String commend = ("UPDATE dataproduk SET `Stok` = '" + updateStok.getText() + "', `Harga` = '"
                                + updateHarga.getText() + "' WHERE `dataproduk`.`Nama_produk` = '" + l.getNama() + "'");
                        new SQL().SetupConeksi(commend, "Insert");
                    }
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}