
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstConnection {
    static final String JDBC_DRIVER = "com.mysql.jc.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/j1b";

    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName ("com.mysql.jdbc.Driver");
            System.out.println ("Connecting to databas...");
            conn = DriverManager.getConnection (DB_URL, USER, PASS);
            System.out.println ("Creating statement...");
            stmt = conn.createStatement ();
            String sql;
            sql = "SELECT * FROM adresy";
            ResultSet rs = stmt.executeQuery (sql);
            while (rs.next ()) {
                int id_adresu = rs.getInt ("id_adresu");
                String kod_pocztowy = rs.getString ("kod_pocztowy");
                String miasto = rs.getString ("miasto");
                String numer_domu = rs.getString ("numer_domu");
                String numer_mieszkania = rs.getString ("numer_mieszkania");
                String panstwo = rs.getString ("panstwo");
                String ulica = rs.getString ("ulica");
                String wojewodztwo = rs.getString ("wojewodztwo");


                System.out.print ("ID: " + id_adresu);
                System.out.print (", kod pocztowy: " + kod_pocztowy);
                System.out.print (", miasto: " + miasto);
                System.out.println (", numer domu: " + numer_domu);
                System.out.println (", numer_mieszkania: " + numer_mieszkania);
                System.out.println (", panstwo: " + panstwo);
                System.out.println (", ulica: " + ulica);
                System.out.println (", wojewodztwo: " + wojewodztwo);
            }

            rs.close ();
            stmt.close ();
            conn.close ();
        } catch (SQLException se) {

            se.printStackTrace ();
        } catch (Exception e) {

            e.printStackTrace ();
        } finally {

            try {
                if (stmt != null)
                    stmt.close ();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close ();
            } catch (SQLException se) {
                se.printStackTrace ();
            }
        }
        System.out.println ("Goodbye!");
    }
}
