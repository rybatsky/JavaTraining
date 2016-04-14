package javase07.t02;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.*;

/**
 * Created by rybatsky
 */

public class PropertiesLoading {

    private Map<File, ResourceBundle> map = new HashMap<>();
    volatile private boolean mapContains = false;

    synchronized public String findKey(File path, String file, String keyWord) throws RuntimeException {
        ResourceBundle rb;
        File fileProperties = new File(path + "//" + file + ".properties");
        if (!fileProperties.isFile()) throw new NullPointerException("There's no such file.");
        while (mapContains) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mapContains = true;
        if (!map.containsKey(fileProperties)) {
            try {
                String [] lang = file.split("_");
                Locale current = new Locale(lang[1], lang[2]);
                URL[] url = {path.toURI().toURL()};
                ClassLoader loader = new URLClassLoader(url);
                rb = ResourceBundle.getBundle(file, current, loader);
                map.put(fileProperties, rb);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        mapContains = false;
        notifyAll();
        String answer = "";
        try {
            answer = map.get(fileProperties).getString(keyWord);
        } catch (MissingResourceException e) {
            System.out.println(keyWord + " is not found in " +file);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
        try {
            return new String(answer.getBytes("ISO-8859-1"));
        } catch (UnsupportedEncodingException e) {
            return answer;
        }
    }
}
