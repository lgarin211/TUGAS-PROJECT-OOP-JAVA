package Project_Kelompok;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;



public class main {

    String[] Item={"Nasi","1000","10"};



    public static ArrayList<TambahProdukFrame> DataProduk=new ArrayList<>();

    public static void main(String[] args) {
        login();
//        tambahProduk();
    }

    

    public static void Menu(){
        FrameMenu newFrame = new FrameMenu();
        newFrame.setTitle("FreamMenu");
        newFrame.MenuKasir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newFrame.setVisible(false);
                FrameKasir newFrameKasir = new FrameKasir();
                newFrameKasir.Kasir();
            }
        });
        newFrame.MenuTambahProduk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                newFrame.setVisible(false);
                TambahProdukFrame newFrameTambahProduk = new TambahProdukFrame();
                newFrameTambahProduk.tambahProduk();
            }
        });
    }


    public static ArrayList<TambahProdukFrame> listTambahProduk = new ArrayList<TambahProdukFrame>();
    
    public static void tambahProduk(){

//        int stokProdukBaru;
//        String namaProdukBaru;
        TambahProdukFrame newFream = new TambahProdukFrame();
        newFream.buttonTambah.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int hargaProdukBaru = 0, tanda2 = 1, tanda3 = 1;
                int stokProdukBaru = 0;
                String namaProdukBaru = newFream.getNama();

                try{
                    tanda2 = 1;
                    hargaProdukBaru = newFream.getHarga();
                }catch(NumberFormatException exception){
                    tanda2 = 2;
                    System.out.println("Please input number for Harga Produk Baru");
                }

                try{
                    tanda3 = 1;
                    stokProdukBaru = newFream.getStok();
                }catch(NumberFormatException exception){
                    tanda3 = 2;
                    System.out.println("Please input number for Stok Produk Baru");
                }

                if(tanda2 == 1 && tanda3 == 1){
                    getDataTambahProduk(namaProdukBaru, hargaProdukBaru, stokProdukBaru);
                    listTambahProduk.add(newFream);
                }
            }
        });
    }

    static void getDataTambahProduk(String namaProdukBaru, int hargaProdukBaru, int stokProdukBaru){
        System.out.println("Nama : " + namaProdukBaru);
        System.out.println("Harga : " + hargaProdukBaru);
        System.out.println("Stok : " + stokProdukBaru);
    }


    public static void login() {
        Login newFream = new Login();
        newFream.setTitle("LOGIN");
        newFream.untitled_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Mail = newFream.Username.getText();
                String Pass = newFream.password.getText();
                // PARSE TO INTEGER
                //  Pass = Integer.parseInt(newFream.password.getText());
                login(Mail, Pass,newFream);
            }
        });
    }

    public static void login(String Mail, String Pass,Login Fr) {
        if (Mail.equals("admin") && Pass.equals("admin")) {
            System.out.println("Login Success");
            Fr.TEXTOFALERT.setText("Login Berhasil \nSelamat Datang " + Mail);
            Fr.TEXTOFALERT.setVisible(true);
            try {
                Thread.sleep(1000);
                Fr.dispose();
                Menu();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Login Fail");
            Fr.TEXTOFALERT.setText("Login Gagal \nSilahkan Coba Lagi");
            Fr.TEXTOFALERT.setVisible(true);
        }
    }


}
