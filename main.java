import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeoutException;

import javax.security.auth.login.LoginContext;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.text.html.HTMLEditorKit.Parser;

public class main {
    // tes
    public static void main(String[] args) {
        login();
    }
    
    public static void Menu(){
        FreamMenu newFream = new FreamMenu();
        newFream.setTitle("FreamMen");
        newFream.Menu_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                newFream.setVisible(false);
                Kasir();
            }
        });

    }

    public static void login() {
        Login newFream = new Login();
        newFream.setTitle("LOGIN");
        newFream.untitled_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Mail = newFream.Usernam.getText();
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
        FreamKasir newFream = new FreamKasir();
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


