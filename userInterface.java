+import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.util.ArrayList; 
import java.util.Arrays; 
import java.io.*; 

public class userInterface {
	
	private JFrame frame;
	private JTextField inputfirstName;
	private JTextField inputfamilyname;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JTextField ans;
	private JLabel lblNewLabel;
	private JLabel lblFirstName;
	private JLabel lblFamilyName;
	private JLabel lblPleaseEnterYour;
	private JLabel lblMatchWithAnd;
	private JTextField inputMessage;
	private JButton continueButton;
	String[] message = new String[100000]; 
	String[] interest = new String[100000]; 
	String[] firstName = new String[100000]; 
	String[] familyName = new String[100000]; 
	
	ArrayList<String> Activities = new ArrayList<String>(); 
	int counter = 0; 
	private JButton btnBegin;
	private JLabel lblWhatDoYou;
	private JTextField activity;
			
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userInterface window = new userInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public userInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		inputfirstName = new JTextField();
		inputfirstName.setBounds(107, 56, 299, 16);
		frame.getContentPane().add(inputfirstName);
		inputfirstName.setColumns(10);
		
		inputfamilyname = new JTextField();
		inputfamilyname.setBounds(124, 84, 299, 17);
		frame.getContentPane().add(inputfamilyname);
		inputfamilyname.setColumns(10);
		
		btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent argoO) {
				//declaring 2 integer numbers: 
				int numb1, numb2, answ; 
				try {
					numb1 = Integer.parseInt(inputfirstName.getText()); 
					numb2 = Integer.parseInt(inputfamilyname.getText()); 
					
					answ = numb1 + numb2; 
					ans.setText(Integer.toString(answ)); 
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Please Enter a valid Number"); 
				}
			}
		});
		
		lblNewLabel = new JLabel("CTF Matcher Version 3.2 ");
		lblNewLabel.setBounds(6, 1, 348, 16);
		frame.getContentPane().add(lblNewLabel);
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(6, 57, 116, 16);
		frame.getContentPane().add(lblFirstName);
		
		lblFamilyName = new JLabel("Family Name:");
		lblFamilyName.setBounds(6, 85, 137, 16);
		frame.getContentPane().add(lblFamilyName);
		
		lblPleaseEnterYour = new JLabel("Please enter your message to people you might ");
		lblPleaseEnterYour.setBounds(6, 110, 310, 16);
		frame.getContentPane().add(lblPleaseEnterYour);
		
		lblMatchWithAnd = new JLabel("match with and your contact information.");
		lblMatchWithAnd.setBounds(6, 126, 299, 16);
		frame.getContentPane().add(lblMatchWithAnd);
		
		inputMessage = new JTextField();
		inputMessage.setBounds(6, 159, 400, 26);
		frame.getContentPane().add(inputMessage);
		inputMessage.setColumns(10);
		
		continueButton = new JButton("Continue");
		continueButton.addActionListener(new ActionListener() {
			final JOptionPane optionPane = new JOptionPane(
				    "Processing matches.");
			
			public void actionPerformed(ActionEvent e) {
			//loading the data-base into an array 

				
			//adding the user to the data base 
			
				String[] person = new String[5]; 
	
				person[0] = inputfirstName.getText(); 
				person[1] = inputfamilyname.getText(); 
				person[2] = inputMessage.getText(); 
				person[3] = activity.getText(); 
			try {
				FileWriter fw = new FileWriter("Community_DB", true); 
				fw.write(person[0] + "\t" + person[1] +"\t" + person[2] + "\t" + person[3] + "\n");
				
				fw.close(); 
			} catch (IOException ioe) {
				System.err.println("IO Exception:" + ioe.getMessage());
			}
			String[][] community= new String[1000000][4]; 
			try { 
				FileReader fr = new FileReader("Community_DB"); 
				BufferedReader br = new BufferedReader(fr); 
				int counter = 0; 
				String currentLine = br.readLine(); 
				while (currentLine != null) {
					currentLine = br.readLine(); 
					String[] currentPerson = currentLine.split("\t"); 
					community[0] = currentPerson; 
				}
				
			} catch (IOException er){
				System.err.println("IO Exception: " + er.getMessage()); 
			}
			}
			

		});
		
		continueButton.setBounds(135, 243, 117, 29);
		frame.getContentPane().add(continueButton);
		
		lblWhatDoYou = new JLabel("What do you want to do? (e.g.: Habs game, astronomy event, etc.)");
		lblWhatDoYou.setBounds(6, 197, 427, 16);
		frame.getContentPane().add(lblWhatDoYou);
		
		activity = new JTextField();
		activity.setBounds(16, 217, 326, 26);
		frame.getContentPane().add(activity);
		activity.setColumns(10);
		
	}
}
