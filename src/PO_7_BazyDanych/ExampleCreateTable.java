package PO_7_BazyDanych;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class ExampleCreateTable {
    public static void main (String[] args) throws SQLException {

        Connection connection = null;
        Statement stmt = null;

        int resultQuery;
        String result = "0";
        try {
            String url = "jdbc:mysql://localhost:3306/";
            InputStream input = new FileInputStream("example.properties");
            Properties ustawienia = new Properties();
            ustawienia.load(input);

            connection = DriverManager.getConnection(
                    ustawienia.getProperty("db.url") + ustawienia.getProperty("db.base"),
                    ustawienia.getProperty("db.user"),
                    ustawienia.getProperty("db.password"));

            stmt = connection.createStatement();
            resultQuery = stmt.executeUpdate("CREATE TABLE Osoba(" +
                                                  "idOsoba int auto_increment primary key, " +
                                                  "pesel char(11) not null, " +
                                                  "imie varchar(40) not null, " +
                                                  "pensja double not null" + 
                                                  ")");

            if (resultQuery == 0)
                System.out.println("Tabela Osoba został utworzona.");
      
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch(SQLException e){
            System.err.println("SQLState: " +
                    ((SQLException)e).getSQLState());
            result = e.getSQLState();
            System.err.println("Error Code: " +
                    ((SQLException)e).getErrorCode());
            System.err.println("Message: " + e.getMessage());
        }
        finally {
            if (result.equals("0"))  stmt.close();
            connection.close();
        }
    }
}
