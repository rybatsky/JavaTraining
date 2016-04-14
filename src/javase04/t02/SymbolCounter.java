package javase04.t02;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by rybatsky
 */

public class SymbolCounter {

    Map<String, Integer> map = new HashMap<>();

    public SymbolCounter(String path){
        addWord();
        wordCounter(path);
    }

    private void addWord() {
        File file = new File("src\\javase04\\t02\\keyWords.txt");
        try(FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String str;
            while (true) {
                str = bufferedReader.readLine();
                if (str == null) break;
                map.put(str, 0);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void wordCounter(String path) {
        File file = new File(path);
        try(FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String str;
            while (true) {
                str = bufferedReader.readLine();
                if (str == null) break;
                finder(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void finder(String str) {
        for(String s : map.keySet()) {
            Pattern p = Pattern.compile(s);
            Matcher m = p.matcher(str);
            while (m.find()) {
                map.put(s, map.get(s) + 1);
            }
        }
    }

    public void printer() {
        for (String s : map.keySet()) {
            if (map.get(s) != 0) {
                System.out.println(s + " " + map.get(s));
            }
        }
    }

    public void symbolWriter(File output) {
        try (Writer writer = new FileWriter(output);
        BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (String s : map.keySet()) {
                if (map.get(s) != 0) {
                    String str = s + " - " + map.get(s) + "\n";
                    bufferedWriter.write(str, 0, str.length());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
