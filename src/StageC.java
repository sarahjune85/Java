import java.util.Scanner;

public class StageC {
	// Object member variables, only visible to StageC methods:
	private String choice;
	private int numEvents;
	private int eventCounter = 0;
	private Scanner sc = new Scanner(System.in);
	// Object array of TffEvents initialised:
	private TffEvent[] tffEvents;

	// Stage C Constructor - instantiates the StageC class, asks for # of events to
	// store, and calls the main menu:
	public StageC() {
		System.out.print("Please enter the maximum number of events: ");
		numEvents = Integer.parseInt(sc.nextLine());
		this.tffEvents = new TffEvent[numEvents];
		mainMenu();
	}

	// Main menu method - displays menu options and drives menu using a String
	// based switch statement:
	public void mainMenu() {
		System.out.println(" ----------------------------------------------- ");
		System.out.printf("%45s\n", "Taradale Folk Festival Event Booking Menu");
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
				addEvent();
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
				System.out.println("Invalid selection, try again. ");
				mainMenu();
				break;
			}
		} while (!choice.isEmpty());
	}

	// addEvent method:
	public boolean addEvent() {
		String title;
		String description;
		double adult;
		double child;
		double concession;
		String type;

		// Checks to see if eventCounter has reached the maximum number of events
		// specified at startup:
		if (eventCounter == numEvents) {
			System.out.println("Maximum number of events reached.");
			mainMenu();
			return false;
		}

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
		type = sc.nextLine();

		switch (type.toUpperCase()) {
		// tffExperienceEvent object - asks for max # of tickets:
		case "Y":
			for (int i = 0; i < numEvents; i++) {
				// if the array object [i] points to is null, adds a new event at that location:
				if (tffEvents[i] == null) {
					System.out.print("Please enter the maximum # of tickets available: ");
					int maxTickets = Integer.parseInt(sc.nextLine());
					tffEvents[i] = tffEvents[eventCounter] = new TffExperienceEvent(title, description, adult, child,
							concession, maxTickets);
					System.out.println("Successfully added a TFF Experience.");
					// Polymorphic method call: the displayEvent() method executed
					// depends on the object eventCounter points to at the time - tffExperienceEvent
					// or tffEvent.
					tffEvents[eventCounter].displayEvent();
					eventCounter++;
					mainMenu();
				}
			}
			break;

		// tffEvent object - no ticket limits:
		case "N":
			for (int i = 0; i < numEvents; i++) {
				if (tffEvents[i] == null) {
					tffEvents[i] = tffEvents[eventCounter] = new TffEvent(title, description, adult, child, concession);
					System.out.println("Successfully added a TFF Event.");
					// Polymorphic method call again:
					tffEvents[eventCounter].displayEvent();
					eventCounter++;
					mainMenu();
				}
			}
			break;
		default:
			System.out.println("Event type " + type + " is invalid.");
			break;
		}
		return true;
	}

	// view event method - searches event array by title, then displays event detail
	// summary:
	public void viewEvent() {
		System.out.println("Please enter the event name or partial keyword: ");
		String id = sc.nextLine();
		System.out.println("Searching events for \"" + id + "\"");
		boolean foundit = false;
		for (int i = 0; i < eventCounter; i++) {
			// ignore case entered by user by converting both id & getTitle() to lowercase.
			// contains() is case sensitive, but was used over equalsIgnoreCase() to enable
			// a partial/keyword search:
			if (tffEvents[i].getTitle().toLowerCase().contains(id.toLowerCase())) {
				System.out.println("Found it!");
				tffEvents[i].displayEvent();
				foundit = true;
			}
		}
		if (!foundit) {
			System.out.println("Event not found.");
			mainMenu();
		}
	}

	// lists all event titles in TffEvent[] array.
	public void listAllEvents() {
		System.out.println("All Event Details:");
		for (int i = 0; i < eventCounter; i++) {
			// stops array before it is empty, preventing null pointer exception:
			if (tffEvents[i] != null)
				// Polymorphic method call will refer to either TffEvent or TffExperienceEvent
				// depending on object:
				tffEvents[i].displayEvent();
		}
	}

	public void addBooking() {
		// search by event title
		System.out.println("Please enter the event name or keyword: ");
		String id = sc.nextLine();
		System.out.println("Searching events for \"" + id + "\"");
		boolean foundit = false;
		// i = counts events
		// j = counts tickets per event
		for (int i = 0; i < eventCounter; i++) {
			if (tffEvents[i].getTitle().toLowerCase().contains(id.toLowerCase())) {
				System.out.println("Found event: " + tffEvents[i].getTitle());
				foundit = true;

				// enter # of bookings required - fail this if # of tickets available is < than
				// - this needs to go to TffExperienceEvent. Book ticket incrementally rather
				// than preselecting a #
				if (tffEvents[i] instanceof TffExperienceEvent) {
//					System.out.println("Please enter # of tickets required: ");
//					int numTickets = Integer.parseInt(sc.nextLine());
//					if (numTickets <= (((TffExperienceEvent) tffEvents[i]).getMaxTickets()
//							- tffEvents[i].getPurchasedTickets())) {

					// Increments ticket counter on TffExperienceEvent:
//						for (int j = 0; j < numTickets; j++) {

					int numBookings = 0;
					System.out.println("Select a ticket type 1-3: ");
					System.out.println("1. Adult");
					System.out.println("2. Child");
					System.out.println("3. Concession");
					String ticketType = sc.nextLine();
					// choose a ticket type - menu of 1-3:
					switch (ticketType) {
					case "1":
						ticketType = "Adult";
						System.out.println("Enter a name for the booking: ");
						String name = sc.nextLine();
						
						if ((tffEvents[i].bookEvent(ticketType, name) == true)) {
							numBookings++;
							((TffExperienceEvent) tffEvents[i]).setNumBookings(numBookings);
							((TffExperienceEvent) tffEvents[i]).displayTickets();
						} else {
							System.out.println("Error StageC - no tickets remaining.");
							mainMenu();
						}
//						tffEvents[i].bookEvent(ticketType, name);
//						numBookings++;
//						((TffExperienceEvent) tffEvents[i]).setNumBookings(numBookings);
//						((TffExperienceEvent) tffEvents[i]).displayTickets();
						break;
					case "2":
						ticketType = "Child";
						System.out.println("Enter a name for the booking: ");
						name = sc.nextLine();

						if ((tffEvents[i].bookEvent(ticketType, name) == true)) {
							numBookings++;
							((TffExperienceEvent) tffEvents[i]).setNumBookings(numBookings);
							((TffExperienceEvent) tffEvents[i]).displayTickets();
						} else {
							System.out.println("Error StageC - no tickets remaining.");
							mainMenu();
						}

						break;
					case "3":
						ticketType = "Concession";
						System.out.println("Enter a name for the booking: ");
						name = sc.nextLine();
						tffEvents[i].bookEvent(ticketType, name);
						numBookings++;
						((TffExperienceEvent) tffEvents[i]).setNumBookings(numBookings);
						((TffExperienceEvent) tffEvents[i]).displayTickets();
						break;
					default:
						System.out.println("Invalid selection, try again. ");
						break;
					}

					break;

					// System.out.println("Experience ticket purchased.");
				}

				mainMenu();

				// fix up TffEvent one:
			} else if (tffEvents[i] instanceof TffEvent) {
				System.out.println("Please enter # of tickets required: ");
				int numTickets = Integer.parseInt(sc.nextLine());
				// tffEvents[i].buyTickets(numTickets);
				for (int j = 0; j < numTickets; i++) {
					// choose a ticket type - menu of 1-3
					// Enter a name for the booking
					// return to tffEvents.bookEvent(ticketType, name);
					// display event title/name/price
				}
			}

		}
		if (!foundit) {
			System.out.println("Event not found.");
			mainMenu();
		}
	}

	public void refundBooking() {
		// search by event title
		System.out.println("Please enter the event name or keyword: ");
		String id = sc.nextLine();
		System.out.println("Searching events for \"" + id + "\"");
		boolean foundit = false;
		for (int i = 0; i < eventCounter; i++) {
			if (tffEvents[i].getTitle().toLowerCase().contains(id.toLowerCase())) {
				System.out.println("Found it!");
				System.out.println(tffEvents[i].getTitle());

		
		// For searching for a ticket holder name, use the 'contains' string method as
		// the only alphabetic characters in the string will be the ticket holder name.
		// only refunds if it is an indoor "Experience" event - rejects otherwise.
		for (int i = 0; i < eventCounter; i++) {
			// experience events only:
			if (tffEvents[i] instanceof TffExperienceEvent) {
				// then search by ticket holder name
				System.out.println("Please enter the name to refund: ");
				String name = sc.nextLine();
				((TffExperienceEvent) tffEvents[i]).refundBooking(name);
			} else {
				System.out.println("Error: Non-refundable event.");
			}
		}
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
