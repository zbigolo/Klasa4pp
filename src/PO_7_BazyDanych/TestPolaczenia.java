package PO_7_BazyDanych;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class TestPolaczenia {


    public static void main (String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/mysql";
        String username = "root";
        String password = "zaq1@WSX";

        Connection connection = null;

        System.out.println("Wariant I \n Connecting database...");

        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);

            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        finally {
            connection.close();
        }

        System.out.println("Wariant II \n Connecting database...");
        try{
            connection = DriverManager.getConnection(url+"?"
                    + "user="+username+"&password="+password);

            System.out.println("Database connected!");
        }catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        finally {
            connection.close();
        }







        System.out.println("Wariant III \n Connecting database...");
        try {
            url = "jdbc:mysql://localhost:3306/";
            InputStream input = new FileInputStream("config.properties");
            Properties ustawienia = new Properties();
            ustawienia.load(input);


            connection = DriverManager.getConnection(
                         url + ustawienia.getProperty("db.base"),
                            ustawienia.getProperty("db.user"),
                            ustawienia.getProperty("db.password"));

            System.out.println("Database connected!");

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch(SQLException e){
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        finally {
            connection.close();
        }

    }


}
