package Project_Kelompok;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.print.*;
import java.io.IOException;

public class SampelPrint {
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

    public static void main(String[] args) {
        JFrame frame = new JFrame("Test Frame");
        JLabel label = new JLabel("Hello, World!");
        frame.getContentPane().add(label);
        frame.pack();
        frame.setVisible(true);

        // Cetak ke file gambar
        // System.out.println(printToImage(frame, "image.jpg"));

        // Cetak ke printer
        printToPrinter(frame);
    }
}
