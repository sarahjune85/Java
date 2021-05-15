/* CPT121 / COSC2135 Programming 1 - Assignment 3
 * Name: Sarah Ruello
 * Student #: s3871770
 * 
 * 
 * ChildzPlay Toy Hire System - StageD class: 
 * This class instantiates the main and an arrayList objects. These objects are constructed 
 * from the 3 subclasses, DressUp, Toy & PlayEquipment - all are an implementation of the abstract class Item. 
 * Upon program start, StageD will check for a data.txt file to load previously entered Items & their details.
 * If not found, program continues with empty list. 
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StageD {
	// Object member variables, only visible to StageC methods:
	private String choice;
	private Scanner sc = new Scanner(System.in);

	// instantiate ArrayList of Item class objects:
	private static ArrayList<Item> holdings = new ArrayList<Item>();

	// Stage D Constructor:
	private StageD() {
		loadArray();
		System.out.println();
		mainMenu();
	}

	// Main menu method - displays menu options and drives menu using a String
	// based switch statement:
	private void mainMenu() {
		System.out.println(".-\"-.     .-\"-.     .-\"-.     .-\"-.     .-\"-. ");
		System.out.printf("%37s\n", "~~ ChildzPlay Toy Hire Menu ~~");
		System.out.println("     \"-.-\"     \"-.-\"     \"-.-\"     \"-.-\"   ");
		System.out.println();
		System.out.println(" A. Add item");
		System.out.println(" B. Display item");
		System.out.println(" C. Display all items");
		System.out.println(" D. Hire item");
		System.out.println(" E. Return item");
		System.out.println(" X. Exit");
		System.out.println();
		System.out.println("Please enter a letter: ");

		// Switch statement for main menu options:
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
				writeData();
				System.exit(0);
				break;
			default:
				System.out.println("Invalid selection, try again. ");
				System.out.println();
				mainMenu();
				break;
			}
		} while (!choice.isEmpty());
	}

	// Add item method:
	private void addItem() {
		String title;
		String description;
		System.out.print("Please enter item title: ");
		title = sc.nextLine();
		System.out.print("Please enter item description: ");
		description = sc.nextLine();
		System.out.println("What kind of item do you wish to add?: ");
		System.out.println(" D. Dress Up");
		System.out.println(" T. Toy");
		System.out.println(" P. Play Equipment");
		getUserInput();

		switch (choice.toUpperCase()) {
		case "D":
			int size = -1;
			int totalPieces = 0;
			// Create new item and add to arrayList:
			System.out.print("Please enter a costume genre: ");
			String genre = sc.nextLine();
			while (size == -1) {
				try {
					System.out.print("Please enter costume size: ");
					size = Integer.parseInt(sc.nextLine());
				} catch (IllegalArgumentException e) {
					System.out.println("Error: Size needs to be an integer: ");
				}
			}

			while (totalPieces == 0) {
				try {
					System.out.print("Enter number of item pieces: ");
					totalPieces = Integer.parseInt(sc.nextLine());
				} catch (IllegalArgumentException e) {
					System.out.println("Error: Total pieces needs to be an integer > 0.");
				}
			}
			Item newDressUp = new DressUp(title, description, true, genre, size, totalPieces);
			holdings.add(newDressUp);
			for (Item i1 : holdings) {
				if (i1.getTitle().equalsIgnoreCase(title)) {
					System.out.println();
					System.out.println("Added item " + i1.getToyID() + ": " + title);
				}
			}
			System.out.println();
			mainMenu();

		case "T":
			// Try/Catch here for the wrong letter entered - Toy item only:
			try {
				String category = null;
				System.out.print("Please choose the category of toy, [C]onstruction, [R]ide-On, or [S]port: ");
				getUserInput();
				switch (choice.toUpperCase()) {
				case "C":
					category = "Construction";
				case "R":
					category = "RideOn";
				case "S":
					category = "Sport";
				}
				// IllegalArgumentException can be thrown from Toy constructor:
				Item newToy = new Toy(title, description, true, category);
				holdings.add(newToy);
				for (Item i1 : holdings) {
					if (i1.getTitle().equalsIgnoreCase(title)) {
						System.out.println();
						System.out.println("Added item " + i1.getToyID() + ": " + title);
					}
				}
			} catch (IllegalArgumentException e) {
				// Displays Toy constructor's exception message when letter entered is wrong:
				System.out.println("Error: " + e.getMessage());
				System.out.println();
			}
			System.out.println();
			mainMenu();

		case "P":
			System.out.print("Please enter item weight in kg: ");
			String weight = sc.nextLine();
			System.out.print("Please enter item height in cm: ");
			String height = sc.nextLine();
			System.out.print("Please enter item width in cm: ");
			String width = sc.nextLine();
			System.out.print("Please enter item depth in cm: ");
			String depth = sc.nextLine();
			System.out.print("Please enter weekly price: ");
			double weeklyPrice = Double.parseDouble(sc.nextLine());
			Item newPlayEquip = new PlayEquipment(title, description, true, weight, height, width, depth, weeklyPrice);
			holdings.add(newPlayEquip);
			for (Item i1 : holdings) {
				if (i1.getTitle().equalsIgnoreCase(title)) {
					System.out.println();
					System.out.println("Added item " + i1.getToyID() + ": " + title);
				}
			}
			System.out.println();
			mainMenu();
		default:
			System.out.println("Item type " + choice + " is invalid.");
			System.out.println();
			mainMenu();
			break;
		}
	}

	// View item method - searches arrayList by toyID, then displays item detail
	// summary:
	private void viewItem() {
		simpleList();
		int targetID = -1;
		try {
		System.out.println("Please enter the item ID: ");
		targetID = Integer.parseInt(sc.nextLine());
		System.out.println("Displaying details for \"" + targetID + "\"...");
		} catch (NumberFormatException e) {
			System.out.println("Not a valid ID");
		}

		boolean foundit = false;

		// search array list for a matching object using foreach loop:
		for (Item i1 : holdings) {
			if (i1.getToyID() == targetID) {
				i1.displayItem();
				System.out.println();
				foundit = true;
			}
		}
		if (!foundit) {
			System.out.println("Item not found.");
			System.out.println();
			mainMenu();
		}
	}

	// Lists all items in holdings arrayList + their complete details:
	private void listAllItems() {
		int hireCount = 0;
		double income = 0;
		if (!holdings.isEmpty()) {
			// iterate through array list elements:
			for (int i = 0; i < holdings.size(); i++) {
				// retrieves current element and store in a temporary Item, i1:
				Item i1 = (holdings.get(i));
				// checks available status of i1 to take count of items on loan & their price:
				boolean available = i1.isAvailable();
				if (!available) {
					hireCount++;
					income += i1.determinePrice();
				}
				// display item details:
				i1.displayItem();
				System.out.println();
			}
			System.out.println(" ------------- S T A T I S T I C S ------------- ");
			System.out.printf(" | %24s %3d %16s\n", "Inventory count :", holdings.size(), "|");
			System.out.printf(" | %24s %3d %16s\n", "Total on loan :", hireCount, "|");
			System.out.printf(" | %24s %3s%-7.2f %9s\n", "Forecast income :", "$", income, "|");
			System.out.println(" ----------------------------------------------- ");
			System.out.println();
		} else {
			System.out.println("No items in list.");
			mainMenu();
		}
	}

	// List all items in holdings - titles & IDs only:
	private void simpleList() {
		int hireCount = 0;
		double income = 0;
		System.out.println("Item list:");
		System.out.println(" ---------");
		for (Item a : holdings) {
			String title = a.getTitle();
			int toyID = a.getToyID();
			boolean available = a.isAvailable();
			String onLoan;
			if (!available) {
				onLoan = "ON LOAN";
				hireCount++;
				income += a.determinePrice();
			} else {
				onLoan = "AVAILABLE";
			}
			System.out.printf("%d : %-20s - %-10s\n", toyID, title, onLoan);
		}		
		System.out.println(" ---------");
		System.out.println(" Total hired: " + hireCount);
		System.out.printf(" Total income: $%.2f\n", income);
		System.out.println();
	}

	// Hire item method:
	private void hireItem() {
		simpleList();
		System.out.println("To hire an item, please enter the item ID: ");
		int targetID = Integer.parseInt(sc.nextLine());
		boolean foundit = false;

		// search array list for a matching object using foreach loop:
		for (Item i1 : holdings) {
			if (i1.getToyID() == targetID) {
				System.out.println();
				System.out.println("You have selected: " + i1.getTitle());
				System.out.println();
				foundit = true;
				try {
					System.out.println("Enter customer ID: ");
					String customerID = sc.nextLine();
					int numWeeks = -1;
					while (numWeeks < 1) {
						try {
							System.out.println("Enter number of weeks to hire out:");
							numWeeks = Integer.parseInt(sc.nextLine());
						} catch (IllegalArgumentException e) {
							System.out.println("Error: # of weeks needs to be an integer > 0.");
						}
					}

					i1.hireItem(customerID, numWeeks);
					System.out.println();
				} catch (HiringException e) {
					System.out.println("Item loan failed:");
					System.out.println(e.getMessage());
					System.out.println();
				}
			}
		}
		if (!foundit) {
			System.out.println("ID not found.");
			mainMenu();
		}
	}

	// Return item method:
	private void returnItem() {
		simpleList();
		System.out.println("To return an item, please enter the item ID: ");
		int targetID = Integer.parseInt(sc.nextLine());
		boolean foundit = false;
		// search array list for a matching object using foreach loop:
		for (Item i1 : holdings) {
			if (i1.getToyID() == targetID) {
				// boolean flicked to true to indicate Item found:
				foundit = true;
				try {
					// uses Item's returnItem() method to switch object's loan status:
					i1.returnItem();
					// returnItem() throws Hiring exception and displays message when user tries to return an
					// item not on loan, caught here:
				} catch (HiringException e) {
					System.out.println("Item return failed: ");
					System.out.println(e.getMessage());
					System.out.println();
				}
			}
		}
		// If ID is not found, boolean remains false and error is displayed:
		if (!foundit) {
			System.out.println("ID not found.");
			mainMenu();
		}
	}

	// Writes all arrayList data to a txt file:
	private void writeData() {
		PrintWriter pw = null;

		try {
			pw = new PrintWriter("data.txt");
		} catch (FileNotFoundException e) {
			System.out.println("I/O error");
		}

		if (pw != null) {
			// Foreach loop cycles through the holdings arrayList and writes to PrintWriter
			// using the overridden methods contained in each subclass:
			for (Item a : holdings) {
				a.writeData(pw);
			}
			// Closing the PrintWriter to ensure it writes to completion:
			pw.close();
		}
	}

	// Loads previously entered data to arrayList from txt file:
	private void loadArray() {
		String tag;
		Item temp;
		Scanner fileScanner = null;
		try {
			fileScanner = new Scanner(new FileReader("data.txt"));
			// Scanner parses data.txt line by line:
			while (fileScanner.hasNext()) {
				temp = null;
				tag = fileScanner.nextLine();
				// if Scanner's nextLine() finds a class tag, creates a new object:
				if (tag.equals("DressUp")) {
					temp = new DressUp(fileScanner);
				} else if (tag.equals("Toy")) {
					temp = new Toy(fileScanner);
				} else if (tag.equals("PlayEquipment")) {
					temp = new PlayEquipment(fileScanner);
				}
				// Adds new object to ArrayList:
				holdings.add(temp);
			}
			System.out.println("Data found - loading saved items...");
		} catch (FileNotFoundException e) {
			// When no data.txt file is located on startup:
			System.out.println("File not found. Starting in default state");
		}
	}

	// reusable method for scanner input, used for switch statement menus:
	private String getUserInput() {
		Scanner in = new Scanner(System.in);
		choice = in.nextLine();
		return choice;
	}

	public static void main(String[] args) {
		new StageD();
	}
}
