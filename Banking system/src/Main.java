import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {
        Transaction x= new Transaction();
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

        Scanner scn= new Scanner(System.in);
        System.out.println(toRead.getFirstNames());
        System.out.println(toRead.getLastNames());
        System.out.println(toRead.getAccountNames());
        System.out.println(toRead.getBalances());
        System.out.println(toRead.getAllAccounts());

        System.out.println("enter account number:");
        int acc=scn.nextInt();
        int indx = getIndxOfAccount(allAcc, acc);
        System.out.println("Deposit:");
        int dep= scn.nextInt();
        allAcc.get(indx).deposit(dep);

        int e = allAcc.get(indx).getBalance();

        System.out.println("transfer to:");
        int accToAdd = scn.nextInt();
        Transfer(allAcc, indx, accToAdd, x);


    }

    private static void Transfer(LinkedList<Account> allAcc, int indx, int accToAdd, Transaction x) {
        Scanner scn= new Scanner(System.in);
        Account indxOfA1 = allAcc.get(indx);
        int indx2 = getIndxOfAccount(allAcc, accToAdd);//method inside a method
        Account indxOfA2 = allAcc.get(indx2);
        System.out.println("how much you want to transfer:");
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
