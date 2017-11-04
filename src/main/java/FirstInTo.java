import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstInTo {

    static final String JDBC_DRIVER = "com.mysql.jc.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/j1b?useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

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
            sql = "INSERT INTO adresy (id_adresu, kod_pocztowy, miasto,numer_domu,numer_mieszkania,panstwo,ulica,wojewodztwo) VALUES (\"1000\",\"085-100\",\"Bydgoszcz\",\"10\",\"4\",\"Polska\",\"wiejska\",\"kuj-pol\")";
            stmt.executeUpdate(sql);

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
