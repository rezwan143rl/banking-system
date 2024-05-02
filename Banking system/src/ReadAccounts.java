package testcases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class Testcases {
    private LinkedList<String> column1 = new LinkedList<>();
    private LinkedList<String> column2 = new LinkedList<>();
    private LinkedList<Integer> column3 = new LinkedList<>();
    private LinkedList<Integer> column4 = new LinkedList<>();

    public void readCSV(String csvFile) {
        String line;
        String csvSplitBy = ",";
        boolean firstRow = true;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (firstRow) {
                    firstRow = false;
                    continue; // Skip the first row
                }
                String[] data = line.split(csvSplitBy);
                if (data.length == 4) {
                    column1.add(data[0]);
                    column2.add(data[1]);
                    column3.add(Integer.parseInt(data[2]));
                    column4.add(Integer.parseInt(data[3]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public LinkedList<String> getColumn1() {
        return column1;
    }

    public LinkedList<String> getColumn2() {
        return column2;
    }

    public LinkedList<Integer> getColumn3() {
        return column3;
    }

    public LinkedList<Integer> getColumn4() {
        return column4;
    }

    public static void main(String[] args) {
        Testcases csvReader = new Testcases();
        csvReader.readCSV("C:\\Users\\rizwa\\Desktop\\java215\\testcases\\src\\testcases\\Accounts_-2015983111.csv");

        System.out.println("Column 1:");
        System.out.println(csvReader.getColumn1());

        System.out.println("\nColumn 2:");
        System.out.println(csvReader.getColumn2());

        System.out.println("\nColumn 3:");
        System.out.println(csvReader.getColumn3());

        System.out.println("\nColumn 4:");
        System.out.println(csvReader.getColumn4());
    }
}
