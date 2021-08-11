package javatest.io;

import java.io.*;
import java.util.zip.GZIPInputStream;

public class InputOutputTest {
    public static void main(String[] args) {
        try {
            new FileReader("a.txt");
            new FileInputStream("a.txt");
            new BufferedReader(new FileReader("a.txt"));
            new BufferedWriter(new FileWriter("a.txt"));
            new ObjectInputStream(new FileInputStream("a.txt"));
            new GZIPInputStream(new FileInputStream("a.txt"));
            new BufferedInputStream(new FileInputStream("a.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
