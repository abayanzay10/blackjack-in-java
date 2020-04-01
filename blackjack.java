import javax.swing.JOptionPane;

public class blackjack {
	
	public static void main(String[]args) {
		
		String yay = "YES";
		String nay = "NO";
		
		String userConfirmation = yay;
		
		while (userConfirmation.equals(yay)) {
				
		System.out.println("*****************************************");
		System.out.println("|               BLACKJACK               |");
		System.out.println("*****************************************");
		System.out.println("|    HAND TOTAL    |   CPU HAND TOTAL   |");
		System.out.println("*****************************************");
				
		int userInitialHand = calculations.initialHand();
		String userInitialHandString = String.valueOf(userInitialHand);
		int cpuInitialHand = calculations.initialHand();
		String cpuInitialHandString = String.valueOf(cpuInitialHand);
						
		if (userInitialHandString.length() == 2 && cpuInitialHandString.length() == 2) {
			System.out.println("|        " + userInitialHand + "        |" + "         " + "**" + "         |");
		} else if (userInitialHandString.length() == 1 && cpuInitialHandString.length() == 1) {
			System.out.println("|        " + userInitialHand + "         |" + "         " + "*" + "          |");
		} else if (userInitialHandString.length() == 1 && cpuInitialHandString.length() == 2) {
			System.out.println("|         " + userInitialHand + "        |" + "         " + "**" + "         |");
		} else {
			System.out.println("|        " + userInitialHand + "        |" + "           " + "*" + "         |");
		}
		
		System.out.println("*****************************************");
		
		int userHandTotal = userInitialHand;
		int cpuHandTotal = cpuInitialHand;
		
		String hit = "HIT";
		String stand = "STAND";
		
		String userHitOrStand = inputs.getUserHitOrStand();
		
		while (userHitOrStand.equals(hit)) {
			int userCardDrawn = calculations.userCardDrawn();
			userHandTotal = userHandTotal + userCardDrawn;
			String userHandTotalString = String.valueOf(userHandTotal);
			
			if (userHandTotalString.length() == 2 && cpuInitialHandString.length() == 2) {
				System.out.println("|        " + userHandTotal + "        |" + "         " + "**" + "         |");
				System.out.println("*****************************************");
			} else if (userHandTotalString.length() == 1 && cpuInitialHandString.length() == 1) {
				System.out.println("|        " + userHandTotal + "         |" + "        " + "*" + "          |");
				System.out.println("*****************************************");
			} else if (userHandTotalString.length() == 1 && cpuInitialHandString.length() == 2) {
				System.out.println("|         " + userHandTotal + "        |" + "         " + "**" + "         |");
				System.out.println("*****************************************");
			} else {
				System.out.println("|        " + userHandTotal + "        |" + "          " + "*" + "         |");
				System.out.println("*****************************************");
			}
						
			if (userHandTotal > 21) {
				userHitOrStand = "STAND";
				JOptionPane.showMessageDialog(null, "PLAYER BUST" + "\n" + "PLAYER HAND TOTAL: " + userHandTotal);
			} else if (userHandTotal <= 21) {
				userHitOrStand = inputs.getUserHitOrStand();
			}
			
		}
		
		String cpuHitOrStand = inputs.getCpuHitOrStand();
		
		while (cpuHitOrStand.equals(hit)) {
			int cpuCardDrawn = calculations.cpuCardDrawn();
			cpuHandTotal = cpuHandTotal + cpuCardDrawn;
			String cpuHandTotalString = String.valueOf(cpuHandTotal);
			cpuHitOrStand = inputs.getCpuHitOrStand();
		}
		
		if (cpuHandTotal > 21) {
			JOptionPane.showMessageDialog(null, "COMPUTER BUST" + "\n" + "COMPUTER HAND TOTAL: " + cpuHandTotal);
		}
		
		int userRemainder = 21 - userHandTotal;
		int cpuRemainder = 21 - cpuHandTotal;
		
		if (userRemainder < cpuRemainder && userRemainder >= 0) {
			JOptionPane.showMessageDialog(null, "PLAYER WINS" + "\n" + "PLAYER HAND TOTAL: " + userHandTotal + "\n" + "COMPUTER HAND TOTAL: " + cpuHandTotal);
		} else if (cpuRemainder < 0 && userRemainder < 0) {
			JOptionPane.showMessageDialog(null, "CPU AND USER BUST. NO WINNER");
		} else if (cpuRemainder < userRemainder && cpuRemainder >= 0) {
			JOptionPane.showMessageDialog(null, "COMPUTER WINS" + "\n" + "COMPUTER HAND TOTAL: " + cpuHandTotal + "\n" + "PLAYER HAND TOTAL: " + userHandTotal);
		} else if (userRemainder == cpuRemainder){
			JOptionPane.showMessageDialog(null, "DRAW" + "\n" + "PLAYER HAND TOTAL: " + userHandTotal + "\n" + "COMPUTER HAND TOTAL: " + cpuHandTotal);
		}  else if (userRemainder < 0) {
			JOptionPane.showMessageDialog(null, "COMPUTER WINS" + "\n" + "COMPUTER HAND TOTAL: " + cpuHandTotal + "\n" + "PLAYER HAND TOTAL: " + userHandTotal);
		} else if (cpuRemainder < 0) {
			JOptionPane.showMessageDialog(null, "PLAYER WINS" + "\n" + "PLAYER HAND TOTAL: " + userHandTotal + "\n" + "COMPUTER HAND TOTAL: " + cpuHandTotal);
		}
		
		userConfirmation = JOptionPane.showInputDialog(null, "PLAY AGAIN\nTYPE 'YES' OR 'NO'").toUpperCase();
		while (!userConfirmation.equals(yay) && !userConfirmation.equals(nay)) {
			userConfirmation = JOptionPane.showInputDialog(null, "INVALID INPUT. TRY AGAIN");
		}
	}
}
}