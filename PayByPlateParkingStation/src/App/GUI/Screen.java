package App.GUI;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;




public class Screen implements ActionListener {

	String [] alphabet  = {"Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "A", "S", "D", "F", "G", "H", "J", "K", "L", "Z", "X", "C", "V", "B", "N", "M"};
	String plateNumberStored;
	String lotNumberStored;
	Font font = new Font("Arial", Font.PLAIN, 20);
	JFrame frame;
	
	JPanel panel, welcomePanel, instructionPanel, buttonPanel, imagePanel, plateNumberInstruction, lotSpaceInstructionPanel,
	processPanel, ticketInfoPanel, ticketInfoPanel1, ticketInfoPanel2, ticketInfoPanel3, ticketInfoPanel4, ticketInfoPanel5, 
	ticketInfoPanel6, ticketInfoPanel7, ticketInfoPanel8, ticketInfoPanel9, ticketInfoPanel10, ticketInfoPanel11;
	
	JLabel welcomeLabel, zoneLabel, instructionLabel1, instructionLabel2, plateNumberImage, processLabel, 
	plateNumberLabel1, plateNumberLabel2, lotSpaceInstructionLabel, processImageLabel, ticketInfoLabel1,
	ticketInfoLabel2, ticketInfoLabel3, ticketInfoLabel4, ticketInfoLabel5, ticketInfoLabel6,ticketInfoLabel9,
	ticketInfoLabel7, ticketInfoLabel8;
	
	JButton enterPlateButtonInstruction, printButton;
	JTextField enteredDisplay;
	JButton [] numberButtons = new JButton [10];
	JButton [] alphabetButtons = new JButton [26];
	JButton [] functionButtons = new JButton [2];
	JButton nextButton = new JButton();
	JButton deleteButton = new JButton();
	boolean welcome = true, enteringPlateNumber = false, lotSpace = false, printing = false;
	
	
	public Screen(int width, int height) {
		
		//framing
		frame = new JFrame("PAY STATION");
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setUndecorated(true);
		frame.getRootPane().setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setVisible(true);
		
		//panel for clock
		panel = new JPanel();
		panel.setBounds(0, 0, 500, 35);
		panel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black));
		panel.setBackground(Color.WHITE);
		//panel.setLayout(null);
		informationDisplay();
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == enterPlateButtonInstruction) {
			welcome = false;
			enteringPlateNumber = true;
			frame.getContentPane().removeAll();
			frame.repaint();
			frame.add(panel);
			informationDisplay();
			plateNumberDisplay();
		}
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numberButtons[i]) {
				enteredDisplay.setText(enteredDisplay.getText().concat(String.valueOf(i)));
			}
		}
		for(int i = 0; i < 26; i++) {
			if(e.getSource() == alphabetButtons[i]) {
				enteredDisplay.setText(enteredDisplay.getText().concat(alphabet[i]));
			}
		}
		if (e.getSource() == functionButtons[0]) {
			String text = enteredDisplay.getText();
			enteredDisplay.setText("");
			for(int i = 0; i < text.length() -1; i++) {
				enteredDisplay.setText(enteredDisplay.getText() + text.charAt(i));
			}
		}
		 if(e.getSource() == functionButtons[1]) {
			if(welcome == false && enteringPlateNumber == true && lotSpace == false && printing == false) {
				String plateNumber = enteredDisplay.getText();
				if(!plateNumber.equals("")) {
				enteringPlateNumber = false;
				lotSpace = true;
				frame.getContentPane().removeAll();
				frame.repaint();
				frame.add(panel);
				informationDisplay();
			}
				plateNumberStored = plateNumber;
		}
			else if(welcome == false && enteringPlateNumber == false && lotSpace == true && printing == false)
			{
				String lotSpaceNumber = enteredDisplay.getText();
				if(!lotSpaceNumber.equals("")) {
					lotSpace = false;
					printing = true;
					frame.getContentPane().removeAll();
					frame.repaint();
					frame.add(panel);
					lotNumberStored = lotSpaceNumber;
					informationDisplay();
				}
			}
		}
			if (e.getSource() == printButton) {
				welcome = true;
				enteringPlateNumber = false;
				lotSpace = false; 
				printing = false;
				frame.getContentPane().removeAll();
				frame.repaint();
				frame.add(panel);
				informationDisplay();
			}
	}
	public void show() {
		ClockLabel timeLabel = new ClockLabel("time");
		ClockLabel dateLabel = new ClockLabel("date");
		ClockLabel dayLabel = new ClockLabel("day");
		panel.add(dateLabel);
		panel.add(timeLabel);
		panel.add(dayLabel);

	}
	
	public boolean isWelcome() {
		return welcome;
	}
	public boolean isEnteringPlateNumber() {
		return enteringPlateNumber;
	}
	public void plateNumberDisplay (){
		enteredDisplay = new JTextField();
		enteredDisplay.setBounds(100,100,300,35);
		enteredDisplay.setEditable(false);
		enteredDisplay.setFont(font);
		enteredDisplay.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
		enteredDisplay.setHorizontalAlignment(JTextField.CENTER);
		enteredDisplay.setBackground(Color.WHITE);
		frame.add(enteredDisplay);
	}
	public void informationDisplay() {
		
		if(welcome == true && enteringPlateNumber == false && lotSpace == false && printing == false) {
			//panel welcoming
			welcomePanel = new JPanel();
			welcomePanel.setBounds(44, 35, 400, 90);
			welcomePanel.setBackground(Color.WHITE);
			
			welcomeLabel = new JLabel("Welcome to Washington");
			welcomeLabel.setFont(new Font("arial", Font.PLAIN, 35));
			welcomeLabel.setBounds(44, 35, 400, 50);
			
			zoneLabel = new JLabel("ZONE 98198");
			zoneLabel.setFont(new Font("arial", Font.BOLD, 35));
			zoneLabel.setForeground(Color.RED);
			
			//panel instructions
			
			instructionPanel = new JPanel();
			instructionPanel.setBounds(20, 125, 450, 90);
			instructionPanel.setBackground(Color.white);
			
			instructionLabel1 = new JLabel("You Need A License Plate");
			instructionLabel1.setFont(new Font("arial", Font.PLAIN, 35));
			instructionLabel2 = new JLabel("Number to Continue");
			instructionLabel2.setFont(new Font("arial", Font.PLAIN,35));
			
			//button panel

			enterPlateButtonInstruction = new JButton("Enter Your Plate Number");
			enterPlateButtonInstruction.setBounds(105, 225 , 280, 50);
			enterPlateButtonInstruction.addActionListener(this);
			enterPlateButtonInstruction.setFocusable(false);
			enterPlateButtonInstruction.setFont(new Font("arial", Font.BOLD,20 ));
			enterPlateButtonInstruction.setForeground(Color.WHITE);
			enterPlateButtonInstruction.setBackground(new Color(57, 3, 253));

			frame.add(panel);
			frame.add(instructionPanel);
			frame.add(enterPlateButtonInstruction);
			frame.add(welcomePanel);
			welcomePanel.add(welcomeLabel);
			welcomePanel.add(zoneLabel);
			instructionPanel.add(instructionLabel1); 
			instructionPanel.add(instructionLabel2);	
		}
		if(welcome == false && enteringPlateNumber == true && lotSpace == false && printing == false) {
		//panel for "enter your license plate" notice
		plateNumberInstruction = new JPanel();
		plateNumberInstruction.setBounds(100,35,300,70);
		//plateNumberInstruction.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		plateNumberInstruction.setBackground(Color.white);
		frame.add(plateNumberInstruction);
		
		//Label of "Enter Your License Plate Number"
		plateNumberLabel1 = new JLabel("Enter Your License Plate");
		plateNumberLabel1.setFont(new Font("arial", Font.BOLD, 20));
		plateNumberLabel2 = new JLabel("Number");
		plateNumberLabel2.setFont(new Font("arial", Font.BOLD,20));
		plateNumberInstruction.add(plateNumberLabel1);
		plateNumberInstruction.add(plateNumberLabel2);
		
		
		//number buttons
		for(int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFocusable(false);
			numberButtons[i].setFont(new Font("arial", Font.PLAIN, 14));
			numberButtons[i].setBackground(Color.WHITE);
		}
		
		//alphabetButtons
		alphabetButtons[0] = new JButton("Q");
		alphabetButtons[1] = new JButton("W");
		alphabetButtons[2] = new JButton("E");
		alphabetButtons[3] = new JButton("R");
		alphabetButtons[4] = new JButton("T");
		alphabetButtons[5] = new JButton("Y");
		alphabetButtons[6] = new JButton("U");
		alphabetButtons[7] = new JButton("I");
		alphabetButtons[8] = new JButton("O");
		alphabetButtons[9] = new JButton("P");
		alphabetButtons[10] = new JButton("A");
		alphabetButtons[11] = new JButton("S");
		alphabetButtons[12] = new JButton("D");
		alphabetButtons[13] = new JButton("F");
		alphabetButtons[14] = new JButton("G");
		alphabetButtons[15] = new JButton("H");
		alphabetButtons[16] = new JButton("J");
		alphabetButtons[17] = new JButton("K");
		alphabetButtons[18] = new JButton("L");
		alphabetButtons[19] = new JButton("Z");
		alphabetButtons[20] = new JButton("X");
		alphabetButtons[21] = new JButton("C");
		alphabetButtons[22] = new JButton("V");
		alphabetButtons[23] = new JButton("B");
		alphabetButtons[24] = new JButton("N");
		alphabetButtons[25] = new JButton("M");

		for(int i = 0; i < 26; i++) {
			alphabetButtons[i].addActionListener(this);
			alphabetButtons[i].setFocusable(false);
			alphabetButtons[i].setFont(new Font("arial", Font.PLAIN, 12));
			alphabetButtons[i].setBackground(Color.white);
		}
		
		//function Buttons
		functionButtons[0] = new JButton("DEL");
		functionButtons[1] = new JButton("NEXT");
		functionButtons[1].setBackground(new Color(57, 3, 253));
		functionButtons[1].setForeground(Color.WHITE);
		functionButtons[0].setBackground(Color.white);
		functionButtons[1].setFont(new Font("arial", Font.BOLD, 12));
		functionButtons[0].setFont(new Font("arial", Font.PLAIN, 12));

		for(int i = 0; i < 2; i++) {
			functionButtons[i].setFocusable(false);
			functionButtons[i].addActionListener(this);
			
		}

		//buttonPanel
		buttonPanel = new JPanel();
		buttonPanel.setBounds(10, 145, 480, 130);
		buttonPanel.setBackground(Color.white);
		frame.add(buttonPanel);
		
		//adding Button
		for(int i=0; i < 10; i++) {
			buttonPanel.add(numberButtons[i]);
		}
		for(int i = 0; i < 19; i++) {
			buttonPanel.add(alphabetButtons[i]);
		}
		buttonPanel.add(functionButtons[0]);
		for(int i = 19; i < 26; i++) {
			buttonPanel.add(alphabetButtons[i]);
		}
		buttonPanel.add(functionButtons[1]);
		}
		else if(welcome == false && enteringPlateNumber == false && lotSpace == true && printing == false) {
			lotSpaceInstructionPanel = new JPanel();
			lotSpaceInstructionPanel.setBounds(125, 40, 250, 35);
			lotSpaceInstructionPanel.setBackground(Color.WHITE);
			frame.add(lotSpaceInstructionPanel);
			
			lotSpaceInstructionLabel = new JLabel("Enter Lot Space #");
			lotSpaceInstructionLabel.setFont(new Font("arial", Font.BOLD, 25));
			lotSpaceInstructionPanel.add(lotSpaceInstructionLabel);
		
			enteredDisplay = new JTextField();
			enteredDisplay.setEditable(false);
			enteredDisplay.setBackground(Color.WHITE);
			enteredDisplay.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
			enteredDisplay.setBounds(125,80,250,35);
			enteredDisplay.setHorizontalAlignment(JTextField.CENTER);
			enteredDisplay.setFont(new Font("arial", Font.PLAIN, 25));
			frame.add(enteredDisplay);
			
			buttonPanel = new JPanel();
			buttonPanel.setBounds(150, 120, 199, 160);
			buttonPanel.setBackground(Color.WHITE);
			frame.add(buttonPanel);
			
			for(int i = 0; i < 10; i++) {
				numberButtons[i] = new JButton(String.valueOf(i));
				numberButtons[i].addActionListener(this);
				numberButtons[i].setFocusable(false);
				numberButtons[i].setBackground(Color.WHITE);
				numberButtons[i].setForeground(Color.BLACK);
				numberButtons[i].setFont(new Font("arial", Font.PLAIN, 20));
			}
			functionButtons[1].setFont(new Font("arial", Font.BOLD, 15));
			functionButtons[0].setFont(new Font("arial", Font.BOLD, 15));
			for(int i=1; i < 10; i++) {
				buttonPanel.add(numberButtons[i]);
			}
			buttonPanel.add(functionButtons[0]);
			buttonPanel.add(numberButtons[0]);
			buttonPanel.add(functionButtons[1]);

		}
		else if(welcome == false && enteringPlateNumber == false && lotSpace == false && printing == true) {
			processPanel = new JPanel();
			processPanel.setBounds(160, 40, 180, 35);
			processPanel.setBackground(Color.WHITE);
			frame.add(processPanel);
			
			processLabel = new JLabel("Ticket Receipt");
			processLabel.setFont(new Font("arial", Font.BOLD, 25));
			processPanel.add(processLabel);
			
			ticketInfoPanel = new JPanel();
			ticketInfoPanel.setBounds(100, 75, 150, 35);
			ticketInfoPanel.setBackground(Color.WHITE);
			frame.add(ticketInfoPanel);
			
			ticketInfoLabel1= new JLabel("License Plate:");
			ticketInfoLabel1.setFont(new Font("arial", Font.PLAIN, 20));
			ticketInfoPanel.add(ticketInfoLabel1);
			
			ticketInfoPanel6 = new JPanel();
			ticketInfoPanel6.setBounds(250, 75, 150, 35);
			ticketInfoPanel6.setBackground(Color.WHITE);
			frame.add(ticketInfoPanel6);
			
			ticketInfoLabel6 = new JLabel(plateNumberStored);
			ticketInfoLabel6.setHorizontalAlignment(JLabel.CENTER);
			ticketInfoLabel6.setFont(new Font("arial", Font.PLAIN, 20));
			ticketInfoPanel6.add(ticketInfoLabel6);
			
			
			ticketInfoPanel1 = new JPanel();
			ticketInfoPanel1.setBounds(100, 110, 150, 35);
			ticketInfoPanel1.setBackground(Color.WHITE);
			frame.add(ticketInfoPanel1);
			
			ticketInfoLabel2 = new JLabel("Lot #:           ");
			ticketInfoLabel2.setFont(new Font("arial", Font.PLAIN, 20));
			ticketInfoPanel1.add(ticketInfoLabel2);
			
			ticketInfoPanel7 = new JPanel();
			ticketInfoPanel7.setBounds(250, 110, 150, 35);
			ticketInfoPanel7.setBackground(Color.WHITE);
			frame.add(ticketInfoPanel7);
			
			ticketInfoLabel5 = new JLabel(lotNumberStored);
			ticketInfoLabel5.setHorizontalAlignment(JLabel.CENTER);
			ticketInfoLabel5.setFont(new Font("arial", Font.PLAIN, 20));
			ticketInfoPanel7.add(ticketInfoLabel5);
			
			ticketInfoPanel2 = new JPanel();
			ticketInfoPanel2.setBounds(100, 145, 150, 35);
			ticketInfoPanel2.setBackground(Color.WHITE);
			frame.add(ticketInfoPanel2);
			
			ticketInfoLabel3 = new JLabel("Expired:        ");
			ticketInfoLabel3.setFont(new Font("arial", Font.PLAIN, 20));
			ticketInfoPanel2.add(ticketInfoLabel3);
			
			ticketInfoPanel8 = new JPanel();
			ticketInfoPanel8.setBounds(250, 145, 150, 35);
			ticketInfoPanel8.setBackground(Color.WHITE);
			frame.add(ticketInfoPanel8);
			expired();
			
			
			ticketInfoLabel7 = new JLabel(expiredDate);
			ticketInfoLabel7.setHorizontalAlignment(JLabel.CENTER);
			ticketInfoLabel7.setFont(new Font("arial", Font.PLAIN, 20));
			ticketInfoPanel8.add(ticketInfoLabel7);
			

			ticketInfoPanel9 = new JPanel();
			ticketInfoPanel9.setBounds(250, 180, 150, 35);
			ticketInfoPanel9.setBackground(Color.WHITE);
			frame.add(ticketInfoPanel9);
			
			ticketInfoLabel8 = new JLabel(expiredTime);
			ticketInfoLabel8.setHorizontalAlignment(JLabel.CENTER);
			ticketInfoLabel8.setFont(new Font("arial", Font.PLAIN, 20));
			ticketInfoPanel9.add(ticketInfoLabel8);
			
			ticketInfoPanel4 = new JPanel();
			ticketInfoPanel4.setBounds(100, 215, 150, 35);
			ticketInfoPanel4.setBackground(Color.WHITE);
			frame.add(ticketInfoPanel4);
			
			ticketInfoLabel4 = new JLabel("Total Cost:    ");
			ticketInfoLabel4.setFont(new Font("arial", Font.PLAIN, 20));
			ticketInfoPanel4.add(ticketInfoLabel4);

			
			ticketInfoPanel10 = new JPanel();
			ticketInfoPanel10.setBounds(250, 215, 150, 35);
			ticketInfoPanel10.setBackground(Color.WHITE);
			frame.add(ticketInfoPanel10);
			
			ticketInfoLabel9 = new JLabel("$0.00");
			ticketInfoLabel9.setHorizontalAlignment(JLabel.CENTER);
			ticketInfoLabel9.setFont(new Font("arial", Font.PLAIN, 20));
			ticketInfoPanel10.add(ticketInfoLabel9);
			
			printButton = new JButton("PRINT");
			printButton.setBounds(410, 250, 80, 30);
			printButton.setFont(new Font("arial", Font.BOLD,15 ));
			printButton.setForeground(Color.WHITE);
			printButton.setBackground(new Color(57, 3, 253));
			printButton.setFocusable(false);
			printButton.addActionListener(this);
			frame.add(printButton);
			
		}
	}
	String expiredDate, expiredTime;
	public void expired() {
	Calendar calendar = Calendar.getInstance(); // Returns instance of current date and time set
	SimpleDateFormat dateExpire = new SimpleDateFormat("dd-MM-yyyy");
	expiredDate = dateExpire.format(calendar.getTime()).toString();
	
	calendar.add(Calendar.HOUR_OF_DAY, +2);
	SimpleDateFormat timeExpire = new SimpleDateFormat("HH:mm");

	expiredTime = timeExpire.format(calendar.getTime()).toString();
	
	
	}
}
class ClockLabel extends JLabel implements ActionListener{
	String type;
	SimpleDateFormat sdf;
	
	public ClockLabel(String type) {
		this.type = type;
		
		switch(type) {
		case "date":
			sdf = new SimpleDateFormat("MM/dd/yyyy");
			setFont(new Font("arial", Font.PLAIN, 20));
			setHorizontalAlignment(SwingConstants.LEFT);
			break;
		case "time":
			sdf= new SimpleDateFormat("        hh:mm:ss a");
			setFont(new Font("arial", Font.PLAIN, 20));
			setHorizontalAlignment(SwingConstants.CENTER);
			break;
		case "day":
			sdf = new SimpleDateFormat("           EEEE");
			setFont(new Font("arial", Font.PLAIN, 20));
			setHorizontalAlignment(SwingConstants.RIGHT);
			break;
		default:
			sdf = new SimpleDateFormat();
			break;
		}
		
		Timer t = new Timer(0,this);
		t.start();
	}
	@Override
	public void actionPerformed(ActionEvent ev) {
		// TODO Auto-generated method stub
		Date date = new Date();
		setText(sdf.format(date));
	}
	
}

