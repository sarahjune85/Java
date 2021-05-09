/* CPT121 / COSC2135 Programming 1 - Assignment 2
 * Name: Sarah Ruello
 * Student #: s3871770
 * 
 * 
 * Tff Events Booking System - StageC class: 
 * This class instantiates the main and an array of tffEvents[] objects. These are constructed 
 * from the two accompanying classes - superclass TffEvent & subclass TffExperienceEvent.  
 */

import java.util.ArrayList;
import java.util.Scanner;

public class StageD {
	// Object member variables, only visible to StageC methods:
	private String choice;
	private int numToys;
	private int itemCounter = 0;
	private Scanner sc = new Scanner(System.in);
	// instantiate ArrayList for use with Account / Account-subclass objects
	ArrayList<Item> itemList = new ArrayList<Item>();

//    Account a1 = new Account("J123", "Jill", 1000.0);      
//    SAccount s1 = new SAccount("J124", "Jill", 3000.0, 1000.0);      
//    CAccount c1 = new CAccount("J125", "Jill", 500.0, 2000.0);      
//    accountList.add(a1);    // add first account to end of list      
//    accountList.add(c1);    // add third account to end of list      
//    accountList.add(1, c1); // insert second account to index position 1 in list     

//    // iterate through Accounts in list and print their details      
//    for (int i = 0; i < accountList.size(); i++) {         
//    	Account a = accountList.get(i);         
//    	a.printDetails();         
//    	System.out.println();      
//    	}

	// Stage C Constructor - instantiates the StageC class, asks for # of events to
	// store, and calls the main menu:
	public StageD() {
		System.out.print("Please enter the maximum number of toys: ");
		numToys = Integer.parseInt(sc.nextLine());
		// this.itemList = new Item[numToys];
		mainMenu();
	}

