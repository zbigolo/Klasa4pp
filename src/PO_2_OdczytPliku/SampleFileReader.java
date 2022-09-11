package PO_2_OdczytPliku;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SampleFileReader {
    public static void main (String[] args) throws IOException {
        File plik = new File(".\\src\\PO_1_OdczytPliku\\SampleFileReader.java");
        FileReader odczyt = null;

        try {
            odczyt = new FileReader(plik);

            int znak;
            while((znak = odczyt.read()) != -1){
                System.out.print((char)znak);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (odczyt != null) odczyt.close();
        }
    }
}
