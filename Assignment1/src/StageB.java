import java.util.Arrays;
import java.util.Scanner;

public class StageB {

	private String choice;
	private Scanner sc = new Scanner(System.in);
	private String destination;
	private int seatRows;
	// private int totalSeats;
	private int purchasedSeats = 0;
	private int purchasedStandard = 0;
	private int purchasedPensioner = 0;
	private int purchasedFrequent = 0;
	private double totalBalance;
	double grandTotal;
	int value = 0;
	Coach coach = new Coach();

	public StageB() {
		System.out.println("+-----------------------------------------+");
		System.out.println("+---------- DCA Bookings System ----------+");
		System.out.println("+-----------------------------------------+");

		System.out.print("Enter destination: ");
		coach.setDestination(destination = sc.nextLine());

		System.out.print("Enter # of rows of seats: ");
		coach.setTotalSeats(seatRows = Integer.parseInt(sc.nextLine()));

		System.out.println();
		System.out.print("Enter the price of a standard seat: ");
		coach.setStandard(Double.parseDouble(sc.nextLine()));

		System.out.print("Enter the price of a pensioner seat: ");
		coach.setPensioner(Double.parseDouble(sc.nextLine()));

		System.out.print("Enter the price of a frequent traveller seat: ");
		coach.setFrequent(Double.parseDouble(sc.nextLine()));

		coach.fillSeats();
		displaySeats(coach.getSeats());
		printTripDetails();
		mainMenu();
	}

	public void mainMenu() {
		System.out.println("Enter the bracketed letter to make a selection: ");
		System.out.println("[B]ook a seat");
		System.out.println("[R]efund a seat");
		System.out.println("[D]isplay available seats");
		System.out.println("[S]tatistics");
		System.out.println("E[X]it");
		menu();
	}

	public void menu() {
		do {
			getUserInput();
			switch (choice.toUpperCase()) {
			case "B":
				buyTickets();
				break;
			case "R":
				refundMenu();
				break;
			case "D":
				displaySeats(coach.getSeats());
				break;
			case "S":
				displayReport();
				break;
			case "X":
				System.out.println("Farewell. Happy travelling!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input, try again.");
				break;
			}
		} while (!choice.isEmpty());
	}

	public void buyTickets() {
		System.out.println("Enter # of seats to book: ");
		int numSeats = Integer.parseInt(sc.nextLine());
		boolean available = false;
		while (available == false) {
			if (numSeats + purchasedSeats > coach.getAllSeats()) {
				System.out.println("Not enough seats available.");
				System.out.println("Re-enter # of seats to book: ");
				numSeats = Integer.parseInt(sc.nextLine());
			}
			if (numSeats + purchasedSeats < coach.getAllSeats()) {
				available = true;
			}
		}
		for (int i = 0; i < numSeats; i++) {
			ticketMenu();
			getUserInput();
			switch (choice.toUpperCase()) {
			case "S":
				// Standard Ticket				
				purchasedSeats++;
				purchasedStandard++;
				totalBalance += coach.getStandard();
				System.out.println("S chosen. Please enter a seat number: ");
				System.out.println(" ------ ");
				int seatNumber = Integer.parseInt(sc.nextLine());
				while (seatNumber > (coach.getAllSeats())) {
					System.out.println("Seat # does not exist. Please pick between 1 - " + coach.getAllSeats());
					System.out.println("Please enter a seat number: ");
					seatNumber = Integer.parseInt(sc.nextLine());
				}

				coach.setSeat(seatNumber, 'S');

				System.out.println("Standard ticket purchased for seat number " + seatNumber);
				System.out.println();
				break;
			case "P":
				// Pensioner ticket				
				purchasedSeats++;
				purchasedPensioner++;
				totalBalance += coach.getPensioner();
				System.out.println("P chosen. Please enter a seat number: ");
				System.out.println(" ------ ");
				seatNumber = Integer.parseInt(sc.nextLine());
				while (seatNumber > (coach.getAllSeats())) {
					System.out.println("Seat # does not exist. Please pick between 1 - " + coach.getAllSeats());
					System.out.println("Please enter a seat number: ");
					seatNumber = Integer.parseInt(sc.nextLine());
				}
				
				coach.setSeat(seatNumber, 'P');

				System.out.println("Pensioner ticket purchased for seat number " + seatNumber);
				System.out.println();
				break;
			case "F":
				// Frequent Ticket
				
				purchasedSeats++;
				purchasedFrequent++;
				totalBalance += coach.getFrequent();
				System.out.println("F chosen. Please enter a seat number: ");
				System.out.println(" ------ ");
				seatNumber = Integer.parseInt(sc.nextLine());
				while (seatNumber > (coach.getAllSeats())) {
					System.out.println("Seat # does not exist. Please pick between 1 - " + coach.getAllSeats());
					System.out.println("Please enter a seat number: ");
					seatNumber = Integer.parseInt(sc.nextLine());
				}
				
				coach.setSeat(seatNumber, 'F');

				System.out.println("Frequent ticket purchased for seat number " + seatNumber);
				System.out.println();
				break;
			default:
				System.out.println("Invalid input, try again.");
				break;

			}
			if (i == numSeats)
				break;
			displayReceipt();
		}
		System.out.println("Total seats purchased: " + purchasedSeats);
		System.out.println(" ------ ");
		displayReceipt();
		mainMenu();
	}

