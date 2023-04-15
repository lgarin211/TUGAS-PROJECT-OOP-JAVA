package Project_Kelompok;

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