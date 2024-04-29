public class Account extends Customer{
    private int balance;
    private int accountNumber;


    public Account(String FName, String LName, int accBal, int accNum) {
        super(FName, LName);
        this.balance = accBal;
        this.accountNumber = accNum;
    }

    public int getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    public void deposit(int amount)
    {

    }
    public void withdraw(int amount)
    {

    }
}
