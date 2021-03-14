import java.util.Scanner;

public class CoachBookings {

	public static void main(String[] args) {

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
		int seats = seatRows * 4;
		int[] totalSeats = new int[seats];
				
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
	}

/* switch statement for menu selections
	public void runMenu() {
		String choice;
		do {

			choice = sc.nextLine();
			switch (choice) {
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
			// default is a catch-all, is optional.
			default:
				System.out.println("Invalid input, try again doofus.");

			}
		} while (!choice.equals("X"));

	} */

}
