package javase04.t01;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rybatsky
 */

public class ByteCounter {

    Map<String, Integer> map = new HashMap<>();
    private final int A = 65;
    private final int Z = 90;
    private final int a = 97;
    private final int z = 122;

    public ByteCounter(String str) {
        addWord();
        wordCounter(str);
    }

    public void addWord() {
        File file = new File("src\\javase04\\t01\\keyWords.txt");
        try (InputStream inputStream = new FileInputStream(file);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {
            String s = "";
            int n;
            while (true) {
                n = bufferedInputStream.read();
                if (n == -1) break;
                if ((n >= a && n <= z) || (n >= A && n <= Z)) {
                    s += (char) n;
                } else {
                    if (s.compareTo("") != 0) map.put(s, 0);
                    s = "";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void wordCounter(String str) {
        File file = new File(str);
        try (InputStream inputStream = new FileInputStream(file);
             BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream)) {
            String s = "";
            int n;
            while (true) {
                n = bufferedInputStream.read();
                if (n == -1) break;
                if ((n >= a && n <= z) || (n >= A && n <= Z)) {
                    s += (char) n;
                } else {
                    if (s.compareTo("") != 0) finder(s);
                    s = "";
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void finder(String str) {
        for (String s : map.keySet()) {
            if (str.compareTo(s) == 0) {
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

    public void byteWriter (File output) {
        try (OutputStream outputStream = new FileOutputStream(output);
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream)) {
            for (String s : map.keySet()) {
                if (map.get(s) != 0) {
                    String str = s + " - " + map.get(s) + '\n';
                    byte[] b = str.getBytes();
                    bufferedOutputStream.write(b, 0, b.length);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
