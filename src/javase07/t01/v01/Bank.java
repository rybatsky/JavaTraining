package javase07.t01.v01;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * Created by rybatsky
 */

public class Bank extends Thread {

    private StringBuilder operations = new StringBuilder();

    public void loading() {
        FileReader fileReader = null;
        try {
            Thread.sleep(5_000);
            fileReader = new FileReader("src//javase07//t01//v01//Transfers.txt");
            int content;
            while ((content = fileReader.read()) != -1) {
                operations.append((char) content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileReader != null)
                    fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    HashMap<Integer, BankAccount> bankAccount = new HashMap<>();

    public void operations() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
            bankAccount.put(i, new BankAccount());
        }

        String[] commands = operations.toString().split("\n");

        for (String command : commands) {
            command = command.replaceAll("\r", "");
            String[] splitCommand = command.split(" ");
            if (Integer.parseInt(splitCommand[0]) < 2) {
                switch (splitCommand[1]) {
                    case "deposit:":
                        new Deposit(bankAccount.get(Integer.parseInt(splitCommand[0])), Double.parseDouble(splitCommand[2]));
                        break;
                    case "transfer:":
                        int num1 = Integer.parseInt(splitCommand[0]);
                        int num2 = Integer.parseInt(splitCommand[4]);
                        double value = Double.parseDouble(splitCommand[2]);
                        new Transfer(bankAccount.get(num1), bankAccount.get(num2), value);
                        break;
                    case "withdraw:":
                        new Withdraw(bankAccount.get(Integer.parseInt(splitCommand[0])), Double.parseDouble(splitCommand[2]));
                        break;
                    default:
                        System.out.println("Command is not found!");
                        break;
                }
            }
        }
        Thread.sleep(25_000);
        System.out.println();
        System.out.println("Account history: ");
        for (int i = 0; i < 2; i++) {
            System.out.println(bankAccount.get(i).getAccountHistory());
        }
    }
}
