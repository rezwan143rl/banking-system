import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.LinkedList;

public class ReadAccounts{
    
    public String url;
    public final String csvSplitBy = ",";
   
    public ReadAccounts(String URL)
    {
        this.url = URL;
    }

    public LinkedList<String> getFirstNames()
    {

    }

    public LinkedList<String> getLastNames()
    {

    }

    public LinkedList<String> getAccounts()
    {

    }

    public LinkedList<String> getBalances()
    {

    }

    try (BufferedReader br = new BufferedReader(new FileReader(url))) {
        while ((url = br.readLine()) != null) {
            String[] data = url.split(csvSplitBy);
            getFirstNames().add(data[0]);
            getLastNames().add(data[1]);
            getAccounts().add(data[2]);
            getBalances().add(data[3]);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}



