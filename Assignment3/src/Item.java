import java.io.PrintWriter;
import java.util.Scanner;

/* CPT121 / COSC2135 Programming 1 - Assignment 2
 * Name: Sarah Ruello
 * Student #: s3871770
 * 
 * This superclass contains the constructor for Item. 
 * StageD creates an arrayList of these objects. Each class is responsible for their own writing and loading to file.
 */

// Superclass
public abstract class Item {

	// protected allows subclasses to directly access variables, without a
	// getter/setter.

	// Static variable for itemID - static ensures that only 1 instance of this integer is
	// created and this instance is shared across all objects, enabling a consistent count of Items.
	protected static int itemID = 100;
	protected int toyID;
	private String title;
	private String description;
	protected boolean available;
	protected String customerID;
	protected int numWeeks;

	// Constructor for abtract class "Item" - this is extended by each subclass:
	public Item(String title, String description, boolean available) {
		this.title = title;
		this.description = description;
		this.available = available;
		++itemID;
		toyID = itemID;
	}

	// Object reads its own data from a text file, using Scanner and parsing each
	// line into the appropriate variable:
	public Item(Scanner sc) {
		this.toyID = Integer.parseInt(sc.nextLine());
		itemID++;
		this.title = sc.nextLine();
		this.description = sc.nextLine();
		this.available = Boolean.parseBoolean(sc.nextLine());
		if (!available) {
			this.customerID = sc.nextLine();
			this.numWeeks = Integer.parseInt(sc.nextLine());
		}
	}

	// The object writes its own data using PrintWriter, using a text output stream:
	public void writeData(PrintWriter pw) {
		// getSimpleName gets the name of the class of the object, which will be used to
		// instantiate the object from file:
		pw.println(this.getClass().getSimpleName());
		pw.println(this.toyID);
		pw.println(this.title);
		pw.println(this.description);
		pw.println(this.available);
		// If item is on loan, this method will also write the loan details to file:
		if (!available) {
			pw.println(this.customerID);
			pw.println(this.numWeeks);
		}
	}

	// Getter for title - used to print Item titles in StageD:
	public String getTitle() {
		return title;
	}

	// Getter for toyID - used by StageD to retrieve toys by ID:
	public int getToyID() {
		return toyID;
	}

	// Getter for loan status:
	public boolean isAvailable() {
		return available;
	}

	// Display item method:
	public void displayItem() {
		System.out.println(" ----------------------------------------------- ");
		System.out.printf(" ID           :  %d\n", toyID);
		System.out.println(" Type         :  " + getClass().getSimpleName());
		System.out.printf(" Item title   :  %s\n", title);
		System.out.printf(" Description  :  %s\n", description);
		if (!available) {
			System.out.printf(" Available?   :  %s\n", "No");
		} else {
			System.out.printf(" Available?   :  %s\n", "Yes");
		}
	}

	// Hire item method - if item is already on loan, throws a HiringException which
	// is caught in StageD.
	public void hireItem(String customerID, int numWeeks) throws HiringException {
		this.customerID = customerID;
		this.numWeeks = numWeeks;
		if (!available) {
			throw new HiringException("Item is already on loan.");
		} else {
			available = false;
			System.out.println("Item " + toyID + " successfully loaned.");
			System.out.println();
			System.out.println("Receipt: ");
			System.out.println(" ----------------------------------------------- ");
			System.out.printf(" ID           :  %d\n", toyID);
			System.out.printf(" Item title   :  %s\n", title);
			System.out.printf(" On loan to   :  %s\n", customerID);
			System.out.printf(" For          :  %d weeks\n", numWeeks);
			System.out.printf(" Total cost   :  $%.2f\n", determinePrice());
			System.out.println(" ----------------------------------------------- ");
		}
	}

	// Return item method - if item is NOT on loan, throws a HiringException which
	// is caught in StageD:
	public void returnItem() throws HiringException {
		if (available) {
			throw new HiringException("Item is not on loan.");
		} else {
			available = true;
			System.out.println("Item " + toyID + " returned by customer ID# " + customerID);
			System.out.println();
			customerID = null;
			numWeeks = 0;
		}
	}

	// Abstract method determinePrice() - all subclasses are forced to implement
	// this method, each one will contain its own specific body:
	public abstract Double determinePrice();

}
