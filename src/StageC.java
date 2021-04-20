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
		System.out.println(" C. List all event details");
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
		listEventTitles();
		System.out.println("Please enter the event name or partial keyword: ");
		String id = sc.nextLine();
		System.out.println("Searching events for \"" + id + "\"...");
		boolean foundit = false;
		for (int i = 0; i < eventCounter; i++) {
			// ignore case entered by user by converting both id & getTitle() to lowercase.
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

	// lists all event titles + their details in TffEvent[] array.
	public void listAllEvents() {
		if (tffEvents != null) {
			if (tffEvents[0] == null) {
				for (int i = 0; i < tffEvents.length;) {
					System.out.println("No events found");
					break;
				}
			} else {
				System.out.println("All Event Details:");
				for (int j = 0; j < eventCounter; j++) {
					// stops array before it is empty, preventing null pointer exception:
					if (tffEvents[j] != null) {
						// Polymorphic method call will refer to either TffEvent or TffExperienceEvent
						// depending on object:
						tffEvents[j].displayEvent();
					}
				}
			}
		}
	}

	public void listEventTitles() {
		// List event titles only:
		if (tffEvents != null) {
			if (tffEvents[0] == null) {
				for (int i = 0; i < tffEvents.length;) {
					System.out.println("No events found");
					break;
				}
			} else {
				System.out.println("Event list:");
				System.out.println();
				for (int j = 0; j < eventCounter; j++) {
					// stops array before it is empty, preventing null pointer exception:
					if (tffEvents[j] != null) {
						// Polymorphic method call will refer to either TffEvent or TffExperienceEvent
						// depending on object:
						System.out.println(tffEvents[j].getTitle());
					}
				}
				System.out.println();
			}
		}
	}

	public void addBooking() {
		listEventTitles();
		// search by event title
		System.out.println("Please enter the event name or keyword: ");
		String id = sc.nextLine();
		System.out.println("Searching events for \"" + id + "\"...");
		boolean foundit = false;

		for (int i = 0; i < eventCounter; i++) {
			if (tffEvents[i].getTitle().toLowerCase().contains(id.toLowerCase())) {
				System.out.println("Found event: " + tffEvents[i].getTitle());
				foundit = true;
				// Booking for TffExperienceEvent object:
				if (tffEvents[i] instanceof TffExperienceEvent) {
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

						if ((tffEvents[i].bookEvent(ticketType, name) == true)) {
							numBookings++;
							((TffExperienceEvent) tffEvents[i]).setNumBookings(numBookings);
							((TffExperienceEvent) tffEvents[i]).displayTickets();
						} else {
							System.out.println("Error StageC - no tickets remaining.");
							mainMenu();
						}
						break;
					default:
						System.out.println("Invalid selection, try again. ");
						break;
					}
					break;
					
				// Booking for TffEvent object:
				} else {
					System.out.println("Please enter # of tickets required: ");
					int numTickets = Integer.parseInt(sc.nextLine());
					int j = 0;
					while (j < numTickets) {
						System.out.println("Select a ticket type 1-3: ");
						System.out.println("1. Adult");
						System.out.println("2. Child");
						System.out.println("3. Concession");
						String ticketType = sc.nextLine();
						switch (ticketType) {
						case "1":
							ticketType = "Adult";
							System.out.println("Adult: Enter a name for the booking: ");
							String name = sc.nextLine();
							// Polymorphic call for TffEvent object:
							tffEvents[i].bookEvent(ticketType, name);
							j++;
							break;
						case "2":
							ticketType = "Child";
							System.out.println("Child: Enter a name for the booking: ");
							name = sc.nextLine();
							tffEvents[i].bookEvent(ticketType, name);
							j++;
							break;
						case "3":
							ticketType = "Concession";
							System.out.println("Concession: Enter a name for the booking: ");
							name = sc.nextLine();
							tffEvents[i].bookEvent(ticketType, name);
							j++;
							break;
						default:
							System.out.println("Invalid selection, try again. ");
							break;
						}
					}
					mainMenu();
				}
			}
		}
		if (!foundit) {
			System.out.println("Event not found.");
			mainMenu();
		}
	}

	public void refundBooking() {
		listEventTitles();
		// search by event title:
		System.out.println("Please enter the event name or partial keyword: ");
		String id = sc.nextLine();
		System.out.println("Searching events for \"" + id + "\"...");
		boolean foundit = false;

		for (int i = 0; i < eventCounter; i++) {
			if (tffEvents[i].getTitle().toLowerCase().contains(id.toLowerCase())) {
				System.out.println("Found event: " + tffEvents[i].getTitle());
				foundit = true;

				// only refund if event is an Experience event:
				if (tffEvents[i] instanceof TffExperienceEvent) {
					System.out.println("List of " + tffEvents[i].getTitle() + " attendees:");
					System.out.println();
					((TffExperienceEvent) tffEvents[i]).displayTickets();
					System.out.println();
					System.out.println("Enter a name to refund: ");
					String targetName = sc.nextLine();

					// if refundName returns true - proceeds to remove name from the bookings array
					// and displays success message:
					if ((((TffExperienceEvent) tffEvents[i]).refundName(targetName) == true)) {
						((TffExperienceEvent) tffEvents[i]).refundName(targetName);
						System.out.println(targetName + " has been refunded.");
						System.out.println("List of " + tffEvents[i].getTitle() + " attendees:");
						System.out.println();
						((TffExperienceEvent) tffEvents[i]).displayTickets();
						System.out.println();
						mainMenu();
					} else {
						System.out.println(targetName + " not found.");
						mainMenu();
					}
				} else {
					System.out.println("Sorry, event is non-refundable.");
					System.out.println();
					mainMenu();
				}
			}
		}
		if (!foundit) {
			System.out.println("Event not found.");
			mainMenu();
		}
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
