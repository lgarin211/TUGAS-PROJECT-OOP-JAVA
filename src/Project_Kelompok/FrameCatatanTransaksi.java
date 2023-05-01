package Project_Kelompok;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class FrameCatatanTransaksi extends JFrame {
    public static ArrayList<String> arrayListBarang = new ArrayList<>();
    public static ArrayList<ClassCheckout> arrayCoba = new ArrayList<>();

    private JPanel panelAtas = new JPanel(new GridLayout(1, 2));
    private JTextField TanggalField = new JTextField();
    private JLabel TanggalLabel = new JLabel("Masukkan tanggal");
    public static Object data[][];
    private JLabel labelListBarang;
    String bikinString = "";
    int count = 0;

    FrameCatatanTransaksi(){
        panelAtas.add(TanggalLabel);
        panelAtas.add(TanggalField);
        add(panelAtas, BorderLayout.NORTH);

        String[] columnNames = {"No", "Tanggal", "Nama", "Nama Barang", "Total Harga"};

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

//        for(String k : arrayListBarang){
//            k += "\n";
//            bikinString += k;
//        }
//        System.out.println(bikinString);
//        labelListBarang = new JLabel();
//        System.out.println(model.getRowCount());
//        String nih = model.getValueAt(0, 3).toString();
//        System.out.println(nih);


        for(FrameCheckOut l : main.DataTransaksi){
            count++;
//            System.out.println("Row count: " + l.model.getRowCount());
//            String nih3 = l.model.getValueAt(0, 1).toString();
//            System.out.println(nih3);
//            for(int i = 0 ; i < l.model.getRowCount() ; i++){
//                bikinString += l.model.getValueAt(i, 1).toString();
//                if(i != l.model.getRowCount()-1){
//                    bikinString += ", ";
//                }
//            }
            Object[] newcolumnNames = {count, l.Date, l.namaPembeli.getText(), l.Belanjaan, l.TotalHarga};
            model.addRow(newcolumnNames);
        }
        count = 0;

        FindProduct(model);

//        for(String k : FrameKasir.BarangBeli){
//            System.out.println("Barang : " + k);
//        }


        setTitle("Catatan Transaksi");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(1000, 700);
        setVisible(true);
        setResizable(true);
    }

    private void FindProduct(DefaultTableModel model) {
        TanggalField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String text = TanggalField.getText();
                if (text.length() != 0) {
                    model.setRowCount(0);
                    main.loadTransaksi("SELECT * FROM Transaksi WHERE Date LIKE '%" + text + "%'");
                    for (FrameCheckOut l : main.DataTransaksi) {
                        count++;
                            Object[] newcolumnNames = {count, l.Date, l.namaPembeli.getText(), l.Belanjaan, l.TotalHarga};
                            model.addRow(newcolumnNames);
                    }
                    count = 0;
//                        Object[] newcolumnNames = { l.no, l.tanggal, l.nama, l.namaBarang, l.totalHarga};
//                        model.addRow(newcolumnNames);
                    }
                }

        });
    }
    public static void main(String[] args) {
//        arrayCoba.add(new ClassCheckout("1", "2023-05-01", "Alvina Krisendi", "Handuk", "90000"));
//        arrayCoba.add(new ClassCheckout("2", "2023-05-02", "Alvina aja", "Permen", "9000"));
//        arrayCoba.add(new ClassCheckout("3", "2023-05-03", "Afrizal", "Botol", "12000"));
//        arrayCoba.add(new ClassCheckout("4", "2023-05-03", "Gus", "Air Putih", "5000"));
//
//        arrayListBarang.add("Lele");
//        arrayListBarang.add("Botol");
//        arrayListBarang.add("Handuk");
//        arrayListBarang.add("Yupi iii i");
//        arrayListBarang.add("Lele");
//        arrayListBarang.add("Botol");
//        arrayListBarang.add("Handuk");
//        arrayListBarang.add("Yupi iii i");

        new FrameCatatanTransaksi();
    }
}
