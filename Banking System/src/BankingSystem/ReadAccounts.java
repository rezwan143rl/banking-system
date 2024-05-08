package BankingSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.util.LinkedList;


public class ReadAccounts {
    public String url;


    public LinkedList<Account> bAcc = new LinkedList<>();

    public void readCSV(String csvFile) {
        String line;
        String csvSplitBy = ","; //As it is a CSV file
        boolean firstRow = true;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (firstRow) {
                    firstRow = false;
                    continue; // Skip the first row
                }
                String[] data = line.split(csvSplitBy);
                if (data.length == 4) {
                    // String to integer type casting
                    bAcc.add(new Account(data[0],data[1],Integer.parseInt(data[2]),Integer.parseInt(data[3]) ));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public ReadAccounts(String URL) {
        this.url = URL;
    }

public LinkedList<Account> getAllAccounts(){
  return bAcc;

}

public LinkedList<String> getFirstNames(){
        int i =0;
        LinkedList<String> x = new LinkedList<>();
        while(i< bAcc.size()){
         x.add(bAcc.get(i).getFirstName());
        i++;}
        return x;

    }
    public LinkedList<String> getLastNames(){
        int i =0;
        LinkedList<String> x = new LinkedList<>();
        while(i< bAcc.size()){
            x.add(bAcc.get(i).getLastName());
            i++;}
        return x;

    }
    public LinkedList<Integer> getAccountNames(){
        int i =0;
        LinkedList<Integer> x = new LinkedList<>();
        while(i< bAcc.size()){
            x.add(bAcc.get(i).getAccountNumber());
            i++;}
        return x;

    }
    public LinkedList<Integer> getBalances(){
        int i =0;
        LinkedList<Integer> x = new LinkedList<>();
        while(i< bAcc.size()){
            x.add(bAcc.get(i).getBalance());
            i++;}
        return x;

    }

    @Override
    public String toString() {
        return "ReadAccounts{" +
                "url='" + url + '\'' +
                ", bAcc=" + bAcc +
                '}';
    }
}

