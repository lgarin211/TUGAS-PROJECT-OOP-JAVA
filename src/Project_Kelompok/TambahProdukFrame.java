package Project_Kelompok;

import javax.swing.*;
import java.awt.*;

public class TambahProdukFrame extends JFrame {

    private JLabel headerTambahProduk = new JLabel("Tambah Produk");
    //    GridLayout layout = new GridLayout(3, 2).setVgap(20);
    private JPanel panelUtama = new JPanel(new GridLayout(3, 2, 0, 50));
    private JLabel namaLabel = new JLabel("Nama Produk Baru: ");
    private JLabel hargaLabel = new JLabel("Harga Produk Baru: ");
    private JLabel stokLabel = new JLabel("Stok Produk Baru: ");
    private JTextField namaField = new JTextField();
    private JTextField hargaField = new JTextField();
    private JTextField stokField = new JTextField();
    JPanel containerButton = new JPanel();
    JButton buttonTambah = new JButton("Tambah");

    public TambahProdukFrame(){
        headerTambahProduk.setHorizontalAlignment(SwingConstants.CENTER);
        add(headerTambahProduk, BorderLayout.NORTH);

        containerButton.add(buttonTambah);
        add(containerButton, BorderLayout.SOUTH);

        panelUtama.add(namaLabel);
        panelUtama.add(namaField);
        panelUtama.add(hargaLabel);
        panelUtama.add(hargaField);
        panelUtama.add(stokLabel);
        panelUtama.add(stokField);
        add(panelUtama);

        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Default close operation open freameMenu
        //        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);


    }

    public Integer getHarga(){
        return Integer.parseInt(hargaField.getText());
    }
    public Integer getStok(){
        return Integer.parseInt(stokField.getText());
    }

    public String getNama(){
        return namaField.getText();
    }

}