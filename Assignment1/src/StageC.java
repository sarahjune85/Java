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
	private String printStandard = " ";
	private String printPensioner = " ";
	private String printFrequent = " ";
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
				mainMenu();
				break;
			case "D":
				displaySeats(coach.getSeats());
				mainMenu();
				break;
			case "S":
				displayReport();
				mainMenu();
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
				purchasedSeats++;
				purchasedStandard++;
				coach.setPurchasedSeats(purchasedSeats);
				coach.setPurchasedStandard(purchasedStandard);
				totalBalance += coach.getStandard();
				System.out.println("S chosen. Please enter a seat number between 1 & " + coach.getSeats().length);
				System.out.println(" ------ ");
				int seatNumber = Integer.parseInt(sc.nextLine());
				while (seatNumber > (coach.getTotalSeats())) {
					System.out.println("Seat # does not exist. Please pick between 1 - " + coach.getTotalSeats());
					System.out.println("Please enter a seat number: ");
					seatNumber = Integer.parseInt(sc.nextLine());
				}
				
//				int[] standardSeatArray = new int[coach.getSeats().length];
//				standardSeatArray[]
//				

//				String msg = " ";
//				printStandard += msg + seatNumber;
				
				setSeat(seatNumber, 'S');
				System.out.println("Standard ticket purchased for seat number " + seatNumber);
				System.out.println();
				break;
			case "P":
				// Pensioner ticket
				purchasedSeats++;
				purchasedPensioner++;
				coach.setPurchasedSeats(purchasedSeats);
				coach.setPurchasedPensioner(purchasedPensioner);
				totalBalance += coach.getPensioner();
				System.out.println("P chosen. Please enter a seat number between 1 & " + coach.getSeats().length);
				System.out.println(" ------ ");
				seatNumber = Integer.parseInt(sc.nextLine());
				while (seatNumber > (coach.getTotalSeats())) {
					System.out.println("Seat # does not exist. Please pick between 1 - " + coach.getTotalSeats());
					System.out.println("Please enter a seat number: ");
					seatNumber = Integer.parseInt(sc.nextLine());
				}

				String msg2 = " ";
				printPensioner += msg2 + seatNumber;
				setSeat(seatNumber, 'P');
				System.out.println("Pensioner ticket purchased for seat number " + seatNumber);
				System.out.println();
				break;
			case "F":
				// Frequent Ticket
				purchasedSeats++;
				purchasedFrequent++;
				coach.setPurchasedSeats(purchasedSeats);
				coach.setPurchasedFrequent(purchasedFrequent);
				totalBalance += coach.getFrequent();
				System.out.println("F chosen. Please enter a seat number between 1 & " + coach.getSeats().length);
				System.out.println(" ------ ");
				seatNumber = Integer.parseInt(sc.nextLine());
				while (seatNumber > (coach.getTotalSeats())) {
					System.out.println("Seat # does not exist. Please pick between 1 - " + coach.getTotalSeats());
					System.out.println("Please enter a seat number: ");
					seatNumber = Integer.parseInt(sc.nextLine());
				}

				String msg3 = " ";
				printFrequent += msg3 + seatNumber;
				setSeat(seatNumber, 'F');
				System.out.println("Frequent ticket purchased for seat number " + seatNumber);
				System.out.println();
				break;
			default:
				System.out.println("Invalid input, try again.");
				break;

			}
			if (i == numSeats)
				break;
			// displayReceipt();
		}
		System.out.println("Total seats purchased: " + coach.getPurchasedSeats());
		System.out.println(" ------ ");
		displayReceipt();
		mainMenu();
	}

	public void refundMenu() {
		System.out.println();
		System.out.println("Please enter seat number to refund: ");
		displaySeats(coach.getSeats());
		int seatNum = Integer.parseInt(sc.nextLine());
		switch (coach.getSeats()[seatNum - 1]) {
		// Standard ticket
		case 'S':
			if ((coach.getSeats()[seatNum - 1] == 'S') && (coach.getPurchasedStandard() >= 1)) {
				coach.refundSeat(seatNum);
				System.out.println("Standard ticket refunded. ");
				purchasedSeats--;
				purchasedStandard--;
				coach.setPurchasedSeats(purchasedSeats);
				coach.setPurchasedStandard(purchasedStandard);
				totalBalance -= coach.getStandard();
			} else {
				System.out.println("Insufficient standard seats bought.");
			}
			System.out.println(" ------ ");
			break;

		// Pensioner ticket
		case 'P':
			if ((coach.getSeats()[seatNum - 1] == 'P') && (coach.getPurchasedPensioner() >= 1)) {
				coach.refundSeat(seatNum);
				System.out.println("Pensioner ticket refunded. ");
				purchasedSeats--;
				purchasedPensioner--;
				coach.setPurchasedSeats(purchasedSeats);
				coach.setPurchasedPensioner(purchasedPensioner);
				totalBalance -= coach.getPensioner();
			} else {
				System.out.println("Insufficient pensioner seats bought.");
			}
			System.out.println(" ------ ");
			break;

		// Frequent Ticket
		case 'F':
			if ((coach.getSeats()[seatNum - 1] == 'F') && (coach.getPurchasedFrequent() >= 1)) {
				coach.refundSeat(seatNum);
				System.out.println("Frequent ticket refunded. ");
				purchasedSeats--;
				purchasedFrequent--;
				coach.setPurchasedSeats(purchasedSeats);
				coach.setPurchasedFrequent(purchasedFrequent);
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

		System.out.println(" ------ ");
		System.out.println("Total seats remaining: " + (coach.getTotalSeats() - coach.getPurchasedSeats()));
		System.out.println(" ------ ");
		mainMenu();
	}

	public void ticketMenu() {
		System.out.println();
		System.out.println("Seats available: " + (coach.getTotalSeats() - coach.getPurchasedSeats()));
		System.out.printf("%-20s $%-5.2f x %-2d\n", "S. Standard seat", coach.getStandard(),
				coach.getPurchasedStandard());
		System.out.printf("%-20s $%-5.2f x %-2d\n", "P. Pensioner seat", coach.getPensioner(),
				coach.getPurchasedPensioner());
		System.out.printf("%-20s $%-5.2f x %-2d\n", "F. Frequent seat", coach.getFrequent(),
				coach.getPurchasedFrequent());
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
		double totalStandard = ((double) coach.getPurchasedStandard() * coach.getStandard());
		double totalPensioner = ((double) coach.getPurchasedPensioner() * coach.getPensioner());
		double totalFrequent = ((double) coach.getPurchasedFrequent() * coach.getFrequent());
		grandTotal = totalPensioner + totalFrequent + totalStandard;
		System.out.println("Receipt");
		System.out.println("*******");
		System.out.printf("Destination: %s\n", destination);
		System.out.println("Number of seats booked: " + coach.getPurchasedSeats());
		System.out.println("\t\t------ ");
		System.out.printf("%-5d %-12s @ $%6.2f = %s%6.2f - Seats %s\n", purchasedStandard, "* Standard",
				coach.getStandard(), "$", (double) purchasedStandard * coach.getStandard(), printStandard);
		System.out.printf("%-5d %-12s @ $%6.2f = %s%6.2f - Seats %s\n", purchasedPensioner, "* Pensioner",
				coach.getPensioner(), "$", (double) purchasedPensioner * coach.getPensioner(), printPensioner);
		System.out.printf("%-5d %-12s @ $%6.2f = %s%6.2f - Seats %s\n", purchasedFrequent, "* Frequent",
				coach.getFrequent(), "$", (double) purchasedFrequent * coach.getFrequent(), printFrequent);
		System.out.println("\t\t------ ");
		System.out.printf("\t\t\tTotal: $%-5.2f\n", grandTotal);
	}

	public void displayReport() {
		System.out.println();
		System.out.printf("%-18s %6d\n", "Seats available:", (coach.getTotalSeats() - coach.getPurchasedSeats()));
		System.out.printf("%-18s %6d\n", "Number of sales:", coach.getPurchasedSeats());
		System.out.printf("%-18s %5.0f%s\n", "Percentage sold:",
				((double) (coach.getPurchasedSeats() * 100) / coach.getTotalSeats()), "%");
		System.out.printf("%-18s $%5.2f\n", "Average price:", ((double) grandTotal / coach.getPurchasedSeats()));
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
			if ((coach.getSeats()[i] == 'S') || (coach.getSeats()[i] == 'P') || (coach.getSeats()[i] == 'F')) {
				System.out.printf("%2d %-2s", (i + 1), "B");
			} else {
				System.out.printf("%2d %-2s", (i + 1), coach.getSeats()[i]);
			}
		}
		System.out.println();
		System.out.println();
	}

	public void setSeat(int data, char value) {
		while ((coach.getSeats()[data - 1] == 'S') || (coach.getSeats()[data - 1] == 'P')
				|| (coach.getSeats()[data - 1] == 'F')) {
			System.out.println("Seat already booked - please choose another: ");
			Scanner in = new Scanner(System.in);
			data = Integer.parseInt(in.nextLine());
		}
		coach.getSeats()[data - 1] = value;
	}

	public static void main(String[] args) {
		StageC app = new StageC();
	}
}
