package Project_Kelompok;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class main {

    public static ArrayList<TambahProdukFrame> DataProduk = new ArrayList<>();

    public static void loaddata() {
        DataProduk.clear();
        new SQL().SetupConeksi("SELECT * FROM dataproduk", "Read");
    }

    public static void loaddata(String query) {
        DataProduk.clear();
        new SQL().SetupConeksi(query, "Read");
    }

    public static void login() {
        Login newFream = new Login();
        newFream.setTitle("LOGIN");
        newFream.untitled_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Mail = newFream.Username.getText();
                String Pass = newFream.password.getText();
                // PARSE TO INTEGER
                // Pass = Integer.parseInt(newFream.password.getText());
                login(Mail, Pass, newFream);
            }
        });
    }

    public static void login(String Mail, String Pass, Login Fr) {
        if (Mail.equals("admin") && Pass.equals("admin")) {
            System.out.println("Login Success");
            Fr.TEXTOFALERT.setText("Login Berhasil \nSelamat Datang " + Mail);
            Fr.TEXTOFALERT.setVisible(true);
            try {
                Thread.sleep(1000);
                Fr.dispose();
                new FrameMenu().Menu();
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
