import java.util.Scanner;

public class StageC {

	private int choice = 0;
	private Scanner sc = new Scanner(System.in);
	private String destination;
	private int seatRows;
	private int totalSeats;
	private double standard;
	private double pensioner;
	private double frequent;
	Coach coach1 = new Coach(destination, standard, pensioner, frequent);
	
	public StageC() {
		startMenu();
		coach1.setSeats(totalSeats);
		coach1.printDetails();
		selectionMenu();
	}

	public void startMenu() {
		System.out.println("+-----------------------------------------+");
		System.out.println("+---------- DCA Bookings System ----------+");
		System.out.println("+-----------------------------------------+");
		System.out.print("Enter destination: ");
		destination = sc.nextLine();
		System.out.print("Enter # of rows of seats: ");
		seatRows = Integer.parseInt(sc.nextLine());
		totalSeats = seatRows * 4;
		
		System.out.print("Enter the price of a standard seat: ");
		standard = Double.parseDouble(sc.nextLine());

		System.out.print("Enter the price of a pensioner seat: ");
		pensioner = Double.parseDouble(sc.nextLine());

		System.out.print("Enter the price of a frequent traveller seat: ");
		frequent = Double.parseDouble(sc.nextLine());		
	}

	public void selectionMenu() {
		System.out.println("Enter a number to make a selection: ");
		System.out.println("1. Buy a ticket");
		System.out.println("2. Refund a ticket");
		System.out.println("3. Display available seats");
		System.out.println("4. Exit");
		menu();
	}

	public void menu() {
		do {
			getUserInput();

			switch (choice) {
			case 1:
				ticketMenu();				
				break;
			case 2:
				//refundMenu();
				break;
			case 3:
				//displaySeats();
			case 4:
				System.out.println("Farewell. Happy travelling!");
				System.exit(0);
				break;
			default:
				break;
			}
		} while (choice != 0);
	}

	public void ticketMenu() {
		System.out.println("1. Standard ticket");
		System.out.println("2. Pensioner ticket");
		System.out.println("3. Frequent ticket");
		System.out.println("4. Back to main menu");
		getUserInput();
		switch (choice) {
		case 1:			
			//Standard Ticket
			System.out.println("# of Standard tickets to purchase: ");
			getUserInput();
			coach1.displayReceipt();
			break;
		case 2:
			//Pensioner ticket
			System.out.println("# of Pensioner tickets to purchase: ");
			getUserInput();
			break;			
		case 3:
			//Frequent Ticket
			System.out.println("# of Frequent tickets to purchase: ");
			getUserInput();
			break;
		case 4:
			System.out.println("Returning to main menu...");
			selectionMenu();
			break;
		default:
			break;
		}
	}

	private int getUserInput() throws NumberFormatException {
		Scanner in = new Scanner(System.in);
		choice = Integer.parseInt(in.nextLine());
		return choice;
	}


	public static void main(String[] args) {
		StageC app = new StageC();
	}
}
