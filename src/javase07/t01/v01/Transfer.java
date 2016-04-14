package javase07.t01.v01;

/**
 * Created by rybatsky
 */

public class Transfer implements Runnable {

    BankAccount bankAccountSender;
    BankAccount bankAccountRecipient;
    double amount;

    Transfer(BankAccount bankAccountSender, BankAccount bankAccountRecipient, double amount) {
        this.bankAccountSender = bankAccountSender;
        this.bankAccountRecipient = bankAccountRecipient;
        this.amount = amount;
        new Thread(this, "Tranfer " + bankAccountSender.getId()).start();
    }

    public void run() {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int hashSender = bankAccountSender.hashCode();
        int hashRecipient = bankAccountRecipient.hashCode();
        BankAccount bankAccount1;
        BankAccount bankAccount2;

        if (hashSender < hashRecipient) {
            bankAccount1 = bankAccountRecipient;
            bankAccount2 = bankAccountSender;
        } else {
            bankAccount1 = bankAccountSender;
            bankAccount2 = bankAccountRecipient;
        }

        synchronized (bankAccount1) {
            synchronized (bankAccount2) {
                bankAccountSender.withdraw(amount);
                bankAccountRecipient.deposit(amount);
            }
        }
    }
}
