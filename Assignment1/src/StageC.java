import java.util.Scanner;

public class StageC {
	// Object member variables, only visible to StageC methods:
	private String choice;
	private Scanner sc = new Scanner(System.in);
	private String destination;
	private int purchasedSeats = 0;
	private int purchasedStandard = 0;
	private int purchasedPensioner = 0;
	private int purchasedFrequent = 0;
	private String stanArrayToString = " ";
	private String pensArrayToString = " ";
	private String freqArrayToString = " ";
	private double grandTotal;	
	Coach coach = new Coach();

	// Stage C Constructor - instantiates the StageC class and calls menu methods:
	public StageC() {
		System.out.println("+-----------------------------------------------+");
		System.out.println("+------------- DCA Bookings System -------------+");
		System.out.println("+-----------------------------------------------+");

		System.out.print("Enter destination: ");
		coach.setDestination(destination = sc.nextLine());
		
		System.out.print("Enter # of rows of seats: ");
		coach.setTotalSeats(Integer.parseInt(sc.nextLine()));

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
		System.out.println(" ----------------------------------------------- ");
		System.out.printf("%29s\n", "Main Menu");
		System.out.println(" ----------------------------------------------- "); // Char count 49
		System.out.println(" [B] ook a seat");
		System.out.println(" [R] efund a seat");
		System.out.println(" [D] isplay available seats");
		System.out.println(" [S] tatistics");
		System.out.println(" E [X] it");
		System.out.println();
		System.out.print("Enter the bracketed letter to make a selection: ");

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
				System.out.print("Invalid input, try again: ");
				break;
			}
		} while (!choice.isEmpty());
	}

	// Buy ticket method:
	public void buyTickets() {
		System.out.println(" ----------------------------------------------- ");
		System.out.printf("%30s\n", "Book tickets");
		System.out.println(" ----------------------------------------------- ");
		// Sets number of times to cycle through buy menu:
		System.out.println("Enter # of seats to book: ");
		int numSeats = Integer.parseInt(sc.nextLine());
		// While loop with a boolean switch:
		// Checks to see if the number of seats requested is less than seats in total,
		// taking into account those already booked:
		boolean available = false;
		while (available == false) {
			if ((numSeats + coach.getPurchasedSeats()) > coach.getSeats().length) {
				System.out.println("Not enough seats available.");
				System.out.println("Re-enter # of seats to book: ");
				numSeats = Integer.parseInt(sc.nextLine());

			} else {
				available = true;
			}
		}

		for (int i = 0; i < numSeats; i++) {
			ticketMenu();
			getUserInput();
			switch (choice.toUpperCase()) {
			// Standard Ticket
			case "S":
				purchasedSeats++;
				purchasedStandard++;
				coach.setPurchasedSeats(purchasedSeats);
				coach.setPurchasedStandard(purchasedStandard);

				System.out.println("S chosen. Please enter an available seat number between 1 - " + coach.getSeats().length);

				int seatNumber = Integer.parseInt(sc.nextLine());
				while (seatNumber > (coach.getSeats().length)) {
					System.out.println("Seat # does not exist. Please pick between 1 - " + coach.getSeats().length);
					System.out.println("Please enter a seat number: ");
					seatNumber = Integer.parseInt(sc.nextLine());
				}
				setSeat(seatNumber, 'S');
				System.out.println(" ------ ");
				System.out.println("Standard ticket purchased for seat number " + seatNumber);
				System.out.println(" ------ ");
				System.out.println();
				break;
			// Pensioner ticket
			case "P":
				purchasedSeats++;
				purchasedPensioner++;
				coach.setPurchasedSeats(purchasedSeats);
				coach.setPurchasedPensioner(purchasedPensioner);

				System.out.println("P chosen. Please enter a seat number between 1 - " + coach.getSeats().length);

				seatNumber = Integer.parseInt(sc.nextLine());
				while (seatNumber > (coach.getSeats().length)) {
					System.out.println("Seat # does not exist. Please pick between 1 - " + coach.getSeats().length);
					System.out.println("Please enter a seat number: ");
					seatNumber = Integer.parseInt(sc.nextLine());
				}
				setSeat(seatNumber, 'P');
				System.out.println(" ------ ");
				System.out.println("Pensioner ticket purchased for seat number " + seatNumber);
				System.out.println(" ------ ");
				System.out.println();
				break;
			// Frequent Ticket
			case "F":
				purchasedSeats++;
				purchasedFrequent++;
				coach.setPurchasedSeats(purchasedSeats);
				coach.setPurchasedFrequent(purchasedFrequent);

				System.out.println("F chosen. Please enter a seat number between 1 - " + coach.getSeats().length);

				seatNumber = Integer.parseInt(sc.nextLine());
				while (seatNumber > (coach.getSeats().length)) {
					System.out.println("Seat # does not exist. Please pick between 1 - " + coach.getSeats().length);
					System.out.println("Please enter a seat number: ");
					seatNumber = Integer.parseInt(sc.nextLine());
				}
				setSeat(seatNumber, 'F');
				System.out.println(" ------ ");
				System.out.println("Frequent ticket purchased for seat number " + seatNumber);
				System.out.println(" ------ ");
				System.out.println();
				break;
			default:
				System.out.println("Invalid seat type, try again.");
				break;

			}
			if (i == numSeats)
				break;

		}
		displayReceipt();
		mainMenu();
	}

	// Refund menu: using seat #, checks to see what seat type is at that index.
	// Deducts seat type according to the char contained in the index's value.
	// If vacant - does not refund:
	public void refundMenu() {
		System.out.println();
		System.out.println(" ----------------------------------------------- ");
		System.out.printf("%32s\n", "Refund tickets");
		System.out.println(" ----------------------------------------------- ");
		System.out.print("Displaying seat matrix... ");
		displaySeats(coach.getSeats());
		System.out.print("Please enter seat number to refund: ");
		int seatNum = Integer.parseInt(sc.nextLine());

		switch (coach.getSeats()[seatNum - 1]) {
		// Standard ticket
		case 'S':
			if ((coach.getSeats()[seatNum - 1] == 'S') && (coach.getPurchasedStandard() >= 1)) {
				coach.refundSeat(seatNum);
				System.out.println(" ------ ");
				System.out.println("Standard ticket refunded. ");
				purchasedSeats--;
				purchasedStandard--;
				coach.setPurchasedSeats(purchasedSeats);
				coach.setPurchasedStandard(purchasedStandard);
			} else {
				System.out.println("Insufficient standard seats bought.");
			}
			System.out.println(" ------ ");
			break;

		// Pensioner ticket
		case 'P':
			if ((coach.getSeats()[seatNum - 1] == 'P') && (coach.getPurchasedPensioner() >= 1)) {
				coach.refundSeat(seatNum);
				System.out.println(" ------ ");
				System.out.println("Pensioner ticket refunded. ");
				purchasedSeats--;
				purchasedPensioner--;
				coach.setPurchasedSeats(purchasedSeats);
				coach.setPurchasedPensioner(purchasedPensioner);
			} else {
				System.out.println("Insufficient pensioner seats bought.");
			}
			System.out.println(" ------ ");
			break;

		// Frequent Ticket
		case 'F':
			if ((coach.getSeats()[seatNum - 1] == 'F') && (coach.getPurchasedFrequent() >= 1)) {
				coach.refundSeat(seatNum);
				System.out.println(" ------ ");
				System.out.println("Frequent ticket refunded. ");
				purchasedSeats--;
				purchasedFrequent--;
				coach.setPurchasedSeats(purchasedSeats);
				coach.setPurchasedFrequent(purchasedFrequent);

			} else {
				System.out.println("Insufficient frequent traveller seats bought.");
			}
			System.out.println(" ------ ");
			break;

		default:
			System.out.println("Seat not booked, try again.");
			refundMenu();
			break;
		}

		System.out.println("Total seats remaining: " + (coach.getSeats().length - coach.getPurchasedSeats()));
		System.out.println();
		mainMenu();
	}

	// Shows ticket prices, how many have been purchased and what seats they are
	// located at:
	public void ticketMenu() {
		System.out.println();

		// Cycles through seat array to collect seat numbers of Standard tickets:
		stanArrayToString = " ";
		for (int i = 0; i < coach.getSeats().length; i++) {
			if (coach.getSeats()[i] == 'S') {
				stanArrayToString += (i + 1) + ", ";
			}
		}
		// Cycles through seat array to collect seat numbers of Pensioner tickets:
		pensArrayToString = " ";
		for (int i = 0; i < coach.getSeats().length; i++) {
			if (coach.getSeats()[i] == 'P') {
				pensArrayToString += (i + 1) + ", ";
			}
		}
		// Cycles through seat array to collect seat numbers of Frequent tickets:
		freqArrayToString = " ";
		for (int i = 0; i < coach.getSeats().length; i++) {
			if (coach.getSeats()[i] == 'F') {
				freqArrayToString += (i + 1) + ", ";
			}
		}

		// Tickets purchase menu display:
		System.out.println("Seats available: " + (coach.getSeats().length - coach.getPurchasedSeats()));
		System.out.println(" ------ ");
		System.out.printf("%-20s $%-5.2f x %-2d- Seat #s: %s\n", "S. Standard seat", coach.getStandard(),
				coach.getPurchasedStandard(), stanArrayToString);
		System.out.printf("%-20s $%-5.2f x %-2d- Seat #s: %s\n", "P. Pensioner seat", coach.getPensioner(),
				coach.getPurchasedPensioner(), pensArrayToString);
		System.out.printf("%-20s $%-5.2f x %-2d- Seat #s: %s\n", "F. Frequent seat", coach.getFrequent(),
				coach.getPurchasedFrequent(), freqArrayToString);
		System.out.println(" ------ ");
		System.out.println("Please enter a seat type - S, P or F: ");
	}

	// Shortcut method for scanner input, used for switch statement menus:
	public String getUserInput() {
		Scanner in = new Scanner(System.in);
		choice = in.nextLine();
		return choice;
	}

	// Prints startup configuration of destination & ticket prices:
	public void printTripDetails() {
		System.out.println();
		System.out.println(" ----------------------------------------------- ");
		System.out.printf("%24s %s\n", "Coach to: ", destination);
		System.out.println(" ----------------------------------------------- ");
		System.out.println();
		System.out.printf("%-20s%6d\n", "Total seats: ", coach.getSeats().length);
		System.out.printf("%-20s$%5.2f\n", "Standard Ticket: ", coach.getStandard());
		System.out.printf("%-20s$%5.2f\n", "Pensioner: ", coach.getPensioner());
		System.out.printf("%-20s$%5.2f\n", "Frequent: ", coach.getFrequent());
		System.out.println();
	}

	// Receipt method: Displays receipt of total seat purchases, and the seats
	// allocated to each ticket type purchased:
	public void displayReceipt() {
		double totalStandard = ((double) coach.getPurchasedStandard() * coach.getStandard());
		double totalPensioner = ((double) coach.getPurchasedPensioner() * coach.getPensioner());
		double totalFrequent = ((double) coach.getPurchasedFrequent() * coach.getFrequent());
		grandTotal = totalPensioner + totalFrequent + totalStandard;

		// Cycles through seat array to collect seat numbers of each type of ticket,
		// then stores in string:
		stanArrayToString = " ";
		for (int i = 0; i < coach.getSeats().length; i++) {
			if (coach.getSeats()[i] == 'S') {
				stanArrayToString +=  (i + 1) + ", ";
			}
		}

		pensArrayToString = " ";
		for (int i = 0; i < coach.getSeats().length; i++) {
			if (coach.getSeats()[i] == 'P') {
				pensArrayToString += (i + 1) + ", ";
			}
		}

		freqArrayToString = " ";
		for (int i = 0; i < coach.getSeats().length; i++) {
			if (coach.getSeats()[i] == 'F') {
				freqArrayToString += (i + 1) + ", ";
			}
		}

		// Prints receipt:
		System.out.println("Receipt");
		System.out.println("*******");
		System.out.printf("Destination: %s\n", destination);
		System.out.println("Number of seats booked: " + coach.getPurchasedSeats());
		System.out.println("\t\t------ ");
		System.out.printf("%-5d %-12s @ $%6.2f = %s%6.2f %10s %s\n", purchasedStandard, "* Standard",
				coach.getStandard(), "$", (double) purchasedStandard * coach.getStandard(), "Seats", stanArrayToString);
		System.out.printf("%-5d %-12s @ $%6.2f = %s%6.2f %10s %s\n", purchasedPensioner, "* Pensioner",
				coach.getPensioner(), "$", (double) purchasedPensioner * coach.getPensioner(), "Seats",
				pensArrayToString);
		System.out.printf("%-5d %-12s @ $%6.2f = %s%6.2f %10s %s\n", purchasedFrequent, "* Frequent",
				coach.getFrequent(), "$", (double) purchasedFrequent * coach.getFrequent(), "Seats", freqArrayToString);
		System.out.println("\t\t------ ");
		System.out.printf("\t\t\tTotal: $%6.2f\n", grandTotal);
		System.out.println();
	}

	// Displays coach sales statistics:
	public void displayReport() {
		System.out.println();
		System.out.printf("%-18s %6d\n", "Seats available:", (coach.getSeats().length - coach.getPurchasedSeats()));
		System.out.printf("%-18s %6d\n", "Number of sales:", coach.getPurchasedSeats());
		System.out.printf("%-18s %5.0f%s\n", "Percentage sold:",
				((double) (coach.getPurchasedSeats() * 100) / coach.getSeats().length), "%");
		System.out.printf("%-18s $%5.2f\n", "Average price:", ((double) grandTotal / coach.getPurchasedSeats()));
		System.out.println();
		mainMenu();
	}

	// Visual representation of bus seats in rows, with seat status of B (booked) or
	// - (vacant):
	public void displaySeats(char[] array) {
		System.out.println();
		System.out.println(" ----------------------------------------------- ");
		System.out.printf("%32s\n", "Seat Allocation");
		System.out.println(" ----------------------------------------------- ");
		System.out.println(" B = Booked\n - = Vacant");
		for (int i = 0; i < coach.getSeats().length; i++) {
			if ((i % 4) == 0)
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

	// Sets a chosen index value in the Coach seats[] array to a ticket type:
	public void setSeat(int data, char value) {
		while ((coach.getSeats()[data - 1] == 'S') || (coach.getSeats()[data - 1] == 'P')
				|| (coach.getSeats()[data - 1] == 'F')) {
			System.out.println("Seat already booked - please choose another: ");
			Scanner in = new Scanner(System.in);
			data = Integer.parseInt(in.nextLine());
		}
		coach.getSeats()[data - 1] = value;
	}
	
	//Main method:
	public static void main(String[] args) {
		StageC app = new StageC();
	}
}
