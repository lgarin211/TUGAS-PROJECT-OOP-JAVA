package Project_Kelompok;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class FrameLihat extends JFrame {
    JLabel Lihat;
    JTable Table;
    JPanel TextPot;


    public static Object data[][] = new Object[main.DataProduk.size()][4];
    
    public FrameLihat() {

        getContentPane().setLayout(null);
        setupGUI();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    void setupGUI() {
        Lihat = new JLabel();
        Lihat.setLocation(350, 0);
        Lihat.setSize(100, 100);
        Lihat.setText("Lihat Produk");
        Lihat.setToolTipText("");
        getContentPane().add(Lihat);

        int a=0;
        main.DataProduk.removeAll(main.DataProduk);
        main.loaddata();

        for (TambahProdukFrame l : main.DataProduk) {
            data[a][0] = l.id;
            data[a][1] = l.getNama();
            data[a][2] = l.getHarga();
            data[a][3] = l.getStok();
            for (Object[] objects : data) {
                System.out.println(objects[0] + " " + objects[1] + " " + objects[2] + " " + objects[3]);
            }
            a++;
        }



        TextPot = new JPanel();
        TextPot.setLocation(0, 100);
        TextPot.setSize(800, 400);
        // TextPot.setBorder(BorderFactory.createLineBorder(Color.red));   
        getContentPane().add(TextPot);
        String[] columnNames = { "No", "Nama", "Harga", "Quantity" };
        Table = new JTable(data, columnNames);
        Table.setPreferredScrollableViewportSize(new Dimension(700, 200));
        JScrollPane scrollPane = new JScrollPane(Table);
        TextPot.add(scrollPane);

        setTitle("FrameLihat");
        setSize(800, 600);
        setVisible(true);
        setResizable(true);

    }

    public static void main(String args[]) {
        new FrameLihat();
    }
}