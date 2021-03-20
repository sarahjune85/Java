import java.util.Arrays;
import java.util.Scanner;

public class StageB {

	private int choice = 0;
	private Scanner sc = new Scanner(System.in);
	private String destination;
	int seatRows;
	int totalSeats;
	private double standardPrice;
	private double pensionerPrice;
	private double frequentPrice;
	private int purchasedSeats = 0;
	private int purchasedStandard = 0;
	private int purchasedPensioner = 0;
	private int purchasedFrequent = 0;
	private double totalBalance;
	double grandTotal;
	char[] seats = new char[totalSeats];
	int value = 0;

	public StageB() {
		System.out.println("+-----------------------------------------+");
		System.out.println("+---------- DCA Bookings System ----------+");
		System.out.println("+-----------------------------------------+");
		System.out.print("Enter destination: ");
		destination = sc.nextLine();
		System.out.print("Enter # of rows of seats: ");
		seatRows = Integer.parseInt(sc.nextLine());
		totalSeats = seatRows * 4;
		char[] seats = new char[totalSeats];
        Arrays.fill(seats, '-'); 
        System.out.println("Coach seats: " + Arrays.toString(seats)); 

		System.out.print("Enter the price of a standard seat: ");
		standardPrice = Double.parseDouble(sc.nextLine());

		System.out.print("Enter the price of a pensioner seat: ");
		pensionerPrice = Double.parseDouble(sc.nextLine());

		System.out.print("Enter the price of a frequent traveller seat: ");
		frequentPrice = Double.parseDouble(sc.nextLine());

		printTripDetails();
		mainMenu();
	}

	public void mainMenu() {
		System.out.println("Enter a number to make a selection: ");
		System.out.println("1. Book a seat");
		System.out.println("2. Refund a seat");
		System.out.println("3. Display available seats");
		System.out.println("4. Display report");
		System.out.println("5. Exit");
		menu();
	}

	public void menu() {
		do {
			getUserInput();

			switch (choice) {
			case 1:
				buyTickets();
				break;
			case 2:
				// refundMenu();
				break;
			case 3:
				displaySeats();
				break;
			case 4:
				displayReport();
				break;
			case 5:
				System.out.println("Farewell. Happy travelling!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid input, try again.");
				break;
			}
		} while (choice != 0);
	}

	public void buyTickets() {
		System.out.println("Enter # of seats to book: ");
		int numSeats = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < numSeats; i++) {
			ticketMenu();
			getUserInput();
			switch (choice) {
			case 1:
				// Standard Ticket
				System.out.println("Standard ticket purchased.");
				purchasedSeats++;
				purchasedStandard++;
				System.out.println("Seats purchased: " + purchasedSeats);
				System.out.println(" ------ ");
				break;
			case 2:
				// Pensioner ticket
				System.out.println("Pensioner ticket purchased. ");
				purchasedSeats++;
				purchasedPensioner++;
				System.out.println("Seats purchased: " + purchasedSeats);
				System.out.println(" ------ ");
				break;
			case 3:
				// Frequent Ticket
				System.out.println("Frequent ticket purchased. ");
				purchasedSeats++;
				purchasedFrequent++;
				System.out.println("Seats purchased: " + purchasedSeats);
				System.out.println(" ------ ");
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

	private void ticketMenu() {
		System.out.printf("%-20s $%-5.2f\n", "1. Standard seat", standardPrice);
		System.out.printf("%-20s $%-5.2f\n", "2. Pensioner seat", pensionerPrice);
		System.out.printf("%-20s $%-5.2f\n", "3. Frequent seat", frequentPrice);
		System.out.println("Please enter a seat type - 1, 2 or 3: ");
	}

	private int getUserInput() throws NumberFormatException {
		Scanner in = new Scanner(System.in);
		choice = Integer.parseInt(in.nextLine());
		return choice;
	}

	public void printTripDetails() {
		System.out.println();
		System.out.printf("+--------------Coach to %s-------------+\n", destination);
		System.out.printf("%-10s%d\n", "Total seats: ", totalSeats);
		System.out.printf("%-10s$%.2f\n", "Standard Ticket: ", standardPrice);
		System.out.printf("%-10s$%.2f\n", "Pensioner: ", pensionerPrice);
		System.out.printf("%-10s$%.2f\n", "Frequent: ", frequentPrice);
		System.out.println();
	}

	public void displayReceipt() {
		// TODO Auto-generated method stub
		double totalStandard = ((double) purchasedStandard * standardPrice);
		double totalPensioner = ((double) purchasedPensioner * pensionerPrice);
		double totalFrequent = ((double) purchasedFrequent * frequentPrice);
		grandTotal = totalPensioner + totalFrequent + totalStandard;
		System.out.println("Receipt");
		System.out.println("*******");
		System.out.printf("Destination: %s\n", destination);
		System.out.println("Number of seats booked: " + purchasedSeats);
		System.out.println("\t\t------ ");
		System.out.printf("%-5d %-12s @ $%6.2f = $%7.2f \n", purchasedStandard, "* Standard", standardPrice, (double) purchasedStandard * standardPrice);
		System.out.printf("%-5d %-12s @ $%6.2f = $%7.2f \n", purchasedPensioner, "* Pensioner", pensionerPrice, (double) purchasedPensioner * pensionerPrice);
		System.out.printf("%-5d %-12s @ $%6.2f = $%7.2f \n", purchasedFrequent, "* Frequent", frequentPrice, (double) purchasedFrequent * frequentPrice);
		System.out.println("\t\t------ ");
		System.out.printf("\t\t\tTotal : $%.2f\n", grandTotal);
	}

	private void displayReport() {
		// TODO Auto-generated method stub
		System.out.println("Number of sales: " + purchasedSeats);
		System.out.println("Percent % of seats sold: ");
		System.out.println("Average price: " + (grandTotal / purchasedSeats));
	}

	public void displaySeats() {

	}

	public void seatAllocation() {

	}

	public static void main(String[] args) {
		StageB app = new StageB();
	}
}
