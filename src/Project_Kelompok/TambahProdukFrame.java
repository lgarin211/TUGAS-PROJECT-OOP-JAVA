package Project_Kelompok;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TambahProdukFrame extends JFrame {
    public String id = "A";
    private JLabel headerTambahProduk = new JLabel("Tambah Produk");
    private JPanel panelUtama = new JPanel(new GridLayout(3, 2, 0, 50));
    private JLabel namaLabel = new JLabel("Nama Produk Baru: ");
    private JLabel hargaLabel = new JLabel("Harga Produk Baru: ");
    private JLabel stokLabel = new JLabel("Stok Produk Baru: ");
    private JTextField namaField = new JTextField();
    private JTextField hargaField = new JTextField();
    private JTextField stokField = new JTextField();
    JPanel containerButton = new JPanel();
    JButton buttonTambah = new JButton("Tambah");

    public TambahProdukFrame(String index, String Nama, String Harga, String Stok) {
        namaField.setText(Nama);
        hargaField.setText(Harga);
        stokField.setText(Stok);
        id = index;
    }

    public TambahProdukFrame() {
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
        setVisible(true);
        tambahProduk();
        this.setSize(1000, 700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

    }

    public Integer getHarga() {
        return Integer.parseInt(hargaField.getText());
    }

    public Integer getStok() {
        return Integer.parseInt(stokField.getText());
    }

    public String getNama() {
        return namaField.getText();
    }

    public void setHargaField(String newHarga) {
        this.hargaField.setText(newHarga);
    }

    public void setStokField(String stokField) {
        this.stokField.setText(stokField);
    }

    public void setNamaField(String namaField) {
        this.namaField.setText(namaField);
    }

    public static void main(String args[]) {
        new TambahProdukFrame();
    }

    public void tambahProduk() {
        TambahProdukFrame newFrame = this;
        newFrame.buttonTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int hargaProdukBaru = 0, tanda2 = 1, tanda3 = 1;
                int stokProdukBaru = 0;
                String namaProdukBaru = newFrame.getNama();

                try {
                    tanda2 = 1;
                    hargaProdukBaru = newFrame.getHarga();
                } catch (NumberFormatException exception) {
                    tanda2 = 2;
                    System.out.println("Please input number for Harga Produk Baru");
                }

                try {
                    tanda3 = 1;
                    stokProdukBaru = newFrame.getStok();
                } catch (NumberFormatException exception) {
                    tanda3 = 2;
                    System.out.println("Please input number for Stok Produk Baru");
                }

                if (tanda2 == 1 && tanda3 == 1) {
                    String commend = ("INSERT INTO dataproduk VALUES (NULL, '" + newFrame.getNama() + "', '"
                            + newFrame.getStok() + "', '" + newFrame.getHarga() + "')");
                    System.out.println(commend);
                    main.DataProduk.add(newFrame);
                    new SQL().SetupConeksi(commend, "Insert");

                    newFrame.setVisible(false);
                    new TambahProdukFrame();
                }
            }
        });
    }
}