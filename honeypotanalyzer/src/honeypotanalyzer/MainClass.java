package honeypotanalyzer;

import javax.swing.JOptionPane;

public class MainClass {
	public static void main(String[] args) {
		
		String sPassword="rosie";
		String sSecret="rosie";
		
		while (!sPassword.equals(sSecret))
		{
			sPassword = JOptionPane.showInputDialog("Enter your password", "Password");
		}
		
		MainFrame gd = new MainFrame(740, 480);
		gd.setUpGUI();
		gd.setUpButtonListeners();
		
	}
}