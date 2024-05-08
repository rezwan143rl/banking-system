package BankingSystem;

import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private LinkedList<Account> globalAccounts =new LinkedList<>();
	private JTextField acc1Transfer;
	private JTextField accDeposit;
	private JTextField accWithdraw;
	private JTextField acc2Transfer;
	private JTextField depositInput;
	private JTextField withdrawInput;
	private JTextField transferAmount;
	private JTextField ans;
    public GUI(LinkedList<Account> accounts) {
    	this.globalAccounts=accounts;
    	
    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		MethodsForGUI x=new MethodsForGUI();
		GUI accounts = new GUI(x.getAllACC());
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setTitle("ABC Bank");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton showAllButton = new JButton("Show All");
		showAllButton.setBounds(247, 304, 98, 29);
		showAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.setLayout(null);
		contentPane.add(showAllButton);
		
		JButton depositButton = new JButton("Deposit");
		depositButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MethodsForGUI x=new MethodsForGUI();
				x.readFile();
				
				LinkedList<Account> allAcc= new LinkedList<>();
				allAcc =x.getAllACC();
				int depositindx=x.getIndxOfAccount(Integer. parseInt(accDeposit.getText()));
				int depositAmount=Integer. parseInt(depositInput.getText());
				allAcc.get(depositindx).deposit(depositAmount);
				
				
				
			}
		});
		depositButton.setBounds(426, 143, 93, 29);
		contentPane.add(depositButton);
		
		JButton transferButton = new JButton("Transfer");
		transferButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                MethodsForGUI x=new MethodsForGUI();
                GUI gu =new GUI();
                LinkedList<Account> allAcc= new LinkedList<>();
				allAcc =x.getAllACC();
                x.readFile();
				int acc1 =x.getIndxOfAccount(Integer. parseInt(acc1Transfer.getText()));
				int acc2=x.getIndxOfAccount(Integer. parseInt(acc2Transfer.getText()));
				int tAmmount =Integer. parseInt(transferAmount.getText());
				x.Transfer(acc1, acc2, tAmmount);
				Account indxOfA1 = allAcc.get(acc1);
				int acc1bal =indxOfA1.getBalance();
				ans.setText(Integer.toString(acc1bal));
				
				
				
				
				
			}
		});
		transferButton.setBounds(488, 266, 96, 29);
		contentPane.add(transferButton);
		
		JButton withdrawButton = new JButton("Withdraw");
		withdrawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                MethodsForGUI x=new MethodsForGUI();
                x.readFile();
				
				LinkedList<Account> allAcc= new LinkedList<>();
				allAcc =x.getAllACC();
				int withdrawindx=x.getIndxOfAccount(Integer. parseInt(accWithdraw.getText()));
				int withdrawAmount=Integer. parseInt(withdrawInput.getText());
				allAcc.get(withdrawindx).withdraw(withdrawAmount);
				
			}
		});
		withdrawButton.setBounds(427, 198, 102, 29);
		contentPane.add(withdrawButton);
		
		acc1Transfer = new JTextField();
		acc1Transfer.setBounds(81, 266, 130, 26);
		contentPane.add(acc1Transfer);
		acc1Transfer.setColumns(10);
		
		accDeposit = new JTextField();
		accDeposit.setBounds(81, 143, 130, 26);
		contentPane.add(accDeposit);
		accDeposit.setColumns(10);
		
		accWithdraw = new JTextField();
		accWithdraw.setBounds(81, 198, 130, 26);
		contentPane.add(accWithdraw);
		accWithdraw.setColumns(10);
		
		acc2Transfer = new JTextField();
		acc2Transfer.setBounds(215, 266, 130, 26);
		contentPane.add(acc2Transfer);
		acc2Transfer.setColumns(10);
		
		depositInput = new JTextField();
		depositInput.setBounds(260, 143, 130, 26);
		contentPane.add(depositInput);
		depositInput.setColumns(10);
		
		withdrawInput = new JTextField();
		withdrawInput.setBounds(260, 198, 130, 26);
		contentPane.add(withdrawInput);
		withdrawInput.setColumns(10);
		
		transferAmount = new JTextField();
		transferAmount.setBounds(359, 266, 130, 26);
		contentPane.add(transferAmount);
		transferAmount.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Account(withdraw)");
		lblNewLabel.setBounds(84, 130, 127, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Amount(withdraw)");
		lblNewLabel_1.setBounds(260, 130, 130, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Account(deposit)");
		lblNewLabel_2.setBounds(81, 187, 130, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Amount(deposit)");
		lblNewLabel_3.setBounds(260, 187, 130, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sender");
		lblNewLabel_4.setBounds(112, 256, 61, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Recipient");
		lblNewLabel_5.setBounds(247, 256, 61, 16);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("amount");
		lblNewLabel_6.setBounds(383, 256, 61, 16);
		contentPane.add(lblNewLabel_6);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(130, 148, 122));
		panel.setBounds(6, 6, 578, 55);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("ABC Bank");
		lblNewLabel_7.setBounds(263, 18, 135, 16);
		panel.add(lblNewLabel_7);
		
		ans = new JTextField();
		ans.setBounds(6, 356, 578, 26);
		contentPane.add(ans);
		ans.setColumns(10);
	}
}
