package javase07.t01.v02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rybatsky
 */

public class Transfer implements Runnable {

    BankAccount bankAccountSender;
    BankAccount bankAccountRecipient;
    double amount;
    Lock lock = new ReentrantLock();

    Transfer(BankAccount bankAccountSender, BankAccount bankAccountRecipient, double amount) {
        this.bankAccountSender = bankAccountSender;
        this.bankAccountRecipient = bankAccountRecipient;
        this.amount = amount;
        new Thread(this, "Tranfer " + bankAccountSender.getId()).start();
    }

    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            lock.lock();
            bankAccountSender.withdraw(amount);
            bankAccountRecipient.deposit(amount);
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
