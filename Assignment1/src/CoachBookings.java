import java.util.Scanner;

public class CoachBookings {
	
	public Scanner sc;
	public int total;

	public void displayMenu() {
		System.out.println("Get on the bus! Bus stuff here.");
		System.out.println("P: Purchase a ticket");
		System.out.println("R: Refund a ticket");
		System.out.println("D: Display seats");
		System.out.println("X: Exit");
	}
	
	// GIT TEST COMMENT - TEST 2 - 3
	
	public void runMenu() {
		String choice;
		do {
			displayMenu();
			choice = sc.nextLine();
			switch(choice) {
			case "P":
				System.out.println("Buy a ticket");
				break;
			case "R":
				System.out.println("Want a refund?");
				break;
			case "D":
				System.out.println("Displaying seats");
				break;
			case "X":
				System.out.println("BYEEEEE");
				break;
			//default is a catch-all, is optional.	
			default:
				System.out.println("Invalid input, try again doofus.");
				
			}
		}
		while (!choice.equals("X"));
		sc.close();
	}

	public CoachBookings() {
		sc = new Scanner(System.in);
		
	}
	

	public static void main(String[] args) {
		new CoachBookings();
	}

}