	public void ticketMenu() {
		System.out.println();
		System.out.println("Seats available: " + (coach.getAllSeats() - purchasedSeats));
		System.out.printf("%-20s $%-5.2f x %-2d\n", "S. Standard seat", coach.getStandard(), purchasedStandard);
		System.out.printf("%-20s $%-5.2f x %-2d\n", "P. Pensioner seat", coach.getPensioner(), purchasedPensioner);
		System.out.printf("%-20s $%-5.2f x %-2d\n", "F. Frequent seat", coach.getFrequent(), purchasedFrequent);
		System.out.println("Please enter a seat type - S, P or F: ");
	}

	public String getUserInput() {
		Scanner in = new Scanner(System.in);
		choice = in.nextLine();
		return choice;
	}

	public void printTripDetails() {
		System.out.println();
		System.out.printf("+--------------Coach to %s-------------+\n", destination);
		System.out.printf("%-10s%d\n", "Total seats: ", coach.getAllSeats());
		System.out.printf("%-10s$%.2f\n", "Standard Ticket: ", coach.getStandard());
		System.out.printf("%-10s$%.2f\n", "Pensioner: ", coach.getPensioner());
		System.out.printf("%-10s$%.2f\n", "Frequent: ", coach.getFrequent());
		System.out.println();
	}

	public void displayReceipt() {
		double totalStandard = ((double) purchasedStandard * coach.getStandard());
		double totalPensioner = ((double) purchasedPensioner * coach.getPensioner());
		double totalFrequent = ((double) purchasedFrequent * coach.getFrequent());
		grandTotal = totalPensioner + totalFrequent + totalStandard;
		System.out.println("Receipt");
		System.out.println("*******");
		System.out.printf("Destination: %s\n", destination);
		System.out.println("Number of seats booked: " + purchasedSeats);
		System.out.println("\t\t------ ");
		System.out.printf("%-5d %-12s @ $%6.2f = %s%6.2f \n", purchasedStandard, "* Standard", coach.getStandard(), "$",
				(double) purchasedStandard * coach.getStandard());
		System.out.printf("%-5d %-12s @ $%6.2f = %s%6.2f \n", purchasedPensioner, "* Pensioner", coach.getPensioner(),
				"$", (double) purchasedPensioner * coach.getPensioner());
		System.out.printf("%-5d %-12s @ $%6.2f = %s%6.2f \n", purchasedFrequent, "* Frequent", coach.getFrequent(), "$",
				(double) purchasedFrequent * coach.getFrequent());
		System.out.println("\t\t------ ");
		System.out.printf("\t\t\tTotal: $%-5.2f\n", grandTotal);
	}

	public void displayReport() {
		System.out.println();
		System.out.println("Seats available: " + (coach.getAllSeats() - purchasedSeats));
		System.out.printf("Number of sales: %-5d\n", purchasedSeats);
		System.out.println("Percent % of seats sold: " + ((double) (purchasedSeats * 100) / coach.getAllSeats()));
		System.out.printf("Average price: $%-5.2f\n", ((double) grandTotal / purchasedSeats));
		System.out.printf("Total sum of seats sold: $%-5.2f\n", totalBalance);
		System.out.println();
		mainMenu();
	}

	public void displaySeats(char[] array) {
		System.out.println();
		System.out.println("Seat allocation: ");
		int n = 4; 
		System.out.println("Printing " + (n) + " x " + (n) + " board...");
		for (int i = 0; i < coach.getSeats().length; i++) {
			if ((i % n) == 0)
				System.out.println();
			System.out.printf("%2d %-2s", (i + 1), coach.getSeats()[i]);
		}
		System.out.println();
		System.out.println();
		mainMenu();
	}

	public void refundMenu() {
		System.out.println();
		System.out.println("Enter seat type to refund: ");
		ticketMenu();
		getUserInput();
		switch (choice.toUpperCase()) {
		case "S":
			// Standard Ticket
			System.out.println(" ------ ");
			if ((totalBalance >= coach.getStandard()) && (purchasedStandard > 0)) {
				System.out.println("Standard ticket refunded.");
				System.out.println();
				purchasedSeats--;
				purchasedStandard--;
				totalBalance -= coach.getStandard();
			} else {
				System.out.println("Cannot refund - insufficient standard seats bought.");
			}
			System.out.println(" ------ ");
			break;
		case "P":
			// Pensioner ticket
			if ((totalBalance >= coach.getPensioner()) && (purchasedPensioner > 0)) {
				System.out.println("Pensioner ticket refunded. ");
				purchasedSeats--;
				purchasedPensioner--;
				totalBalance -= coach.getPensioner();
			} else {
				System.out.println("Insufficient pensioner seats bought.");
			}
			System.out.println(" ------ ");
			break;
		case "F":
			// Frequent Ticket
			if ((totalBalance >= coach.getFrequent()) && (purchasedFrequent > 0)) {
				System.out.println("Frequent ticket refunded. ");
				purchasedSeats--;
				purchasedFrequent--;
				totalBalance -= coach.getFrequent();
			} else {
				System.out.println("Insufficient frequent traveller seats bought.");
			}
			System.out.println(" ------ ");
			break;
		default:
			System.out.println("Invalid input, try again.");
			break;

		}
		System.out.println("Total seats remaining: " + (coach.getAllSeats() - purchasedSeats));
		System.out.println(" ------ ");
		displayReceipt();
		mainMenu();
	}

	public static void main(String[] args) {
		StageB app = new StageB();
	}
}