	// Main menu method - displays menu options and drives menu using a String
	// based switch statement:
	public void mainMenu() {
		System.out.println(".-\"-.     .-\"-.     .-\"-.     .-\"-.     .-\"-.     .-\"-.");
		System.out.println("     \"-.-\"     \"-.-\"     \"-.-\"     \"-.-\"     \"-.-\"     \"-.-\"");
		// System.out.println(" ----------------------------------------------- ");
		System.out.printf("%30s\n", "~~ChildzPlay Toy Hire Menu~~");
		// System.out.println(" ----------------------------------------------- ");

		System.out.println(" A. Add item");
		System.out.println(" B. Display item");
		System.out.println(" C. Display all items");
		System.out.println(" D. Hire item");
		System.out.println(" E. Return item");
		System.out.println(" X. Exit");
		System.out.println();
		System.out.println(".-\"-.     .-\"-.     .-\"-.     .-\"-.     .-\"-.     .-\"-.");
		System.out.println("     \"-.-\"     \"-.-\"     \"-.-\"     \"-.-\"     \"-.-\"     \"-.-\"");

		do {
			getUserInput();
			switch (choice.toUpperCase()) {
			case "A":
				addItem();
				break;
			case "B":
				viewItem();
				mainMenu();
				break;
			case "C":
				listAllItems();
				mainMenu();
				break;
			case "D":
				hireItem();
				mainMenu();
				break;
			case "E":
				returnItem();
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
	public boolean addItem() {
		String title;
		String description;
		String type;
		String category;

		// Checks to see if eventCounter has reached the maximum number of events
		// specified at startup:
		if (itemCounter == numToys) {
			System.out.println("Maximum number of toys reached.");
			mainMenu();
			return false;
		}

		System.out.print("Please enter item title: ");
		title = sc.nextLine();
		System.out.print("Please enter item description: ");
		description = sc.nextLine();
		System.out.print("What kind of item do you wish to add? ");
		type = sc.nextLine();
		System.out.println(" D. Dress Up");
		System.out.println(" B. Toy");
		System.out.println(" C. Play Equipment");

		switch (type.toUpperCase()) {
		case "D":
			Item newDressUp = new DressUp(title, description, true, type, itemCounter, itemCounter);
			itemList.add(newDressUp);

		case "T":
			System.out.print("Please choose the category of toy, [C]onstruction, [R]ide-On, or [S]port: ");
			String input = sc.nextLine();
			switch (input.toUpperCase()) {
			case "C":
				category = "Construction";
				break;
			case "R":
				category = "RideOn";
				break;
			case "S":
				category = "Sport";
				break;

			default:
				System.out.println("Category " + category + " is invalid.");
				break;
			}

			Item newToy = new Toy(title, description, true, category);
			itemList.add(newToy);
			itemCounter++;
			mainMenu();

		case "P":
			Item newPlayEquip = new PlayEquipment(title, description, true, type);
			itemList.add(newPlayEquip);

		default:
			System.out.println("Toy type " + type + " is invalid.");
			break;
		}
	}
//
//		switch (type.toUpperCase()) {
//		// tffExperienceEvent object - asks for max # of tickets:
//		case "Y":
//			for (int i = 0; i < numToys; i++) {
//				// if the array object [i] points to is null, adds a new event at that location:
//				if (itemList[i] == null) {
//					System.out.print("Please enter the maximum # of tickets available: ");
//					int maxTickets = Integer.parseInt(sc.nextLine());
//					itemList[i] = itemList[itemCounter] = new Toy(title, description, adult, child, concession,
//							maxTickets);
//					System.out.println("Successfully added a TFF Experience.");
//					// Polymorphic method call: the displayEvent() method executed
//					// depends on the object eventCounter points to at the time - tffExperienceEvent
//					// or tffEvent.
//					itemList[itemCounter].displayItem();
//					itemCounter++;
//					mainMenu();
//				}
//			}
//			break;
//
//		// tffEvent object - no ticket limits:
//		case "N":
//			for (int i = 0; i < numToys; i++) {
//				if (itemList[i] == null) {
//					itemList[i] = itemList[itemCounter] = new Item(title, description, adult, child, concession);
//					System.out.println("Successfully added a TFF Event.");
//					// Polymorphic method call again:
//					itemList[itemCounter].displayItem();
//					itemCounter++;
//					mainMenu();
//				}
//			}
//			break;
//		default:
//			System.out.println("Event type " + type + " is invalid.");
//			break;
//		}
//		return true;
//	}

	// view event method - searches event array by title, then displays event detail
	// summary:
	public void viewItem() {
		listEventTitles();
		System.out.println("Please enter the event name or partial keyword: ");
		String id = sc.nextLine();
		System.out.println("Searching events for \"" + id + "\"...");
		boolean foundit = false;
		for (int i = 0; i < itemCounter; i++) {
			// ignore case entered by user by converting both id & getTitle() to lowercase.
			if (itemList[i].getTitle().toLowerCase().contains(id.toLowerCase())) {
				System.out.println("Found it!");
				itemList[i].displayItem();
				foundit = true;
			}
		}
		if (!foundit) {
			System.out.println("Event not found.");
			mainMenu();
		}
	}

	// lists all event titles + their details in TffEvent[] array.
	public void listAllItems() {
		// Check if the first item in the tffEvents object array is null - if so, there
		// are no events yet.
		if (itemList[0] == null) {
			for (int i = 0; i < itemList.length;) {
				System.out.println("No events found");
				break;
			}
		} else {
			System.out.println("All Event Details:");
			for (int j = 0; j < itemCounter; j++) {
				// stops array before it is empty, preventing null pointer exception:
				if (itemList[j] != null) {
					// Polymorphic method call will refer to either TffEvent or TffExperienceEvent
					// depending on object:
					itemList[j].displayItem();
				}
			}
		}
	}

	public void listEventTitles() {
		// List event titles only:
		if (itemList != null) {
			if (itemList[0] == null) {
				for (int i = 0; i < itemList.length;) {
					System.out.println("No events found");
					break;
				}
			} else {
				System.out.println("Event list:");
				System.out.println();
				for (int j = 0; j < itemCounter; j++) {
					// stops array before it is empty, preventing null pointer exception:
					if (itemList[j] != null) {
						// Polymorphic method call will refer to either TffEvent or TffExperienceEvent
						// depending on object:
						System.out.println(itemList[j].getTitle());
					}
				}
				System.out.println();
			}
		}
	}

	public void hireItem() {
		listEventTitles();
		// search by event title
		System.out.println("To add a booking, please enter the event name or keyword: ");
		String id = sc.nextLine();
		System.out.println("Searching events for \"" + id + "\"...");
		System.out.println();
		boolean foundit = false;

		for (int i = 0; i < itemCounter; i++) {
			if (itemList[i].getTitle().toLowerCase().contains(id.toLowerCase())) {
				System.out.println("Found event: " + itemList[i].getTitle());
				System.out.println();
				foundit = true;
				// Booking for TffExperienceEvent object:
				if (itemList[i] instanceof Toy) {
					System.out.println("Please enter # of tickets required: ");
					int numTickets = Integer.parseInt(sc.nextLine());
					for (int j = 0; j < numTickets; j++) {
						System.out.println("Select a ticket type 1-3: ");
						System.out.println("1. Adult");
						System.out.println("2. Child");
						System.out.println("3. Concession");
						String ticketType = sc.nextLine();
						// Ticket type - switch statement.
						// Menu will continue asking once more for ticketType & name, after numTickets
						// has been hit. This is by design, to demonstrate the false statement returned
						// by bookEvent().
						switch (ticketType) {
						case "1":
							ticketType = "Adult";
							System.out.println("Enter a name for the booking: ");
							String name = sc.nextLine();
							// Polymorphic call for bookEvent():
							if ((itemList[i].bookEvent(ticketType, name) == true)) {
								// Cast to TffExperienceEvent to reach method not contained in superclass:
								((Toy) itemList[i]).displayTickets();
								System.out.println();
								break;
							} else {
								System.out.println("Booking failed...Returning to main menu.");
								mainMenu();
							}
						case "2":
							ticketType = "Child";
							System.out.println("Enter a name for the booking: ");
							name = sc.nextLine();

							if ((itemList[i].bookEvent(ticketType, name) == true)) {
								((Toy) itemList[i]).displayTickets();
								System.out.println();
							} else {
								System.out.println("Booking failed...Returning to main menu.");
								mainMenu();
							}
							break;
						case "3":
							ticketType = "Concession";
							System.out.println("Enter a name for the booking: ");
							name = sc.nextLine();
							if ((itemList[i].bookEvent(ticketType, name) == true)) {
								((Toy) itemList[i]).displayTickets();
								System.out.println();
							} else {
								System.out.println("Booking failed...Returning to main menu.");
								mainMenu();
							}
							break;
						default:
							System.out.println("Invalid selection, try again. ");
							break;
						}
					}

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
							itemList[i].bookEvent(ticketType, name);
							j++;
							break;
						case "2":
							ticketType = "Child";
							System.out.println("Child: Enter a name for the booking: ");
							name = sc.nextLine();
							itemList[i].bookEvent(ticketType, name);
							j++;
							break;
						case "3":
							ticketType = "Concession";
							System.out.println("Concession: Enter a name for the booking: ");
							name = sc.nextLine();
							itemList[i].bookEvent(ticketType, name);
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

	public void returnItem() {
		listEventTitles();
		// search by event title:
		System.out.println("Please enter the event name or partial keyword: ");
		String id = sc.nextLine();
		System.out.println("Searching events for \"" + id + "\"...");
		boolean foundit = false;

		for (int i = 0; i < itemCounter; i++) {
			if (itemList[i].getTitle().toLowerCase().contains(id.toLowerCase())) {
				System.out.println("Found event: " + itemList[i].getTitle());
				foundit = true;

				// only refund if event is an Experience event:
				if (itemList[i] instanceof Toy) {
					System.out.println("List of " + itemList[i].getTitle() + " attendees:");
					System.out.println();
					((Toy) itemList[i]).displayTickets();
					System.out.println();
					System.out.println("Enter a name to refund: ");
					String targetName = sc.nextLine();

					// if refundName returns true - proceeds to remove name from the bookings array
					// and displays success message:
					if ((((Toy) itemList[i]).refundName(targetName) == true)) {
						((Toy) itemList[i]).refundName(targetName);
						System.out.println(targetName + " has been refunded.");
						System.out.println();
						System.out.println("List of " + itemList[i].getTitle() + " attendees:");
						System.out.println();
						((Toy) itemList[i]).displayTickets();
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
		new StageD();
	}
}
