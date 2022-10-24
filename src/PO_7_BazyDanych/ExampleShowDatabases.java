package PO_7_BazyDanych;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ExampleShowDatabases {
    public static void main (String[] args) throws SQLException {
        Connection connection = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            String url = "jdbc:mysql://localhost:3306/";
            InputStream input = new FileInputStream("mysql.properties");
            Properties ustawienia = new Properties();
            ustawienia.load(input);
            System.out.println(ustawienia.getProperty("db.url") + ustawienia.getProperty("db.base"));

            connection = DriverManager.getConnection(
                    ustawienia.getProperty("db.url") + ustawienia.getProperty("db.base"),
                    ustawienia.getProperty("db.user"),
                    ustawienia.getProperty("db.password"));


            /*
            Obiekt Statement reprezentuje instrukcję języka SQL, którą możemy
             wykonać w danym połączeniu.Obiekt Statement zajmuje się m.in..
             weryfikacją poprawności polecenia
             */
            stmt = connection.createStatement();

            /*
            Obiekt ResultSet, który zawiera odczytane informacje z bazy danych
             */
            rs = stmt.executeQuery("show databases;");

            System.out.println("List of databases: ");

            while (rs.next()){
                System.out.print(rs.getString(1) + "\n");
            }

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch(SQLException e){
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        finally {
            rs.close();
            stmt.close();
            connection.close();
        }
    }
}
