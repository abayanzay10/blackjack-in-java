import java.util.Random;
import javax.swing.JOptionPane;

public class calculations {
	
	public static int initialHand() {
		
		Random rand1 = new Random();
		
		int card1 = rand1.nextInt(11) + 1;
		int card2 = rand1.nextInt(11) + 1;
		
		int hand = card1 + card2;
		
		return hand;
		
	}
	
	public static int userCardDrawn() {	
		
		Random rand2 = new Random();
		int card = rand2.nextInt(11) + 1;
		
		if (card == 1) {
			int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "DRAW 1 OR 11\nTYPE 1 OR 11"));
			while (choice != 1 && choice != 11) {
				choice = Integer.parseInt(JOptionPane.showInputDialog("INVALID INPUT. TRY AGAIN"));
			}
			
			return choice;
		}
		
		return card;
		
	}
	
	public static int cpuCardDrawn() {
		
		Random rand3 = new Random();
		int card = rand3.nextInt(11) + 1;
		
		if (card == 1) {
			Random rand4 = new Random();
			int indicator = rand4.nextInt(2) + 1;
			
			if (indicator == 1) {
				card = 1;
			} else {
				card = 11;
			}
			
		}
		
		return card;
		
	}
	
}