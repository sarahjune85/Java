import java.util.Scanner;

import Week5.Person;

public class StageC {
	// Object member variables, only visible to StageC methods:
	private String choice;
	private int numEvents = 0;
	private int eventCounter = 0;
	private Scanner sc = new Scanner(System.in);
	TffEvent[] tffEvents = new TffEvent[numEvents];

	// Stage C Constructor - instantiates the StageC class, asks for # of events to
	// store, and calls menu:
	public StageC() {

		System.out.print("Please enter the maximum number of events: ");
		numEvents = Integer.parseInt(sc.nextLine());
		mainMenu();
	}

	// Main menu method - displays menu options and drives menu using a String
	// based switch statement:
	public void mainMenu() {
		System.out.println(" ----------------------------------------------- ");
		System.out.printf("%29s\n", "Taradale Folk Festival Event Booking Menu");
		System.out.println(" ----------------------------------------------- ");
		System.out.println(" A. Add new event");
		System.out.println(" B. View event");
		System.out.println(" C. List all events");
		System.out.println(" D. Make booking");
		System.out.println(" E. Refund booking");
		System.out.println(" X. Exit");
		System.out.println();

		do {
			getUserInput();
			switch (choice.toUpperCase()) {
			case "A":
				if (addEvent() == true)
					System.out.println("Successfully added a new event");
				else
					System.out.println("Error - unable to add a new event");
				break;
			case "B":
				viewEvent();
				mainMenu();
				break;
			case "C":
				listAllEvents();
				mainMenu();
				break;
			case "D":
				addBooking();
				mainMenu();
				break;
			case "E":
				refundBooking();
				mainMenu();
				break;
			case "X":
				System.out.println("Exiting program...Goodbye.");
				System.exit(0);
				break;
			default:
				System.out.print("Invalid selection, try again: ");
				break;
			}
		} while (!choice.isEmpty());
	}
	
	public boolean addEvent() {
		String title;
		String description;
		double adult;
		double child;
		double concession;
		//boolean indoor;
		
		if (eventCounter == numEvents)
			return false;
		
		System.out.print("Please enter event title: ");
		title = sc.nextLine();
		System.out.print("Please enter event description: ");
		description = sc.nextLine();
		System.out.print("Please enter the price of an adult ticket: ");
		adult = Double.parseDouble(sc.nextLine());
		System.out.print("Please enter the price of a child's ticket: ");
		child = Double.parseDouble(sc.nextLine());
		System.out.print("Please enter the price of a concession ticket: ");
		concession = Double.parseDouble(sc.nextLine());
		System.out.print("Is this an indoor experience? Y/N: ");
		if (sc.nextLine().equalsIgnoreCase("y")) {
			// push these to TffExperienceEvent etc
			int ticketsTotal;
			System.out.print("Please enter the maximum # of tickets available: ");
			ticketsTotal = Integer.parseInt(sc.nextLine());
			// display method for this also shows Max tickets & Bookings
		} 
		
		// look for an empty spot in the array, add the object		
		for(int i = 0; i < tffEvents.length; i++) {
			if (tffEvents[i] == null) {
				tffEvents[i] = tffEvents[eventCounter++] = new TffEvent(title, description, adult, child, concession);
				eventCounter++;
				return true;
			}
		}
		
		// print event detail summary here 		
		return false;
	}
	
	private void viewEvent() {
		// search event array by title
		// display event detail summary
		
	}
	
	private void listAllEvents() {
		// super simple - just lists all event titles in TffEvent array.
		
	}

	
	private void addBooking() {
		// search by event title - experience events only
		// enter # of bookings required - fail this if # of tickets available is less than
		// choose a ticket type - menu of 1-3
		// Enter a name for the booking
		// display event title/name/price
	}
	

	private void refundBooking() {
		// search array by title again
		// then search by ticket holder name
		// only refunds if it is an indoor "Experience" event - rejects otherwise.
		// spits out the String in the 1D array in TffExperience
	}
	

	// reusable method for scanner input, used for switch statement menus:
	public String getUserInput() {
		Scanner in = new Scanner(System.in);
		choice = in.nextLine();
		return choice;
	}
	
	public static void main(String[] args) {
		new StageC();
	}
}
