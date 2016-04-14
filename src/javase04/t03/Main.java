package javase04.t03;

import java.io.File;

/**
 * Created by rybatsky
 */

public class Main {

    public static void main(String[] args) {

        File input = new File("src\\javase04\\t03\\input.txt");
        File output = new File("src\\javase04\\t03\\output.txt");
        Converter converter = new Converter(input, output);

        converter.reader();
        converter.writer();
        converter.printer();
    }
}
