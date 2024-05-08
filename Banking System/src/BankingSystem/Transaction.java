package BankingSystem;

public class Transaction {
    public Transaction() {
    }
    public void transfer(Account acc1 ,Account acc2, int amount) //a method to transfer money between accounts
    {
        int temp1;// to temporarily hold the balance of account 1
        int temp2;//to temporarily hold the balance of account 2
        temp1 =acc1.getBalance();
        temp2 =acc2.getBalance();
        temp1 = temp1-amount;//new temp 1 after transfer by account1
        temp2= temp2+amount;// new temp 2 after receiving by account2
        acc1.setBalance(temp1); //setting the new balance after transfer
        acc2.setBalance(temp2);
    }
}
