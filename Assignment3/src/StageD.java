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
	private int itemCounter = 0; // probs not needed
	private Scanner sc = new Scanner(System.in);
	// instantiate ArrayList Item subclass objects:
	private static ArrayList<Item> holdings = new ArrayList<Item>();

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
		System.out.println("Initializing....No items currently listed.");
		System.out.println();
//		numToys = Integer.parseInt(sc.nextLine());
//		// this.itemList = new Item[numToys];
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
		System.out.println("Please enter a letter: ");
		
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

	// addItem method:
	public void addItem() {
		String title;
		String description;
		String type;
		
		System.out.print("Please enter item title: ");
		title = sc.nextLine();
		System.out.print("Please enter item description: ");
		description = sc.nextLine();
		System.out.println("What kind of item do you wish to add?: ");
		System.out.println(" D. Dress Up");
		System.out.println(" T. Toy");
		System.out.println(" P. Play Equipment");
		type = sc.nextLine();


		switch (type.toUpperCase()) {
		case "D":
			// Create new item and add to arrayList:
			System.out.print("Please enter a costume genre: ");
			String genre = sc.nextLine();
			System.out.print("Please enter costume size: ");
			int size = Integer.parseInt(sc.nextLine());
			System.out.print("Enter number of item pieces: ");
			int totalPieces = Integer.parseInt(sc.nextLine());
			Item newDressUp = new DressUp(title, description, true, genre, size, totalPieces);
			holdings.add(newDressUp);
			listAllItems();
			mainMenu();
			
		case "T":
			String category = null;
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
			holdings.add(newToy);		
			listAllItems();
			mainMenu();

		case "P":
			System.out.print("Please enter item weight: ");
			String weight = sc.nextLine();
			System.out.print("Please enter item height: ");
			String height = sc.nextLine();
			System.out.print("Please enter item width: ");
			String width = sc.nextLine();
			System.out.print("Please enter item depth: ");
			String depth = sc.nextLine();
			System.out.print("Please enter weekly price: ");
			double weeklyPrice = Double.parseDouble(sc.nextLine());
			Item newPlayEquip = new PlayEquipment(title, description, true, weight, height, width,
					depth, weeklyPrice);
			holdings.add(newPlayEquip);
			listAllItems();
			mainMenu();

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
		//listEventTitles(); // change to list IDs/titles
		System.out.println("Please enter the event name or partial keyword: ");
		String id = sc.nextLine();
		System.out.println("Searching events for \"" + id + "\"...");
		boolean foundit = false;
		for (int i = 0; i < itemCounter; i++) {
			// ignore case entered by user by converting both id & getTitle() to lowercase.
			if (holdings[i].getTitle().toLowerCase().contains(id.toLowerCase())) {
				System.out.println("Found it!");
				holdings[i].displayItem();
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

		if (!holdings.isEmpty()) {
			// iterate through array list elements:
			for (int i = 0; i < holdings.size(); i++) {
				// retrieve current element:
				Item i1 = (holdings.get(i));

				// display item details:
				System.out.println();
				System.out.println("Type: " + i1.getClass().getSimpleName());
				
				// print items:
				i1.displayItem();
				System.out.println();
			}
		} else {
			System.out.println("No items in list.");
			mainMenu();
		}
		
	}


	public void hireItem() {

		// search by event title
		System.out.println("To add a booking, please enter the event name or keyword: ");
		String id = sc.nextLine();
		System.out.println("Searching events for \"" + id + "\"...");
		System.out.println();
		boolean foundit = false;
		Item item = null;
		
		// search array list for a matching object:
		
		for (Item i1: holdings) {
			
			if (i1.getItemID().equalsIgnoreCase(targetID)) {
				item = i1;
			}
		
//
//		for (int i = 0; i < itemCounter; i++) {
//			if (itemList[i].getTitle().toLowerCase().contains(id.toLowerCase())) {
//				System.out.println("Found event: " + itemList[i].getTitle());
//				System.out.println();
//				foundit = true;
//				// Booking for TffExperienceEvent object:
//				if (itemList[i] instanceof Toy) {
//					System.out.println("Please enter # of tickets required: ");
//					int numTickets = Integer.parseInt(sc.nextLine());
//					for (int j = 0; j < numTickets; j++) {
//						System.out.println("Select a ticket type 1-3: ");
//						System.out.println("1. Adult");
//						System.out.println("2. Child");
//						System.out.println("3. Concession");
//						String ticketType = sc.nextLine();
//						// Ticket type - switch statement.
//						// Menu will continue asking once more for ticketType & name, after numTickets
//						// has been hit. This is by design, to demonstrate the false statement returned
//						// by bookEvent().
//						switch (ticketType) {
//						case "1":
//							ticketType = "Adult";
//							System.out.println("Enter a name for the booking: ");
//							String name = sc.nextLine();
//							// Polymorphic call for bookEvent():
//							if ((itemList[i].bookEvent(ticketType, name) == true)) {
//								// Cast to TffExperienceEvent to reach method not contained in superclass:
//								((Toy) itemList[i]).displayTickets();
//								System.out.println();
//								break;
//							} else {
//								System.out.println("Booking failed...Returning to main menu.");
//								mainMenu();
//							}
//						case "2":
//							ticketType = "Child";
//							System.out.println("Enter a name for the booking: ");
//							name = sc.nextLine();
//
//							if ((itemList[i].bookEvent(ticketType, name) == true)) {
//								((Toy) itemList[i]).displayTickets();
//								System.out.println();
//							} else {
//								System.out.println("Booking failed...Returning to main menu.");
//								mainMenu();
//							}
//							break;
//						case "3":
//							ticketType = "Concession";
//							System.out.println("Enter a name for the booking: ");
//							name = sc.nextLine();
//							if ((itemList[i].bookEvent(ticketType, name) == true)) {
//								((Toy) itemList[i]).displayTickets();
//								System.out.println();
//							} else {
//								System.out.println("Booking failed...Returning to main menu.");
//								mainMenu();
//							}
//							break;
//						default:
//							System.out.println("Invalid selection, try again. ");
//							break;
//						}
//					}
//
//					// Booking for TffEvent object:
//				} else {
//					System.out.println("Please enter # of tickets required: ");
//					int numTickets = Integer.parseInt(sc.nextLine());
//					int j = 0;
//					while (j < numTickets) {
//						System.out.println("Select a ticket type 1-3: ");
//						System.out.println("1. Adult");
//						System.out.println("2. Child");
//						System.out.println("3. Concession");
//						String ticketType = sc.nextLine();
//						switch (ticketType) {
//						case "1":
//							ticketType = "Adult";
//							System.out.println("Adult: Enter a name for the booking: ");
//							String name = sc.nextLine();
//							// Polymorphic call for TffEvent object:
//							itemList[i].bookEvent(ticketType, name);
//							j++;
//							break;
//						case "2":
//							ticketType = "Child";
//							System.out.println("Child: Enter a name for the booking: ");
//							name = sc.nextLine();
//							itemList[i].bookEvent(ticketType, name);
//							j++;
//							break;
//						case "3":
//							ticketType = "Concession";
//							System.out.println("Concession: Enter a name for the booking: ");
//							name = sc.nextLine();
//							itemList[i].bookEvent(ticketType, name);
//							j++;
//							break;
//						default:
//							System.out.println("Invalid selection, try again. ");
//							break;
//						}
//					}
//					mainMenu();
//				}
//			}
		}
		if (!foundit) {
			System.out.println("Event not found.");
			mainMenu();
		}
	}

	public void returnItem() {
		//listEventTitles();
		// search by event title:
		System.out.println("Please enter the event name or partial keyword: ");
		String id = sc.nextLine();
		System.out.println("Searching events for \"" + id + "\"...");
		boolean foundit = false;

		for (int i = 0; i < itemCounter; i++) {
			if (holdings[i].getTitle().toLowerCase().contains(id.toLowerCase())) {
				System.out.println("Found event: " + holdings[i].getTitle());
				foundit = true;

				// only refund if event is an Experience event:
				if (holdings[i] instanceof Toy) {
					System.out.println("List of " + holdings[i].getTitle() + " attendees:");
					System.out.println();
					((Toy) holdings[i]).displayTickets();
					System.out.println();
					System.out.println("Enter a name to refund: ");
					String targetName = sc.nextLine();

					// if refundName returns true - proceeds to remove name from the bookings array
					// and displays success message:
					if ((((Toy) holdings[i]).refundName(targetName) == true)) {
						((Toy) holdings[i]).refundName(targetName);
						System.out.println(targetName + " has been refunded.");
						System.out.println();
						System.out.println("List of " + holdings[i].getTitle() + " attendees:");
						System.out.println();
						((Toy) holdings[i]).displayTickets();
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
