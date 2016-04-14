package javase07.t01.v02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rybatsky
 */

public class Withdraw implements Runnable {

    BankAccount bankAccount;
    double amount;
    private Lock lock = new ReentrantLock();

    Withdraw(BankAccount bankAccount, double amount) {
        this.bankAccount = bankAccount;
        this.amount = amount;
        new Thread(this, "Withdraw " + bankAccount.getId()).start();
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            lock.lock();
            bankAccount.withdraw(amount);
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
