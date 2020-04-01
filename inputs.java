import javax.swing.*;
import java.util.Random;

public class inputs {
	
	public static String getUserHitOrStand() {
		
		String userInput = JOptionPane.showInputDialog(null, "HIT OR STAND\nTYPE 'HIT' OR 'STAND'").toUpperCase();
		String hit = "HIT";
		String stand = "STAND";
		
		while (!userInput.equals(hit) && !userInput.equals(stand)) {
			userInput = JOptionPane.showInputDialog("INVALID INPUT. TRY AGAIN: ");
		}
		
		if (userInput.equals(hit)) {
			System.out.println("|   HIT OR STAND " + "  |" + "         " + userInput + "        |");
			System.out.println("*****************************************");
		}
		
		return userInput;
		
	}
	
	public static String getCpuHitOrStand() {	
		
		Random rand = new Random();
		int indicator = rand.nextInt(2) + 1;
		String cpuInput;
		
		if (indicator == 1) {
			cpuInput = "HIT";
		} else if (indicator == 2) {
			cpuInput = "STAND";
		} else {
			cpuInput = "STAND";
		}
		
		return cpuInput;
		
	}
	
	public static String playConfirm() {
		String input = JOptionPane.showInputDialog(null, "CONFIRM YOU WANT TO PLAY\nTYPE 'YES' OR 'NO'");
		return input;
	}
	
}