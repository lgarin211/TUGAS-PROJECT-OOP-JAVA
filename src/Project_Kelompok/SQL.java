package Project_Kelompok;

import java.sql.*;

import com.mysql.cj.jdbc.Driver;

public class SQL {
    String url = "jdbc:mysql://www.lagarin.my.id:3306/lagarinm_Project_OOP_PPTI15";
    String driver = "com.mysql.cj.jdbc.Driver";
    String username = "lagarinm_lagarinm";
    String password = "Gsagustinus211";

    // String url = "jdbc:mysql://localhost:3306/java_pac";
    // String driver = "com.mysql.cj.jdbc.Driver";
    // String username = "root";
    // String password = "";

    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

    public void SetupConeksi(String query, String Type) {
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            st = con.createStatement();

            if (Type.equals("Read")) {
                read(query);
            } else if (Type.equals("Insert")) {
                insert(query);
            } else if (Type.equals("Read2")) {
                readTransaksi(query);
            } else if (Type.equals("Delete")) {
                delete(query);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void read(String query) throws ClassNotFoundException, SQLException {
        rs = st.executeQuery(query);
        while (rs.next()) {
            String id = rs.getString("id");
            String nama = rs.getString("Nama_produk");
            String harga = rs.getString("Harga");
            String stok = rs.getString("Stok");
            TambahProdukFrame item = new TambahProdukFrame(id, nama, harga, stok);
            main.DataProduk.add(item);
        }
    }

    private void readTransaksi(String query) throws ClassNotFoundException, SQLException {
        rs = st.executeQuery(query);
        while (rs.next()) {
            String id = rs.getString("id");
            String pembeli = rs.getString("Pembeli");
            String harga = rs.getString("Total");
            String Item = rs.getString("Barang");
            String tgl = rs.getString("tanggal");
            FrameCheckOut item = new FrameCheckOut(id, pembeli, harga, Item, tgl);
        }
    }

    private void insert(String query) throws ClassNotFoundException, SQLException {
        System.out.println(query);
        st.executeUpdate(query);
    }

    private void update(String query) throws ClassNotFoundException, SQLException {
        st.executeUpdate(query);
    }

    private void delete(String query) throws ClassNotFoundException, SQLException {
        st.executeUpdate(query);
    }

}
