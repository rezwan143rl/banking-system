package BankingSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import java.awt.BorderLayout;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class bankGui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField accName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bankGui frame = new bankGui();
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
	public bankGui() {
		setFont(new Font("Arial", Font.BOLD, 12));
		setTitle("Banking System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPopupMenu popupMenu1 = new JPopupMenu();
		addPopup(contentPane, popupMenu1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), null));
		panel.setBackground(new Color(110, 127, 115));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBounds(6, 6, 440, 37);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("ABC Bank");
		lblNewJgoodiesTitle.setForeground(new Color(29, 33, 30));
		lblNewJgoodiesTitle.setFont(new Font("Arial", Font.BOLD, 13));
		lblNewJgoodiesTitle.setBounds(194, 6, 79, 25);
		panel.add(lblNewJgoodiesTitle);
		
		accName = new JTextField();
		accName.setBounds(233, 115, 130, 26);
		contentPane.add(accName);
		accName.setColumns(10);
		
		JLabel accNameLabel = DefaultComponentFactory.getInstance().createLabel("Enter account no:");
		accNameLabel.setBounds(76, 120, 120, 16);
		contentPane.add(accNameLabel);
		
		JButton accNameButton = new JButton("Next");
		accNameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MethodsForGUI x= new MethodsForGUI();
				
				x.readFile();
				
				int z= x.getIndxOfAccount(Integer.parseInt(accName.getText()));
				x.Transfer(z,22,500);
				
				
			}
		});
		accNameButton.setBounds(165, 208, 117, 29);
		contentPane.add(accNameButton);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
