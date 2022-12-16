package honeypotanalyzer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ShellCaller {
	public static void main(String[] args) {
		String sOutput="";
		try {
			Process proc = Runtime.getRuntime().exec("/home/ruby/hpot/loop.sh");
			BufferedReader read = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			
			try {
				proc.waitFor();
			}
			catch(InterruptedException e) {
				System.out.println(e.getMessage());
			}
			while (read.ready()) {
				sOutput+=read.readLine() + "\n";
			}
	} catch(IOException e) {
			System.out.println(e.getMessage());
	}
	System.out.println(sOutput);
	}
}
	
		
		