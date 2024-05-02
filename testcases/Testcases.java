package testcases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class Node {
    String data;
    Node next;

    Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    void insert(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

public class Testcases {
    public static void main(String[] args) {
        LinkedList column1 = new LinkedList();
        LinkedList column2 = new LinkedList();
        LinkedList column3 = new LinkedList();
        LinkedList column4 = new LinkedList();

        String csvFile = "C:\\Users\\rizwa\\Desktop\\java215\\testcases\\src\\testcases\\Accounts_-2015983111.csv";
        
        String line;
        String csvSplitBy = ",";
        boolean firstRow = true; // Flag to skip the first row

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (firstRow) {
                    firstRow = false;
                    continue; // Skip the first row
                }
                String[] data = line.split(csvSplitBy);
                if (data.length == 4) {
                    column1.insert(data[0]);
                    column2.insert(data[1]);
                    column3.insert(data[2]);
                    column4.insert(data[3]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Column 1:");
        column1.display();

        System.out.println("\nColumn 2:");
        column2.display();

        System.out.println("\nColumn 3:");
        column3.display();

        System.out.println("\nColumn 4:");
        column4.display();
    }
}
