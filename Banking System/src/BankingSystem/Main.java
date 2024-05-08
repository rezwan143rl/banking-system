package BankingSystem;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {

        Account account1= new Account("Jeffrey","Ting”", 1, 2000 );
        Account account2= new Account("Hiran","Patel", 2, 1000);

        System.out.println("The balance of account 1 is : "+account1.getBalance());
        System.out.println("The balance of account 2 is : "+account2.getBalance());

        account1.deposit(250);
        System.out.println("After deposit the balance of account 1  is : "+ account1.getBalance());
        account2.withdraw(500);
        System.out.println("After withdraw the balance of account 2 is : " +account2.getBalance());
        Transaction t= new Transaction();
        t.transfer(account1,account2,250);
        System.out.println("After Transfer the balance of account 1  is : "+ account1.getBalance());
        System.out.println("After Transfer the balance of account 2  is : "+ account2.getBalance());

        String file = "Accounts_-2015983111.csv";


        ReadAccounts toRead = new ReadAccounts(file);

        toRead.readCSV(file);


        LinkedList<Account> allAcc = new LinkedList<Account>();
        allAcc=toRead.getAllAccounts();

        Scanner scn= new Scanner(System.in);
        LinkedList<String> firstnames =new LinkedList<>();
        LinkedList<String> lastNames =new LinkedList<>();
        LinkedList<Integer> accountList=new LinkedList<>();
        LinkedList<Integer> balanceList =new LinkedList<>();
        firstnames=toRead.getFirstNames();
        lastNames=toRead.getLastNames();
        accountList=toRead.getAccountNames();
       balanceList=toRead.getBalances();


        System.out.println("enter account number:");
        int acc=scn.nextInt();
        int indx = getIndxOfAccount(allAcc, acc);
        System.out.println("Deposit:");
        int dep= scn.nextInt();
        allAcc.get(indx).deposit(dep);

        int e = allAcc.get(indx).getBalance();

        System.out.println("transfer to:");
        int accToAdd = scn.nextInt();
        Transfer(allAcc, indx, accToAdd, t);


    }
    

    private static void Transfer(LinkedList<Account> allAcc, int indx, int accToAdd, Transaction x) {
        Scanner scn= new Scanner(System.in);
        Account indxOfA1 = allAcc.get(indx);
        int indx2 = getIndxOfAccount(allAcc, accToAdd);//method inside a method
        Account indxOfA2 = allAcc.get(indx2);
        System.out.println("How much you want to transfer:");
        int amount = scn.nextInt();

        x.transfer(indxOfA1,indxOfA2,amount);
        System.out.println("Balance transfer completed\nyour available balance is : "+indxOfA1.getBalance());
    }

    private static int getIndxOfAccount(LinkedList<Account> allAcc, int acc) {
        int indx=-1;
        //System.out.println(toRead.toString())
        int size = allAcc.size();
        for(int i =0; i<(size+1);i++)
        {
            if(acc == allAcc.get(i).getAccountNumber())
            {
                indx =i;
                break;
            }


        }


        return indx;
    }
}
