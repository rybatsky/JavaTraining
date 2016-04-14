package javase06.t02;

import java.io.File;
import java.util.MissingResourceException;

/**
 * Created by rybatsky
 */

public class FileManager {

    private File file;

    FileManager() {
        file = new File(System.getProperty("user.dir"));
    }

    public void upDirectory() throws Exception {
        try {
            file = new File(file.getParent());
        } catch (NullPointerException nullPointerException) {
            currentDirectory();
            throw new NullPointerException("There's no up directory, it's a root one!");
        } catch (Exception exception) {
            throw new Exception(exception);
        }
    }

    public void downDirectory(String dir) throws Exception {
        try {
            file = new File(file.getPath() + "//" + dir);
            if (!file.isDirectory()) {
                file = new File(file.getParent());
            } else {
                currentDirectory();
            }
        } catch (NullPointerException nullPointerException) {
            throw nullPointerException;
        } catch (Exception exception) {
            throw new Exception(exception);
        }
    }

    public void currentDirectory() {
        System.out.println("Current directory: " + file.toString());
    }

    public void filesInDirectory() {
        System.out.println("Files in current directory: ");
        for (File file : this.file.listFiles()) {
            System.out.println(file.getName());
        }
    }

    public void open(String name, String keyWord) throws Exception{
        try {
            String answer = PropertiesLoading.findKey(file, name, keyWord);
            System.out.println(answer);
        } catch (MissingResourceException mE) {
            System.out.println(name + "is not found");
        } catch (NullPointerException nE) {
            throw nE;
        } catch (IllegalArgumentException iE) {
            throw iE;
        }
    }
}
