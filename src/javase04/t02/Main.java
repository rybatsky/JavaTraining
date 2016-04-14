package javase04.t02;

import java.io.File;

/**
 * Created by rybatsky
 */

public class Main {

    public static void main(String[] args) {

        File file = new File("src\\javase04\\t02\\output.txt");
        SymbolCounter sc = new SymbolCounter("src\\javase04\\t02\\symbolcounter.java");
        sc.printer();
        sc.symbolWriter(file);
    }
}
