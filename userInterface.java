import java.awt.EventQueue;

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
import javax.swing.SwingConstants; 

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
	private JTextField matcher;
			
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
		frame.setBounds(100, 100, 520, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		inputfirstName = new JTextField();
		inputfirstName.setBounds(107, 28, 400, 16);
		frame.getContentPane().add(inputfirstName);
		inputfirstName.setColumns(10);
		
		inputfamilyname = new JTextField();
		inputfamilyname.setBounds(107, 55, 400, 17);
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
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(6, 1, 438, 16);
		frame.getContentPane().add(lblNewLabel);
		
		lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(6, 28, 116, 16);
		frame.getContentPane().add(lblFirstName);
		
		lblFamilyName = new JLabel("Family Name:");
		lblFamilyName.setBounds(6, 56, 137, 16);
		frame.getContentPane().add(lblFamilyName);
		
		lblPleaseEnterYour = new JLabel("Please enter your message to people you might ");
		lblPleaseEnterYour.setBounds(6, 84, 310, 16);
		frame.getContentPane().add(lblPleaseEnterYour);
		
		lblMatchWithAnd = new JLabel("match with and your contact information.");
		lblMatchWithAnd.setBounds(6, 98, 299, 16);
		frame.getContentPane().add(lblMatchWithAnd);
		
		inputMessage = new JTextField();
		inputMessage.setBounds(6, 116, 496, 26);
		frame.getContentPane().add(inputMessage);
		inputMessage.setColumns(10);
		
		continueButton = new JButton("MATCH");
		continueButton.addActionListener(new ActionListener() {
		
			
			public void actionPerformed(ActionEvent e) {
			//loading the data-base into an array 
			//matcher.setText("Processing matches...");
				
			//adding the user to the data base 
			
				String[] person = new String[5]; 
	
				person[0] = inputfirstName.getText(); 
				person[1] = inputfamilyname.getText(); 
				person[2] = inputMessage.getText(); 
				person[3] = activity.getText(); 
			
			
			//loading the community to the array 
			String[][] community= new String[1000][4]; 
			try { 
				FileReader fr = new FileReader("Community_DB"); 
				BufferedReader br = new BufferedReader(fr); 
				int counter = 0; 
				String currentLine = br.readLine(); 
				System.out.println(currentLine); 
				while (currentLine != null) {
					String[] currentPerson = currentLine.split("\t"); 
					community[counter] = currentPerson;
					currentLine = br.readLine(); 
					counter++; 
				}
				
			} catch (IOException er){
				System.err.println("IO Exception: " + er.getMessage()); 
			}
			
			int count = 0; 
			System.out.println(community.length);
			System.out.println(Arrays.deepToString(community));
			int[] matchedIndices = new int[100]; 
			int arrayIndex = 0; 
			for (int i =0; i < community.length; i++) {
				String currentString = person[3];
				String communityString = community[i][3]; 
				//System.out.println(currentString.equalsIgnoreCase(communityString));
				//System.out.println("Counter number: " + i);
				//System.out.println(i + "th person:" + currentString + " " + communityString);
				if (person[3].equalsIgnoreCase(community[i][3])) {
					count++; 
					matchedIndices[arrayIndex] =  i; 
					arrayIndex++; 
				}
			}
			//System.out.println("matches at:" + Arrays.toString(matchedIndices));
			if (count == 0) {
				matcher.setText("Sorry, no matches ):");  
			} else  {
				String textDialogue = "Congratulations, you got matched."; 
				matcher.setText("Congratulations, you got matched.");
				for (int i =0; i <100; i++) {
					int currentIndex = matchedIndices[i]; 
					//System.out.println("Current match index: " + currentIndex);
					String name = community[currentIndex][0] + " " + community[currentIndex][1]; 
					//System.out.println(name);
					String message = community[currentIndex][2]; 
					//System.out.println(message);
					textDialogue = textDialogue + "\n" + 
													"Name: " + community[currentIndex][0] + " " + community[currentIndex][1] + 
													"\n" + "Message: " + community[currentIndex][2] + "\n"; 
					
					
					
					//matcher.setText("Name: " + community[currentIndex][0] + " " + community[currentIndex][1] + "\n"
									//+ "Message: " + community[currentIndex][2] + "\n"); 
				}
				JOptionPane.showMessageDialog(null, textDialogue); 
			}
			
			try {
				FileWriter fw = new FileWriter("Community_DB", true); 
				fw.write(person[0] + "\t" + person[1] +"\t" + person[2] + "\t" + person[3] + "\n");
				
				fw.close(); 
			} catch (IOException ioe) {
				System.err.println("IO Exception:" + ioe.getMessage());
			}
			
			
			
			}
			

		});
		
		continueButton.setBounds(6, 188, 501, 29);
		frame.getContentPane().add(continueButton);
		
		lblWhatDoYou = new JLabel("What do you want to do? (e.g.: Habs game, astronomy event, etc.)");
		lblWhatDoYou.setBounds(6, 144, 427, 16);
		frame.getContentPane().add(lblWhatDoYou);
		
		activity = new JTextField();
		activity.setBounds(6, 163, 496, 26);
		frame.getContentPane().add(activity);
		activity.setColumns(10);
		
		matcher = new JTextField();
		
		matcher.setBounds(6, 220, 501, 165);
		frame.getContentPane().add(matcher);
		matcher.setColumns(10);
		
	}
}
