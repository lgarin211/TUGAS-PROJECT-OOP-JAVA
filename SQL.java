import java.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.cj.jdbc.Driver;


public class SQL {   
 public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/java_pac";
        String driver = "com.mysql.cj.jdbc.Driver";
        String username = "root";
        String password = "";
        
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
        try {
            // Register driver
            Class.forName(driver);

            // Open connection
            con = DriverManager.getConnection(url, username, password);

            // Create statement
            st = con.createStatement();

            // Execute query
            String query = "SELECT * FROM tbl_barang";
            rs = st.executeQuery(query);

            // Process results
            while (rs.next()) {
                String id = rs.getString("kd_barang");
                System.out.println("Ikd_barang: " + id);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close resources
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
}
