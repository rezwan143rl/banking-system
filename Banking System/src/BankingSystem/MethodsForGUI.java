package BankingSystem;

import java.util.LinkedList;
import java.util.Scanner;

public class MethodsForGUI {
	
	private LinkedList<Account> allAcc = new LinkedList<>();
	
	
	public void readFile(){
		String file = "Accounts_-2015983111.csv";


	     ReadAccounts toRead = new ReadAccounts(file);

	     toRead.readCSV(file);


	     LinkedList<Account> allAcc = new LinkedList<Account>();
	     allAcc=toRead.getAllAccounts();
	     this.allAcc=allAcc;
	     
	     
		
	}
	public MethodsForGUI() {}
	public void setAllAcc(LinkedList<Account> x)
	{
		this.allAcc=x;
	}
	 public LinkedList<Account> getAllACC(){
		 return allAcc;
	 }

	
	
	
	
	 public void Transfer(int acc1, int acc2,int amount) {
		 LinkedList<Account> allAcc = new LinkedList<>();
		 allAcc=this.allAcc;
		    Transaction x = new Transaction();
	       
	        Account indxOfA1 = allAcc.get(acc1);
	        
	        Account indxOfA2 = allAcc.get(acc2);
	       
	        

	        x.transfer(indxOfA1,indxOfA2,amount);
	       // String str= "Balance transfer completed\\nyour available balance is : "+String.format("%d",indxOfA1.getBalance());
	        //System.out.println("Balance transfer completed\nyour available balance is : "+indxOfA1.getBalance());
	       // System.out.println(str);
	    }

	    public int getIndxOfAccount( int acc) {
	    	LinkedList<Account> allAcc = new LinkedList<>();
	    	allAcc=this.allAcc;
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
