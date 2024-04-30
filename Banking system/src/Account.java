// used inheritance 

public class Account extends Customer{
       // used encapsulation
    private int balance;
    private int accountNumber; 

    // constructor 
    public Account(String FName, String LName, int accBal, int accNum) {
        super(FName, LName); // to access variable of the parent class 
        this.balance = accBal;       
        this.accountNumber = accNum;
    }

    public int getBalance() {
        return balance;        //getter method to access private variables 
    }

    public int getAccountNumber() {
        return accountNumber;    //getter method to access private variables 
    }

    public void setBalance(int balance) {
        this.balance = balance;    //setter method to access private variables 
    }


    // method to deposit money
    public void deposit(int amount)
    {
     int temp;
     temp =getBalance();
     temp = temp +amount;
     setBalance(temp);
        System.out.println("Amount = "+amount+" is added successfully to the account.\n new balance is "+getBalance());
    }
    // method to withdraw money
    public void withdraw(int amount)
    {
        int temp;
        temp =getBalance();
        temp = temp -amount;
        setBalance(temp);
        System.out.println("Amount = "+amount+" is  successfully withdrawn from the account.\n new balance is "+getBalance());
    }
}
