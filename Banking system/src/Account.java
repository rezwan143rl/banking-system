public class Account extends Customer{
    private int balance;
    private int accountNumber;


    public Account(String FName, String LName, int accNum, int accBal) {
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

    public void setBalance(int balance) {
        this.balance = balance;
    }



    public void deposit(int amount)
    {
     int temp;
     temp =getBalance();
     temp = temp +amount;
     setBalance(temp);
        System.out.println("Amount = "+amount+" is added successfully to the account.\n new balance is "+getBalance());
    }
    public void withdraw(int amount)
    {
        int temp;
        temp =getBalance();
        temp = temp -amount;
        setBalance(temp);
       // System.out.println("Amount = "+amount+" is  successfully withdrawn from the account.\n new balance is "+getBalance());
    }
}
