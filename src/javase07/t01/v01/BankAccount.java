package javase07.t01.v01;

/**
 * Created by rybatsky
 */

public class BankAccount {

    private int id;
    private static int idN = 0;
    private StringBuilder accountHistory;
    private double balance;

    public double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }

    public StringBuilder getAccountHistory() {
        return accountHistory;
    }

    synchronized private void setId() {
        this.id = idN;
        idN++;
    }

    public BankAccount() {
        setId();
        this.balance = 0;
        accountHistory = new StringBuilder();
        accountHistory.append("Id: " + this.getId());
        accountHistory.append(" Balance: " + this.getBalance() + "\n");
    }

     public void deposit(double deposit) {
         try {
             Thread.sleep(1_000);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         if (deposit > 0) {
             this.balance += deposit;
             accountHistory.append("Deposit: " + deposit + "\n");
             accountHistory.append("Balance: " + getBalance() + "\n");
             System.out.println("Deposit: " + deposit);
         } else {
             System.out.println("Deposit can't be negative!");
             accountHistory.append("Negative deposit: " + deposit + "\n");
             accountHistory.append("Balance: " + getBalance() + "\n");
         }
     }

    public void withdraw(double withdraw) {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (withdraw > 0 && this.getBalance() >= withdraw) {
            this.balance -= withdraw;
            accountHistory.append("Withdraw: " + withdraw + "\n");
            accountHistory.append("Balance: " + getBalance() + "\n");
            System.out.println("Withdraw: " + withdraw);
        } else if (withdraw <= 0){
            System.out.println("Withdraw can't be negative!");
            accountHistory.append("Negative withdraw: " + withdraw + "\n");
            accountHistory.append("Balance: " + getBalance() + "\n");
        } else {
            System.out.println("Balance is less than withdraw!");
            accountHistory.append("Withdraw: " + withdraw + "\n");
            accountHistory.append("Balance: " + getBalance() + "\n");
        }
    }
}
