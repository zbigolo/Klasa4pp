package PO_8_SQLLite;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;


public class ExampleConnect {
    public static void main (String[] args) throws SQLException {
        Connection connection = null;


        try {
            String url = "jdbc:sqlite:./bases/";
            String filesdb = "films.db";
            connection = DriverManager.getConnection(url+filesdb);

            System.out.println("Połączono z bazą: "+filesdb);

        } catch(SQLException e){
            String msg = "SQLState: " + ((SQLException)e).getSQLState() +"\n"+
                    "Error Code: " + ((SQLException)e).getErrorCode() +" \n " +
                    "Message: " + e.getMessage();
            JOptionPane.showMessageDialog(
                    null,
                    msg,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        finally {
            //if (result.equals("0")) pstmt.close();
            connection.close();
        }
    }
}
