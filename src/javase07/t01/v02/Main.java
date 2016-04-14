package javase07.t01.v02;

/**
 * Created by rybatsky
 */

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Bank bank = new Bank();
        bank.loading();
        bank.operations();
    }
}
