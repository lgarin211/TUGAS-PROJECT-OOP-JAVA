package Project_Kelompok;

import java.awt.*;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.print.*;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.xml.crypto.Data;
import java.util.*;

public class main {

    public static ArrayList<TambahProdukFrame> DataProduk = new ArrayList<>();
    public static ArrayList<FrameCheckOut> DataTransaksi = new ArrayList<>();

    public static void printToImage(JFrame frame, String imagePath) {
        try {
            BufferedImage image = new BufferedImage(frame.getWidth(), frame.getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2D = image.createGraphics();
            frame.print(graphics2D);
            ImageIO.write(image, "jpg", new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printToPrinter(JFrame frame) {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(new Printable() {
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if (pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D g2 = (Graphics2D) graphics;
                g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                frame.printAll(graphics);
                return Printable.PAGE_EXISTS;
            }
        });
        try {
            job.print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }

    public static void loaddata() {
        DataProduk.clear();
        new SQL().SetupConeksi("SELECT * FROM dataproduk", "Read");
    }
    public static void loadTransaksi() {
        DataTransaksi.clear();
        new SQL().SetupConeksi("SELECT * FROM Transaksi", "Read2");
    }

    public static void loadTransaksi(String query) {
        DataTransaksi.clear();
        new SQL().SetupConeksi(query, "Read2");
    }

    public static void loaddata(String query) {
        DataProduk.clear();
        new SQL().SetupConeksi(query, "Read");
    }

    public static void main(String[] args) {
        loaddata();
        loadTransaksi();
        JFrame tag = new FrameMenu();
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

class Alert {
    public static void Alert(String pesan) {
        JOptionPane.showMessageDialog(null, pesan, "Error", JOptionPane.WARNING_MESSAGE);
    }
    public static void succ(String pesan) {
        JOptionPane.showMessageDialog(null, pesan, "Success", JOptionPane.PLAIN_MESSAGE);
    }
}