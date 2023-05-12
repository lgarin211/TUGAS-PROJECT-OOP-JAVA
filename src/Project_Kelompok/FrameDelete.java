package Project_Kelompok;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameDelete extends JFrame implements DeleteProduk {
    private JLabel headerFrameDelete = new JLabel("Delete Produk");
    private JPanel PanelAtas = new JPanel(new GridLayout(2, 1, 40, 0));
    private JComboBox listBarang = new JComboBox();
    private JPanel panelDelete = new JPanel(new GridLayout(1, 2, 20, 0));
    private JButton deleteButton = new JButton("Hapus");
    private JButton deleteAllButton = new JButton("Hapus Semua Produk");

    public FrameDelete() {
        headerFrameDelete.setHorizontalAlignment(SwingConstants.CENTER);
        PanelAtas.add(headerFrameDelete);
        for (TambahProdukFrame l : main.getDataProduk()) {
            listBarang.addItem(l.getNama());
        }
        PanelAtas.add(listBarang);
        add(PanelAtas, BorderLayout.NORTH);
        deleteButton.setHorizontalAlignment(SwingConstants.CENTER);
        panelDelete.add(deleteButton);
        panelDelete.add(deleteAllButton);
        add(panelDelete, BorderLayout.SOUTH);

        deleteProduk();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        this.setSize(1000, 700);
    }

    public void deleteProduk() {
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (TambahProdukFrame l : main.getDataProduk()) {
                    if (l.getNama().equals(listBarang.getSelectedItem())) {
                        String commend = ("DELETE FROM dataproduk WHERE Nama_produk = '" + l.getNama() + "'");
                        System.out.println(commend);
                        new SQL().SetupConeksi(commend, "Delete");

                        main.getDataProduk().clear();
                        main.loaddata();
                        Alert.succ("Produk berhasil dihapus");
                        setVisible(false);
                        new FrameDelete();
                    }
                }
            }
        });

        deleteAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (TambahProdukFrame l : main.getDataProduk()) {
                    String commend = ("DELETE FROM dataproduk WHERE Nama_produk = '" + l.getNama() + "'");
                    System.out.println(commend);
                    new SQL().SetupConeksi(commend, "Delete");
                }
                main.getDataProduk().clear();
                main.loaddata();
                Alert.succ("Semua Produk berhasil dihapus");
                setVisible(false);
                new FrameDelete();
            }
        });
    }
}

interface DeleteProduk {
    void deleteProduk();
}
