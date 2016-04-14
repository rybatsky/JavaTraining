package javase07.t02;

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
                        try {
                            open(command[1], command[2]);
                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Don't forget key word.");
                        }
                        break;
                    }

                    case "help": {
                        help();
                        break;
                    }

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

    private void open(String name, String keyWord) {
        try {
            fileManager.open(name,keyWord);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            help();
        }
    }

    private void help() {
        helpDir();
        helpUp();
        helpCd();
        helpOpen();
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

    private void helpEx() {
        System.out.println("exit -- to exit console");
    }
}
