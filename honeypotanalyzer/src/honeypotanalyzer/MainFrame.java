package honeypotanalyzer;

//Below I am creating the pop out window of the application
//Import the package for JFrame and WindowConstants
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame{
	
	private JFrame frame;
	private JTextField input;
	private JTextArea textArea;
	private int width;
	private int height;
	private JPanel resultsPanel;
	private JPanel buttonPanel;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private Cursor waitCursor;
	private Cursor defaultCursor;
	
	public MainFrame (int w, int h) {
		frame = new JFrame("Rosie's Honeypot Analyser");
		
		// Create a black line border
		Border border = BorderFactory.createLineBorder(Color.black);
		
		// Create two JPanels: one for buttons, one for results
		buttonPanel = new JPanel();
		resultsPanel = new JPanel();
		
		// Set the border of the two panels to be black line (so I can see where they are!!!).
		buttonPanel.setBorder(border);
		resultsPanel.setBorder(border);
		
		// this is the results text area
		textArea = new JTextArea("Hello");

		// Store width and height of the main window
		width = w;
		height = h;
		
		// Create and add buttons to the button panel
		button1 = new JButton("Top ten IP addresses");
		button2 = new JButton("24 hours analysis");
		button3 = new JButton("Attack Summary fail/success");
		button4 = new JButton("Monthly Attack Summary");
		
		// Set buttonPanel layout to be a 2*2 grid layout
		buttonPanel.setLayout(new GridLayout(2,2));
		
		// Add buttons to buttonPanel
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		buttonPanel.add(button4);
		
		// Add textArea to the resultsPanel
		resultsPanel.add(textArea);
		
		// Create a busy and a normal cursor
		waitCursor = new Cursor(Cursor.WAIT_CURSOR);
		defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
	}
	
	//creating main method - adding components and setting the layout
	public void setUpGUI() {
		Container cp = frame.getContentPane();
		BorderLayout flow = new BorderLayout();
		cp.setLayout(flow);
		frame.setSize(width, height);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		cp.add(buttonPanel, BorderLayout.NORTH);
		cp.add(resultsPanel, BorderLayout.CENTER);

		frame.setVisible(true);
	}
	

	
	// Add the event listener in a separate class as it doesn't need too many fields or methods
	public void setUpButtonListeners() {
		ActionListener buttonListener = new ActionListener() {
			//`@Override
			public void actionPerformed(ActionEvent ae) {
				Object o = ae.getSource();
				
				String sScriptToRun="";
				
				// Show top 10 IP addresses
				if(o == button1) {
					sScriptToRun="Top10IP.sh";
				} 
				else if(o == button2) {
					sScriptToRun="24Hour.sh";
				} 
				else if(o == button3) {
					sScriptToRun="AttackSummary.sh";
				} 
				else if(o == button4) {
					sScriptToRun="MonthByMonth.sh";
				}
				
				// Set the cursor to the busy cursor
				frame.setCursor(waitCursor);
				    
				String sOutput="";
				textArea.setText("This may take some time, please be patient");
					
				// have to get the text area to update itself?? How
				try {
						Process proc = Runtime.getRuntime().exec("/home/ruby/hpot/"+sScriptToRun);
						BufferedReader read = new BufferedReader(new InputStreamReader(proc.getInputStream()));
							
						try {
							proc.waitFor();
						}
						catch(InterruptedException e) {
							System.out.println(e.getMessage());
						}
						while (read.ready()) {
							sOutput+=read.readLine() + "\n";
							textArea.setText(sOutput);
						}
				} catch(IOException e) {
						System.out.println(e.getMessage());
				}
				textArea.setText(sOutput);
				//System.out.println(sOutput);
					
				// Set the cursor back to the default cursor
				frame.setCursor(defaultCursor);
				
			}
		};
		
		button1.addActionListener(buttonListener);
		button2.addActionListener(buttonListener);
		button3.addActionListener(buttonListener);
		button4.addActionListener(buttonListener);
	}
	

}