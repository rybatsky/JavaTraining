package javase05.t01;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.NotDirectoryException;
import java.util.Scanner;

import static java.lang.System.in;

/**
 * Created by rybatsky
 */

public class Console {

    private FileManager fileManager;

    Console() {
        fileManager = new FileManager();
    }

    public void commands() {
        String[] command;
        String text = "";
        help();
        try (Scanner sc = new Scanner(in)) {
            do {
                try {
                    text = sc.nextLine();
                } catch (Exception e) {
                    System.out.println("Error!");
                    System.out.println(e.getMessage());
                }
                command = text.split(" ");
                switch (command[0]) {
                    case "dir": {
                        fileManager.filesInDirectory();
                        break;
                    }
                    case "up": {
                        up();
                        break;
                    }
                    case "cd": {
                        cd(command[1]);
                        break;
                    }
                    case "open": {
                        open(command[1]);
                        break;
                    }
                    case "write": {
                        write(command);
                        break;
                    }
                    case "rewrite": {
                        rewrite(command);
                        break;
                    }
                    case "create": {
                        create(command);
                        break;
                    }
                    case "help": {
                        help();
                        break;
                    }
//                    case "delete": {
//                        delete(command);
//                        break;
//                    }
                    case "exit": {
                        break;
                    }
                    default:
                        System.out.println("Wrong input!");
                }
            } while (!text.equals("exit"));
        }
    }

    private void up() {
        try {
            fileManager.upDirectory();
            fileManager.currentDirectory();
        } catch (NullPointerException nullPointerException) {
            System.out.println(nullPointerException.getMessage());
            helpDir();
            helpCd();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            help();
        }
    }

    private void cd(String dir) {
        try {
            if (dir == null) {
                help();
            } else {
                fileManager.downDirectory(dir);
            }
        } catch (NotDirectoryException notDirException) {
            System.out.println("There's no such directory.");
            helpDir();
            helpCd();
        } catch (NullPointerException nullPException) {
            System.out.println(nullPException.getMessage());
            help();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            help();
        }
    }

    private void open(String name) {
        try {
            fileManager.open(name);
        } catch (FileNotFoundException fNotFound) {
            System.out.println("Такого файла не существует!");
            helpDir();
            helpCreate();
            helpOpen();
            helpWrite();
            helpRewrite();
        } catch (IOException ioException) {
            System.out.println("Ошибка чтения!");
            help();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            help();
        }
    }

    private String text(String[] command) {
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < command.length; i++) {
            sb.append(command[i] + " ");
        }
        return sb.toString();
    }
    private void  write(String[] command) {
        try {
            fileManager.write(command[1], text(command), true);
            System.out.println("Text added.");
        } catch (FileNotFoundException fNotFound) {
            System.out.println(fNotFound.getMessage());
            helpDir();
            helpCreate();
        } catch (IOException ioException) {
            System.out.println("Ошибка чтения!");
            help();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            help();
        }
    }

    private void rewrite(String[] command) {
        try {
            fileManager.write(command[1], text(command), false);
            System.out.println("Text rewrote.");
        } catch (FileNotFoundException fNotFound) {
            System.out.println(fNotFound.getMessage());
            helpDir();
            helpCreate();
        } catch (IOException ioException) {
            System.out.println("Ошибка записи!");
            help();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            help();
        }
    }

    private void create(String[] command) {
        try {
            fileManager.create(command[1], text(command));
            System.out.println("File with text created.");
        } catch (FileAlreadyExistsException fAlreadyExist) {
            System.out.println("Файл " + fAlreadyExist.getMessage() + " уже существует!");
            helpDir();
            helpOpen();
            helpRewrite();
            helpWrite();
        } catch (IOException ioException) {
            System.out.println("Ошибка чтения!");
            help();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            help();
        }
    }

//    private void delete(String[] command) {
//        try {
//            fileManager.delete(command[1]);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private void help() {
        helpDir();
        helpUp();
        helpCd();
        helpOpen();
        helpWrite();
        helpRewrite();
        helpCreate();
//        helpDelete();
        helpEx();
    }

    private void helpDir() {
        System.out.println("dir -- to show all files in current directory");
    }

    private void helpUp() {
        System.out.println("up -- to go up in directory");
    }

    private void helpCd() {
        System.out.println("cd  DirectoryName -- to open directory");
    }

    private void helpOpen() {
        System.out.println("open FileName.extension -- to open file");
    }

    private void helpWrite() {
        System.out.println("write FileName.extension text -- to add text in file");
    }

    private void helpRewrite() {
        System.out.println("rewrite FileName.extension text -- to replace text in file");
    }

    private void helpCreate() {
        System.out.println("create FileName.extension text -- to create new file with text");
    }

//    private void helpDelete() {
//        System.out.println("delete FileName.extension -- to delete new file");
//    }

    private void helpEx() {
        System.out.println("exit -- to exit console");
    }
}
