package javase05.t01;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;

/**
 * Created by rybatsky
 */
public class TextEditor {

    private static String load(File file) throws Exception{
        StringBuilder sb = new StringBuilder();
        try (FileReader fileReader = new FileReader(file)) {
            int content;
            while ((content = fileReader.read()) != -1) {
                sb.append((char) content);
            }
            return sb.toString();
        } catch (FileNotFoundException fileNotFound) {
            throw new FileNotFoundException();
        } catch (IOException ioException) {
            throw new IOException(ioException);
        } catch (Exception exception) {
            throw new Exception(exception);
        }
    }

    public static void read(File file) throws Exception {
        try {
            System.out.println(load(file));
        } catch (FileNotFoundException fileNotFoundException) {
            throw new FileNotFoundException();
        } catch (IOException ioException) {
            throw new IOException(ioException);
        } catch (Exception exception) {
            throw new Exception();
        }
    }

    public static void write(File file, String text, boolean delete) throws Exception {
        try (FileWriter fileWriter = new FileWriter(file, delete)) {
            fileWriter.write(text);
        } catch (FileNotFoundException fileNotFoundException) {
            throw new FileNotFoundException();
        } catch (IOException ioException) {
            throw new IOException(ioException);
        } catch (Exception exception) {
            throw new Exception(exception);
        }
    }

    public static void create(File file, String text) throws Exception {
        try (FileWriter fileWriter = new FileWriter(file, false)) {
            fileWriter.write(text);
        } catch (FileAlreadyExistsException fileAlreadyExistsException) {
            throw new FileAlreadyExistsException(file.toString());
        } catch (IOException ioException) {
            throw new IOException(ioException);
        } catch (Exception exception) {
            throw new Exception(exception);
        }
    }

//    public static void delete(String path) {
//        Path pathSource = Paths.get(path);
//        try {
//            Files.delete(pathSource);
//            System.out.println("File deleted successfully");
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SecurityException e) {
//            System.out.println("Нет доступа!");
//        }
//    }
}
