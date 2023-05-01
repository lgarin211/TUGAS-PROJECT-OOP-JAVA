package Project_Kelompok;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

interface FrameLihatInterface<T> {
    void setupGUI();

    void findProduct(DefaultTableModel model, T searchQuery);
}

public class FrameLihat<T> extends JFrame implements FrameLihatInterface<T> {
    private JLabel Lihat;
    private JLabel Cari;
    private JPanel TextPot;
    private JTextField FindProduk;

    public static Object data[][];

    public FrameLihat() {
        main.DataProduk.clear();
        main.loaddata();
        getContentPane().setLayout(null);
        setupGUI();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void setupGUI() {
        Lihat = new JLabel();
        Lihat.setLocation(450, 0);
        Lihat.setSize(200, 100);
        Lihat.setText("Lihat Produk");
        getContentPane().add(Lihat);

        Cari = new JLabel();
        Cari.setLocation(300, 325);
        Cari.setSize(200, 100);
        Cari.setText("Cari Produk");
        getContentPane().add(Cari);

        TextPot = new JPanel();
        TextPot.setLocation(0, 100);
        TextPot.setSize(1000, 250);
        // TextPot.setBorder(BorderFactory.createLineBorder(Color.red));
        getContentPane().add(TextPot);

        FindProduk = new JTextField();
        FindProduk.setLocation(400, 350);
        FindProduk.setSize(300, 50);
        getContentPane().add(FindProduk);

        // add event on input text FindProduk

        String[] columnNames = { "No", "Nama", "Harga", "Quantity" };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(700, 200));
        TextPot.add(new JScrollPane(table));

        for (TambahProdukFrame l : main.DataProduk) {
            Object[] newcolumnNames = { l.id, l.getNama(), l.getHarga(), l.getStok(), };
            model.addRow(newcolumnNames);
        }

        findProduct(model, null);

        setTitle("FreamLihat");
        this.setSize(1000, 700);
        setVisible(true);
        setResizable(true);
    }

    @Override
    public void findProduct(DefaultTableModel model, T searchQuery) {
        FindProduk.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String text = FindProduk.getText();
                if (text.length() != 0) {
                    model.setRowCount(0);
                    String searchQuery = "SELECT * FROM dataproduk WHERE Nama_produk LIKE '%" + text + "%'";
                    main.loaddata(searchQuery);
                    for (TambahProdukFrame l : main.DataProduk) {
                        Object[] newcolumnNames = { l.id, l.getNama(), l.getHarga(), l.getStok(), };
                        model.addRow(newcolumnNames);
                    }
                }
            }
        });
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(FrameLihat::new);
    }
}
