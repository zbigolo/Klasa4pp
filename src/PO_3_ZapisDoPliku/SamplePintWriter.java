package PO_3_ZapisDoPliku;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SamplePintWriter {
    public static void main(String[] args) throws IOException {

        File savefile = new File("test.txt");
        FileWriter file = new FileWriter(savefile);

        String napis = "Ala ma kota i dwa psy.";
        String[] words = napis.split(" ");

        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
            file.write(words[i]+"\n");
        }
        file.close();
    }
}
