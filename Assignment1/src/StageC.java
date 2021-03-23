import java.util.Arrays;
import java.util.Scanner;

public class StageC {

	private String choice;
	private Scanner sc = new Scanner(System.in);
	private String destination;
	private int seatRows;
	private int purchasedSeats = 0;
	private int purchasedStandard = 0;
	private int purchasedPensioner = 0;
	private int purchasedFrequent = 0;
	private double totalBalance;
	double grandTotal;
	int value = 0;
	Coach coach = new Coach();

	// Stage C Constructor - instantiates the StageC class and calls menu methods:
	public StageC() {
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

	// Main menu method:
	public void mainMenu() {
		System.out.println("Enter the bracketed letter to make a selection: ");
		System.out.println("[B]ook a seat");
		System.out.println("[R]efund a seat");
		System.out.println("[D]isplay available seats");
		System.out.println("[S]tatistics");
		System.out.println("E[X]it");

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
			if (numSeats + coach.getPurchasedSeats() > coach.getTotalSeats()) {
				System.out.println("Not enough seats available.");
				System.out.println("Re-enter # of seats to book: ");
				numSeats = Integer.parseInt(sc.nextLine());
			}
			if (numSeats + coach.getPurchasedSeats() < coach.getTotalSeats()) {
				available = true;
			}
		}
		for (int i = 0; i < numSeats; i++) {
			ticketMenu();
			getUserInput();
			switch (choice.toUpperCase()) {
			case "S":
				// Standard Ticket
				// setter for purchased seats needed
				purchasedSeats++; // make getter/setter
				// setter for purchased pensioner here
				purchasedStandard++; // make getter/setter
				totalBalance += coach.getStandard();
				System.out.println("S chosen. Please enter a seat number: ");
				System.out.println(" ------ ");
				int seatNumber = Integer.parseInt(sc.nextLine());
				while (seatNumber > (coach.getTotalSeats())) {
					System.out.println("Seat # does not exist. Please pick between 1 - " + coach.getTotalSeats());
					System.out.println("Please enter a seat number: ");
					seatNumber = Integer.parseInt(sc.nextLine());
				}

				coach.setSeat(seatNumber, 'S');

				System.out.println("Standard ticket purchased for seat number " + seatNumber);
				System.out.println();
				break;
			case "P":
				// Pensioner ticket
				// setter for purchased seats needed
				purchasedSeats++; // make getter/setter
				// setter for purchased pensioner here
				purchasedPensioner++; // make getter/setter
				totalBalance += coach.getPensioner();
				System.out.println("P chosen. Please enter a seat number: ");
				System.out.println(" ------ ");
				seatNumber = Integer.parseInt(sc.nextLine());
				while (seatNumber > (coach.getTotalSeats())) {
					System.out.println("Seat # does not exist. Please pick between 1 - " + coach.getTotalSeats());
					System.out.println("Please enter a seat number: ");
					seatNumber = Integer.parseInt(sc.nextLine());
				}

				coach.setSeat(seatNumber, 'P');

				System.out.println("Pensioner ticket purchased for seat number " + seatNumber);
				System.out.println();
				break;
			case "F":
				// Frequent Ticket
				// setter for purchased seats needed
				purchasedSeats++; // make getter/setter
				// setter for purchased pensioner here
				purchasedFrequent++; // make getter/setter
				totalBalance += coach.getFrequent();
				System.out.println("F chosen. Please enter a seat number: ");
				System.out.println(" ------ ");
				seatNumber = Integer.parseInt(sc.nextLine());
				while (seatNumber > (coach.getTotalSeats())) {
					System.out.println("Seat # does not exist. Please pick between 1 - " + coach.getTotalSeats());
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
		System.out.println("Total seats purchased: " + coach.getPurchasedSeats());
		System.out.println(" ------ ");
		displayReceipt();
		mainMenu();
	}

	public void ticketMenu() {
		System.out.println();
		System.out.println("Seats available: " + (coach.getTotalSeats() - coach.getPurchasedSeats()));
		System.out.printf("%-20s $%-5.2f x %-2d\n", "S. Standard seat", coach.getStandard(), purchasedStandard); // getter
		System.out.printf("%-20s $%-5.2f x %-2d\n", "P. Pensioner seat", coach.getPensioner(), purchasedPensioner); // make
																													// getter
		System.out.printf("%-20s $%-5.2f x %-2d\n", "F. Frequent seat", coach.getFrequent(), purchasedFrequent); // make
																													// getter
		System.out.println("Please enter a seat type - S, P or F: ");
	}
	
	// Premade method for scanner input:
	public String getUserInput() {
		Scanner in = new Scanner(System.in);
		choice = in.nextLine();
		return choice;
	}

	public void printTripDetails() {
		System.out.println();
		System.out.printf("+--------------Coach to %s-------------+\n", destination);
		System.out.printf("%-10s%d\n", "Total seats: ", coach.getTotalSeats());
		System.out.printf("%-10s$%.2f\n", "Standard Ticket: ", coach.getStandard());
		System.out.printf("%-10s$%.2f\n", "Pensioner: ", coach.getPensioner());
		System.out.printf("%-10s$%.2f\n", "Frequent: ", coach.getFrequent());
		System.out.println();
	}

	public void displayReceipt() {
		double totalStandard = ((double) purchasedStandard * coach.getStandard()); // make getter/setter
		double totalPensioner = ((double) purchasedPensioner * coach.getPensioner());// make getter/setter
		double totalFrequent = ((double) purchasedFrequent * coach.getFrequent());// make getter/setter
		grandTotal = totalPensioner + totalFrequent + totalStandard;
		System.out.println("Receipt");
		System.out.println("*******");
		System.out.printf("Destination: %s\n", destination);
		System.out.println("Number of seats booked: " + coach.getPurchasedSeats());
		System.out.println("\t\t------ ");
		System.out.printf("%-5d %-12s @ $%6.2f = %s%6.2f \n", purchasedStandard, "* Standard", coach.getStandard(), "$",
				(double) purchasedStandard * coach.getStandard());
		System.out.printf("%-5d %-12s @ $%6.2f = %s%6.2f \n", purchasedPensioner, "* Pensioner", coach.getPensioner(),
				"$", (double) purchasedPensioner * coach.getPensioner());
		System.out.printf("%-5d %-12s @ $%6.2f = %s%6.2f \n", purchasedFrequent, "* Frequent", coach.getFrequent(), "$",
				(double) purchasedFrequent * coach.getFrequent());
		System.out.println("\t\t------ ");
		System.out.printf("\t\t\tTotal: $ %-5.2f\n", grandTotal);
	}

	public void displayReport() {
		System.out.println();
		System.out.println("Seats available: " + (coach.getTotalSeats() - coach.getPurchasedSeats()));
		System.out.printf("Number of sales: %-5d\n", coach.getPurchasedSeats());
		System.out.println(
				"Percent % of seats sold: " + ((double) (coach.getPurchasedSeats() * 100) / coach.getAllSeats()));
		System.out.printf("Average price: $%-5.2f\n", ((double) grandTotal / coach.getPurchasedSeats()));
		System.out.println();
		mainMenu();
	}

	public void displaySeats(char[] array) {
		System.out.println();
		System.out.println("Seat allocation: ");
		int n = 4;
		for (int i = 0; i < coach.getSeats().length; i++) {
			if ((i % n) == 0)
				System.out.println();
			System.out.printf("%2d %-2s", (i + 1), coach.getSeats()[i]);
		}
		System.out.println();
		System.out.println();
		mainMenu();
	}

	// Whole refund menu probably needs to be pushed to Coach class, with price
	// totals
	public void refundMenu() {
		System.out.println();
		System.out.println("Please enter seat number to refund: ");
		displaySeats(coach.getSeats());
		getUserInput();
		int seatNum = Integer.parseInt(sc.nextLine());
		coach.refundSeat(seatNum);
		switch (choice.toUpperCase()) {
		case "S":
			// Standard Ticket
			System.out.println(" ------ ");
			if ((totalBalance >= coach.getStandard()) && (coach.getPurchasedStandard() > 0)) {
				System.out.println("Standard ticket refunded.");
				System.out.println();
				purchasedSeats--;
				purchasedStandard--;
				coach.setPurchasedSeats() - 1;
				coach.setPurchasedStandard() - 1; //make getter/setter
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
				purchasedPensioner--; //make getter/setter
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
				purchasedFrequent--; //make getter/setter
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
		System.out.println("Total seats remaining: " + (coach.getTotalSeats() - coach.getPurchasedSeats()));
		System.out.println(" ------ ");
		displayReceipt();
		mainMenu();
	}

	public static void main(String[] args) {
		StageC app = new StageC();
	}
}
