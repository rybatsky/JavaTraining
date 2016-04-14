package javase07.t01.v02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by rybatsky
 */

public class Deposit implements Runnable{

    BankAccount bankAccount;
    double deposit;
    private Lock lock = new ReentrantLock();

    Deposit(BankAccount bankAccount, double deposit) {
        this.bankAccount = bankAccount;
        this.deposit = deposit;
        new Thread(this, "Deposit: " + bankAccount.getId()).start();
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            lock.lock();
            bankAccount.deposit(deposit);
        } catch (Exception e) {
            e.fillInStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
