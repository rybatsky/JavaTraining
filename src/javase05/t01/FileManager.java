package javase05.t01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;

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
            throw new NullPointerException("Подниматься некуда. Это корневая директория!");
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

    public void open(String name) throws Exception{
        try {
            TextEditor.read(new File(file + "//" + name));
        } catch (FileNotFoundException fileNotFoundException) {
            throw new FileNotFoundException();
        } catch (IOException ioException) {
            throw new IOException(ioException);
        } catch (Exception exception) {
            throw new Exception();
        }
    }

    public void create(String name, String text) throws Exception{
        File tempFile = new File(file + "//" + name);
        if (tempFile.isFile()) throw new FileAlreadyExistsException(tempFile.toString());
        else {
            try {
                TextEditor.create(tempFile, text);
            } catch (IOException ioException) {
                throw new IOException(ioException);
            } catch (Exception exception) {
                throw new Exception(exception);
            }
        }
    }

//    public void delete(String name) throws Exception{
//        File tempFile = new File(file + "//" + name);
//        if (!tempFile.isFile()) throw new FileNotFoundException("File not found.");
//        try {
//            TextEditor.delete(name);
//        } catch (Exception exception) {
//            throw new Exception(exception);
//        }
//    }

    public void write(String name, String text, boolean delete) throws Exception{
        File tempFile = new File(file + "//" + name);
        if (!tempFile.isFile()) throw new FileNotFoundException("File not found.");
        try {
            TextEditor.write(tempFile, text, delete);
        } catch (IOException ioException) {
            throw new IOException(ioException);
        } catch (Exception exception) {
            throw new Exception(exception);
        }
    }
}