package PO_KlasaFile;

import java.io.File;

public class KlasaFile {

    public static void main(String[] args) {

        File plik = new File("D:\\books.pdf");

        System.out.println("Czy istnieje: " + plik.exists());
        System.out.println("Nazwa: " + plik.getName());
        System.out.println("PATH: " + plik.getPath());
        System.out.println(plik.delete());
    }
}
