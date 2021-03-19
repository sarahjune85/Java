import java.util.Scanner;

public class StageC {
	
	public StageC() {

		Scanner sc = new Scanner(System.in);
		String destination;
		int seatRows;
		double standard;
		double pensioner;
		double frequent;

		System.out.println("+-----------------------------------+");
		System.out.println("+------- DCA Bookings System -------+");
		System.out.println("+-----------------------------------+");

		System.out.print("Enter destination: ");
		destination = sc.nextLine();
		// Notice: read a String using sc.nextLine()
		// Avoids any issues with trailing newline

		System.out.println("Travelling to: " + destination);
		System.out.print("Enter # of rows of seats: ");
		seatRows = Integer.parseInt(sc.nextLine());
		int totalSeats = seatRows * 4;
		// Seats should be a charArray - S, P, F - then store $ amount across the seat.
		char[] seats = new char[totalSeats];
				
		System.out.print("Enter the price of a standard seat: ");
		standard = Double.parseDouble(sc.nextLine());
		
		System.out.print("Enter the price of a pensioner seat: ");
		pensioner = Double.parseDouble(sc.nextLine());
		
		System.out.print("Enter the price of a frequent traveller seat: ");
		frequent = Double.parseDouble(sc.nextLine());
		
		sc.close();
		// Maybe some more space here aaaa
		System.out.println("+------- Your inputs -------+");
		System.out.println("Total seats available on coach: " + seats);
		System.out.printf("Standard seat price: %.2f\n", standard);
		System.out.printf("Pensioner seat price: %.2f\n", pensioner);
		System.out.printf("Frequent seat price: %.2f\n", frequent);
		

		
		runMenu();
	}


	public void runMenu() {
		String choice;
		do {

			Scanner sc = new Scanner(System.in);
			System.out.println("Make a selection: ");
			choice = sc.nextLine();
			switch (choice) {
			case "P":
				System.out.println("Ticket purchased");
				break;
			case "R":
				System.out.println("Refund Issued");
				break;
			case "D":
				System.out.println("Displaying seats: ");
				break;
			case "X":
				System.out.println("BYEEEEE");
				break;
			// default is a catch-all, is optional.
			default:
				System.out.println("Invalid input, try again doofus.");

			}
		} while (!choice.equals("X"));

	} 
	
	public void displayReceipt() {
	/*	
		Receipt 
		******* 
		Destination : xxxxxxxxxxxxx
		Number of seats booked : x 
		 xx * Standard @ $xx.xx = $ xx.xx 
		 xx * Pensioner @ $xx.xx = $ xx.xx 
		 xx * Frequent @ $xx.xx = $ xx.xx 
		 ------ 
		 Total : $xxx.xx 
		 
		*/
	}
	
	public static void main(String[] args) {
		StageC app = new StageC();
	}

}
