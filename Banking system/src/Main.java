public class Main {
    public static void main(String[] args) {
        Transaction x= new Transaction();
        Account acc1= new Account("bilai","kuddus", 0, 1234 );
        Account acc2= new Account("bilai","sesra", 16500, 1345 );

        acc1.deposit(50000);
        acc1.withdraw(10000);

        x.transfer(acc2,acc1,250);
        System.out.println(acc1.getBalance() +"   "+acc2.getBalance());

    }
}
