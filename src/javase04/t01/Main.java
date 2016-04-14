package javase04.t01;

import java.io.File;

/**
 * Created by rybatsky
 */

public class Main {

    public static void main(String[] args) {

        File file = new File("src\\javase04\\t01\\output.txt");
        ByteCounter bc = new ByteCounter("src\\javase04\\t01\\bytecounter.java");
        bc.printer();
        bc.byteWriter(file);
    }
}