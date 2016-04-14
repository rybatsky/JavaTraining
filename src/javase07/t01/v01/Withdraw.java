package javase07.t01.v01;

/**
 * Created by rybatsky
 */

public class Withdraw implements Runnable {

    BankAccount bankAccount;
    double amount;

    Withdraw(BankAccount bankAccount, double amount) {
        this.bankAccount = bankAccount;
        this.amount = amount;
        new Thread(this, "Withdraw " + bankAccount.getId()).start();
    }

    public void run() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (bankAccount) {
            bankAccount.withdraw(amount);
        }
    }
}
