package Project_Kelompok;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class FrameCatatanTransaksi extends JFrame {
    private JPanel panelAtas = new JPanel(new GridLayout(1, 2));
    private JTextField TanggalField = new JTextField();
    private JLabel TanggalLabel = new JLabel("Masukkan tanggal");
    private static Object data[][];
    private int count = 0;

    FrameCatatanTransaksi(){
        panelAtas.add(TanggalLabel);
        panelAtas.add(TanggalField);
        add(panelAtas, BorderLayout.NORTH);

        String[] columnNames = {"ID TRANSAKSI", "Tanggal", "Nama", "Nama Barang", "Total Harga"};

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);


        for(FrameCheckOut l : main.getDataTransaksi()){
            count++;
            Object[] newcolumnNames = {count, l.getDate(), l.getNamaPembeli().getText(), l.getBelanjaan(), l.getTotalHarga()};
            model.addRow(newcolumnNames);
        }
        count = 0;

        FindProduct(model);

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
                    main.loadTransaksi("SELECT * FROM Transaksi WHERE tanggal LIKE '%" + text + "%'");
                    for (FrameCheckOut l : main.getDataTransaksi()) {
                        count++;
                            Object[] newcolumnNames = {count, l.getDate(), l.getNamaPembeli().getText(), l.getBelanjaan(), l.getTotalHarga()};
                            model.addRow(newcolumnNames);
                    }
                    count = 0;
                }else{
                    model.setRowCount(0);
                    main.loadTransaksi("SELECT * FROM Transaksi");
                    for (FrameCheckOut l : main.getDataTransaksi()) {
                        count++;
                            Object[] newcolumnNames = {count, l.getDate(), l.getNamaPembeli().getText(), l.getBelanjaan(), l.getTotalHarga()};
                            model.addRow(newcolumnNames);
                    }
                    count = 0;
                }
            }

        });
    }
    public static void main(String[] args) {

        new FrameCatatanTransaksi();
    }
}
