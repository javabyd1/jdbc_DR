import config.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FirstCaseSQL {
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost:3306/j1b";
//
//    static final String USER = "root";
//    static final String PASS = "";

    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        Scanner scanner = new Scanner (System.in);
        int choice;
        do {
            System.out.println ("Co wybierasz ? ");
            System.out.println ("0- wyjdź");
            System.out.println ("1- wyświetl wszystkie adresy");
            System.out.println ("2- dodaj adres");
            choice = scanner.nextInt ();
            try {
                conn = Database.getConnection ();
                System.out.println ("Creating statement...");
                stmt = conn.createStatement ();
                String sql;

                switch (choice) {
                    case 1:
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

                        break;
                    case 2:
                        System.out.println ("Podaj ID");
                        int noweId = scanner.nextInt ();
                        scanner.nextLine ();
                        System.out.println ("Podaj miasto: ");
                        String noweMiasto = scanner.nextLine ();

                        System.out.println ("Podaj kod pocztowy : ");
                        String nowyKodPocztowy = scanner.nextLine ();


                        sql = "INSERT INTO adresy (id_adresu, kod_pocztowy, miasto) " +
                                "VALUES (" + noweId + ",'" + nowyKodPocztowy + "','" + noweMiasto + "')";
                        int result = stmt.executeUpdate (sql);
                        System.out.println ("Result: " + result);
                        break;
                }
            } catch (SQLException se) {
                se.printStackTrace ();
            } catch (Exception e) {
                e.printStackTrace ();
            }
        }
        while (choice != 0);
        System.out.println ("Goodbye!");
    }
}
