package Project_Kelompok;

import java.awt.*;
import java.awt.event.*;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class main {
    public static void main(String[] args) {
        login();
    }
    public static void Menu(){
        FrameMenu newFrame = new FrameMenu();
        newFrame.setTitle("FreamMenu");
        newFrame.MenuKasir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newFrame.setVisible(false);
                Kasir();
            }
        });

        newFream.Menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFream.setVisible(false);
                tambahProduk();
            }
        });

    }


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

    public static void Kasir(){
        FrameKasir newFream = new FrameKasir();
        newFream.setTitle("FreamKasir");
        //row click
        newFream.Table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = newFream.Table.getSelectedRow();
                String id = newFream.Table.getModel().getValueAt(row, 0).toString();
                String nama = newFream.Table.getModel().getValueAt(row, 1).toString();
                String harga = newFream.Table.getModel().getValueAt(row, 2).toString();
                String Qty = newFream.Table.getModel().getValueAt(row, 3).toString();
                newFream.Harg.setText(harga);
                newFream.Nama.setText(nama);
                newFream.QTY.setText(Qty);
            }
        });

        // on a colom edit
        newFream.Table.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                int row = newFream.Table.getSelectedRow();
                int col = newFream.Table.getSelectedColumn();
                String id = newFream.Table.getModel().getValueAt(row, 0).toString();
                String nama = newFream.Table.getModel().getValueAt(row, 1).toString();
                String harga = newFream.Table.getModel().getValueAt(row, 2).toString();
                String Qty = newFream.Table.getModel().getValueAt(row, 3).toString();
            }
        });
    }


}

