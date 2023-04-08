package Project_Kelompok;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

    ArrayList<TambahProdukFrame> dataProdukBaru = new ArrayList<>();

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
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(false);
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

    public void tambahProduk(){

//        int stokProdukBaru;
//        String namaProdukBaru;
        TambahProdukFrame newFrame = new TambahProdukFrame();
        newFrame.setVisible(true);
        newFrame.buttonTambah.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int hargaProdukBaru = 0, tanda2 = 1, tanda3 = 1;
                int stokProdukBaru = 0;
                String namaProdukBaru = newFrame.getNama();

                try{
                    tanda2 = 1;
                    hargaProdukBaru = newFrame.getHarga();
                }catch(NumberFormatException exception){
                    tanda2 = 2;
                    System.out.println("Please input number for Harga Produk Baru");
                }

                try{
                    tanda3 = 1;
                    stokProdukBaru = newFrame.getStok();
                }catch(NumberFormatException exception){
                    tanda3 = 2;
                    System.out.println("Please input number for Stok Produk Baru");
                }

                if(tanda2 == 1 && tanda3 == 1){
//                    getDataTambahProduk(namaProdukBaru, hargaProdukBaru, stokProdukBaru);
                    main.DataProduk.add(newFrame);
                    getDataTambahProduk(main.DataProduk);
                    newFrame.setVisible(false);

                    TambahProdukFrame newFrameTambahProduk = new TambahProdukFrame();
                    newFrameTambahProduk.tambahProduk();
                }
            }
        });
    }

    void getDataTambahProduk(ArrayList<TambahProdukFrame> dataProdukBaru){
        for (int i = 0 ; i < dataProdukBaru.size() ; i++){
            System.out.println("Produk " + i);
            System.out.println("Nama : " + dataProdukBaru.get(i).getNama());
            System.out.println("Harga : " + dataProdukBaru.get(i).getHarga());
            System.out.println("Stok : " + dataProdukBaru.get(i).getStok());
            System.out.println("===============================================");
        }
    }
//    void getDataTambahProduk(String namaProdukBaru, int hargaProdukBaru, int stokProdukBaru){
//        System.out.println("Nama : " + namaProdukBaru);
//        System.out.println("Harga : " + hargaProdukBaru);
//        System.out.println("Stok : " + stokProdukBaru);
//    }

}