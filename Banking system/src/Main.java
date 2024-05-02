import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Transaction x= new Transaction();
        /*Account acc1= new Account("Hilai","Dcruz", 0, 1234 );
        Account acc2= new Account("Ricky","Ponting", 16500, 1345 );

        acc1.deposit(50000);
        acc1.withdraw(10000);

        x.transfer(acc2,acc1,250);
        System.out.println(acc1.getBalance() +"   "+acc2.getBalance());*/
        String filename = "Accounts_-2015983111.csv";


        ReadAccounts toRead = new ReadAccounts(filename);

        toRead.readCSV(filename);


        LinkedList<Account> allAcc = new LinkedList<Account>();
        allAcc=toRead.getAllAccounts();

        //Scanner scn= new Scanner(System.in);
        System.out.println(toRead.getFirstNames());
        System.out.println(toRead.getLastNames());
        System.out.println(toRead.getAccountNames());
        System.out.println(toRead.getBalances());
        System.out.println(toRead.getAllAccounts());

        //System.out.println(toRead.toString());
        //int e = allAcc.get(allAcc.indexOf()).getBalance();
       // System.out.println(e);



    }
}
